import java.util.Calendar;

import org.joda.time.LocalTime;


public class App {

	public static void main(String[] args) {
		System.out.println(LocalTime.now().toString());
		System.out.println(Calendar.getInstance().getTime().toString());

	}

}
