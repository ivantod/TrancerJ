package com.ivantod.trancer.material;

import com.ivantod.trancer.scene.ShadingInfo;
import com.ivantod.trancer.util.color.Color;

public interface Material {

	public Color shade(ShadingInfo shadingInfo);
}
