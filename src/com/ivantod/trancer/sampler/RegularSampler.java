package com.ivantod.trancer.sampler;

import com.ivantod.trancer.util.geom.Point2D;

public class RegularSampler extends Sampler {

	
	public RegularSampler() {
		super();
	}

	public RegularSampler(int numSamples) {
		super(numSamples);
	}
	
	
	@Override
	public void generateSamples() {
		int n = (int) Math.sqrt(numSamples);

		for (int j = 0; j < numSets; j++) {
			for (int p = 0; p < n; p++)	{
				for (int q = 0; q < n; q++) {
					samples.add(new Point2D((q + 0.5) / n, (p + 0.5) / n));
				}
			}
		}
	}

}
