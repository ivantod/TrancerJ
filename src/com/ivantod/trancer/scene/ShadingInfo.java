package com.ivantod.trancer.scene;

import com.ivantod.trancer.util.geom.Point;
import com.ivantod.trancer.util.geom.Vector;

public class ShadingInfo {

	private Vector normal;
	private Point localHitPoint;
	
	
	// getters and setters
	
	public Vector getNormal() {
		return normal;
	}
	public void setNormal(Vector normal) {
		this.normal = normal;
	}
	public Point getLocalHitPoint() {
		return localHitPoint;
	}
	public void setLocalHitPoint(Point localHitPoint) {
		this.localHitPoint = localHitPoint;
	}
	
	
}
