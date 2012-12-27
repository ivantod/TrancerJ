package com.ivantod.trancer.raytracer;

import java.util.List;

import org.apache.commons.lang3.mutable.MutableDouble;

import com.ivantod.trancer.geometry.Ray;
import com.ivantod.trancer.primitive.Shape;
import com.ivantod.trancer.scene.Scene;
import com.ivantod.trancer.scene.ShadingInfo;
import com.ivantod.trancer.util.color.Color;

public class MultiObjectRayTracer implements RayTracer {

	@Override
	public Color traceRay(Ray ray, Scene scene) {
		ShadingInfo shadingInfo = new ShadingInfo(scene);
		double tMin = 999999.0;
		MutableDouble t = new MutableDouble(tMin);

		List<Shape> shapes = scene.getShapes();
		
		int numShapes = shapes.size();

		// cout << " Size of shapes is: ";
		// cout << numShapes << ". Begin for loop: ";

		for (int i = 0; i < numShapes; i++) {
			Shape s = shapes.get(i);
			// cout << i << ",";
			boolean hit = s.intersect(ray, t, shadingInfo);
			//if (hit) System.out.println("HIT! "+s.getColor());
			if (hit && t.getValue()<tMin) {
				shadingInfo.setColor(s.getColor());
				shadingInfo.setObjectHit(true);
			}
		}

		// cout << " and for loop done " << endl;

		if (shadingInfo.isObjectHit()) {
			return shadingInfo.getColor();
		} else {
			return scene.getBackgroundColor();
		}
	}

}
