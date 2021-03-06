package checkpoint.second.service;

import checkpoint.second.model.Automaker;
import checkpoint.second.model.Vehicle;
import checkpoint.second.repository.VehicleRepository;

import java.util.Objects;
import java.util.Scanner;

public class VehicleService {

	VehicleRepository vehicleRepository = new VehicleRepository();

	public Vehicle[] listAll() {
		return vehicleRepository.listAll();
	}

	public Vehicle[] searchByAutomaker(String name) {
		Vehicle[] vehicles = vehicleRepository.listAll();
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

	public Vehicle searchByModel(String model) {
		Vehicle[] vehicles = vehicleRepository.listAll();
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

	public void addVehicle(Vehicle vehicle) {
		Vehicle[] vehicles = vehicleRepository.listAll();
		Vehicle checkByModel = searchByModel(vehicle.getModel());
		if (Objects.nonNull(checkByModel.getModel())) {
			throw new IllegalArgumentException("This vehicle model already exists!");
		}

		Vehicle[] newVehicles = new Vehicle[vehicles.length + 1];
		for (int i = 0; i < vehicles.length; i++) {
			newVehicles[i] = vehicles[i];
		}
		newVehicles[vehicles.length] = vehicle;
		vehicleRepository.setVehicles(newVehicles);
	}

	public void updateVehicle(Vehicle vehicle) {
		Vehicle[] vehicles = vehicleRepository.listAll();
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i].getModel().equalsIgnoreCase(vehicle.getModel())) {
				vehicles[i] = vehicle;
			}
		}
	}

	public void deleteVehicleByModel(int position) {
		Vehicle[] vehicles = vehicleRepository.listAll();
		if (!(position >= 0 && position < vehicles.length)) {
			throw new IllegalArgumentException("Vehicle not found!");
		}

		for (int i = position; i < vehicles.length - 1; i++) {
			vehicles[i] = vehicles[i + 1];
		}

		Vehicle[] newVehicles = new Vehicle[vehicles.length - 1];
		for (int i = 0; i < vehicles.length - 1; i++) {
			newVehicles[i] = vehicles[i];
		}
		vehicleRepository.setVehicles(newVehicles);
	}

	public int getPosition(String model) {
		Vehicle[] vehicles = vehicleRepository.listAll();
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i].getModel().equalsIgnoreCase(model)) {
				return i;
			}
		}
		return -1;
	}

	public void printVehicleModel(Vehicle[] vehicles) {
		for (Vehicle vehicle : vehicles) {
			if (Objects.isNull(vehicle))
				break;

			System.out.println(vehicle.getModel());
		}
	}

	public Vehicle getNewVehicleToAdd() {
		Scanner in = new Scanner(System.in);
		System.out.println("Model: ");
		String newModel = in.nextLine();
		System.out.println("Color: ");
		String newColor = in.nextLine();
		System.out.println("Year: ");
		String newYear = in.nextLine();
		System.out.println("Automaker: ");
		String newAutomaker = in.nextLine();
		Automaker automaker = new Automaker(newAutomaker);
		return new Vehicle(newModel, newColor, newYear, automaker);
	}

	public Vehicle getNewVehicleToUpdate(Vehicle vehicle) {
		Scanner in = new Scanner(System.in);
		System.out.println("Color: ");
		String newColor = in.nextLine();
		System.out.println("Year: ");
		String newYear = in.nextLine();
		Automaker automaker = new Automaker(vehicle.getAutomaker().getName());
		return new Vehicle(vehicle.getModel(), newColor, newYear, automaker);
	}

	public VehicleService(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	public VehicleService() {
	}

}