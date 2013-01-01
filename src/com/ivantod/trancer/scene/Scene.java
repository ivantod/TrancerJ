package com.ivantod.trancer.scene;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.mutable.MutableDouble;

import com.ivantod.trancer.geometry.Normal;
import com.ivantod.trancer.geometry.Point;
import com.ivantod.trancer.geometry.Ray;
import com.ivantod.trancer.light.AmbientLight;
import com.ivantod.trancer.light.Light;
import com.ivantod.trancer.primitive.Shape;
import com.ivantod.trancer.raytracer.RayTracer;
import com.ivantod.trancer.util.color.Color;

public class Scene {

	private List<Shape> shapes = new ArrayList<Shape>();
	private List<Light> lights = new ArrayList<Light>();
	
	private Light ambient;
	
	private Color backgroundColor = new Color();
	
	private ViewPlane viewPlane;
	
	private RayTracer rayTracer;
	
	private double zEye;
	private double zDist;
	
	public Scene(ViewPlane viewPlane, RayTracer rayTracer, double zEye, double zDist) {
		this.viewPlane = viewPlane;
		this.rayTracer = rayTracer;
		this.zEye = zEye;
		this.zDist = zDist;
		backgroundColor = new Color(0.0, 0.0, 0.0); // default background colour is black
		ambient = new AmbientLight(); // create a default ambient light with white colour
	}
	
	public ShadingInfo hitObject(Ray ray) {
		ShadingInfo shadingInfo = new ShadingInfo(this);
		MutableDouble t = new MutableDouble(0);
		double tMin = Double.MAX_VALUE;
		Point localHitPoint = null;
		Normal normal = null;
		
		for (Shape shape : shapes) {
			if (shape.intersect(ray, t, shadingInfo) && t.getValue() < tMin) {
				tMin = t.getValue();
				shadingInfo.setObjectHit(true);
				shadingInfo.setMaterial(shape.getMaterial());
				shadingInfo.setHitPoint(ray.getOrigin().add(ray.getDirection().multiply(t.getValue())));
				
				// Below two lines are safe to do because localHitPoint and normal in shadingInfo get assigned
				// new reference pointers in every iteration of the loop so the old one is not overwritten.
				localHitPoint = shadingInfo.getLocalHitPoint();
				normal = shadingInfo.getNormal();
			}
		}
		
		if (shadingInfo.isObjectHit()) {
			shadingInfo.setT(tMin);
			shadingInfo.setLocalHitPoint(localHitPoint);
			shadingInfo.setNormal(normal);
			//shadingInfo.setRay(ray);
		}
		
		return shadingInfo;
		
	}
	
	public void addLight(Light l) {
		lights.add(l);
	}
	
	public void addShape(Shape s) {
		shapes.add(s);
	}
	
	public List<Light> getLights() {
		return lights;
	}
	
	public List<Shape> getShapes() {
		return shapes;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public ViewPlane getViewPlane() {
		return viewPlane;
	}

	public void setViewPlane(ViewPlane viewPlane) {
		this.viewPlane = viewPlane;
	}

	public RayTracer getRayTracer() {
		return rayTracer;
	}

	public void setRayTracer(RayTracer rayTracer) {
		this.rayTracer = rayTracer;
	}

	public double getZEye() {
		return zEye;
	}

	public void setZEye(double zEye) {
		this.zEye = zEye;
	}

	public double getZDist() {
		return zDist;
	}

	public void setZDist(double zDist) {
		this.zDist = zDist;
	}

	public Light getAmbient() {
		return ambient;
	}

	public void setAmbient(Light ambient) {
		this.ambient = ambient;
	}
	
	
}
