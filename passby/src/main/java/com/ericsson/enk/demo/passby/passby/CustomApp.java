package com.ericsson.enk.demo.passby.passby;

public class CustomApp {

	public static void main(String[] args) {
		CustomObject c = new CustomObject();
		CustomObjectPassByController customObjectPassByController = new CustomObjectPassByController();
		customObjectPassByController.manipulateCustomObject(c);
		System.out.println(c.toString());

	}

}
