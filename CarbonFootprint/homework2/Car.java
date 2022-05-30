package homework2;

/* Car:
 * 1km->271g CO2
 * (data from https://www.ourstreetsmpls.org/does_bike_commuting_affect_your_carbon_footprint_and_how_much)
 */
public class Car implements CarbonFootprint {

	private static double FOOTPRINT_PER_KM = 271;
	private static double TO_METRIC_TON = .000001;

	private double km;

	//Constructor
	public Car(double inputKm) {
		km = inputKm;
	}

	@Override
	public double getCarbonFootprint() {
		double totalCarbonFootprint = km * FOOTPRINT_PER_KM * TO_METRIC_TON;
		totalCarbonFootprint = Math.round(totalCarbonFootprint*100.0)/100.0;
		return totalCarbonFootprint;
	}

	//the string for print the info
	public String toString() {
		String string = "Car: ";
		string = string + "\nKilometers of travel: " + km;
		return string;
	}

}