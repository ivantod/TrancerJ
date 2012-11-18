package com.ivantod.trancer.scene;

import com.ivantod.trancer.geometry.Normal;
import com.ivantod.trancer.geometry.Point;
import com.ivantod.trancer.util.color.Color;

public class ShadingInfo {

	private Normal normal = new Normal();
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
	
	public Normal getNormal() {
		return normal;
	}
	public void setNormal(Normal normal) {
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
