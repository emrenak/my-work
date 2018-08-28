package com.ericsson.enk.demo.passby.passby;

public class MultiplierApp {
	public static void main(String[] args) {
		int x = 5;
		multiply(x);
		System.out.println(x);
	}
	
	private static void multiply(int x){
		x = x * x ;
	}
}
