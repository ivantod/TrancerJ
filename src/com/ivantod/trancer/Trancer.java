package com.ivantod.trancer;

import com.ivantod.trancer.camera.Camera;
import com.ivantod.trancer.camera.PinholeCamera;
import com.ivantod.trancer.geometry.Point;
import com.ivantod.trancer.primitive.Shape;
import com.ivantod.trancer.primitive.Sphere;
import com.ivantod.trancer.raytracer.MultiObjectRayTracer;
import com.ivantod.trancer.raytracer.RayTracer;
import com.ivantod.trancer.scene.Scene;
import com.ivantod.trancer.scene.ViewPlane;
import com.ivantod.trancer.util.color.Color;

public class Trancer {

	private void buildScene(Scene scene) {
		Color red = new Color(1.0, 0.0, 0.0);
		Color yellow = new Color(1.0, 1.0, 0.0);

		Shape shape = new Sphere(new Point(0.0,-25.0, 0.0), 80.0, red);
		scene.addShape(shape);

		shape = new Sphere(new Point(20.0, 30.0, 0.0), 60, yellow);
		scene.addShape(shape);
	}

	
	public void createRenderedFile() {

//		double zw = 100.0;
//		double zEye = 600.0;

		double zw = 50.0;
		double zEye = 500.0;
		double zDist = 1000.0;


		System.out.println("*** Trancer starting!\n");

		ViewPlane viewPlane = new ViewPlane(250, 250, zw, 1);
		viewPlane.setNumSamples(25);

		System.out.println("+++ ViewPlane initialised.\n");

		RayTracer tracer = new MultiObjectRayTracer();

		System.out.println("+++ RayTracer initialised.\n");

		Scene scene = new Scene(viewPlane, tracer, zEye, zDist);

		System.out.println("+++ Scene initialised.\n");

		buildScene(scene);

		System.out.println("+++ Scene built.\n");

		Camera camera = new PinholeCamera(new Point(300,400,500), new Point(0,0,-50), 500);
		camera.computeUnitVectors();

		System.out.println("+++ Camera initialised.\n");

		camera.renderScene(scene);

		//scene->renderScene();
		//scene->renderPerspective();

		System.out.println("+++ Scene rendered.\n");

	}
	
	public static void main(String... args) {
		Trancer t = new Trancer();
		t.createRenderedFile();
	}

}
