package com.ivantod.trancer.util.math;

import java.util.Random;

public class MathFunc {

	private static Random random = new Random();
	
	public static int randInt(int low, int high) {
		return random.nextInt(high - low + 1) + low;
	}
	
	public static double randFloat() {
		return random.nextDouble();
	}
	
	public static double randFloat(double low, double high) {
		return randFloat() * (high - low) + low;
	}
	
	public static int randInt() {
		int i = Math.abs(random.nextInt());
		if (i < 0) i = 0; // Correction for the case when i turns out to be Integer.MIN_VALUE after random call.
		return i;
	}

}
