package checkpoint.second.service;

import checkpoint.second.model.Vehicle;
import checkpoint.second.repository.VehicleRepository;

public class VehicleService {

	public Vehicle[] searchByAutomaker(Vehicle[] vehicles, String name) {
		Vehicle[] newVehicles = new Vehicle[vehicles.length];
		int i = 0;
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getAutomaker().getName().equals(name)) {
				newVehicles[i] = vehicle;
				i++;
			}
		}
		return newVehicles;
	}

	public Vehicle searchByModel(Vehicle[] vehicles, String model) {
		Vehicle newVehicle = new Vehicle();
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getModel().equalsIgnoreCase(model)) {
				newVehicle.setModel(vehicle.getModel());
				newVehicle.setColor(vehicle.getColor());
				newVehicle.setYear(vehicle.getYear());
				newVehicle.setAutomaker(vehicle.getAutomaker());
			}
		}
		return newVehicle;
	}

	public Vehicle[] addVehicle(Vehicle[] vehicles, Vehicle vehicle) {
		int n = vehicles.length;
		Vehicle[] newArray = new Vehicle[n + 1];
		for (int i = 0; i < n; i++) {
			newArray[i] = vehicles[i];
		}
		newArray[n] = vehicle;

		return newArray;
	}

	public VehicleService(VehicleRepository vehicleRepository) {
	}
}
