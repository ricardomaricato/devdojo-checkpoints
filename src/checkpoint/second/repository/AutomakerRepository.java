package checkpoint.second.repository;

import checkpoint.second.model.Automaker;

public class AutomakerRepository {

	Automaker gm = new Automaker("GM");
	Automaker hyundai = new Automaker("Hyundai");
	Automaker volkswagen = new Automaker("Volkswagen");
	Automaker audi = new Automaker("Audi");
	Automaker mercedes = new Automaker("Mercedes");
	Automaker peugeot = new Automaker("Peugeot");

	Automaker[] automakers = {gm, hyundai, volkswagen, audi, mercedes, peugeot};

	public Automaker[] listAll() {
		return automakers;
	}

}
