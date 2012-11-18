package com.ivantod.trancer.scene;

import com.ivantod.trancer.sampler.MultiJitteredSampler;
import com.ivantod.trancer.sampler.RegularSampler;
import com.ivantod.trancer.sampler.Sampler;

public class ViewPlane {
	
	int hRes;
	int vRes;
	int pixelSize;
	double zw;
	double gamma = 1.0;
	double invGamma = 1/gamma;
	int numSamples;
	
	Sampler sampler;

	public ViewPlane(int hRes, int vRes, double zw, int pixelSize) {
		this.hRes = hRes;
		this.vRes = vRes;
		this.zw = zw;
		this.pixelSize = pixelSize;
	}


	// getters and setters
	
	public int getHRes() {
		return hRes;
	}

	public void setHRes(int hRes) {
		this.hRes = hRes;
	}

	public int getVRes() {
		return vRes;
	}

	public void setVRes(int vRes) {
		this.vRes = vRes;
	}

	public int getPixelSize() {
		return pixelSize;
	}

	public void setPixelSize(int pixelSize) {
		this.pixelSize = pixelSize;
	}

	public double getZw() {
		return zw;
	}

	public void setZw(double zw) {
		this.zw = zw;
	}

	public double getGamma() {
		return gamma;
	}

	public void setGamma(double gamma) {
		this.gamma = gamma;
		this.invGamma = 1/gamma;
	}

	public double getInvGamma() {
		return invGamma;
	}

	public int getNumSamples() {
		return numSamples;
	}

	public void setNumSamples(int numSamples) {
		this.numSamples = numSamples;

		if (numSamples>1) {
			//cout << "    Setting MultiJitteredSampler with " << numSamples << endl;
			sampler = new MultiJitteredSampler(numSamples);
		} else {
			//cout << "    Setting RegularSampler with " << numSamples << endl;
			sampler = new RegularSampler(1);
		}
	}

	public Sampler getSampler() {
		return sampler;
	}

	public void setSampler(Sampler sampler) {
		this.sampler = sampler;
	}
}
