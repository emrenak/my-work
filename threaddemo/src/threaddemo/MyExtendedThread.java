package threaddemo;

public class MyExtendedThread extends MyThread {

	public MyExtendedThread(int i) {
		super(i);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		SleeperSingleton.getInstance().process(id);
	}

	
}
