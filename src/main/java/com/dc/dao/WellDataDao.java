package com.dc.dao;

import java.util.List;
import java.util.Map;

import com.dc.pojo.WellData;

public interface WellDataDao {
	List<WellData> getAllWellData(Double lonMin,Double lonMax,Double latMin,Double latMax);
	List<WellData> getListWellData(Map<String, Object> map);
}
