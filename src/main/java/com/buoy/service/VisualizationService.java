package com.buoy.service;

import com.buoy.entity.VisualizationVo;
import com.buoy.exception.ExceptionResultInfo;

public interface VisualizationService {
	public VisualizationVo selectByCondition(String mapper,String fromDay,String toDay) throws ExceptionResultInfo;
}
