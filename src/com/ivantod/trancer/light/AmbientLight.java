package com.ivantod.trancer.light;

import com.ivantod.trancer.geometry.Vector;
import com.ivantod.trancer.scene.ShadingInfo;
import com.ivantod.trancer.util.color.Color;

public class AmbientLight extends Light {

	private double ls;
	private Color color;
	
	public AmbientLight() {
		ls = 1.0;
		color = new Color(1.0,1.0,1.0); // white;
	}
	
	@Override
	public Vector direction(ShadingInfo shadingInfo) {
		return new Vector(0.0, 0.0, 0.0);
	}

	@Override
	public Color luminance(ShadingInfo shadingInfo) {
		return color.multiply(ls);
	}

}
