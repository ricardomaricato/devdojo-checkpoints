package checkpoint.second;

import checkpoint.second.model.Automaker;
import checkpoint.second.model.Vehicle;
import checkpoint.second.service.AutomakerService;
import checkpoint.second.service.VehicleService;
import checkpoint.second.validation.AutomakerValidation;

import java.util.Objects;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {

		AutomakerService automakerService = new AutomakerService();
		VehicleService vehicleService = new VehicleService();

		while (true) {

			System.out.println("1 - Search by automaker");
			System.out.println("2 - Search by model");
			System.out.println("3 - Add vehicle");
			System.out.println("4 - Update vehicle");
			System.out.println("5 - Delete vehicle");
			System.out.println("0 - Exit");

			Scanner in = new Scanner(System.in);
			int selectedNumber = in.nextInt();
			if (selectedNumber < 0 || selectedNumber > 5) {
				System.out.println("Input not allowed!");
				continue;
			}

			if (selectedNumber == 0)
				break;

			Automaker[] automakers = automakerService.listAll();
			Vehicle[] vehicles = vehicleService.listAll();

			switch (selectedNumber) {
				case 0:
					break;
				case 1:

					vehicleService.printAutomakerName(automakers);

					int selectedAutomaker = in.nextInt();
					System.out.println("Available vehicles:");
					String automakerSelected = automakers[selectedAutomaker - 1].getName();
					System.out.println(automakerSelected);

					Vehicle[] vehicleSelected = vehicleService.searchByAutomaker(vehicles, automakerSelected);
					vehicleService.printVehicleModel(vehicleSelected);
					continue;
				case 2:
					vehicleService.printVehicleModel(vehicles);

					in.nextLine();
					String modelToSearch = in.nextLine();
					Vehicle vehicleModelSearched = vehicleService.searchByModel(vehicles, modelToSearch);

					if (Objects.isNull(vehicleModelSearched.getModel())) {
						System.out.println("Vehicle not found!");
						break;
					}

					vehicleModelSearched.prettyPrint();
					continue;
				case 3:
					Vehicle newVehicle = vehicleService.getNewVehicleToAdd();

					if (!AutomakerValidation.isValid(automakers, newVehicle.getAutomaker().getName())) {
						System.out.println("Automaker invalid!");
						break;
					}

					vehicleService.addVehicle(vehicles, newVehicle);
					continue;
				case 4:
					vehicleService.printVehicleModel(vehicles);

					in.nextLine();
					String modelToUpdate = in.nextLine();
					Vehicle searchVehicle = vehicleService.searchByModel(vehicles, modelToUpdate);

					if (Objects.isNull(searchVehicle)) {
						System.out.println("Vehicle not found!");
						break;
					}

					searchVehicle.prettyPrint();
					Vehicle newVehicleToUpdate = vehicleService.getNewVehicleToUpdate(searchVehicle);
					vehicleService.updateVehicle(vehicles, newVehicleToUpdate);
					continue;
				case 5:
					vehicleService.printVehicleModel(vehicles);
					System.out.println("Which vehicle do you want to delete?");

					in.nextLine();
					String modelToDelete = in.nextLine();
					int position = vehicleService.getPosition(vehicles, modelToDelete);
					vehicleService.deleteVehicleByModel(vehicles, position);
					continue;
				default:
					throw new IllegalStateException("Unexpected value: " + selectedNumber);
			}

			System.out.println("Do you wish to continue?");
			System.out.println("0 - No");
			System.out.println("1 - Yes");

			int selectedNumber2 = in.nextInt();
			if (selectedNumber2 < 0 || selectedNumber2 > 1) {
				System.out.println("Input not allowed!");
				return;
			}

			if (selectedNumber2 == 0)
				break;
		}
	}
}
