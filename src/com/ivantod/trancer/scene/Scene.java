package com.ivantod.trancer.scene;

import java.util.ArrayList;
import java.util.List;

import com.ivantod.trancer.light.Light;
import com.ivantod.trancer.primitive.Shape;
import com.ivantod.trancer.raytracer.RayTracer;
import com.ivantod.trancer.util.color.Color;

public class Scene {

	private List<Shape> shapes = new ArrayList<Shape>();
	private List<Light> lights = new ArrayList<Light>();
	
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
	}
	
	/*
	Scene::Scene(ViewPlane viewPlane, RayTracer* rayTracer, double zEye, double zDist) :
		viewPlane(viewPlane), ambientLight(new AmbientLight) {
		backgroundColour.red = 0.0;
		backgroundColour.green = 0.0;
		backgroundColour.blue = 0.0;
		this->rayTracer = rayTracer;
		this->zEye = zEye;
		this->zDist = zDist;
	}
	*/
	
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
	
	
}
