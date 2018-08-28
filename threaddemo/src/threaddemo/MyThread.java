package threaddemo;

public class MyThread extends Thread {

	protected int id;
	
	public MyThread(int id) {
		super();
		this.id = id;
	}
	public MyThread() {
		super();
	}
	
//	@Override
//	public void run() {
//		SleeperSingleton.getInstance().process(id);
//	}

}
