package ListaAvancadaQ1;

public class Emplyoee {
	
	private int id;
	private String name;
	private double salary;
	
	

	public Emplyoee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public Emplyoee() {
		this.id = 0;
		this.name = null;
		this.salary = 0.0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void Increase(double porcent) {
		this.setSalary(salary*porcent/100);
	}

	@Override
	public String toString() {
		return "\nID: " + id + "\nName: " + name + "\nSalary: " + salary + "\n";
	}
	
	
	
}
