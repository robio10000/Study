package main;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		double input = 3.3;


		float out = (float) takeRoot(input, 0, input, 1E-20, new Square());
		float rightResult = (float) Math.sqrt(input);
		System.out.println("MY:" + out + "MATH:" + rightResult);
		if (out == rightResult) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

	}

	private static double takeRoot(double inp, double min, double max, double acc, IFunction iFunc) {
		double mid = 0d;
		double prev = mid;
		double diff2 = 1;

		if (inp < 0) { // If the input is for example -1
			throw new IllegalArgumentException("Input under 0 is not allowed");
		}
		if (inp == 0) {
			return 0;
		} else if (inp == 1) {
			return 1;
		}
		if (inp < 1) {
//			System.out.println("Your input is under 1. Min and max was changed!");
			min = 0;
			max = 1;
		}

		while (true) {
			mid = (min + max) / 2;
			if (iFunc.function(mid) < inp) {
				min = mid;
			} else {
				max = mid;
			}
			double diff = Math.abs((iFunc.function(mid)) - inp); // calculate the difference between the middle and the
																	// input

			if (diff <= acc || iFunc.function(mid) == inp) { // if the difference between middle and the input is not
																// more than 1E-x
//				System.out.println("diff < acc");
				break;
			}
			diff2 = Math.abs(prev - mid); // the difference between previous middle and middle
//			 System.out.println(diff2);
			if (diff2 == 0) {
				break;
			}

//			System.out.println(mid);
			prev = mid;

		}
		return mid;
	}

}
