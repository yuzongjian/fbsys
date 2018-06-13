package com.buoy.mapper;

import com.buoy.entity.Waterquality;
import com.buoy.entity.WaterqualityExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterqualityMapper {
    int countByExample(WaterqualityExample example);

    int deleteByExample(WaterqualityExample example);

    int deleteByPrimaryKey(Integer wqId);

    int insert(Waterquality record);

    int insertSelective(Waterquality record);

    List<Waterquality> selectByExample(WaterqualityExample example);

    Waterquality selectByPrimaryKey(Integer wqId);

    int updateByExampleSelective(@Param("record") Waterquality record, @Param("example") WaterqualityExample example);

    int updateByExample(@Param("record") Waterquality record, @Param("example") WaterqualityExample example);

    int updateByPrimaryKeySelective(Waterquality record);

    int updateByPrimaryKey(Waterquality record);
    
    Waterquality selectTheLast(@Param("buoyId") String buoyId);
    
    List<Waterquality> selectTheLast24(@Param("buoyId") String buoyId);
    
    List<Waterquality> selectTheLast24WithTime(@Param("buoyId") String buoyId,@Param("time") String time);
    
    Waterquality selectDateByDay(@Param("buoyId")String buoyId,@Param("time")String time);
    
    List<Waterquality> selectBetweenDay(@Param("buoyId") String buoyId,@Param("fromDay") String fromDay,@Param("toDay") String toDay);
}