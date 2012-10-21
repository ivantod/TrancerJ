package com.ivantod.trancer.util.geom;

public class Point {

	private double x;
	private double y;
	private double z;
	
	public Point() {
		this(0.0, 0.0, 0.0);
	}
	
	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector subtract(Point to) {
		return vectorToPoint(to);
	}
	
	public Point add(Vector v) {
		return pointFromVector(v);
	}
	
	public Vector vectorToPoint(Point to) {
		return new Vector(x-to.x, y-to.y, z-to.z);
	}
	
	public Point pointFromVector(Vector v) {
		return new Point(x+v.getX(), y+v.getY(), z+v.getZ());
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

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	
	
	
}
