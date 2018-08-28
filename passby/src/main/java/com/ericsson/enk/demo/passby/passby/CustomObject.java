package com.ericsson.enk.demo.passby.passby;

public class CustomObject {

	private String name;
	private String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public CustomObject() {
		name = "Custom";
		value = "Manipulated";
	}
	@Override
	public String toString() {
		return "CustomObject [name=" + name + ", value=" + value + "]";
	}
	
	
	
}
