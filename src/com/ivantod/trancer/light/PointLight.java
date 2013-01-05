package com.ivantod.trancer.light;

import org.apache.commons.lang3.mutable.MutableDouble;

import com.ivantod.trancer.geometry.Ray;
import com.ivantod.trancer.geometry.Vector;
import com.ivantod.trancer.primitive.Shape;
import com.ivantod.trancer.scene.ShadingInfo;
import com.ivantod.trancer.util.color.Color;

public class PointLight extends Light {

	private double ls;
	private Color color;
	private Vector location;
	
	public PointLight(Vector location) {
		this.location = location;
		setLs(1.0);
		color = new Color(1.0, 1.0, 1.0);
	}
		
	@Override
	public boolean inShadow(Ray ray, ShadingInfo shadingInfo) {
		MutableDouble t = new MutableDouble();
		double d = location.distance(ray.getOrigin());
		
		for (Shape shape : shadingInfo.getScene().getShapes()) {
			if (shape.shadowIntersect(ray, t) && t.getValue() < d) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Vector direction(ShadingInfo shadingInfo) {
		return location.subtract(shadingInfo.getHitPoint()).hat();
	}

	@Override
	public Color luminance(ShadingInfo shadingInfo) {
		return color.multiply(ls);
	}

	
	
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getLs() {
		return ls;
	}

	public void setLs(double ls) {
		this.ls = ls;
	}

}
