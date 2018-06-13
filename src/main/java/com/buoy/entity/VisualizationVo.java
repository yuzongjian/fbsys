package com.buoy.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class VisualizationVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<String> buoys = new ArrayList<>();
	
	List<List<?>> list = new ArrayList<>();

	public List<String> getBuoys() {
		return buoys;
	}

	public void setBuoys(List<String> buoys) {
		this.buoys = buoys;
	}

	public List<List<?>> getList() {
		return list;
	}

	public void setList(List<List<?>> list) {
		this.list = list;
	}	
	
	
}
