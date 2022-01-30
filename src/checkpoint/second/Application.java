package checkpoint.second;

import checkpoint.second.model.Automaker;
import checkpoint.second.model.Vehicle;
import checkpoint.second.repository.VehicleRepository;
import checkpoint.second.service.VehicleService;
import checkpoint.second.validation.AutomakerValidation;

import java.util.Objects;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Automaker gm = new Automaker("GM");
		Automaker hyundai = new Automaker("Hyundai");
		Automaker volkswagen = new Automaker("Volkswagen");
		Automaker audi = new Automaker("Audi");
		Automaker mercedes = new Automaker("Mercedes");
		Automaker peugeot = new Automaker("Peugeot");

		Automaker[] automakers = {gm, hyundai, volkswagen, audi, mercedes, peugeot};

		Vehicle suburban = new Vehicle("Suburban", "White", "1952", gm);
		Vehicle malibu = new Vehicle("Malibu", "Black", "1966", gm);
		Vehicle silverado = new Vehicle("Silverado", "Red", "1999", gm);
		Vehicle azera = new Vehicle("Azera", "White", "2000", hyundai);
		Vehicle sonata = new Vehicle("Sonata", "Black", "2002", hyundai);
		Vehicle veloster = new Vehicle("Veloster", "Red", "2004", hyundai);
		Vehicle golf = new Vehicle("Golf", "White", "2008", volkswagen);
		Vehicle jetta = new Vehicle("Jetta", "Black", "2010", volkswagen);
		Vehicle polo = new Vehicle("Polo", "Red", "2012", volkswagen);
		Vehicle a4 = new Vehicle("A4", "White", "2014", audi);
		Vehicle q7 = new Vehicle("Q7", "Black", "2016", audi);
		Vehicle r8 = new Vehicle("R8", "Red", "2018", audi);
		Vehicle c180 = new Vehicle("C 180", "White", "2020", mercedes);
		Vehicle c200 = new Vehicle("C 200", "Black", "2022", mercedes);
		Vehicle gla200 = new Vehicle("GLA200", "Red", "2024", mercedes);
		Vehicle p206 = new Vehicle("P 206", "White", "2001", peugeot);
		Vehicle p208 = new Vehicle("P 208", "Black", "2003", peugeot);
		Vehicle p2008 = new Vehicle("P 2008", "Red", "2005", peugeot);

		Vehicle[] vehicles = {
				suburban, malibu, silverado,
				azera, sonata, veloster,
				golf, jetta, polo,
				a4, q7, r8,
				c180, c200, gla200,
				p206, p208, p2008
		};

		final VehicleRepository vehicleRepository = new VehicleRepository(vehicles);
		final VehicleService vehicleService = new VehicleService(vehicleRepository);

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

			switch (selectedNumber) {
				case 0:
					break;
				case 1:
					vehicleService.printAutomakerName(automakers);

					int selectedAutomaker = in.nextInt();
					System.out.println("Available vehicles:");
					String automakerSelected = automakers[selectedAutomaker - 1].getName();
					System.out.println(automakerSelected);

					Vehicle[] vehicleSelected = vehicleService.searchByAutomaker(vehicleRepository.getVehicles(), automakerSelected);
					vehicleService.printVehicleModel(vehicleSelected);
					continue;
				case 2:
					vehicleService.printVehicleModel(vehicleRepository.getVehicles());

					in.nextLine();
					String modelToSearch = in.nextLine();
					Vehicle vehicleModelSearched = vehicleService.searchByModel(vehicleRepository.getVehicles(), modelToSearch);

					if (Objects.isNull(vehicleModelSearched)) {
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

					vehicleRepository.setVehicles(vehicleService.addVehicle(vehicles, newVehicle));
					continue;
				case 4:
					vehicleService.printVehicleModel(vehicleRepository.getVehicles());

					in.nextLine();
					String modelToUpdate = in.nextLine();
					Vehicle searchVehicle = vehicleService.searchByModel(vehicleRepository.getVehicles(), modelToUpdate);

					if (Objects.isNull(searchVehicle)) {
						System.out.println("Vehicle not found!");
						break;
					}

					searchVehicle.prettyPrint();
					Vehicle newVehicleToUpdate = vehicleService.getNewVehicleToUpdate(searchVehicle);
					vehicleService.updateVehicle(vehicleRepository.getVehicles(), newVehicleToUpdate);
					continue;
				case 5:
					vehicleService.printVehicleModel(vehicles);
					System.out.println("Which vehicle do you want to delete?");

					in.nextLine();
					String modelToDelete = in.nextLine();
					int position = vehicleService.getPosition(vehicleRepository.getVehicles(), modelToDelete);
					vehicleService.deleteVehicleByModel(vehicleRepository.getVehicles(), position);
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
