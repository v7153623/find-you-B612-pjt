package com.ssafy.home.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel
public class Home {
	
	private String aptName;
	private String dongName;
	private int floor;
	private double area;
	private String dealAmount;
	private double lat;
	private double lng;
	private double length;
	
	public Home() {
	}

	public Home(String aptName, String dongName, int floor, double area, String dealAmount, double lat, double lng,
			double length) {
		this.aptName = aptName;
		this.dongName = dongName;
		this.floor = floor;
		this.area = area;
		this.dealAmount = dealAmount;
		this.lat = lat;
		this.lng = lng;
		this.length = length;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Home [aptName=" + aptName + ", dongName=" + dongName + ", floor=" + floor + ", area=" + area
				+ ", dealAmount=" + dealAmount + ", lat=" + lat + ", lng=" + lng + ", length=" + length + "]";
	}
	
}