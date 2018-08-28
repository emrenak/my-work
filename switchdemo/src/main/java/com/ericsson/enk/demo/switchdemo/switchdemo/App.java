package com.ericsson.enk.demo.switchdemo.switchdemo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int i = 1;
        
        switch (i) {
		case 1:
			System.out.println("It is 1");
		case 2:
			System.out.println("It is 2");
		case 3:
			System.out.println("It is 3");

		default:
			System.out.println("It is default");
		
		}
        
        System.out.println("Done");
    }
}
