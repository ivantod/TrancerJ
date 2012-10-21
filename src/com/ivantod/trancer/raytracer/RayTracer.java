package com.ivantod.trancer.raytracer;

import com.ivantod.trancer.geometry.Ray;
import com.ivantod.trancer.scene.Scene;
import com.ivantod.trancer.util.color.Color;

public interface RayTracer {
	
	public Color traceRay(Ray ray, Scene scene);

}
