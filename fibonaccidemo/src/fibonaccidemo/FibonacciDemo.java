package fibonaccidemo;

/*
 * 0,1,1,2,3,5,8,13,21,34,55
 * 
 */
public class FibonacciDemo {
	public static void main(String[] args) {
		FibonacciCalculator fb = new FibonacciCalculator();
		fb.calculate(0, 1);
	}
}

class FibonacciCalculator{
	int next;
	void calculate(int previousNumber, int currentNumber){
		next = previousNumber + currentNumber;
		System.out.println(next);
		calculate(currentNumber, next);
	}
	
}
