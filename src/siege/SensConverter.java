package siege;


public class SensConverter {

	
	private double oldAds;
	private double aspectRatio;
	private double a;
	private double b;
	private double horFov;
	private double vertFov;
	private double fovMultiplier;
	private double adsMultiplier;
	
	
	public SensConverter(double oldAds, double a, double b, double vertFov, double fovMultiplier,
			double adsMultiplier) {
		this.oldAds = oldAds;
		this.a = a;
		this.b = b;
		this.vertFov = vertFov;
		this.fovMultiplier = fovMultiplier;
		this.adsMultiplier = adsMultiplier;
	}
	
	public double aspectRatio() {
		aspectRatio = a / b;
		return aspectRatio;
	}
	public double horizontalFov() {
		horFov = Math.toDegrees(2 * Math.atan(aspectRatio() * Math.tan(Math.toRadians(vertFov) / 2)));
		return horFov;
	}

	public double verticalFov(){
		vertFov = 2 * Math.atan(Math.tan(Math.toRadians(75)) * aspectRatio());
		return vertFov;
	}

	public double fovAdjustment() {
		double fovAdjustment;
		if(horizontalFov() > 150) {
			fovAdjustment = Math.tan(verticalFov() * fovMultiplier / 2) / Math.tan(verticalFov()/2);
		}
		else {
			fovAdjustment = Math.tan(Math.toRadians(vertFov) * fovMultiplier / 2) / Math.tan(Math.toRadians(vertFov)/2);
		}
		return fovAdjustment;
	}

	public double newADS() {
		double newAds = (adsMultiplier/fovAdjustment()) * oldAds;
		return newAds;
	}
	
	public double trueADS() {
		double trueAds = (adsMultiplier/fovAdjustment()) * oldAds * 0.02;
		return trueAds;
	}
	
	public double adjustedADS() {
		double trueAds = (adsMultiplier/fovAdjustment()) * oldAds * 0.02 / newMultiplier();
		return trueAds;
	}
	
	public double newMultiplier() {
		double newMultiplier = 0 ;
		return newMultiplier;
		
	}
	
	
}
