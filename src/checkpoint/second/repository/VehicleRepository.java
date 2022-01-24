package checkpoint.second.repository;

import checkpoint.second.model.Vehicle;

public class VehicleRepository {
	Vehicle[] vehicles;

	public VehicleRepository(Vehicle[] vehicles) {
		this.vehicles = vehicles;
	}

	public Vehicle[] getVehicles() {
		return vehicles;
	}

	public void setVehicles(Vehicle[] vehicles) {
		this.vehicles = vehicles;
	}
}
