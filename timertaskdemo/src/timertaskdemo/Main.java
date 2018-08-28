package timertaskdemo;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

	public static void main(String[] args) {
    	TimerTask task = new RunMeTask();

    	Timer timer = new Timer();
    	timer.schedule(task, 10000,10000);

	}

}
