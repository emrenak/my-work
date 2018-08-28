package datenotimezone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class App {

	public static final String neverExpiryDate = "99991231T12:00:00+0000";
	private static SimpleDateFormat dateXMLFormat  = new SimpleDateFormat("yyyyMMdd'T'HH:mm:ssZ");
	public static void main(String[] args) {
//		dateXMLFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
//		
//		Calendar c = Calendar.getInstance();
//		//c.setTimeZone(new SimpleTimeZone(0, "No time"));
//		TimeZone tz = TimeZone.getDefault();
//		TimeZone.setDefault(new SimpleTimeZone(0, "No time"));
//		c.clear(Calendar.ZONE_OFFSET);
//		c.set(Calendar.SECOND, 00);
//		c.set(Calendar.MINUTE, 00);
//		c.set(Calendar.HOUR_OF_DAY, 12);
//		c.set(Calendar.DAY_OF_MONTH, 31);
//		c.set(Calendar.MONTH, 11);
//		c.set(Calendar.YEAR, 9999);
//	
////		String [] s = TimeZone.getAvailableIDs();
////		for (int i = 0; i < s.length; i++) {
////			System.out.println(s[i]);
////		}
////		System.out.println(TimeZone.getAvailableIDs());;
//		try {
//			System.out.println(c.getTime());
//		//	System.out.println(dateXMLFormat.parse(neverExpiryDate));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally{
//			TimeZone.setDefault(tz);
//			System.out.println(c.getTime());
//		}
		
		System.out.println(new Date().toGMTString());
	}
}
