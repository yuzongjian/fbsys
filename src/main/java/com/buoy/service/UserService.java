package com.buoy.service;

import java.util.List;
import java.util.Map;

import com.buoy.entity.Permissions;
import com.buoy.entity.User;
import com.buoy.util.Page;

public interface UserService {
	public User selectUserByUsername(String username);
	public List<User> selectUsers(Page page);
	public List<Permissions> selectPermissions();
	public Map<String, Object> saveOrUpdateUsers(List<User> users,String username);
	public int updateUser(User user,String username);
	public int updateUserPermission(List<Permissions> permissions,Integer id);
	public int deleteAllPermissionsByUserId(Integer id);
	public int selectUsersCount();
	public List<Permissions> selectPermissionByUsername(String username);
}
