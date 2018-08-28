package com.ericsson.enk.demo.volatiledemo.volatiledemo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	try {
			throw new Exception();
		} catch (Exception e) {
			throw e;
		} finally{
			System.out.println( "Hello World!" );	
		}
        
    }
}
