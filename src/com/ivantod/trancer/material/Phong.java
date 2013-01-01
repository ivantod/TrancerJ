package com.ivantod.trancer.material;

import com.ivantod.trancer.brdf.GlossySpecular;
import com.ivantod.trancer.brdf.Lambertian;
import com.ivantod.trancer.geometry.Vector;
import com.ivantod.trancer.light.Light;
import com.ivantod.trancer.scene.ShadingInfo;
import com.ivantod.trancer.util.color.Color;

public class Phong implements Material {

	private double ambientReflection;
	private double diffuseReflection;
	private double specularReflection;
	private Color color;
	
	private Lambertian ambientBrdf;
	private Lambertian diffuseBrdf;
	private GlossySpecular specularBrdf;
	
	public Phong(double ambientReflection, double diffuseReflection, double specularReflection, double exp, Color color) {
		this.ambientReflection = ambientReflection;
		this.diffuseReflection = diffuseReflection;
		this.specularReflection = specularReflection;
		this.color = color;
		
		ambientBrdf = new Lambertian(ambientReflection, color);
		diffuseBrdf = new Lambertian(diffuseReflection, color);
		specularBrdf = new GlossySpecular(specularReflection, color, exp);
	}

	@Override
	public Color shade(ShadingInfo shadingInfo) {
		Vector wo = new Vector(0.0,0.0,0.0).subtract(shadingInfo.getRay().getDirection()); // reverse direction
		Color luminance = ambientBrdf.rho(shadingInfo, wo).multiply(shadingInfo.getScene().getAmbient().luminance(shadingInfo));
		
		for (Light light : shadingInfo.getScene().getLights()) {
			Vector wi = light.direction(shadingInfo);
			double nDotWi = shadingInfo.getNormal().dotProduct(wi);
			
			if (nDotWi > 0.0) {
				luminance.addTo(diffuseBrdf.f(shadingInfo, wi, wo).add(specularBrdf.f(shadingInfo, wi, wo)).multiply(light.luminance(shadingInfo)).multiply(nDotWi));
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

	public double getSpecularReflection() {
		return specularReflection;
	}

	public void setSpecularReflection(double specularReflection) {
		this.specularReflection = specularReflection;
	}

}
