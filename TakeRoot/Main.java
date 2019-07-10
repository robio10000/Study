package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.printf("#: ");
		double input = sc.nextDouble(); // Keyboard input

		sc.close();

		double out = takeRoot(input, 0, input, 0, x -> x * x); // Use the method
		double rightResult = Math.sqrt(input);
		System.out.printf("\nResult: MY: %f MATH: %f\n", out, rightResult);

	}

	/**
	 * Calculate with Binary search
	 * 
	 * @param inp   your number
	 * @param min   minimum of search area
	 * @param max   maximum of search area
	 * @param acc   accuracy
	 * @param iFunc f(x)
	 * @return the result of Binary search with your f(x)
	 */
	private static double takeRoot(double inp, double min, double max, double acc, IFunction iFunc) {

		// Check the parameters
		if (inp < 1 && (max < 1 || max == inp)) { // If the input is for example 0.9 and if your max is not right
			throw new IllegalArgumentException("Please check your arguments!(min, max)");
		}
		if (acc <= 0) { // If the accuracy is 0 or smaller
			throw new IllegalArgumentException("Please check your arguments!(accuracy)");
		}

		double midOld = Double.NaN;

		while (true) {

//			double diff = Math.abs(iFunc.function(min) - inp);
//			if (diff <= acc) { // Checks if min or max is output
//				return min;
//			}
//			diff = Math.abs(iFunc.function(max) - inp);
//			if (diff <= acc) {
//				return max;
//			}

			double mid = (min + max) / 2; // set the middle
			if (iFunc.function(mid) < inp) {
				min = mid;
			} else {
				max = mid;
			}

			double diff = Math.abs((iFunc.function(mid)) - inp); // calculate the difference between the middle and the
																	// input
			if (diff <= acc) { // if the difference between middle and the input is not
								// more than 1E-x
				return mid;
			}
			diff = max - min;

			// Checks if the difference between max and min is fit or (minOld has a value
			// and the difference between midOld and mid is fit)
			if (diff <= acc || (!Double.isNaN(midOld) && Math.abs(midOld - mid) < acc)) {
				System.out.println(max + " - " + min + " = " + (max - min) + " <= " + acc);
				System.out.println("f(" + mid + ") = " + mid * mid);
//				throw new IllegalArgumentException("Please check your arguments!");
				return mid;
			}
			midOld = mid;

		}
	}

}
