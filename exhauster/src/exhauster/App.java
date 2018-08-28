package exhauster;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) {
		int threadCount = Integer.parseInt(args[0]); 
		long waitMillis = Long.parseLong(args[1]);

	    ExecutorService eService = Executors.newFixedThreadPool(threadCount);
	    for (int i = 0; i < threadCount; i++) {
	    	MyThread t = new MyThread(i);
	    	eService.execute(t);
	    	
		}
	    try {
			Thread.sleep(waitMillis);
			System.out.println("Exiting...");
			System.exit(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        
	}
}

