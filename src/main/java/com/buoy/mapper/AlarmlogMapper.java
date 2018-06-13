package com.buoy.mapper;

import com.buoy.entity.Alarmlog;
import com.buoy.entity.AlarmlogExample;
import com.buoy.util.Page;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlarmlogMapper {
    int countByExample(AlarmlogExample example);

    int deleteByExample(AlarmlogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Alarmlog record);

    int insertSelective(Alarmlog record);

    List<Alarmlog> selectByExample(AlarmlogExample example);

    Alarmlog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Alarmlog record, @Param("example") AlarmlogExample example);

    int updateByExample(@Param("record") Alarmlog record, @Param("example") AlarmlogExample example);

    int updateByPrimaryKeySelective(Alarmlog record);

    int updateByPrimaryKey(Alarmlog record);
    
    int insertBatch(@Param("list")List<Alarmlog> alarmlogs);
    
    List<Alarmlog> selectByPage(@Param("page") Page page,@Param("fromDay") String fromDay,@Param("toDay")String toDay);

    int selectCount(@Param("fromDay") String fromDay,@Param("toDay")String toDay);
    
   // List<Alarmlog> selectLike(@Param("day") String day);
    
    List<Alarmlog> selectLogByBuoyIdAndDate(@Param("buoy") String buoy,@Param("day") String day);
    
    List<Alarmlog> getActiveLog();
    
    int updateActiveLog(@Param("id") Integer id);

}