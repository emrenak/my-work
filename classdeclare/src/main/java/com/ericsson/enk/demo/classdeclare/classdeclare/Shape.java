package com.ericsson.enk.demo.classdeclare.classdeclare;

public class Shape {

	private String color;

	public Shape(String color) {
		System.out.print("Shape");
		this.color = color;
	}
	
	public Shape(){
		System.out.print("Shape");
	}

	public static void main(String[] args) {
		new Rectangle();
	}

}
