package stringinterning;


public class InternTest {
    public static void main( String[] args ) {
        testInterning();
    }

    private static void testInterning()
    {
        test( 1000 * 1000 );
        test( 1000 * 1000 );
    }
 
    private static void test( final int cnt )
    {
        long start = System.currentTimeMillis();
        double totalTime = 0.0;
        for ( int i = 0; i < cnt; ++i )
        {
        	String str = "Ericsson - Region Middle East - Information Technologies and Cloud - Technology Integration - Software Customization Center #" + i;
            str.intern();
            if ( i % 100000 == 0 )
            {
            	double time = ( System.currentTimeMillis() - start ) / 1000.0;
            	totalTime += time;
                System.out.println( i + "; time = " + time + " sec" );
                start = System.currentTimeMillis();
            }
        }
        System.out.println( "Total time = " + totalTime );
    }
}