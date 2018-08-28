package timertaskdemo;
import java.util.TimerTask;

public class RunMeTask extends TimerTask
{
	@Override
	public void run() {
		System.out.println("Time:" + System.currentTimeMillis());
	}
}