package com.ivantod.trancer.geometry;


public class Ray {

	private Point origin;
	private Vector direction;
	
	public Ray() {
		// nothing
	}
	
	public Ray(Point origin, Vector direction) {
		this.origin = origin;
		this.direction = direction;
	}
	
	// getters and setters
	
	public Point getOrigin() {
		return origin;
	}
	
	public void setOrigin(Point origin) {
		this.origin = origin;
	}
	
	public Vector getDirection() {
		return direction;
	}
	
	public void setDirection(Vector direction) {
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		return "o="+origin.toString()+", d="+direction.toString();
	}

}
