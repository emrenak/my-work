package com.ericsson.enk.demo.executordemo.executordemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class App 
{
    public static void main( String[] args )
    {
    	int threadCount = 10; // configurable olabilir
    	
        //LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<String>();

        ExecutorService eService = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
        	MyThread t = new MyThread(i);
        	//Thread t1 = new Thread(t);
        	//t1.start();
        	eService.execute(t);
        	//System.out.println("Run");
        	
		}
       
    }
}
