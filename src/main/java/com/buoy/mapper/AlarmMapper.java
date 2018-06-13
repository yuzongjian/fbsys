package com.buoy.mapper;

import com.buoy.entity.Alarm;
import com.buoy.entity.AlarmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlarmMapper {
    int countByExample(AlarmExample example);

    int deleteByExample(AlarmExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Alarm record);

    int insertSelective(Alarm record);

    List<Alarm> selectByExample(AlarmExample example);

    Alarm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Alarm record, @Param("example") AlarmExample example);

    int updateByExample(@Param("record") Alarm record, @Param("example") AlarmExample example);

    int updateByPrimaryKeySelective(Alarm record);

    int updateByPrimaryKey(Alarm record);
    
    List<Alarm> selectAll();
    
    int updateByType(@Param("alarm") Alarm alarm);
    
    Alarm selectByType(@Param("type")String type);
}