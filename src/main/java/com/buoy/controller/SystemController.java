package com.buoy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.buoy.entity.Permissions;
import com.buoy.entity.User;
import com.buoy.exception.ExceptionResultInfo;
import com.buoy.service.UserService;
import com.buoy.util.Constant;
import com.buoy.util.Page;
import com.buoy.util.ResultInfo;
import com.hxtt.global.u;
/**
 * 系统及用户管理
 * @author Howard
 * 2017年4月20日
 */
@Controller
public class SystemController extends BaseController {
	
	@Autowired
	private UserService userService;
	/**
	 * 跳转到登录页
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index() {
		return "/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "/login";
	}
	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,Model model) {
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
//		String msg = new String("空");
		try {
			
			subject.login(token); //这里会先调用realm的 doGetAuthenticationInfo方法 之后这里再login，根据结果判定 登录信息是否正确 
			
		} catch(UnknownAccountException uae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,未知账户"); 
            //throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL, "对用户[" + username + "]进行登录验证..验证未通过,未知账户");
//            model.setAttribute("message_login", "未知账户");  
            model.addAttribute("msg", "未知账户");
        }catch(IncorrectCredentialsException ice){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");  
            //request.setAttribute("message_login", "密码不正确");  
            model.addAttribute("msg", "密码不正确");
        }catch(LockedAccountException lae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");  
//            request.setAttribute("message_login", "账户已锁定");  
            model.addAttribute("msg", "账户已锁定");
        }catch(ExcessiveAttemptsException eae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");  
//            request.setAttribute("message_login", "用户名或密码错误次数过多");  
            model.addAttribute("msg", "用户名或密码错误次数过多");
        }catch(AuthenticationException ae){  
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");  
            ae.printStackTrace();  
//            request.setAttribute("message_login", "用户名或密码不正确");  
            model.addAttribute("msg", "用户名或密码不正确");
        }  
		if(subject.isAuthenticated()){  
			//没有认证的用户请求需要认证的链接时，shiro在跳转前会把跳转过来的页面链接保存到session的attribute中，key的值叫shiroSavedRequest，我们可以能过WebUtils类拿到。
			SavedRequest savedRequest = WebUtils.getSavedRequest(request);
			System.out.println("用户[" + username + "]登录认证通过"); //(这里可以进行一些认证通过后的一些系统参数初始化操作)
	        // 获取保存的URL
			//如果不存在
	        if (savedRequest == null || savedRequest.getRequestUrl() == null) {
//	        	//将session托管与shiro 所以这里获取shiro的session，其跟一直在用的session没什么不同
	        	Session session = SecurityUtils.getSubject().getSession();
	        	User user = (User) session.getAttribute("session_user");
	            return "redirect:/map";
	        }
	        //存在之前的登录前url，仅限上面的说的请求需要登录的资源而未登录时才会保存
	        //shiro-web-example/member/test 打印出来发现带有项目名
	        //截取第二个/之后的字符串
	        String url = savedRequest.getRequestUrl();
	        int i = savedRequest.getRequestUrl().indexOf("/", 2);
	        url = url.substring(i);
	        return "redirect:" + url;
        }else{  
            token.clear();  
            return "/login";
        }  
		//return "/login";
	}
	/**
	 * 退出登录
	 * @return
	 */
	//如果配置了logout的bean，这里的方法可以不写
	@RequestMapping("/logout")
	public String logout(){
		System.out.println("退出登录");
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		
		return "redirect:/login";
	}
	/**
	 * 获取用户列表
	 * @param pageno
	 * @throws IOException
	 */
	@RequestMapping("/users/getusers")
	public @ResponseBody void getUsers(Integer pageno) throws IOException {
		if (pageno == null || pageno <= 0) {
			pageno = 1;
		}
		int total = userService.selectUsersCount();
		Page page = new Page(10, pageno);
		page.setTotal(total);
		List<User> users = userService.selectUsers(page);
		
		List<Permissions> permissions = userService.selectPermissions();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("users", users);
		map.put("page", page);
		map.put("permissions", permissions);
		ResultInfo result = new ResultInfo(Constant.TYPE_RESULT_SUCCESS,0,"获取用户列表成功!");
		result.setSysdata(map);
		response.setCharacterEncoding("UTF-8"); //设置编码格式
		response.setContentType("text/html");   //设置数据格式
		String data = JSON.toJSONString(result);
		PrintWriter out = response.getWriter(); //获取写入对象
		out.print(data); //将json数据写入流中
		
	}
	/**
	 * 跳转到用户展示页
	 * @return
	 */
	@RequiresAuthentication
	@RequiresPermissions("users")
	@RequestMapping("/users")
	public String userView(){
		return "/user";
	}
	/**
	 * 用户修改
	 * @param user
	 * @param ids
	 * @throws IOException
	 */
	@RequiresAuthentication
	@RequiresPermissions("users")
	@RequestMapping("/users/update")
	public @ResponseBody void userUpdate(User user, @RequestParam("ids[]") List<Integer> ids) throws IOException {
		List<Permissions> permissions = new ArrayList<>();
		Permissions permission;
		for (Integer p:ids) {
			permission = new Permissions();
			permission.setId(p);
			permissions.add(permission);
		}
		user.setPermissions(permissions);
		User u = (User) request.getSession().getAttribute("session_user");
		int i = userService.updateUser(user,u.getUsername());
		ResultInfo result;
		if (i == 1) {
			System.out.println("更新成功");
			result = new ResultInfo(Constant.TYPE_RESULT_SUCCESS,0,"修改成功!");
		}else {
			result = new ResultInfo(Constant.TYPE_RESULT_FAIL,0,"修改失败!");
		}
		String data = JSON.toJSONString(result);
		response.setCharacterEncoding("UTF-8"); //设置编码格式
		response.setContentType("text/html");   //设置数据格式
		PrintWriter out = response.getWriter(); //获取写入对象
		out.print(data); //将json数据写入流中
	}
	/**
	 * 检查账号是否已经被使用
	 * @param username
	 * @throws IOException
	 */
	@RequiresAuthentication
	@RequiresPermissions("users")
	@RequestMapping("/users/checked")
	public @ResponseBody void userCheckedUsername(String username) throws IOException {
		User user = userService.selectUserByUsername(username);
		ResultInfo result;
		if (user == null) {
			result = new ResultInfo(Constant.TYPE_RESULT_SUCCESS,0,"用户名可用!");
			
		}else {
			result = new ResultInfo(Constant.TYPE_RESULT_FAIL,0,"账号名已经存在!");
		}
		String data = JSON.toJSONString(result);
		response.setCharacterEncoding("UTF-8"); //设置编码格式
		response.setContentType("text/html");   //设置数据格式
		PrintWriter out = response.getWriter(); //获取写入对象
		out.print(data); //将json数据写入流中
	}
	
	/**
	 * 用户新增修改删除
	 * @param datas
	 * @throws IOException
	 */
	@RequiresAuthentication
	@RequiresPermissions("users")
	@RequestMapping("/user/modify")
	public @ResponseBody void usersModify(String datas) throws IOException {
		String usersString[] = datas.split("\\|");
		User user;
		List<User> users = new ArrayList<>();
		ResultInfo result = null;
		for (String uString:usersString) {
			String[] u = uString.split(",");
			if (u[u.length-2] != null && u[u.length-2].trim().equals("0")) continue;
			user = new User();
			user.setUsername(u[1]);
			user.setRealname(u[0]);
			user.setDate(u[3]);
			//todo
			int parseInt = Integer.parseInt(u[4]);
			if (parseInt == 1) {
				user.setLocked(Boolean.TRUE);
			} else {
				user.setLocked(Boolean.FALSE);
			}
			if (u[5] != null) {
				if (u[5].trim().equals("")) {
					user.setId(null);
				}else {
					int id = Integer.parseInt(u[5]);
					user.setId(id);
				}
			}
			//权限
			List<Permissions> permissions = new ArrayList<>();
			Permissions permission;
			if (u[6] != null && !u[6].trim().equals("")) {
				String[] p = u[6].split("%");
				for (int i = 0 ; i < p.length; i ++) {
					int pid = Integer.parseInt(p[i]);
					permission = new Permissions();
					permission.setId(pid);
					permissions.add(permission);
				}
			}
			user.setPermissions(permissions);
			user.setBeizhu(u[7]);
			
			if (u[8] != null && !u[8].trim().equals("")) {
				int isdelete = Integer.parseInt(u[8]);
				if (isdelete == 1) {
					user.setDeleted(Boolean.TRUE);
				}else {
					user.setDeleted(Boolean.FALSE);
				}
			}
			if (u[10] != null && !u[10].trim().equals("")) {
				//验证
				String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
				String salt = user.getUsername() + salt2;
				//System.out.println(salt);
				user.setSalt(salt);
				//user.setLocked(Boolean.TRUE);
//			user.setLocked();
				SimpleHash encodedPassword = new SimpleHash("md5", u[10],user.getUsername()+salt2,2);
				//System.out.println(encodedPassword.toHex());
				user.setPassword(encodedPassword.toHex());
				
			}
			users.add(user);
		}
		User u = (User) request.getSession().getAttribute("session_user");
		Map<String, Object> map = userService.saveOrUpdateUsers(users,u.getUsername());
//			System.out.println(map.get("update"));
//			System.out.println(map.get("insert"));
//			System.out.println(map.get("fail"));
		logger.info("成功更新"+map.get("update")+"条，插入"+map.get("insert")+"条，失败"+map.get("fail")+"条");
		result = new ResultInfo(Constant.TYPE_RESULT_SUCCESS, 0, "成功更新"+map.get("update")+"条，插入"+map.get("insert")+"条，失败"+map.get("fail")+"条");
		if (users.size() <= 0) {
			result = new ResultInfo(Constant.TYPE_RESULT_SUCCESS, 0, "成功更新0条，插入0条，失败0条");

		}
		ObjectMapper objectMapper = new ObjectMapper();
		String d = objectMapper.writeValueAsString(result);
		response.setCharacterEncoding("UTF-8"); //设置编码格式
		response.setContentType("text/html");   //设置数据格式
		PrintWriter out = response.getWriter(); //获取写入对象
		out.print(d); //将json数据写入流中
		out.flush();
	}
}
