package com.dc.pojo;

import lombok.Data;

@Data
public class WellData {
	private int id;
	private int bianhao;// 井盖编号
	private String co;// 天然气浓度
	private String water;// 水位
	private String weiyi;// 位移
	private String pressure;// 压力
	private Double lng;// 井盖经度
	private Double lat;// 井盖纬度
	private String areas;// 区
	private String urban;// 市
	private String province;// 省
	private String time;//数据采集时间
	private boolean show;//是否显示井盖信息
}
