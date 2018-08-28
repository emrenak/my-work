package exhauster;


public class MyThread implements Runnable {

	int id ;
	
	public void run() {
		while (true) {
			long time = System.currentTimeMillis();
			if(time%1000 == 0){
				//Do nothing
				
			}
		}

	}
	public MyThread(int id) {
		super();
		this.id = id;
	}
	public MyThread() {
		super();
	}
	
	

}
