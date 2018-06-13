package com.buoy.service;

import java.util.List;
import java.util.Map;

import com.buoy.entity.Station;

public interface BuoyService {
	public List<Station> selectAll();
	public Station selectByStation(String stationId);
	public int updateStation(Station station,String username);
	public Map<String, Object> updateStation(List<Station> stations,String username);
	
}
