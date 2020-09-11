package siege;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		double defaultMulti = 0.02;

		System.out.println("Exact Siege Sens Converter By @ModDR6\n");
		Multipliers multi = new Multipliers();
		ArrayList<Double> adsMultis = new ArrayList<Double>(multi.collectArrayAds());
		ArrayList<Double> fovMultis = new ArrayList<Double>(multi.collectArraysFov());
		ArrayList<Double> newAds = new ArrayList<Double>();

		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter Old ADS Senstivity:");
		int ads = myObj.nextInt();
		System.out.println("Enter FOV:");
		int fov = myObj.nextInt();
		System.out.println("Enter First Aspect Ratio Number (ex. 16 if 16:9):");
		int ar1 = myObj.nextInt();
		System.out.println("Enter Second Aspect Ratio Number (ex. 9 if 16:9):");
		int ar2 = myObj.nextInt();
		System.out.println();
		System.out.println("Old ADS: " + ads);
		System.out.println("FOV: " + fov);
		System.out.println("Aspect Ratio: " + ar1 + ":" + ar2);
		System.out.println();

		for (int i = 0; i < 8; i++) {
			SensConverter convert = new SensConverter(ads, ar1, ar2, fov, fovMultis.get(i), adsMultis.get(i));
			newAds.add(convert.newADS());
		}
		System.out.println("Siege ADS");
		System.out.println("ADS 1x = " + newAds.get(0));
		System.out.println("ADS 1.5x = " + newAds.get(1));
		System.out.println("ADS 2x = " + newAds.get(2));
		System.out.println("ADS 2.5x = " + newAds.get(3));
		System.out.println("ADS 3x = " + newAds.get(4));
		System.out.println("ADS 4x = " + newAds.get(5));
		System.out.println("ADS 5x = " + newAds.get(6));
		System.out.println("ADS 12x = " + newAds.get(7));

		System.out.println("\nTrue ADS");
		System.out.println("ADS 1x = " + newAds.get(0) * defaultMulti);
		System.out.println("ADS 1.5x = " + newAds.get(1) * defaultMulti);
		System.out.println("ADS 2x = " + newAds.get(2) * defaultMulti);
		System.out.println("ADS 2.5x = " + newAds.get(3) * defaultMulti);
		System.out.println("ADS 3x = " + newAds.get(4) * defaultMulti);
		System.out.println("ADS 4x = " + newAds.get(5) * defaultMulti);
		System.out.println("ADS 5x = " + newAds.get(6) * defaultMulti);
		System.out.println("ADS 12x = " + newAds.get(7) * defaultMulti);

		int select = promptOptimize(myObj);
		ArrayList<Sens> closest = new ArrayList<Sens>(minimize(findBest(newAds, defaultMulti, select)));
		printArrayList(closest);

	}

	public static double newMultiplier(double trueAds, double inputSens) {
		double adjustMulti = (trueAds / inputSens);
		return adjustMulti;
	}
	
	public static void printArrayList(ArrayList<Sens> closest) {
		for(int i = 0; i < closest.size(); i++) {
			System.out.println();
			System.out.println("Multiplier:"+closest.get(i).getMulti());
			System.out.println("ADS 1x = " + closest.get(i).getAds1());
			System.out.println("ADS 1.5x =" + closest.get(i).getAds15());
			System.out.println("ADS 2x = " + closest.get(i).getAds2());
			System.out.println("ADS 2.5x = " + closest.get(i).getAds25());
			System.out.println("ADS 3x = " + closest.get(i).getAds3());
			System.out.println("ADS 4x = " + closest.get(i).getAds4());
			System.out.println("ADS 5x = " + closest.get(i).getAds5());
			System.out.println("ADS 12x = " + closest.get(i).getAds12());
			System.out.println();
		}
		
	}

	public static ArrayList<Sens> findBest(ArrayList<Double> newAds, double defaultMulti, int select) {
		double ads1;
		double ads15;
		double ads2;
		double ads25;
		double ads3;
		double ads4;
		double ads5;
		double ads12;
		ArrayList<Sens> collection = new ArrayList<Sens>();

		for (int i = 1; i < 201; i++) {
			double newMulti = newMultiplier(newAds.get(select - 1) * defaultMulti, i);
			//System.out.println("\nNew ADS Multiplier: " + newMulti);
			//System.out.println("\nAdjusted ADS with Multiplier");


			ads1 = newAds.get(0) * defaultMulti / newMulti;
			ads15 = newAds.get(1) * defaultMulti / newMulti;
			ads2 = newAds.get(2) * defaultMulti / newMulti;
			ads25 = newAds.get(3) * defaultMulti / newMulti;
			ads3 = newAds.get(4) * defaultMulti / newMulti;
			ads4 = newAds.get(5) * defaultMulti / newMulti;
			ads5 = newAds.get(6) * defaultMulti / newMulti;
			ads12 = newAds.get(7) * defaultMulti / newMulti;

			Sens mySens = new Sens(ads1, ads15, ads2, ads25, ads3, ads4, ads5, ads12, newMulti);
			collection.add(mySens);

//			System.out.println("ADS 1x = " + ads1);
//			System.out.println("ADS 1.5x = " + ads15);
//			System.out.println("ADS 2x = " + ads2);
//			System.out.println("ADS 2.5x = " + ads25);
//			System.out.println("ADS 3x = " + ads3);
//			System.out.println("ADS 4x = " + ads4);
//			System.out.println("ADS 5x = " + ads5);
//			System.out.println("ADS 12x = " + ads12);

			if (ads12 > 200) {
				i = 201;
			}

		}
		return collection;

	}

	public static ArrayList<Sens> minimize(ArrayList<Sens> collection){
		ArrayList<Sens> possible = new ArrayList<Sens>();

		for(int i = 0; i < collection.size(); i++) {


			double ads1 = collection.get(i).getAds1();
			double ads15 = collection.get(i).getAds15();
			double ads2 = collection.get(i).getAds2();
			double ads25 = collection.get(i).getAds25();
			double ads3 = collection.get(i).getAds3();
			double ads4 = collection.get(i).getAds4();
			double ads5 = collection.get(i).getAds5();
			double ads12 = collection.get(i).getAds12();
			

			double adjAds1 = Math.round(ads1);
			double adjAds15 = Math.round(ads15);
			double adjAds2 = Math.round(ads2);
			double adjAds25 = Math.round(ads25);
			double adjAds3 = Math.round(ads3);
			double adjAds4 = Math.round(ads4);
			double adjAds5 = Math.round(ads5);
			double adjAds12 = Math.round(ads12);

			double pError1 = percentError(adjAds1, ads1);
			double pError15 = percentError(adjAds15, ads15);
			double pError2 = percentError(adjAds2, ads2);
			double pError25 = percentError(adjAds25, ads25);
			double pError3 = percentError(adjAds3, ads3);
			double pError4 = percentError(adjAds4, ads4);
			double pError5 = percentError(adjAds5, ads5);
			double pError12 = percentError(adjAds12, ads12);

			if(checkError(pError1, pError15, pError2, pError25, pError3, pError4, pError5, pError12)) {
				possible.add(collection.get(i));
			}
			else {
				//System.out.println("Error");
			}
		}
		return possible;
	}

	public static boolean checkError(double a, double b, double c, double d, double e, double f, double g, double h) {
		if(a < 0.14 && b < 0.14 && c < 0.14 && d < 0.14 && e < 0.14 && f < 0.14 && g < 0.14 && h < 0.14 ) {
			return true;
		}
		else {
			return false;
		}

	}

	public static double percentError(double adj, double actual) {
		double error = Math.abs((actual/adj * 100) - 100);
		return error;
	}

	public static int promptOptimize(Scanner myObj) {
		System.out.println("\nWhich Zoom Level Would You Like To Optimize (1-8):");
		System.out.println("1.ADS 1x");
		System.out.println("2.ADS 1.5x");
		System.out.println("3.ADS 2x");
		System.out.println("4.ADS 2.5x");
		System.out.println("5.ADS 3x");
		System.out.println("6.ADS 4x");
		System.out.println("7.ADS 5x");
		System.out.println("8.ADS 12x");
		int select = myObj.nextInt();
		return select;
	}
}
