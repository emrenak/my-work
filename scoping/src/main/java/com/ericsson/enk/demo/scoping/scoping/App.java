package com.ericsson.enk.demo.scoping.scoping;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	List<String> accessMethodsToNotOverrideUnit = new ArrayList<String>();
    	accessMethodsToNotOverrideUnit.add("test");
    	if(accessMethodsToNotOverrideUnit.contains(null)){
    		System.out.println("true");
    	}else{
    		System.out.println("false");
    	}
    	// Television t = new Television(29);
       
    }
}
