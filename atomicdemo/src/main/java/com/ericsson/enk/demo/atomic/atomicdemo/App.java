package com.ericsson.enk.demo.atomic.atomicdemo;

import java.util.Calendar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	new AtomThread("A");
    	new AtomThread("B");
    	new AtomThread("C");

    }
}
