package application;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

import entities.Contact;

public class Program {
	static Queue<Contact> c = new LinkedList<Contact>();

	public static void main(String[] args) {
		Integer option=0;
		String o=null;
		do {
			try {
				o = JOptionPane.showInputDialog("1 - Inserir Contato\n2 - Próximo Contato");
				option = Integer.parseInt(o);

				
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(o==null) {
				JOptionPane.showMessageDialog(null,"Programa encerrado");
			}else {
				switch (option) {
				case 1: {
					inserir();
					break;
				}
				case 2:{
					next();
					break;
				}
								
				default:
					JOptionPane.showMessageDialog(null,"Valor invalido");
					break;
				}
			}
			}while(o!=null);
	}
	
	public static void inserir() {
		c.add(new Contact());
		
	}
	public static void next(){
		if(c.size()>0) {
		JOptionPane.showMessageDialog(null, c.poll());
		}else {
			JOptionPane.showMessageDialog(null,"Don't Have more contact's" );
		}
	}
}
