package com.buoy.mapper;

import com.buoy.entity.Permissions;
import com.buoy.entity.User;
import com.buoy.entity.UserExample;
import com.buoy.entity.UserPermissionsKey;
import com.buoy.util.Page;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectUserByUsername (@Param("username") String username);
    
    User selectUserWithPermission();
    
    List<User> selectUsers(@Param("page") Page page);
    
    List<Permissions> selectPermissionsByUserId(@Param("userId") Integer id);
    
    int saveOrUpdateUser(User user);
    
    int updateUser(User user);
    
    int selectCount();
}