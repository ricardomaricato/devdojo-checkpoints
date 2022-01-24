package checkpoint.second.model;

public class Vehicle {

	private String model;
	private String color;
	private String year;
	private Automaker automaker;

	public void prettyPrint() {
		System.out.println(this);
	}

	public Vehicle(String model, String color, String year, Automaker automaker) {
		this.model = model;
		this.color = color;
		this.year = year;
		this.automaker = automaker;
	}

	@Override
	public String toString() {
		return "Vehicle{" +
				"model='" + model + '\'' +
				", color='" + color + '\'' +
				", year='" + year + '\'' +
				", automaker=" + automaker +
				'}';
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Automaker getAutomaker() {
		return automaker;
	}

	public void setAutomaker(Automaker automaker) {
		this.automaker = automaker;
	}
}
