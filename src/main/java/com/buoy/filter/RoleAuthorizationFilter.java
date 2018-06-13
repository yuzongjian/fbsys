package com.buoy.filter;

import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
/**
 * 自定义过滤器
 * 在xml里配置该bean后 可以实现 将原本要同时满足的角色改为只要满足其一即可
 * 仅在配置方式的roles下有用 注解方式有自己的注解参数可以控制
 * @author Howard
 * 2017年3月12日
 */
public class RoleAuthorizationFilter extends AuthorizationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		Subject subject = getSubject(request, response);  
        String[] rolesArray = (String[]) mappedValue;  
  
        if (rolesArray == null || rolesArray.length == 0) {  
            // no roles specified, so nothing to check - allow access.  
            return true;  
        }  
  
        Set<String> roles = CollectionUtils.asSet(rolesArray);  
        for (String role : roles) {  
            if (subject.hasRole(role)) {  
            	System.out.println("自定义过滤器 角色认证成功");
                return true;  
            }  
        }  
        System.out.println("自定义过滤器 角色认证失败");
        return false;  
	}  
}
