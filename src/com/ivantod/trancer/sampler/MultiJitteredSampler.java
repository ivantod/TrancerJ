package com.ivantod.trancer.sampler;

import com.ivantod.trancer.geometry.Point2D;
import com.ivantod.trancer.util.math.MathFunc;

public class MultiJitteredSampler extends Sampler {
	
	public MultiJitteredSampler() {
		super();
	}
	
	public MultiJitteredSampler(int numSamples, int numSets) {
		super(numSamples, numSets);
	}

	public MultiJitteredSampler(int numSamples) {
		super(numSamples);
	}



	@Override
	public void generateSamples() {	
		int n = (int) Math.sqrt(numSamples);
		double subcellWidth = 1.0 / (numSamples);

		// fill samples list with dummy points, to make life easier later.
		
		for (int j = 0; j < numSamples * numSets; j++) samples.add(new Point2D());

		// distribute points in the initial patterns

		for (int p = 0; p < numSets; p++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					samples.get(i * n + j + p * numSamples).setX((i * n + j) * subcellWidth + MathFunc.randFloat(0, subcellWidth));
					samples.get(i * n + j + p * numSamples).setY((j * n + i) * subcellWidth + MathFunc.randFloat(0, subcellWidth));
				}
			}
		}

		// shuffle x coordinates

		for (int p = 0; p < numSets; p++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int k = MathFunc.randInt(j, n - 1);
					double t = samples.get(i * n + j + p * numSamples).getX();
					samples.get(i * n + j + p * numSamples).setX(samples.get(i * n + k + p * numSamples).getX());
					samples.get(i * n + k + p * numSamples).setX(t);
				}
			}
		}

		// shuffle y coordinates

		for (int p = 0; p < numSets; p++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int k = MathFunc.randInt(j, n - 1);
					double t = samples.get(j * n + i + p * numSamples).getY();
					samples.get(j * n + i + p * numSamples).setY(samples.get(k * n + i + p * numSamples).getY());
					samples.get(k * n + i + p * numSamples).setY(t);
				}
			}
		}

	}

	@Override
	public Point2D sampleUnitSquare() {
		// TODO Auto-generated method stub
		return null;
	}

}
