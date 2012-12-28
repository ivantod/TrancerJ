package com.ivantod.trancer.light;

import com.ivantod.trancer.geometry.Vector;
import com.ivantod.trancer.scene.ShadingInfo;
import com.ivantod.trancer.util.color.Color;

public abstract class Light {

	public abstract Vector direction(ShadingInfo shadingInfo);
	
	public abstract Color luminance(ShadingInfo shadingInfo);
}
