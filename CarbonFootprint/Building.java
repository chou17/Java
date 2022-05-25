package homework2;

/* Building 
 * 1000 kWh of electricity -> 0.6 metric tons
 * 1000 kWh of natural gas -> 0.18 metric tons
 * 1000 kWh of heating oil -> 0.25 metric tons
 * 1000 kWh of coal -> 0.34 metric tons
 * 1000 kWh of LPG -> 0.21 metric tons
 * 1000 US gallons of propane -> 5.84 metric tons
 * 1000 metric tons of wooden pellets -> 72.62 metric tons
 * data from https://www.carbonfootprint.com/calculator.aspx
 */

public class Building implements CarbonFootprint {

	private static double ELECTRICITY_PER_KWH = 0.0006;
	private static double NATURAL_GAS_PER_KWH = 0.00018;
	private static double HEATING_OIL_PER_KWH = 0.00025;
	private static double COAL_PER_KWH = 0.00034;
	private static double LPG_PER_KWH = 0.00021;
	private static double PROPANE_PER_GALLON = 0.00584;
	private static double WOODEN_PELLETS_PER_METRIC_TON = 0.07262;
	
	private double electricity;
	private double naturalGas;
	private double heatingOil;
	private double coal;
	private double lpg;
	private double propane;
	private double woodenPellets;

	//Constructor
	public Building(double inputElectricity, double inputNaturalGas, double inputHeatingOil, 
			        double inputCoal, double inputLPG, double inputPropane, double inputWoodenPellets) {

		electricity = inputElectricity;
		naturalGas = inputNaturalGas;
		heatingOil = inputHeatingOil;
		coal = inputCoal;
		lpg = inputLPG;
		propane = inputPropane;
		woodenPellets = inputWoodenPellets;
	}

	@Override
	public double getCarbonFootprint() {
		double eCarbonFootprint = electricity * ELECTRICITY_PER_KWH;
		double nCarbonFootprint  = naturalGas * NATURAL_GAS_PER_KWH;
		double hCarbonFootprint = heatingOil * HEATING_OIL_PER_KWH;
		double cCarbonFootprint = coal * COAL_PER_KWH;
		double lCarbonFootprint = lpg * LPG_PER_KWH;
		double pCarbonFootprint = propane * PROPANE_PER_GALLON;
		double wCarbonFootprint = woodenPellets * WOODEN_PELLETS_PER_METRIC_TON;
		double totalCarbonFootprint = eCarbonFootprint + nCarbonFootprint + hCarbonFootprint + 
				cCarbonFootprint + lCarbonFootprint + pCarbonFootprint + wCarbonFootprint; 
		totalCarbonFootprint = Math.round(totalCarbonFootprint*100.0)/100.0;
		
		return totalCarbonFootprint;
	}

    //the string for print the info (number of people, electricity...)
	public String toString() {
		String string = "Building: ";
		string = string + "\nConsumption of electricity (kWh): " + electricity;
	    string = string + "\nConsumption of natural Gas (kWh): " + naturalGas;
		string = string + "\nConsumption of heating Oil (kWh): "+ heatingOil;
		string = string + "\nConsumption of coal (kWh): " + coal;
		string = string + "\nConsumption of LPG (kWh): "+ lpg;
		string = string + "\nConsumption of propane (US gallons): " + propane;
		string = string + "\nConsumption of wooden Pellets (metric tons): " + woodenPellets;
		return string;
	}
}