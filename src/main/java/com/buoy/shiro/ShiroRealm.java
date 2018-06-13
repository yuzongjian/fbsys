package com.buoy.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;  
import org.apache.shiro.authc.AuthenticationInfo;  
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;  
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;  
import org.apache.shiro.authz.SimpleAuthorizationInfo;  
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.buoy.entity.Permissions;
import com.buoy.entity.User;
import com.buoy.service.UserService;


/**
 * realm 
 * @author Howard
 * 2017年3月12日
 */
public class ShiroRealm extends AuthorizingRealm {  
	@Autowired
	private UserService userService;
	
	private CredentialsMatcher credentialsMatcher;
    /**
     * 权限认证 
     */
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {  
    	System.out.println("doGetAuthorizationInfo");
    	String name = (String) getAvailablePrincipal(principals);  
//    	List<SysRoles> roles = sysUsersService.getRolesByUserId(name);
    	List<Permissions> permissions = userService.selectPermissionByUsername(name);
    	List<String> list = new ArrayList<>();
    	if (permissions != null) {
    		for(Permissions p: permissions) {
        		//System.out.println(p);
        		list.add(p.getPermission());
        	}
    	}
    	SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    	info.addStringPermissions(list);
    	return info;
//    	List<String> rolesName = new ArrayList<>();
//    	//使用hashset为了使获取资源路径是不重复
//    	if (null != roles) {
//    		List<SysPermissions> permissionses = sysPermissionsService.getAllPermissionsByRoles(roles);
//    		for(SysRoles role:roles) {
//    			//获取用户角色信息
//    			rolesName.add(role.getRole());
//    			System.out.println("角色不为空!!");
//    			info.addRoles(rolesName);
//    		}
//    		if (permissionses != null) {
//    			for(SysPermissions p:permissionses) {
//    				set.add(p.getPermission());
//    			}
//    			//获取权限资源路径
//    			List<String> permissions = new ArrayList<>(set);
//    			for(String s: permissions) {
//    				System.out.println(s);
//    			}
//    			info.addStringPermissions(permissions);
//    			System.out.println("权限不为空!");
//    		}
//    		
//    		return info;
//    	}
    	//return null;
        // 根据用户配置用户与权限  
    	/*System.out.println("doGetAuthorizationInfo");
        if (principals == null) {  
        	System.out.println("----");
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");  
//            System.out.println("----");
        }  
        List<String> roles = new ArrayList<String>();  
        // 简单默认一个用户与角色，实际项目应User user = userService.getByAccount(name);  
        User user = new User("shiro", "123456");  
        Role role = new Role("member");  
        user.setRole(role);  
        
        if (user.getName().equals(name)) {  
            if (user.getRole() != null) {  
                roles.add(user.getRole().getName());  
            }  
        } else {  
            throw new AuthorizationException();  
        }  
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  */
        // 增加角色  
//        info.addRoles(roles);  
//        return info;  
    }  
  
    /**
     * 用户认证
     */
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)  
            throws AuthenticationException {  
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;  
        System.out.println("doGetAuthenticationInfo");
        //通过数据库获取 根据用户输入的用户名获取用户
//        SysUsers user = sysUsersService.getByUsername(token.getUsername());
        User user = userService.selectUserByUsername(token.getUsername());
        if (user != null ) {
        	SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        	//SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
        	//清除之前的缓存 如果开启了缓存 最好加上这步用于清空上次登录的缓存
        	clearCache(info.getPrincipals());
//        	将session托管与shiro 所以这里获取shiro的session，其跟一直在用的session没什么不同
        	Session session = SecurityUtils.getSubject().getSession();
        	SecurityUtils.getSubject().getSession().setTimeout(-1000l);
        	session.setAttribute("session_user", user);
        	//不代表成功 可能密码错误 在contoller里会判定
        	if (user.getLocked() == Boolean.TRUE) 
        		throw new LockedAccountException();
        	return info;
        }else {
        	//这里会当作账号不存在处理
        	return null;
        }
        
       /* User user = new User("shiro", "123456");  
        if (user == null) {  
        	System.out.println("----");
            throw new AuthorizationException();  
        }  
        if(token != null) {
        	System.out.println(token.getUsername());
        }
        SimpleAuthenticationInfo info = null;  
        if (user.getName().equals(token.getUsername())) {  
            info = new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());  
        }  */
//        System.out.println("2222");
//        return info;  
    }  
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
//    @Override
//    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
//    	this.credentialsMatcher = credentialsMatcher;
//    }
}  