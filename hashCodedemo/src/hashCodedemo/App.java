package hashCodedemo;

import java.util.HashMap;
import java.util.Map;

public class App {

	public static void main(String[] args) {
		Map<MyPhoneNumber, String> m = new HashMap();
		m.put(new MyPhoneNumber(707, 867, 5309), "Jenny");
		System.out.println(m.get(new MyPhoneNumber(707, 867, 5309))); // hascode override edilmezse, map den null gelecek. 
		
		String[] ipAddresses = new String[0];
		System.out.println(ipAddresses[0]);
	
	}

}
