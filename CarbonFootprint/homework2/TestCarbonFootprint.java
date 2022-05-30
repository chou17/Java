package homework2;

import java.util.ArrayList;

public class TestCarbonFootprint {

	public static void main(String[] args) {
		// Create list of different objects(Building, Car, Bicycle)
		ArrayList<CarbonFootprint> carbonFootprintObj = new ArrayList<CarbonFootprint>();
		try {
			//electricity, naturalGas, heatingOil, coal, lpg, propane, woodenPellets
			carbonFootprintObj.add(new Building(0, 1000, 1000, 100, 100, 100, 0));
			//kilometers of travel
			carbonFootprintObj.add(new Car(10000));
			//kilometers of travel
            carbonFootprintObj.add(new Bicycle(10000));
			
            //print the result
			for (CarbonFootprint obj : carbonFootprintObj) {
				System.out.println(obj.toString());
				System.out.println("Carbon footprint: About " + obj.getCarbonFootprint() + " metric tons of CO2.\n");
			}

		} catch (Exception exception) {
			System.out.println("Error");
		}
	}
}