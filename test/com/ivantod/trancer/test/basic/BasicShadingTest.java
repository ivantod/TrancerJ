package com.ivantod.trancer.test.basic;

import org.junit.Test;

import com.ivantod.trancer.camera.Camera;
import com.ivantod.trancer.camera.PinholeCamera;
import com.ivantod.trancer.geometry.Point;
import com.ivantod.trancer.geometry.Vector;
import com.ivantod.trancer.light.AmbientLight;
import com.ivantod.trancer.light.PointLight;
import com.ivantod.trancer.material.Matte;
import com.ivantod.trancer.material.Phong;
import com.ivantod.trancer.primitive.Shape;
import com.ivantod.trancer.primitive.Sphere;
import com.ivantod.trancer.raytracer.RayCaster;
import com.ivantod.trancer.raytracer.RayTracer;
import com.ivantod.trancer.scene.Scene;
import com.ivantod.trancer.scene.ViewPlane;
import com.ivantod.trancer.util.color.Color;

public class BasicShadingTest {

	//@Test
	public void basicShadingTest() {
		double zw = 50.0;
		double zEye = 500.0;
		double zDist = 1000.0;


		System.out.println("*** Trancer starting!");

		ViewPlane viewPlane = new ViewPlane(400, 400, zw, 1);
		viewPlane.setNumSamples(16);

		System.out.println("+++ ViewPlane initialised.");

		RayTracer tracer = new RayCaster();

		System.out.println("+++ RayTracer initialised.");

		Scene scene = new Scene(viewPlane, tracer, zEye, zDist);

		System.out.println("+++ Scene initialised.");

//		Color red = new Color(1.0, 0.0, 0.0);
		Color yellow = new Color(1.0, 1.0, 0.0);
		
		AmbientLight ambient = new AmbientLight();
		scene.setAmbient(ambient);
		
		PointLight pointLight = new PointLight(new Vector(100, 50, 150));
		pointLight.setLs(3.0);
		scene.addLight(pointLight);

		Shape shape = new Sphere(new Point(10.0,-5.0, 0), 27.0, yellow);
		
		Matte matte = new Matte(0.25, 0.65, yellow);
		
		shape.setMaterial(matte);
		
		scene.addShape(shape);

	//	shape = new Sphere(new Point(20.0, 30.0, 0.0), 60, yellow);
	//	scene.addShape(shape);

		System.out.println("+++ Scene built.");

		Camera camera = new PinholeCamera(new Point(0,0,500), new Point(-5,0,0), 850.0);
		camera.computeUnitVectors();

		System.out.println("+++ Camera initialised.");

		System.out.println("+++ Rendering started.");
		
		camera.renderScene(scene);

		//scene->renderScene();
		//scene->renderPerspective();

		System.out.println("+++ Scene rendered.");
	}

	//@Test
	public void anotherShadingTest() {
		double zw = 50.0;
		double zEye = 500.0;
		double zDist = 1000.0;


		System.out.println("*** Trancer starting!");

		ViewPlane viewPlane = new ViewPlane(250, 250, zw, 1);
		viewPlane.setNumSamples(16);

		System.out.println("+++ ViewPlane initialised.");

		RayTracer tracer = new RayCaster();

		System.out.println("+++ RayTracer initialised.");

		Scene scene = new Scene(viewPlane, tracer, zEye, zDist);

		System.out.println("+++ Scene initialised.");

		Color red = new Color(1.0, 0.0, 0.0);
		Color yellow = new Color(1.0, 1.0, 0.0);
		
		AmbientLight ambient = new AmbientLight();
		scene.setAmbient(ambient);
		
		PointLight pointLight = new PointLight(new Vector(230, 220, 150));
		pointLight.setLs(3.0);
		scene.addLight(pointLight);

		Shape shape = new Sphere(new Point(0.0,-25.0, 0.0), 80.0, red);
		Matte matte = new Matte(0.25, 0.65, red);
		shape.setMaterial(matte);
		scene.addShape(shape);

		shape = new Sphere(new Point(90.0, 100.0, 70.0), 50, yellow);
		matte = new Matte(0.25, 0.65, yellow);
		shape.setMaterial(matte);
		scene.addShape(shape);
		
		System.out.println("+++ Scene built.");

		Camera camera = new PinholeCamera(new Point(300,400,500), new Point(0,0,-50), 500.0);
		camera.computeUnitVectors();

		System.out.println("+++ Camera initialised.");

		System.out.println("+++ Rendering started.");
		
		camera.renderScene(scene);

		//scene->renderScene();
		//scene->renderPerspective();

		System.out.println("+++ Scene rendered.");
	}
	
	//@Test
	public void doubledShadingTest() {
		double zw = 100.0;
		double zEye = 1000.0;
		double zDist = 2000.0;


		System.out.println("*** Trancer starting!");

		ViewPlane viewPlane = new ViewPlane(500, 500, zw, 1);
		viewPlane.setNumSamples(16);

		System.out.println("+++ ViewPlane initialised.");

		RayTracer tracer = new RayCaster();

		System.out.println("+++ RayTracer initialised.");

		Scene scene = new Scene(viewPlane, tracer, zEye, zDist);

		System.out.println("+++ Scene initialised.");

		Color red = new Color(1.0, 0.0, 0.0);
		Color yellow = new Color(1.0, 1.0, 0.0);
		Color blue = new Color(0.0, 0.6, 1.0);
		
		AmbientLight ambient = new AmbientLight();
		scene.setAmbient(ambient);
		
		PointLight pointLight = new PointLight(new Vector(460, 440, 300));
		pointLight.setLs(3.0);
		scene.addLight(pointLight);

		Shape shape = new Sphere(new Point(0.0,-50.0, 0.0), 160.0, red);
		Matte matte = new Matte(0.25, 0.65, red);
		shape.setMaterial(matte);
		scene.addShape(shape);

		shape = new Sphere(new Point(180.0, 200.0, 140.0), 100, yellow);
		matte = new Matte(0.25, 0.65, yellow);
		shape.setMaterial(matte);
		scene.addShape(shape);
		
		//shape = new Sphere(new Point(-60.0, 200, 140.0), 100, blue);
		shape = new Sphere(new Point(-220.0, 50, -140.0), 100, blue);
		matte = new Matte(0.25, 0.65, blue);
		shape.setMaterial(matte);
		scene.addShape(shape);
		
		System.out.println("+++ Scene built.");

		Camera camera = new PinholeCamera(new Point(600,800,1000), new Point(0,0,-100), 1000.0);
		camera.computeUnitVectors();

		System.out.println("+++ Camera initialised.");

		System.out.println("+++ Rendering started.");
		
		camera.renderScene(scene);

		//scene->renderScene();
		//scene->renderPerspective();

		System.out.println("+++ Scene rendered.");
	}
	
	@Test
	public void phongShadingTest() {
		double zw = 100.0;
		double zEye = 1000.0;
		double zDist = 2000.0;
		double phongExp = 40;


		System.out.println("*** Trancer starting!");

		ViewPlane viewPlane = new ViewPlane(500, 500, zw, 1);
		viewPlane.setNumSamples(16);

		System.out.println("+++ ViewPlane initialised.");

		RayTracer tracer = new RayCaster();

		System.out.println("+++ RayTracer initialised.");

		Scene scene = new Scene(viewPlane, tracer, zEye, zDist);

		System.out.println("+++ Scene initialised.");

		Color red = new Color(1.0, 0.0, 0.0);
		Color yellow = new Color(1.0, 1.0, 0.0);
		Color blue = new Color(0.0, 0.6, 1.0);
		
		AmbientLight ambient = new AmbientLight();
		scene.setAmbient(ambient);
		
		PointLight pointLight = new PointLight(new Vector(460, 440, 300));
		pointLight.setLs(3.0);
		pointLight.setCastsShadow(false);
		scene.addLight(pointLight);
		
		pointLight = new PointLight(new Vector(-460, 440, 300));
		pointLight.setLs(3.0);
		pointLight.setCastsShadow(false);
		scene.addLight(pointLight);
    
		Shape shape = new Sphere(new Point(0.0,-50.0, 0.0), 160.0, red);
		Phong phong = new Phong(0.25, 0.65, 0.2, phongExp, red);
		shape.setMaterial(phong);
		scene.addShape(shape);

		shape = new Sphere(new Point(180.0, 200.0, 140.0), 100, yellow);
		phong = new Phong(0.25, 0.65, 0.1, phongExp, yellow);
		shape.setMaterial(phong);
		scene.addShape(shape);
		
		//shape = new Sphere(new Point(-60.0, 200, 140.0), 100, blue);
		shape = new Sphere(new Point(-220.0, 50, -140.0), 100, blue);
		phong = new Phong(0.25, 0.65, 0.12, phongExp, blue);
		shape.setMaterial(phong);
		scene.addShape(shape);
		
		System.out.println("+++ Scene built.");

		Camera camera = new PinholeCamera(new Point(600,800,1000), new Point(0,0,-100), 1000.0);
		camera.computeUnitVectors();

		System.out.println("+++ Camera initialised.");

		System.out.println("+++ Rendering started.");
		
		camera.renderScene(scene);

		//scene->renderScene();
		//scene->renderPerspective();

		System.out.println("+++ Scene rendered.");
	}
	
}
