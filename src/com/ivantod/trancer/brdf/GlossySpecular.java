package com.ivantod.trancer.brdf;

import com.ivantod.trancer.geometry.Vector;
import com.ivantod.trancer.scene.ShadingInfo;
import com.ivantod.trancer.util.color.Color;

public class GlossySpecular implements BRDF {

	double ks;
	Color cs;
	double exp;
	
	public GlossySpecular(double ks, Color cs, double exp) {
		this.ks = ks;
		this.cs = cs; //new Color (1.0, 1.0, 1.0); //cs;
		this.exp = exp;
	}
	
	public GlossySpecular(double exp) {
		this(0.0, new Color(1.0, 1.0, 1.0), exp);
	}
	
	
	@Override
	public Color f(ShadingInfo shadingInfo, Vector wi, Vector wo) {
		Color luminance = new Color();
		Vector minusWi = new Vector(0.0,0.0,0.0).subtract(wi);
		
		double nDotWi = shadingInfo.getNormal().dotProduct(wi);
		Vector r = shadingInfo.getNormal().multiply(2.0 * nDotWi).add(minusWi);
		
		double rDotWo = r.dotProduct(wo);
		
		if (rDotWo > 0.0) {
			luminance = cs.multiply(ks * Math.pow(rDotWo, exp));
		}
		
		return luminance;
	}

	@Override
	public Color rho(ShadingInfo shadingInfo, Vector wo) {
		// TODO Auto-generated method stub
		return null;
	}

}
