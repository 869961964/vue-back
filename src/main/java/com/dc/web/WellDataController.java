package com.dc.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dc.pojo.User1;
import com.dc.pojo.WellData;
import com.dc.service.WellDataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/wellData")
public class WellDataController {
	@Autowired
	private WellDataService wellDataService;
	@GetMapping("/getAllWellData")
	public List<WellData> getAllWellData(Double lonMin, Double lonMax, Double latMin, Double latMax){
		List<WellData> list = new ArrayList<>();
		list = wellDataService.getAllWellData(lonMin, lonMax, latMin, latMax);
		return list;
	} 
	
	@RequestMapping("/listPage")
	public PageInfo<WellData> getOnePagenoteData(Integer pageIndex, Integer pageSize, String province,String urban,String areas) throws Exception {
		/* 创建分页工具类 */
		PageHelper.startPage(pageIndex, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("areas",areas);
		map.put("urban",urban);
		map.put("province",province);
		List<WellData> docs = wellDataService.getListWellData(map);
		PageInfo<WellData> pageInfo = new PageInfo<>(docs);
		log.info("pageInfo={}", pageInfo.toString());
		return pageInfo;

	}
}
