package com.ivantod.trancer.scene;

import com.ivantod.trancer.geometry.Normal;
import com.ivantod.trancer.geometry.Point;
import com.ivantod.trancer.geometry.Ray;
import com.ivantod.trancer.material.Material;
import com.ivantod.trancer.util.color.Color;

public class ShadingInfo {

	private Normal normal = new Normal();
	private Point localHitPoint = new Point();
	private Point hitPoint = new Point();
	private boolean objectHit = false;
	private Color color = new Color();
	private Scene scene;
	private Ray ray;
	private Material material;
	private double t;
	
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
	
	public ShadingInfo(ShadingInfo other) {
		this.objectHit = other.isObjectHit();
		this.material = other.getMaterial();
		this.hitPoint = other.getHitPoint();
		this.localHitPoint = other.getLocalHitPoint();
		this.normal = other.getNormal();
		this.ray = other.getRay();
		this.scene = other.getScene();
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

	public Point getHitPoint() {
		return hitPoint;
	}

	public void setHitPoint(Point hitPoint) {
		this.hitPoint = hitPoint;
	}


	public Ray getRay() {
		return ray;
	}


	public void setRay(Ray ray) {
		this.ray = ray;
	}


	public Scene getScene() {
		return scene;
	}


	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public double getT() {
		return t;
	}

	public void setT(double t) {
		this.t = t;
	}
	
	
}
