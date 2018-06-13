package com.buoy.mapper;

import com.buoy.entity.Permissions;
import com.buoy.entity.UserPermissionsExample;
import com.buoy.entity.UserPermissionsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPermissionsMapper {
    int countByExample(UserPermissionsExample example);

    int deleteByExample(UserPermissionsExample example);

    int deleteByPrimaryKey(UserPermissionsKey key);

    int insert(UserPermissionsKey record);

    int insertSelective(UserPermissionsKey record);

    List<UserPermissionsKey> selectByExample(UserPermissionsExample example);

    int updateByExampleSelective(@Param("record") UserPermissionsKey record, @Param("example") UserPermissionsExample example);

    int updateByExample(@Param("record") UserPermissionsKey record, @Param("example") UserPermissionsExample example);
    
    int deleteByUserId(@Param("id")Integer id);
    
    int insertBatch(@Param("params")List<Permissions> permissions,@Param("id")Integer id);
}