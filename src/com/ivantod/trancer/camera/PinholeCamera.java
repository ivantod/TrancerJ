package com.ivantod.trancer.camera;

import com.ivantod.trancer.geometry.Point;
import com.ivantod.trancer.geometry.Point2D;
import com.ivantod.trancer.geometry.Ray;
import com.ivantod.trancer.geometry.Vector;
import com.ivantod.trancer.scene.Scene;
import com.ivantod.trancer.util.color.Color;
import com.ivantod.trancer.util.file.TGAFileSupport;

public class PinholeCamera extends Camera {
	
	private double zoom;
	private double d; // view plane distance

	PinholeCamera(Point eye, Point lookAt, float d) {
		this.eye = eye;
		this.lookAt = lookAt;
		this.d = d;
		this.zoom = 1.0;
	}
	
	private Vector calculateRayDirection(Point2D p) {
		//Vector direction = u * p.x + v * p.y - w * d;
		//direction.normalise();
		Vector direction = u.multiply(p.getX()).add(v.multiply(p.getY())).add(w.multiply(d));
		direction.normalise();
		
		return direction;
	}
	
	@Override
	public void renderScene(Scene s) {
		
		
		Ray ray = new Ray(); 

		//int depth = 0; // recursion depth, not used right now

		Point2D squarePoint; // sample point on unit square
		Point2D pixelPoint = new Point2D(); // sample point on pixel

		ray.setOrigin(eye);

		int pixelSize = s.getViewPlane().getPixelSize(); // / zoom;
		
		int hRes = s.getViewPlane().getHRes();
		int vRes = s.getViewPlane().getVRes();

		TGAFileSupport tgaSupport = new TGAFileSupport("/Users/ivantod/test.tga");
		tgaSupport.prepareHeader(hRes, vRes);

		for (int row=0; row < vRes; row++) {
			for (int col=0; col < hRes; col++) {
				Color pixelColour = new Color(); // black
				if (s.getViewPlane().getSampler() == null) {
					// no antialiasing
					double xd = pixelSize * (col - 0.5 * (hRes - 1.0));
					double yd = pixelSize * (row - 0.5 * (vRes - 1.0));
					ray.setDirection(calculateRayDirection(new Point2D(xd, yd)));
					pixelColour = s.getRayTracer().traceRay(ray, s);
				} else {
					// antialiasing based on sampling
					for (int j=0; j<s.getViewPlane().getNumSamples(); j++) {
						squarePoint = s.getViewPlane().getSampler().sampleUnitSquare();
						pixelPoint.setX( pixelSize * (col - 0.5 * hRes + squarePoint.getX()) );
						pixelPoint.setY( pixelSize * (row - 0.5 * vRes + squarePoint.getY()) );

						ray.setDirection(calculateRayDirection(pixelPoint));

						pixelColour.addTo(s.getRayTracer().traceRay(ray, s));
					}

					pixelColour.normaliseWith(s.getViewPlane().getNumSamples()); // normalise colour back to values in interval [0,1]
					//pixelColour *= exposureTime;

					//cout << pixelColour.red << " " << pixelColour.green << " " << pixelColour.blue << endl;
				}
				tgaSupport.writePixel(pixelColour);
			}
		}

	}

	public double getZoom() {
		return zoom;
	}

	public void setZoom(double zoom) {
		this.zoom = zoom;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	
}
