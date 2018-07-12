package com.ricrya.entity;

public class Site {
	private int id;
	private String site_name;
	
	
	public Site() {
	}
	
	public Site(int id, String site_name) {
		this.id = id;
		this.site_name = site_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSite_name() {
		return site_name;
	}
	public void setSite_name(String site_name) {
		this.site_name = site_name;
	}
	
	
}
