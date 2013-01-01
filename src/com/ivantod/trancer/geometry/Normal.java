package com.ivantod.trancer.geometry;



public class Normal {

	private double x;
	private double y;
	private double z;
	
	public Normal() {
		this(0.0, 0.0, 0.0);
	}
	
	public Normal(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Normal(Vector v) {
		this.x = v.getX();
		this.y = v.getY();
		this.z = v.getZ();
	}
	
	public double dotProduct(Normal n) {
		return x*n.getX() + y*n.getY() + z*n.getZ();
	}
	
	public double dotProduct(Vector v) {
		return x*v.getX() + y*v.getY() + z*v.getZ();
	}
	
	public Normal multiply(double a) {
		return new Normal(x*a, y*a, z*a);
	}
	
	public Normal add(Normal v) {
		return new Normal(x+v.getX(), y+v.getY(), z+v.getZ());
	}
	
	public Vector add(Vector v) {
		return new Vector(x+v.getX(), y+v.getY(), z+v.getZ());
	}
	
	public Normal subtract(Normal v) {
		return new Normal(x-v.getX(), y-v.getY(), z-v.getZ());
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
