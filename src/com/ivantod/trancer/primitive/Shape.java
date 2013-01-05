package com.ivantod.trancer.primitive;

import org.apache.commons.lang3.mutable.MutableDouble;

import com.ivantod.trancer.geometry.Ray;
import com.ivantod.trancer.material.Material;
import com.ivantod.trancer.scene.ShadingInfo;
import com.ivantod.trancer.util.color.Color;

public abstract class Shape {

	protected Color color;
	protected Material material;
	
	public abstract boolean intersect(Ray ray, MutableDouble tMin, ShadingInfo shadingInfo);
	
	public abstract boolean shadowIntersect(Ray ray, MutableDouble tMin);

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	
}
