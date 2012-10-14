package com.ivantod.trancer.primitive;

import com.ivantod.trancer.geometry.Ray;
import com.ivantod.trancer.scene.ShadingInfo;

public interface Shape {

	public boolean intersect(Ray r, double tMin, ShadingInfo shadingInfo);
}
