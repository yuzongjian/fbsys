package com.buoy.mapper;

import com.buoy.entity.Weather;
import com.buoy.entity.WeatherExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeatherMapper {
    int countByExample(WeatherExample example);

    int deleteByExample(WeatherExample example);

    int deleteByPrimaryKey(Integer wId);

    int insert(Weather record);

    int insertSelective(Weather record);

    List<Weather> selectByExample(WeatherExample example);

    Weather selectByPrimaryKey(Integer wId);

    int updateByExampleSelective(@Param("record") Weather record, @Param("example") WeatherExample example);

    int updateByExample(@Param("record") Weather record, @Param("example") WeatherExample example);

    int updateByPrimaryKeySelective(Weather record);

    int updateByPrimaryKey(Weather record);
    
    Weather selectTheLast(@Param("buoyId") String buoyId);
    
    List<Weather> selectTheLast24(@Param("buoyId") String buoyId);
    
    List<Weather> selectTheLast24WithTime(@Param("buoyId") String buoyId,@Param("time") String time);
    
    Weather selectDateByDay(@Param("buoyId")String buoyId,@Param("time")String time);
    
    List<Weather> selectBetweenDay(@Param("buoyId") String buoyId,@Param("fromDay") String fromDay,@Param("toDay") String toDay);
}