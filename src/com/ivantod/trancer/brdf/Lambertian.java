package com.ivantod.trancer.brdf;

import com.ivantod.trancer.geometry.Vector;
import com.ivantod.trancer.scene.ShadingInfo;
import com.ivantod.trancer.util.color.Color;
import com.ivantod.trancer.util.math.MathConst;

public class Lambertian implements BRDF {
	
	double kd;
	Color cd;
	
	Lambertian(double kd, Color cd) {
		this.kd = kd;
		this.cd = cd;
	}

	@Override
	public Color f(ShadingInfo shadingInfo, Vector wi, Vector wo) {
		return cd.multiply(kd * MathConst.INV_PI);
	}

	@Override
	public Color rho(ShadingInfo shadingInfo, Vector wo) {
		return cd.multiply(kd);
	}

}
