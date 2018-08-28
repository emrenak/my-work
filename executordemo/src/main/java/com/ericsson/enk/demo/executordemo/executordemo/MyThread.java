package com.ericsson.enk.demo.executordemo.executordemo;


public class MyThread implements Runnable {

	int id ;
	public void run() {
		System.out.println("Thread id :" + id);
		/*while (true) {
			System.out.println("Thread id :" + id);
			try {
				Thread.sleep(3000);// configurable bir sure bekleyip sonra uyanip tekrar queue kontrol edebilir
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/

	}
	public MyThread(int id) {
		super();
		this.id = id;
	}
	public MyThread() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
