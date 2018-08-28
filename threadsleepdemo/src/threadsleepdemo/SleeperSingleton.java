package threadsleepdemo;

public class SleeperSingleton {

	public static SleeperSingleton instance = new SleeperSingleton();
	
	private SleeperSingleton(){
		
	}
	
	public static SleeperSingleton getInstance(){
		return instance;
	}
	
	public void process(int id){
		try {
			System.out.println("Waiting for process " + id);
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
