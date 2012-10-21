package com.ivantod.trancer.geometry;

import com.ivantod.trancer.util.geom.Point;
import com.ivantod.trancer.util.geom.Vector;

public class Ray {

	private Point origin;
	private Vector direction;
	
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

}
