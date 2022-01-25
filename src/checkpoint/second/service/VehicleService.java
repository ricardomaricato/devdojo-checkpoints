package checkpoint.second.service;

import checkpoint.second.model.Vehicle;
import checkpoint.second.repository.VehicleRepository;

public class VehicleService {

	private final VehicleRepository vehicleRepository;

	public Vehicle[] searchByAutomaker(Vehicle[] vehicles, String name) {
		Vehicle[] newVehicles = new Vehicle[3];
		int i = 0;
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getAutomaker().getName().equals(name)) {
				newVehicles[i] = vehicle;
				i++;
			}
		}
		return newVehicles;
	}

	public VehicleService(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}
}
