package com.ivantod.trancer.util.geom;

public class Point2D {

	private double x;
	private double y;
	
	public Point2D() {
		this(0.0, 0.0);
	}
	
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point2D(Point2D p) {
		this.x = p.x;
		this.y = p.y;
	}

	public Point2D mult(double a) {
		return new Point2D(x*a, y*a);
	}
	
	public void setCoordinates(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	
}
