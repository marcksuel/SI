package entities;

import javax.swing.JOptionPane;

public class Patient {
	private String name;
	private Integer CPF;
	private Integer key;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCPF() {
		return CPF;
	}
	public void setCPF(Integer cPF) {
		CPF = cPF;
	}
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	
	public Patient(Integer key) {
		try {
			setName(JOptionPane.showInputDialog(null, "Name: "));

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			setCPF(Integer.parseInt(JOptionPane.showInputDialog(null, "CPF: ")));

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			setKey(key);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public String toString() {
		return "Patient"
				+ "\nName: " + name 
				+ "\nCPF: " + CPF 
				+ "\nKey:" + key 
				+ "\n";
	}
	
	
}
