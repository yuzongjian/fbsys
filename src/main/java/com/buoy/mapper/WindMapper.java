package com.buoy.mapper;

import com.buoy.entity.StatisticsVo;
import com.buoy.entity.Wind;
import com.buoy.entity.WindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WindMapper {
    int countByExample(WindExample example);

    int deleteByExample(WindExample example);

    int deleteByPrimaryKey(Integer windId);

    int insert(Wind record);

    int insertSelective(Wind record);

    List<Wind> selectByExample(WindExample example);

    Wind selectByPrimaryKey(Integer windId);

    int updateByExampleSelective(@Param("record") Wind record, @Param("example") WindExample example);

    int updateByExample(@Param("record") Wind record, @Param("example") WindExample example);

    int updateByPrimaryKeySelective(Wind record);

    int updateByPrimaryKey(Wind record);
    
    Wind selectTheLast(@Param("buoyId") String buoyId);
    
    List<Wind> selectTheLast24(@Param("buoyId") String buoyId);
    
   // List<Wind> selectTheLast24(@Param("buoyId") String buoyId,@Param("field") String field);
    
    List<Wind> selectTheLast24WithTime(@Param("buoyId") String buoyId,@Param("time") String time);
    
    Wind selectDateByDay(@Param("buoyId")String buoyId,@Param("time")String time);
    
    List<Wind> selectBetweenDay(@Param("buoyId") String buoyId,@Param("fromDay") String fromDay,@Param("toDay") String toDay);
    
    List<Wind> selectToExport(@Param("params")List<String> list, @Param("buoyId") String buoyId);
    
    List<StatisticsVo> selectTest(@Param("time1")String time1);
}