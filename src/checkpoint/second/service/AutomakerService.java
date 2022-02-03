package checkpoint.second.service;

import checkpoint.second.model.Automaker;
import checkpoint.second.repository.AutomakerRepository;

public class AutomakerService {

	AutomakerRepository automakerRepository = new AutomakerRepository();

	public Automaker[] listAll() {
		return automakerRepository.listAll();
	}

	public void printAutomakerName() {
		Automaker[] automakers = automakerRepository.listAll();
		int index = 1;
		for (Automaker automaker : automakers) {
			System.out.printf("%d - %s\n", index, automaker.getName());
			index++;
		}
	}
}
