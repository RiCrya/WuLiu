package com.ricrya.entity;

public class Company {
	private int id;
	private String companyName;
	private int start_site_id;
	private int end_site_id;
	private int type_id;
	private double price;
	private String site_name;
	private String site_name1;
	private String typeName;
	
	
	
	public String getSite_name() {
		return site_name;
	}
	public void setSite_name(String site_name) {
		this.site_name = site_name;
	}
	public String getSite_name1() {
		return site_name1;
	}
	public void setSite_name1(String site_name1) {
		this.site_name1 = site_name1;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getStart_site_id() {
		return start_site_id;
	}
	public void setStart_site_id(int start_site_id) {
		this.start_site_id = start_site_id;
	}
	public int getEnd_site_id() {
		return end_site_id;
	}
	public void setEnd_site_id(int end_site_id) {
		this.end_site_id = end_site_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}


	public Company(int id, String companyName, int start_site_id, int end_site_id, int type_id, double price,
			String site_name, String site_name1, String typeName) {
		this.id = id;
		this.companyName = companyName;
		this.start_site_id = start_site_id;
		this.end_site_id = end_site_id;
		this.type_id = type_id;
		this.price = price;
		this.site_name = site_name;
		this.site_name1 = site_name1;
		this.typeName = typeName;
	}
	public Company() {
	}
	
	
}
