package com.ivantod.trancer.util.color;

public class Color {

	private double r;
	private double g;
	private double b;
	
	public Color() {
		this(0.0, 0.0, 0.0);
	}
	
	public Color(double c) {
		this(c, c, c);
	}
	
	public Color(double r, double g, double b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public Color multiply(double a) {
		return new Color(r*a, g*a, b*a);
	}
	
	public void divideBy(double a) {
		r/=a; g/=a;	b/=a;
	}
	

	
	// getters and setters
	
	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}
	
	
}
