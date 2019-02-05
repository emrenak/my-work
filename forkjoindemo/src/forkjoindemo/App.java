package forkjoindemo;

import java.util.concurrent.ForkJoinPool;

public class App {

	public static void main(String[] args) {
		// Create a task pool.
		ForkJoinPool fjp = new ForkJoinPool();
		double[] nums = new double[1000000];
		// Give nums some values.
		for (int i = 0; i < nums.length; i++)
			nums[i] = (double) i;

		System.out.println("A portion of the original sequence:");
		for (int i = 0; i < 10; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println("\n");
		long start = System.currentTimeMillis();
		SqrtTransform task = new SqrtTransform(nums, 0, nums.length);
		// Start the main ForkJoinTask.
		fjp.invoke(task);
		long end = System.currentTimeMillis();
		long finish =  end - start;
		System.out.println("Finished in:" + finish);
		System.out.println("A portion of the transformed sequence" + " (to four decimal places):");
		for (int i = 0; i < 10; i++) {
			System.out.format("%.4f ", nums[i]);
		}
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
}
