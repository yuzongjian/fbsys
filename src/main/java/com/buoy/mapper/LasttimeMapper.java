package com.buoy.mapper;

import com.buoy.entity.Lasttime;
import com.buoy.entity.LasttimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LasttimeMapper {
    int countByExample(LasttimeExample example);

    int deleteByExample(LasttimeExample example);

    int deleteByPrimaryKey(Integer ltId);

    int insert(Lasttime record);

    int insertSelective(Lasttime record);

    List<Lasttime> selectByExample(LasttimeExample example);

    Lasttime selectByPrimaryKey(Integer ltId);

    int updateByExampleSelective(@Param("record") Lasttime record, @Param("example") LasttimeExample example);

    int updateByExample(@Param("record") Lasttime record, @Param("example") LasttimeExample example);

    int updateByPrimaryKeySelective(Lasttime record);

    int updateByPrimaryKey(Lasttime record);
    
    int updateByBuoy(@Param("date")String date,@Param("buoyName")String buoyName);
    
    String selectBuoyLastTime(@Param("time")String time,@Param("buoy")String buoy);
    
    String selectPreOrNextTime(@Param("time")String time,@Param("buoy")String buoy,@Param("type") int type);
    
}