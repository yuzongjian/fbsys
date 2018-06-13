package com.buoy.mapper;

import com.buoy.entity.Wave;
import com.buoy.entity.WaveExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaveMapper {
    int countByExample(WaveExample example);

    int deleteByExample(WaveExample example);

    int deleteByPrimaryKey(Integer wId);

    int insert(Wave record);

    int insertSelective(Wave record);

    List<Wave> selectByExample(WaveExample example);

    Wave selectByPrimaryKey(Integer wId);

    int updateByExampleSelective(@Param("record") Wave record, @Param("example") WaveExample example);

    int updateByExample(@Param("record") Wave record, @Param("example") WaveExample example);

    int updateByPrimaryKeySelective(Wave record);

    int updateByPrimaryKey(Wave record);
    
    Wave selectTheLast(@Param("buoyId") String buoyId);
    
    List<Wave> selectTheLast24(@Param("buoyId") String buoyId);
    
    Wave selectDateByDay(@Param("buoyId")String buoyId,@Param("time")String time);
    
    List<Wave> selectTheLast24WithTime(@Param("buoyId") String buoyId,@Param("time") String time);
    
    List<Wave> selectBetweenDay(@Param("buoyId") String buoyId,@Param("fromDay") String fromDay,@Param("toDay") String toDay);
}