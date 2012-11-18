package com.ivantod.trancer.camera;

import com.ivantod.trancer.geometry.Point;
import com.ivantod.trancer.geometry.Vector;
import com.ivantod.trancer.scene.Scene;

public abstract class Camera {

	protected Point eye;
	protected Point lookAt;
	protected Vector up;
	protected Vector u, v, w;
	protected double exposureTime;
	protected double rotAngle;
	
	public Camera() {
		eye = new Point(0, 0, 500);
		lookAt = new Point(0, 0, 0);
		up = new Vector(0, 1, 0);
		u = new Vector(1, 0, 0);
		v = new Vector(0, 1, 0);
		w = new Vector(0, 0, 1);
		exposureTime = 1.0;
		rotAngle = 0; 
	}
	
	public abstract void renderScene(Scene s);
	
	public void computeUnitVectors() {
		w = eye.subtract(lookAt);
		w.normalise();
		u = up.crossProduct(w);
		u.normalise();
		v = w.crossProduct(u);

		if (eye.getX() == lookAt.getX() && eye.getZ() == lookAt.getZ() && eye.getY() > lookAt.getY()) { // camera looking vertically down
			u = new Vector(0, 0, 1);
			v = new Vector(1, 0, 0);
			w = new Vector(0, 1, 0);
		}

		if (eye.getX() == lookAt.getX() && eye.getZ() == lookAt.getZ() && eye.getY() < lookAt.getY()) { // camera looking vertically up
			u = new Vector(1, 0, 0);
			v = new Vector(0, 0, 1);
			w = new Vector(0, -1, 0);
		}

		/* doesn't work, no rotation supported at the moment
		if (rotAngle!=0) {
			double radians = rotAngle*PI/180;
			u.rotateZAxis(radians);
			v.rotateZAxis(radians);
			u.normalise();
			v.normalise();
		}
		*/
	}

	
	// getters and setters
	
	public Point getEye() {
		return eye;
	}

	public void setEye(Point eye) {
		this.eye = eye;
	}

	public Point getLookAt() {
		return lookAt;
	}

	public void setLookAt(Point lookAt) {
		this.lookAt = lookAt;
	}

	public Vector getUp() {
		return up;
	}

	public void setUp(Vector up) {
		this.up = up;
	}

	public Vector getU() {
		return u;
	}

	public void setU(Vector u) {
		this.u = u;
	}

	public Vector getV() {
		return v;
	}

	public void setV(Vector v) {
		this.v = v;
	}

	public Vector getW() {
		return w;
	}

	public void setW(Vector w) {
		this.w = w;
	}

	public double getExposureTime() {
		return exposureTime;
	}

	public void setExposureTime(double exposureTime) {
		this.exposureTime = exposureTime;
	}

	public double getRotAngle() {
		return rotAngle;
	}

	public void setRotAngle(double rotAngle) {
		this.rotAngle = rotAngle;
	}
	
	
}
