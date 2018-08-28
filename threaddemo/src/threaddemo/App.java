package threaddemo;

public class App {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread t = new MyExtendedThread(i);
			t.start();
			new Thread(new MyExtendedThreadRunnable()).start();
		}

	}

}
