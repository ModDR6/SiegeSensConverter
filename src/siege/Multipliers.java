package siege;

import java.util.ArrayList;

public class Multipliers {
	
	public ArrayList<Double> collectArraysFov() {
		ArrayList<Double> fovMultis  = new ArrayList<Double>();
		final double fov1 = 0.9;
		final double fov15 = 0.59;
		final double fov2 = 0.49;
		final double fov25 = 0.42;
		final double fov3 = 0.35;
		final double fov4 = 0.3;
		final double fov5 = 0.22;
		final double fov12 = 0.092;
		fovMultis.add(fov1);
		fovMultis.add(fov15);
		fovMultis.add(fov2);
		fovMultis.add(fov25);
		fovMultis.add(fov3);
		fovMultis.add(fov4);
		fovMultis.add(fov5);
		fovMultis.add(fov12);
		return fovMultis;
		
	}

	public ArrayList<Double> collectArrayAds() {
		ArrayList<Double> adsMultis  = new ArrayList<Double>();
		final double ads1 = 0.6;
		final double ads15 = 0.59;
		final double ads2 = 0.49;
		final double ads25 = 0.42;
		final double ads3 = 0.35;
		final double ads4 = 0.3;
		final double ads5 = 0.22;
		final double ads12 = 0.14;
		adsMultis.add(ads1);
		adsMultis.add(ads15);
		adsMultis.add(ads2);
		adsMultis.add(ads25);
		adsMultis.add(ads3);
		adsMultis.add(ads4);
		adsMultis.add(ads5);
		adsMultis.add(ads12);
		return adsMultis;
	}

}
