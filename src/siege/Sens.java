package siege;

public class Sens {
	private double multiplier;
	private double ads1;
	private double ads15;
	private double ads2;
	private double ads25;
	private double ads3;
	private double ads4;
	private double ads5;
	private double ads12;
	
	public Sens(double ads1, double ads15, double ads2, double ads25, double ads3, double ads4,
			double ads5, double ads12, double multi) {
		this.multiplier = multi;
		this.ads1 = ads1;
		this.ads15 = ads15;
		this.ads2 = ads2;
		this.ads25 = ads25;
		this.ads3 = ads3;
		this.ads4 = ads4;
		this.ads5 = ads5;
		this.ads12 = ads12;
	}

	public double getMulti() {
		return multiplier;
	}

	public double getAds1() {
		return ads1;
	}

	public double getAds15() {
		return ads15;
	}

	public double getAds2() {
		return ads2;
	}

	public double getAds25() {
		return ads25;
	}

	public double getAds3() {
		return ads3;
	}

	public double getAds4() {
		return ads4;
	}

	public double getAds5() {
		return ads5;
	}

	public double getAds12() {
		return ads12;
	}
	
	
	
}
