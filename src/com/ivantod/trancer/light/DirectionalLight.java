package com.ivantod.trancer.light;

import com.ivantod.trancer.geometry.Vector;
import com.ivantod.trancer.scene.ShadingInfo;
import com.ivantod.trancer.util.color.Color;

public class DirectionalLight extends Light {

	
	private double ls;
	private Color color;
	private Vector direction; // direction should always be a unit vector ||direction||==1.
	
	public DirectionalLight(Vector direction) {
		ls = 1.0;
		color = new Color(1.0, 1.0, 1.0);
		setDirection(direction);
	}
	
	public DirectionalLight() {
		this(new Vector(0.0, 1.0, 0.0));
	}
	
	@Override
	public Vector direction(ShadingInfo shadingInfo) {
		return direction;
	}

	@Override
	public Color luminance(ShadingInfo shadingInfo) {
		return color.multiply(ls);
	}

	public double getLs() {
		return ls;
	}

	public void setLs(double ls) {
		this.ls = ls;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Vector getDirection() {
		return direction;
	}

	public void setDirection(Vector direction) {
		this.direction = direction;
		direction.normalise();
	}

}
