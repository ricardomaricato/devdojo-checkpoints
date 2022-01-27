package checkpoint.second.model;

public class Automaker {

	private String name;

	@Override
	public String toString() {
		return "Automaker{" +
				"name='" + name + '\'' +
				'}';
	}

	public Automaker(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
