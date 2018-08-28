package com.ericsson.enk.demo.passby.passby;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String s = "Native String";
        
        StringPassByController spByController = new StringPassByController();
        
        spByController.manipulateString(s);
        
        System.out.println(s);
        
        Boolean b = true;
        
        BooleanPassByController bp = new BooleanPassByController();
        
        bp.manipulateBoolen(b);
        
        System.out.println(b.toString());
    }
}
