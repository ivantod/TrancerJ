package com.ivantod.trancer.light;

import com.ivantod.trancer.geometry.Ray;
import com.ivantod.trancer.geometry.Vector;
import com.ivantod.trancer.scene.ShadingInfo;
import com.ivantod.trancer.util.color.Color;

public abstract class Light {
	
	private boolean castsShadow = true;

	public abstract Vector direction(ShadingInfo shadingInfo);
	
	public abstract Color luminance(ShadingInfo shadingInfo);
	
	public boolean inShadow(Ray ray, ShadingInfo shadingInfo) {
		return false;
	}

	public boolean castsShadow() {
		return castsShadow;
	}

	public void setCastsShadow(boolean castsShadow) {
		this.castsShadow = castsShadow;
	}
	
	
}
