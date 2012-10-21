package com.ivantod.trancer.util.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.ivantod.trancer.util.color.Color;

public class TGAFileSupport {
	
	RandomAccessFile f;

	public TGAFileSupport(String filePath) {
		try {
			f = new RandomAccessFile(filePath, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void prepareHeader(int xSize, int ySize) {
		try {
			f.writeByte(0); // No id present.
			f.writeByte(0); // No colour map is included.
			f.writeByte(2); // Uncompressed RBG image
			f.writeByte(0); f.writeByte(0); f.writeByte(0); f.writeByte(0); f.writeByte(0); // Colour map info (5 bytes), we don't care.
			f.writeByte(0); f.writeByte(0); // X-origin (2 bytes), set it to zero.
			f.writeByte(0); f.writeByte(0); // Y-origin (2 bytes), set it to zero.
			f.writeByte(xSize & 0x00FF); f.writeByte((xSize & 0xFF00) / 256); // Max X size of image, low byte first.
			f.writeByte(ySize & 0x00FF); f.writeByte((ySize & 0xFF00) / 256); // Max Y size of image, low byte first.
			f.writeByte(24); // Image has 24-bit colour.
			f.writeByte(0); // Image descriptor, we don't care.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writePixel(double r, double g, double b) {
		try {
			f.writeByte((int) Math.min(b*255.0, 255.0));
			f.writeByte((int) Math.min(g*255.0, 255.0));
			f.writeByte((int) Math.min(r*255.0, 255.0));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writePixel(Color c) {
		writePixel(c.getR(), c.getG(), c.getB());
	}
}
