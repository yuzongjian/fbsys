package com.buoy.mapper;

import com.buoy.entity.Station;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StationMapper {
    List<Station> selectAll();
    int saveOrUpdate(Station station);
    Station selectByStation(@Param("stationId")String stationId);
    Station selectByBuoyId(@Param("buoyId")String buoyId);
}