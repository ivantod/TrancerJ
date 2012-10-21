package com.ivantod.trancer.primitive;

import org.apache.commons.lang3.mutable.MutableDouble;

import com.ivantod.trancer.geometry.Ray;
import com.ivantod.trancer.scene.ShadingInfo;
import com.ivantod.trancer.util.color.Color;

public abstract class Shape {

	protected Color color;
	
	public abstract boolean intersect(Ray ray, MutableDouble tMin, ShadingInfo shadingInfo);

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
