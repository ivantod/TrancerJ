package com.ivantod.trancer.primitive;

import org.apache.commons.lang3.mutable.MutableDouble;

import com.ivantod.trancer.geometry.Ray;
import com.ivantod.trancer.scene.ShadingInfo;
import com.ivantod.trancer.util.color.Color;
import com.ivantod.trancer.util.geom.Point;
import com.ivantod.trancer.util.geom.Vector;
import com.ivantod.trancer.util.math.MathConst;

public class Sphere extends Shape {
	
	private double r;
	private Point centre;
	
	
	public Sphere(double r, Point centre, Color color) {
		this.r = r;
		this.centre = centre;
		this.color = color;
	}

	@Override
	public boolean intersect(Ray ray, MutableDouble tMin, ShadingInfo shadingInfo) {
		double t;
		
		Vector temp = ray.getOrigin().subtract(centre);
		double a = ray.getDirection().dotProduct(ray.getDirection());
		double b = 2.0 * (temp.dotProduct(ray.getDirection()));
		double c = temp.dotProduct(temp) - r * r;

		double discriminant = b*b - 4*a*c;

		if (discriminant<0.0) {
			return false;
		} else {
			double e = Math.sqrt(discriminant);
			double denom = 2.0 * a;
			t = (-b - e)/denom;  // smaller root
			if (t > MathConst.EPSILON) {
				tMin.setValue(t);
				shadingInfo.setNormal( ray.getDirection().multiply(t).add(temp).divide(r) ); // (temp + ray.direction * t) / r
				shadingInfo.setLocalHitPoint( ray.getOrigin().add(ray.getDirection().multiply(t)) ); // ray.origin + ray.direction * t
				return true;
			}

			t = (-b + e)/denom; // larger root
			if (t > MathConst.EPSILON) {
				tMin.setValue(t);
				shadingInfo.setNormal( ray.getDirection().multiply(t).add(temp).divide(r) );
				shadingInfo.setLocalHitPoint( ray.getOrigin().add(ray.getDirection().multiply(t)) );
				return true;
			}
		}

		return false;
	}

	
	// getters and setters
	
	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}
}
