package checkpoint.second.service;

import checkpoint.second.model.Automaker;
import checkpoint.second.repository.AutomakerRepository;

public class AutomakerService {

	AutomakerRepository automakerRepository = new AutomakerRepository();

	public Automaker[] listAll() {
		return automakerRepository.listAll();
	}
}
