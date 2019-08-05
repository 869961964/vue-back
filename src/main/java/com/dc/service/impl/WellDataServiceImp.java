package com.dc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dc.dao.WellDataDao;
import com.dc.pojo.WellData;
import com.dc.service.WellDataService;
@Service
public class WellDataServiceImp implements WellDataService{
    @Autowired
	private WellDataDao wellData;
	@Override
	public List<WellData> getAllWellData(Double lonMin, Double lonMax, Double latMin, Double latMax) {
		
		return wellData.getAllWellData(lonMin, lonMax, latMin, latMax);
	}
	@Override
	public List<WellData> getListWellData(Map<String, Object> map) {
		
		return wellData.getListWellData(map);
	}

}
