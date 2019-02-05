package forkjoindemo;

import java.util.concurrent.RecursiveAction;

class SqrtTransform extends RecursiveAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// The threshold value is arbitrarily set at 1,000 in this example.
	// In real-world code, its optimal value can be determined by
	// profiling and experimentation.
	final int seqThreshold = 1000;
	// Array to be accessed.
	double[] data;
	// Determines what part of data to process.
	int start, end;

	SqrtTransform(double[] vals, int s, int e) {
		data = vals;
		start = s;
		end = e;
	}

	// This is the method in which parallel computation will occur.
	protected void compute() {
		// If number of elements is below the sequential threshold,
		// then process sequentially.
		if ((end - start) < seqThreshold) {
			// Transform each element into its square root.
			for (int i = start; i < end; i++) {
				data[i] = Math.sqrt(data[i]);
			}
		} else {
			// Otherwise, continue to break the data into smaller pieces.
			// Find the midpoint.
			int middle = (start + end) / 2;
			// Invoke new tasks, using the subdivided data.
			invokeAll(new SqrtTransform(data, start, middle), new SqrtTransform(data, middle, end));
		}
	}
}