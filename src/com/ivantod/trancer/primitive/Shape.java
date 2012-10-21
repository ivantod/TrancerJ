package com.ivantod.trancer.primitive;

import com.ivantod.trancer.geometry.Ray;
import com.ivantod.trancer.scene.ShadingInfo;
import com.ivantod.trancer.util.color.Color;

public abstract class Shape {

	protected Color color;
	
	public abstract boolean intersect(Ray ray, double tMin, ShadingInfo shadingInfo);

	public Color getC() {
		return color;
	}

	public void setC(Color color) {
		this.color = color;
	}
	
	
}
