package com.services.admin_nation;

public class Search {

	private String keyName;
	private String keyType;

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getKeyType() {
		return keyType;
	}
	
	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}
	
	public Search(String keyName, String keyType) {
		super();
		this.keyName = keyName;
		this.keyType=keyType;
	}

	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
