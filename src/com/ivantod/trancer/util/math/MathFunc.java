package com.ivantod.trancer.util.math;

import java.util.Random;

public class MathFunc {

	private static Random random = new Random();
	
	public static int randInt(int low, int high) {
		return random.nextInt(high - low) + low;
	}
	
	public static double randFloat() {
		return random.nextDouble();
	}
	
	public static double randFloat(double low, double high) {
		return randFloat() * (high - low) + low;
	}
	
}
