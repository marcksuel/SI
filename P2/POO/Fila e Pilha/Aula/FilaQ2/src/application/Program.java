package application;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

import entities.Patient;

public class Program {
	static Queue<Patient> line = new LinkedList<Patient>();
	static Integer key=0;
	public static void main(String[] args) {
		Integer option=0;
		String o=null;
		do {
			try {
				o = JOptionPane.showInputDialog("1 - Inserir paciente"
											+ "\n2 - Chamar Paciente"
											+ "\n3 - Verificar lotação"
											+ "\n4 - Proximo Paciente"
											+ "\n5 - Verificar quantidade na fila");
				option = Integer.parseInt(o);

				
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(o==null) {
				JOptionPane.showMessageDialog(null,"Programa encerrado");
			}else {
				switch (option) {
					case 1: {
						if(capacity()) {
							insert();
						}
						break;
					}
					case 2:{
						nextPatient();
						break;
					}
					case 3:{
						capacity();
						break;
					}						
					case 4:{
						next();
						break;
					}
					case 5:{
						quantity();
						break;
					}
						
					default:{
						JOptionPane.showMessageDialog(null,"Valor invalido");
						break;
					}
				}
			}
			}while(o!=null);
	}//main
	
	public static void insert() {
		key++;
		line.add(new Patient(key));
	}
	
	public static void nextPatient() {
		line.poll();
	}
	
	public static Boolean capacity() {
		Integer capacity = 5; // depende do tamanho maximo da fila
		if(line.size()==0) {
			JOptionPane.showMessageDialog(null, "Empty queue");
			return true;
		}
		else if(line.size()<capacity) {
			JOptionPane.showMessageDialog(null, "Available spots: " + (capacity-line.size()));
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Full queue");
			return false;			
		}
	}
	
	public static void next() {
		if(line.size()>0) {
			JOptionPane.showInternalMessageDialog(null, line.element().toString());
		}else {
			JOptionPane.showMessageDialog(null, "Empty queue");
		}
	}
	
	public static void quantity() {
		JOptionPane.showMessageDialog(null, "Available spots: " + line.size());

	}

}
