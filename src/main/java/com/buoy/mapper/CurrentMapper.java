package com.buoy.mapper;

import com.buoy.entity.Current;
import com.buoy.entity.CurrentExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CurrentMapper {
    int countByExample(CurrentExample example);

    int deleteByExample(CurrentExample example);

    int deleteByPrimaryKey(Integer cId);

    int insert(Current record);

    int insertSelective(Current record);

    List<Current> selectByExample(CurrentExample example);

    Current selectByPrimaryKey(Integer cId);

    int updateByExampleSelective(@Param("record") Current record, @Param("example") CurrentExample example);

    int updateByExample(@Param("record") Current record, @Param("example") CurrentExample example);

    int updateByPrimaryKeySelective(Current record);

    int updateByPrimaryKey(Current record);
    
    Current selectTheLast(@Param("buoyId") String buoyId);
    
    List<Current> selectTheLast24(@Param("buoyId") String buoyId);
    
    List<Current> selectTheLast24WithTime(@Param("buoyId") String buoyId,@Param("time") String time);
    
    Current selectDateByDay(@Param("buoyId")String buoyId,@Param("time")String time);
    
    List<Current> selectBetweenDay(@Param("buoyId") String buoyId,@Param("fromDay") String fromDay,@Param("toDay") String toDay);
}