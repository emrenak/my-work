package com.ericsson.enk.demo.restfulldemo.restclient.restclient;

import java.io.Serializable;

public class CountryClient implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id ;
	String countryName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String name) {
		this.countryName = name;
	}
	@Override
	public String toString() {
		return "CountryClient [id=" + id + ", name=" + countryName + "]";
	}
	
	
}
