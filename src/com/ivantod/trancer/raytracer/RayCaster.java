package com.ivantod.trancer.raytracer;

import com.ivantod.trancer.geometry.Ray;
import com.ivantod.trancer.scene.Scene;
import com.ivantod.trancer.scene.ShadingInfo;
import com.ivantod.trancer.util.color.Color;

public class RayCaster implements RayTracer {
	/*
	Scene scene;
	
	public RayCaster(Scene scene) {
		this.scene = scene;
	}
	*/

	@Override
	public Color traceRay(Ray ray, Scene scene) {
		ShadingInfo shadingInfo = new ShadingInfo(scene.hitObject(ray));
		if (shadingInfo.isObjectHit()) {
			// shadingInfo.setRay(ray); // for specular reflection.
			return shadingInfo.getMaterial().shade(shadingInfo);
		}  else {
			return scene.getBackgroundColor();
		}
	}

}
