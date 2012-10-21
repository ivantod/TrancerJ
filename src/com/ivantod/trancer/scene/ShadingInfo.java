package com.ivantod.trancer.scene;

import com.ivantod.trancer.util.color.Color;
import com.ivantod.trancer.util.geom.Point;
import com.ivantod.trancer.util.geom.Vector;

public class ShadingInfo {

	private Vector normal = new Vector();
	private Point localHitPoint = new Point();
	private boolean objectHit = false;
	private Color color = new Color();
	private Scene scene;
	
	public ShadingInfo(Scene scene) {
		this.scene = scene;
/*		
		localHitPoint(),
		hitPoint(),
		normal(),
		scene(scene),
		depth(0),
		material(NULL)
		{
objectHit = false;
colour.red = 0.0;
colour.blue = 0.0;
colour.green = 0.0;
t = 0;*/
	}
	
	
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
	public boolean isObjectHit() {
		return objectHit;
	}
	public void setObjectHit(boolean objectHit) {
		this.objectHit = objectHit;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
