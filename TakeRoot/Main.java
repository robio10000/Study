package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.printf("#: ");
		double input = sc.nextDouble(); // Keyboard input

		sc.close();

		double out = calcF(input, 2, input, 1E-15, x -> (x) * (x)+2); // Use the method
		System.out.printf("\nResult: %f", out);

	}

	/**
	 * Calculate with Binary search
	 * 
	 * @param y0    your number(input)
	 * @param xMin  minimum of search area f(xMin) must be smaller than input
	 * @param xMax  maximum of search area f(xMax) must be bigger than input
	 * @param acc   accuracy !(acc < 0 && acc < 1E-15)
	 * @param iFunc f(x)
	 * @return the result of Binary search with your f(x)
	 */
	private static double calcF(double y0, double xMin, double xMax, double acc, IFunction iFunc) {

		// checks if input is bigger than f(xMax) or f(xMin) smaller than input or xMax
		// is smaller than xMin
		if (iFunc.function(xMax) < y0) {
			System.out.println(iFunc.function(xMax));
			throw new IllegalArgumentException("Please check your arguments!(max)");
		}else if(iFunc.function(xMin) > y0) {
			throw new IllegalArgumentException("Please check your arguments!(min)");
		}else if(xMax < xMin) {
			throw new IllegalArgumentException("Please check your arguments!(min, max)");
		}

		if (acc < 1E-15) { // If the accuracy is smaller 1E-15(0,000000000000001)
			throw new IllegalArgumentException("Please check your arguments!(accuracy)");
		}

		// if anyone of the parameters are NaN
		if (Double.isNaN(y0) || Double.isNaN(xMin) || Double.isNaN(xMax) || Double.isNaN(acc)) {
			throw new IllegalArgumentException("Please check your arguments!(NaN)");
		}

		double min = xMin;
		double max = xMax;
		double midOld = Double.NaN;

		while (true) {

			double mid = (min + max) / 2; // set the middle
			double fX = iFunc.function(mid); // f(x)

			if (fX < y0) { // Checks if f(x) < input
				min = mid;
			} else {
				max = mid;
			}

			double diff = Math.abs(fX - y0); // calculate the difference between the middle and the input
			if (diff <= acc) { // if the difference between middle and the input is not
								// more than 1E-x
				return mid;
			}

			diff = max - min; // calculate the difference between max and min
			// Checks if difference is fit or (minOld has a value and the difference between
			// midOld and mid is fit)
			if (diff <= acc || (!Double.isNaN(midOld) && Math.abs(midOld - mid) < acc)) {
				System.out.println(max + " - " + min + " = " + (max - min) + " <= " + acc);
				System.out.println("f(" + mid + ") = " + mid * mid);
				System.out.println("Please check the result");
				return mid;
			}
			midOld = mid;

		}
	}

}
