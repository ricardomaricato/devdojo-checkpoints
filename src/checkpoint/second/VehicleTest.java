package checkpoint.second;

import checkpoint.second.model.Automaker;
import checkpoint.second.model.Vehicle;
import checkpoint.second.repository.VehicleRepository;
import checkpoint.second.service.VehicleService;
import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class VehicleTest {
	public static void main(String[] args) {
		Vehicle suburban = new Vehicle("Suburban", "White", "1952", new Automaker("GM"));
		Vehicle malibu = new Vehicle("Malibu", "Black", "1966", new Automaker("GM"));
		Vehicle silverado = new Vehicle("Silverado", "Red", "1999", new Automaker("GM"));
		Vehicle azera = new Vehicle("Azera", "White", "2000", new Automaker("Hyundai"));
		Vehicle sonata = new Vehicle("Sonata", "Black", "2002", new Automaker("Hyundai"));
		Vehicle veloster = new Vehicle("Veloster", "Red", "2004", new Automaker("Hyundai"));
		Vehicle golf = new Vehicle("Golf", "White", "2008", new Automaker("Volkswagen"));
		Vehicle jetta = new Vehicle("Jetta", "Black", "2010", new Automaker("Volkswagen"));
		Vehicle polo = new Vehicle("Polo", "Red", "2012", new Automaker("Volkswagen"));
		Vehicle a4 = new Vehicle("A4", "White", "2014", new Automaker("Audi"));
		Vehicle q7 = new Vehicle("Q7", "Black", "2016", new Automaker("Audi"));
		Vehicle r8 = new Vehicle("R8", "Red", "2018", new Automaker("Audi"));
		Vehicle c180 = new Vehicle("C 180", "White", "2020", new Automaker("Mercedes"));
		Vehicle c200 = new Vehicle("C 200", "Black", "2022", new Automaker("Mercedes"));
		Vehicle gla200 = new Vehicle("GLA200", "Red", "2024", new Automaker("Mercedes"));
		Vehicle p206 = new Vehicle("P 206", "White", "2001", new Automaker("Peugeot"));
		Vehicle p208 = new Vehicle("P 208", "Black", "2003", new Automaker("Peugeot"));
		Vehicle p2008 = new Vehicle("P 2008", "Red", "2005", new Automaker("Peugeot"));

		Vehicle[] vehicles = new Vehicle[18];
		vehicles[0] = suburban;
		vehicles[1] = malibu;
		vehicles[2] = silverado;
		vehicles[3] = azera;
		vehicles[4] = sonata;
		vehicles[5] = veloster;
		vehicles[6] = golf;
		vehicles[7] = jetta;
		vehicles[8] = polo;
		vehicles[9] = a4;
		vehicles[10] = q7;
		vehicles[11] = r8;
		vehicles[12] = c180;
		vehicles[13] = c200;
		vehicles[14] = gla200;
		vehicles[15] = p206;
		vehicles[16] = p208;
		vehicles[17] = p2008;

		VehicleService vehicleService = new VehicleService();
		Vehicle[] automaker = vehicleService.searchByAutomaker(vehicles, "Mercedes");
		for (Vehicle vehicle : automaker) {
			if (vehicle.getAutomaker().getName() != null) {
				System.out.println(vehicle.getAutomaker().getName());
			}
		}
	}
}