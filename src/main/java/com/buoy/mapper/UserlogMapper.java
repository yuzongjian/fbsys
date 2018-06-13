package com.buoy.mapper;

import com.buoy.entity.Alarmlog;
import com.buoy.entity.Userlog;
import com.buoy.entity.UserlogExample;
import com.buoy.util.Page;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserlogMapper {
    int countByExample(UserlogExample example);

    int deleteByExample(UserlogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Userlog record);

    int insertSelective(Userlog record);

    List<Userlog> selectByExample(UserlogExample example);

    Userlog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Userlog record, @Param("example") UserlogExample example);

    int updateByExample(@Param("record") Userlog record, @Param("example") UserlogExample example);

    int updateByPrimaryKeySelective(Userlog record);

    int updateByPrimaryKey(Userlog record);
    
    int selectCount(@Param("fromDay") String fromDay,@Param("toDay")String toDay);

    List<Userlog> selectByPage(@Param("page") Page page,@Param("fromDay") String fromDay,@Param("toDay")String toDay);

}