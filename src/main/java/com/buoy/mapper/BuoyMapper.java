package com.buoy.mapper;

import com.buoy.entity.Buoy;
import com.buoy.entity.BuoyExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuoyMapper {
    int countByExample(BuoyExample example);

    int deleteByExample(BuoyExample example);

    int deleteByPrimaryKey(Integer bId);

    int insert(Buoy record);

    int insertSelective(Buoy record);

    List<Buoy> selectByExample(BuoyExample example);

    Buoy selectByPrimaryKey(Integer bId);

    int updateByExampleSelective(@Param("record") Buoy record, @Param("example") BuoyExample example);

    int updateByExample(@Param("record") Buoy record, @Param("example") BuoyExample example);

    int updateByPrimaryKeySelective(Buoy record);

    int updateByPrimaryKey(Buoy record);
    
    Buoy selectTheLast(@Param("buoyId") String buoyId);

    String[] selectDateByLikeDay(@Param("buoyId")String buoyId,@Param("time")String time);
    
    Buoy selectDateByDay(@Param("buoyId")String buoyId,@Param("time")String time);
    
    List<Buoy> selectBetweenDay(@Param("buoyId") String buoyId,@Param("fromDay") String fromDay,@Param("toDay") String toDay);
}