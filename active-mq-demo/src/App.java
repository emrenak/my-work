
public class App {

	public static void main(String[] args) {
		//thread(new Listener(),false);
		Publisher p = new Publisher();
		p.sendMessage();

	}

   public static void thread(Runnable runnable, boolean daemon) {
        Thread brokerThread = new Thread(runnable);
        brokerThread.setDaemon(daemon);
        brokerThread.start();
    }
}
