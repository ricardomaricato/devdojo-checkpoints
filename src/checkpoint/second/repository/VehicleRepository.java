package checkpoint.second.repository;

import checkpoint.second.model.Automaker;
import checkpoint.second.model.Vehicle;

public class VehicleRepository {
	Automaker gm = new Automaker("GM");
	Automaker hyundai = new Automaker("Hyundai");
	Automaker volkswagen = new Automaker("Volkswagen");
	Automaker audi = new Automaker("Audi");
	Automaker mercedes = new Automaker("Mercedes");
	Automaker peugeot = new Automaker("Peugeot");

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

	public Vehicle[] listAll() {
		return vehicles;
	}

	public VehicleRepository() {
	}

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
