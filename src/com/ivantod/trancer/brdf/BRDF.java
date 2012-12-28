package com.ivantod.trancer.brdf;

import com.ivantod.trancer.geometry.Vector;
import com.ivantod.trancer.scene.ShadingInfo;
import com.ivantod.trancer.util.color.Color;

public interface BRDF {

	public Color f(ShadingInfo shadingInfo, Vector wi, Vector wo);
	
	public Color rho(ShadingInfo shadingInfo, Vector wo);

}
