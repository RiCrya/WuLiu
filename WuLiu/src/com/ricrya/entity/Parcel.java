package com.ricrya.entity;

public class Parcel {
	
	private int id;
	private String pkg_number;
	private int pkg_start_id;
	private int pkg_end_id;
	private int pkg_type_id;
	private String sender;
	private String sender_phone;
	private String recipient;
	private String recipient_phone;
	private String site_name;
	private String site_name1;
	private String typeName;
	
	public Parcel() {
	}
	
	

	public Parcel(int id, String pkg_number, int pkg_start_id, int pkg_end_id, int pkg_type_id, String sender,
			String sender_phone, String recipient, String recipient_phone, String site_name, String site_name1,
			String typeName) {
		this.id = id;
		this.pkg_number = pkg_number;
		this.pkg_start_id = pkg_start_id;
		this.pkg_end_id = pkg_end_id;
		this.pkg_type_id = pkg_type_id;
		this.sender = sender;
		this.sender_phone = sender_phone;
		this.recipient = recipient;
		this.recipient_phone = recipient_phone;
		this.site_name = site_name;
		this.site_name1 = site_name1;
		this.typeName = typeName;
	}



	public int getPkg_start_id() {
		return pkg_start_id;
	}



	public void setPkg_start_id(int pkg_start_id) {
		this.pkg_start_id = pkg_start_id;
	}



	public int getPkg_end_id() {
		return pkg_end_id;
	}



	public void setPkg_end_id(int pkg_end_id) {
		this.pkg_end_id = pkg_end_id;
	}



	public int getPkg_type_id() {
		return pkg_type_id;
	}



	public void setPkg_type_id(int pkg_type_id) {
		this.pkg_type_id = pkg_type_id;
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

	public String getSite_name() {
		return site_name;
	}

	public void setSite_name(String site_name) {
		this.site_name = site_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPkg_number() {
		return pkg_number;
	}

	public void setPkg_number(String pkg_number) {
		this.pkg_number = pkg_number;
	}



	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSender_phone() {
		return sender_phone;
	}

	public void setSender_phone(String sender_phone) {
		this.sender_phone = sender_phone;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getRecipient_phone() {
		return recipient_phone;
	}

	public void setRecipient_phone(String recipient_phone) {
		this.recipient_phone = recipient_phone;
	}
	
	
	
}
