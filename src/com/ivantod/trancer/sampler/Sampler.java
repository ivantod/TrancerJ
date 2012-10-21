package com.ivantod.trancer.sampler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ivantod.trancer.util.geom.Point;
import com.ivantod.trancer.util.geom.Point2D;

public abstract class Sampler {

	protected int numSamples;
	protected int numSets;
	protected List<Point2D> samples; // sample points on a unit square
	protected List<Point2D> diskSamples; // sample points on a unit disk
	protected List<Point> hemisphereSamples; // sample points on a unit hemisphere
	protected List<Point> sphereSamples;
	protected List<Integer> shuffledIndices;
	protected long count; // the current number of sample points used
	protected int jump; // random jump
	
	public Sampler() {
		this(1, 83);
	}
	
	public Sampler(int numSamples) {
		this(numSamples, 83);
	}
	
	public Sampler(int numSamples, int numSets) {
		this.numSamples = numSamples;
		this.numSets = numSets;
		this.count = 0;
		this.jump = 0;
		setupShuffledIndices();
	}
	
	public void setupShuffledIndices() {
		List<Integer> indices = new ArrayList<Integer>(numSamples * numSets);
	
		for (int j=0; j<numSamples; j++) indices.add(j);
	
		for (int p=0; p<numSets; p++) {
			Collections.shuffle(indices);
	
			for (int j=0; j<numSamples; j++) {
				shuffledIndices.add(indices.get(j));
			}
		}
	}
	
	public abstract void generateSamples();
	
	
	// getters and setters
	
	public int getNumSamples() {
		return numSamples;
	}
	public void setNumSamples(int numSamples) {
		this.numSamples = numSamples;
	}
	public int getNumSets() {
		return numSets;
	}
	public void setNumSets(int numSets) {
		this.numSets = numSets;
	}
	public List<Point2D> getSamples() {
		return samples;
	}
	public void setSamples(List<Point2D> samples) {
		this.samples = samples;
	}
	public List<Point2D> getDiskSamples() {
		return diskSamples;
	}
	public void setDiskSamples(List<Point2D> diskSamples) {
		this.diskSamples = diskSamples;
	}
	public List<Point> getHemisphereSamples() {
		return hemisphereSamples;
	}
	public void setHemisphereSamples(List<Point> hemisphereSamples) {
		this.hemisphereSamples = hemisphereSamples;
	}
	public List<Point> getSphereSamples() {
		return sphereSamples;
	}
	public void setSphereSamples(List<Point> sphereSamples) {
		this.sphereSamples = sphereSamples;
	}
	public List<Integer> getShuffledIndices() {
		return shuffledIndices;
	}
	public void setShuffledIndices(List<Integer> shuffledIndices) {
		this.shuffledIndices = shuffledIndices;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public int getJump() {
		return jump;
	}
	public void setJump(int jump) {
		this.jump = jump;
	}
	
	
	
}
