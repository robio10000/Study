package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.printf("#: ");
		double input = sc.nextDouble(); // Keyboard input

		sc.close();

		double out = calcF(input, 0, 2, 1E-15, x -> (x - 3) * (x - 3) + 3); // Use the method
		System.out.println("(y | x)\n(" + input + " | " + out + ")");

	}

	/**
	 * Calculate with Binary search
	 * 
	 * @param y0    <br>
	 *              your number(input)
	 * @param xMin  <br>
	 *              minimum of search area <i>f</i>(xMin) must be smaller than input
	 *              and must be smaller as xMax
	 * @param xMax  <br>
	 *              maximum of search area <i>f</i>(xMax) must be bigger as input
	 *              and must be bigger as xMin
	 * @param acc   <br>
	 *              accuracy !(acc < 0 && acc < 1E-15)
	 * @param iFunc <br>
	 *              f(x) for example:<br>
	 *              x - > x*x
	 * @return the result of Binary search with your f(x)
	 */
	private static double calcF(double y0, double xMin, double xMax, double acc, IFunction iFunc) {

		// if anyone of the parameters are NaN
		if (Double.isNaN(y0) || Double.isNaN(xMin) || Double.isNaN(xMax) || Double.isNaN(acc)) {
			throw new IllegalArgumentException("Please check your arguments!(NaN)");
		}

		// What is f(xMin) and f(xMax) for debug
//		double fMin = iFunc.function(xMin);
//		double fMax = iFunc.function(xMax);

		boolean down = false;
		// checks if input is bigger than f(xMax) or f(xMin) smaller than input or xMax
		// is smaller than xMin
		if (iFunc.function(xMax) < y0  && iFunc.function(xMin) > y0) {
			//throw new IllegalArgumentException("Please check your arguments![ f(xMax) is < y0]");
			down = true;
		}else if(iFunc.function(xMax) > y0 && iFunc.function(xMin) < y0) {
			down = false;
		}else if (xMax < xMin) {
			throw new IllegalArgumentException("Please check your arguments!(min is > max)");
		}

		if (acc < 1E-15) { // If the accuracy is smaller 1E-15(0,000000000000001)
			throw new IllegalArgumentException("Please check your arguments!(accuracy)");
		}

		double min = xMin;
		double max = xMax;
		double midOld = Double.NaN;

		while (true) {

			double mid = (min + max) / 2; // set the middle
			double fX = iFunc.function(mid); // f(x)

			if (fX < y0) { // Checks if f(x) < input
				if (down == true) {
					max = mid;
				}else {
					min = mid;
				}
			} else {
				if (down == true) {
					min = mid;
				}else {
					max = mid;
				}
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
