package entities;

import javax.swing.JOptionPane;

public class Contact {
	private String name;
	private Integer ddd;
	private Integer number;
	
	public Contact(String name, Integer ddd, Integer number) {
		setName(name);
		setDdd(ddd);
		setNumber(number);
	}
	
	public Contact() {
		setName(JOptionPane.showInputDialog("Name:  "));
		setDdd(Integer.parseInt(JOptionPane.showInputDialog("DDD: ")));
		setNumber(Integer.parseInt(JOptionPane.showInputDialog("Number: ")));
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDdd() {
		return ddd;
	}
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Contact: "
				+ "\nName: " + name 
				+ "\nNuumber: (" + ddd + ") " + number 
				+ "\n";
	}
	
	
	
}
