package com.ivantod.trancer.util.geom;

public class Vector {

	private double x;
	private double y;
	private double z;
	
	public Vector() {
		this(0.0, 0.0, 0.0);
	}
	
	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector multiply(double a) {
		return new Vector(x*a, y*a, z*a);
	}
	
	public Vector divide(double a) {
		return new Vector(x/a, y/a, z/a);
	}
	
	public double dotProduct(Vector v) {
		return x*v.getX() + y*v.getY() + z*v.getZ();
	}
	
	public Vector add(Vector v) {
		return new Vector(x+v.getX(), y+v.getY(), z+v.getZ());
	}
	
	
	// getters and setters
	
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
