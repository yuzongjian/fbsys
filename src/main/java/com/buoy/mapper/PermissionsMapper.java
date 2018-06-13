package com.buoy.mapper;

import com.buoy.entity.Permissions;
import com.buoy.entity.PermissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionsMapper {
    int countByExample(PermissionsExample example);

    int deleteByExample(PermissionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Permissions record);

    int insertSelective(Permissions record);

    List<Permissions> selectByExample(PermissionsExample example);

    Permissions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Permissions record, @Param("example") PermissionsExample example);

    int updateByExample(@Param("record") Permissions record, @Param("example") PermissionsExample example);

    int updateByPrimaryKeySelective(Permissions record);

    int updateByPrimaryKey(Permissions record);
    
    List<Permissions> getAll();
    
    List<Permissions> selectPermissionByUsername(@Param("username") String username);
}