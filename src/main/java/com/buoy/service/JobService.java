package com.buoy.service;

import java.util.List;

import com.buoy.entity.Buoy;
import com.buoy.entity.Current;
import com.buoy.entity.Waterquality;
import com.buoy.entity.Wave;
import com.buoy.entity.Weather;
import com.buoy.entity.Wind;

public interface JobService {
	public int addBuoyList(List<Buoy> buoys);
	public int addCurrentList(List<Current> currents);
	public int addWaterQualityList(List<Waterquality> waterQualities);
	public int addWaveList(List<Wave> waves);
	public int addWeatherList(List<Weather> weathers);
	public int addWindList(List<Wind> winds);
	
}
