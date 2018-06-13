package com.buoy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.buoy.entity.StatisticsVo;
/**
 * 其他相关mapper.java和mapper.xml和实体Example类由于用了自动生成工具，都有多余代码和方法，待删除
 * @author hongwu
 *
 */
public interface ExportMapper {
	List<StatisticsVo> selectToExport(@Param("fromDay") String fromDay,@Param("toDay") String toDay,@Param("list") List<String> list);
	List<StatisticsVo> selectToExportByYear(@Param("year") String day,@Param("list") List<String> list);
	List<StatisticsVo> selectByLastTime();
	
	StatisticsVo selectBuoyByTime(@Param("time") String time,@Param("buoy") String buoy);
}
