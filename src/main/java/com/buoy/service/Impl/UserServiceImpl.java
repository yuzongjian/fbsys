package com.buoy.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.utils.StringKeyDirtyFlagMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buoy.entity.Permissions;
import com.buoy.entity.User;
import com.buoy.entity.Userlog;
import com.buoy.mapper.PermissionsMapper;
import com.buoy.mapper.UserMapper;
import com.buoy.mapper.UserPermissionsMapper;
import com.buoy.mapper.UserlogMapper;
import com.buoy.service.UserService;
import com.buoy.util.Page;
import com.buoy.util.StringUtil;
@Service
public class UserServiceImpl implements UserService {
	
	protected static Logger logger = Logger.getLogger(UserServiceImpl.class);

	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PermissionsMapper permissionsMapper;
	@Autowired
	private UserPermissionsMapper userPermissionsMapper;
	@Autowired
	private UserlogMapper userlogMapper;
	
	@Override
	public User selectUserByUsername(String username) {
		User user = userMapper.selectUserByUsername(username);
		return user;
	}

	@Override
	public List<User> selectUsers(Page page) {
		List<User> users = userMapper.selectUsers(page);
		User u = null;
		List<Permissions> permissions;
		for (int i = 0; i < users.size(); i ++) {
			u = users.get(i);
			permissions = userMapper.selectPermissionsByUserId(u.getId());
			u.setPermissions(permissions);
			users.set(i, u);
		}
		return users;
	}

	@Override
	public List<Permissions> selectPermissions() {
		return permissionsMapper.getAll();
	}

	@Override
	public Map<String, Object> saveOrUpdateUsers(List<User> users,String username) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("update", 0);
		map.put("insert", 0);
		map.put("fail", 0);
		for (User u:users) {
			User user = selectUserByUsername(u.getUsername());
			int updateResult = userMapper.saveOrUpdateUser(u);
			userPermissionsMapper.deleteByUserId(u.getId());
			if (updateResult == 2) {
				//更新
				if (u.getDeleted() != true) {
					int insertPermissionsResult = userPermissionsMapper.insertBatch(u.getPermissions(), u.getId());
					if (insertPermissionsResult > 0) {
						logger.info("用户更新成功...");
						
						Userlog userlog = new Userlog();
						userlog.setDate(StringUtil.getNowTime("yyyy-MM-dd HH:mm"));
						userlog.setSummary("更新账户");
						userlog.setDetails("管理员"+username+"更新账户"+u.getUsername()+":"+u.getBeizhu());
						userlogMapper.insert(userlog);
						//todo
						
						map.put("update", (Integer)map.get("update")+1);
					}else {
						logger.info("用户更新失败...");
					}
				}else {
					Userlog userlog = new Userlog();
					userlog.setDate(StringUtil.getNowTime("yyyy-MM-dd HH:mm"));
					userlog.setSummary("更新账户");
					userlog.setDetails("管理员"+username+"更新账户"+u.getUsername()+":"+u.getBeizhu());
					userlogMapper.insert(userlog);
					
					logger.info("用户更新成功...");
					map.put("update", (Integer)map.get("update")+1);
				}
				
			}else if (updateResult == 1) {
				//增加
				if (user != null) {
					userPermissionsMapper.insertBatch(u.getPermissions(), user.getId());
					Userlog userlog = new Userlog();
					userlog.setDate(StringUtil.getNowTime("yyyy-MM-dd HH:mm"));
					userlog.setSummary("更新账户");
					userlog.setDetails("管理员"+username+"更新账户"+u.getUsername()+":"+u.getBeizhu());
					userlogMapper.insert(userlog);
					logger.info("用户更新成功...");
					map.put("update", (Integer)map.get("update")+1);
				}else {
					user = selectUserByUsername(u.getUsername());
					int insertPermissionsResult = userPermissionsMapper.insertBatch(u.getPermissions(), user.getId());
					if (insertPermissionsResult > 0) {
						
						Userlog userlog = new Userlog();
						userlog.setDate(StringUtil.getNowTime("yyyy-MM-dd HH:mm"));
						userlog.setSummary("添加账户");
						userlog.setDetails("管理员"+username+"添加账户"+u.getUsername()+":"+u.getBeizhu());
						userlogMapper.insert(userlog);
						
						logger.info("用户添加成功...");
						map.put("insert", (Integer)map.get("insert")+1);
					}
				}
			}else {
				//失败
				logger.info("记录用户失败日志");
				map.put("fail", (Integer)map.get("fail")+1);
			}
			
		}
		return map;
	}

	@Override
	public int updateUser(User user,String username) {
		int i = userMapper.updateUser(user);
		int deleteResult = deleteAllPermissionsByUserId(user.getId());
		int updatePermissionResult = updateUserPermission(user.getPermissions(), user.getId());
		System.out.println("权限更新.."+updatePermissionResult);
		
		Userlog userlog = new Userlog();
		userlog.setDate(StringUtil.getNowTime("yyyy-MM-dd HH:mm"));
		userlog.setSummary("更新账户");
		userlog.setDetails("管理员"+username+"更新账户"+user.getUsername()+":"+user.getBeizhu());
		userlogMapper.insert(userlog);
		
		logger.info("用户更新成功...");

		return i;
	}

	@Override
	public int updateUserPermission(List<Permissions> permissions, Integer id) {
		
		return userPermissionsMapper.insertBatch(permissions, id);
	}

	@Override
	public int deleteAllPermissionsByUserId(Integer id) {
		
		return userPermissionsMapper.deleteByUserId(id);
	}

	@Override
	public int selectUsersCount() {
		return userMapper.selectCount();
	}

	@Override
	public List<Permissions> selectPermissionByUsername(String username) {
		
		return permissionsMapper.selectPermissionByUsername(username);
	}

}
