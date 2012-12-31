package com.ivantod.trancer.material;

import com.ivantod.trancer.brdf.Lambertian;
import com.ivantod.trancer.geometry.Vector;
import com.ivantod.trancer.light.Light;
import com.ivantod.trancer.scene.ShadingInfo;
import com.ivantod.trancer.util.color.Color;

public class Matte implements Material {
	
	private double ambientReflection;
	private double diffuseReflection;
	private Color color;
	
	private Lambertian ambientBrdf;
	private Lambertian diffuseBrdf;
	
	public Matte(double ambientReflection, double diffuseReflection, Color color) {
		this.ambientReflection = ambientReflection;
		this.diffuseReflection = diffuseReflection;
		this.color = color;
		ambientBrdf = new Lambertian(ambientReflection, color);
		diffuseBrdf = new Lambertian(diffuseReflection, color);
	}

	@Override
	public Color shade(ShadingInfo shadingInfo) {
		Vector wo = new Vector(0.0,0.0,0.0).subtract(shadingInfo.getRay().getDirection()); // reverse direction
		Color luminance = ambientBrdf.rho(shadingInfo, wo).multiply(shadingInfo.getScene().getAmbient().luminance(shadingInfo));
		
		for (Light light : shadingInfo.getScene().getLights()) {
			Vector wi = light.direction(shadingInfo);
			double nDotWi = shadingInfo.getNormal().dotProduct(wi);
			
			if (nDotWi > 0.0) {
				luminance.addTo(diffuseBrdf.f(shadingInfo, wi, wo).multiply(light.luminance(shadingInfo)).multiply(nDotWi));
			}
		}
		
		return luminance;
	}

	public double getAmbientReflection() {
		return ambientReflection;
	}

	public void setAmbientReflection(double ambientReflection) {
		this.ambientReflection = ambientReflection;
	}

	public double getDiffuseReflection() {
		return diffuseReflection;
	}

	public void setDiffuseReflection(double diffuseReflection) {
		this.diffuseReflection = diffuseReflection;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
