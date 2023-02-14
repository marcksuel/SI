package ListaAvancadaQ1;
import java.util.Arrays;

import javax.swing.JOptionPane;


public class Company {
	private Emplyoee[] emplyoee = new Emplyoee[100];
	public int cont=0;
	
	public Company() {
		for(int i =0;i<100;i++) {
			this.emplyoee[i] = new Emplyoee();
		}
	}
	
	public Emplyoee getEmplyoee(int id) {
		return emplyoee[cont];
	}
	
	public void setEmplyoee(Emplyoee emplyoee) {
		this.emplyoee[cont] = emplyoee;
	}
	
	public boolean Repeat (Emplyoee e) {
		
		boolean test=false;
		for(int i=0;i<cont;i++){
			if(e.getId() == this.emplyoee[i].getId()) {
				test = true;
				break;
			}
		}
		return test;
	}
	
	public void Register() {
		
	Emplyoee emplyoee = Information();
		
		if(cont==0 && emplyoee.getName()!= null) {
			setEmplyoee(emplyoee);
			JOptionPane.showMessageDialog(null, emplyoee.toString() + " foi registrado com sucesso!");
			cont++;		}else if (emplyoee.getName()!= null) {
			if(Repeat(emplyoee)){
				JOptionPane.showMessageDialog(null, "O ID já foi registrado");
			}else{
				setEmplyoee(emplyoee);
				JOptionPane.showMessageDialog(null, emplyoee.toString() + " foi registrado com sucesso!");
				cont++;
			}
		}else {
			JOptionPane.showMessageDialog(null, "Operação cancelada");
		}
		
	}
	
	public Emplyoee Information() {
		Emplyoee emplyoee = new Emplyoee();
		Emplyoee cancel = new Emplyoee();

		//NOME
		boolean try_nome;
		String nome=null;
		do {
			try {
				
			try_nome=false;
			nome = JOptionPane.showInputDialog("Emplyoee name: ");
			if(nome == null) { // cancelou a digitação do codigo
				try_nome=true;
				break; // força sair do while mas n operar mais nada depois 
			}				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Valor inválido");
				try_nome = true;
			}
			
		} while (try_nome);
		
		if(try_nome == false) { // caso não cancelamento da operação
			emplyoee.setName(nome);
			
			 //SALARIO
			boolean try_salary;
			String salary=null;
			
			do {
				try {
					
				try_salary=false;
				salary = JOptionPane.showInputDialog("Emplyoee salary: ");
				if(salary == null) { // cancelou a digitação do codigo
					try_salary=true;
					break; // força sair do while mas n operar mais nada depois 
				}				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor inválido");
					try_salary = true;
				}
				
			} while (try_salary);
			
			if(try_salary == false) { // caso não cancelamento da operação
				emplyoee.setSalary(Double.parseDouble(salary));
				//ID
					boolean try_id;
					String id=null;
					
					do {
						try {
							
						try_id=false;
						id = JOptionPane.showInputDialog("Emplyoee ID: ");
						if(id == null) { // cancelou a digitação do codigo
							try_id=true;
							break; // força sair do while mas n operar mais nada depois 
						}				
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Valor inválido");
							try_id = true;
						}
						
					} while (try_id);
					
					if(try_id == false) { // caso não cancelamento da operação
						emplyoee.setId(Integer.parseInt(id));
					}else {
						emplyoee =cancel;
					}
				}else {
					emplyoee =cancel;

				}
			}else {
				emplyoee =cancel;

			}				

		return emplyoee;
	}
	
	public void Increase() {
		int id=0;
		String i=null;
		boolean try_id;
		do {
			try {
				
			try_id=false;
			i = JOptionPane.showInputDialog("Emplyoee ID: ");
			id = Integer.parseInt(i);
			if(i == null) { // cancelou a digitação do codigo
				try_id=true;
				break; // força sair do while mas n operar mais nada depois 
			}				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Valor inválido");
				try_id = true;
			}
			
		} while (try_id);
		
		if(try_id == false) { // caso não cancelamento da operação
			for(int j=0;j<cont;j++){
				if(id == this.emplyoee[j].getId()) {
					boolean try_porcent;
					String p=null;
					double porcent=0.0;
					do {
						try {
							
						try_porcent=false;
						p = JOptionPane.showInputDialog("Increase Salary: ");
						porcent = Double.parseDouble(i);
						if(p == null) { // cancelou a digitação do codigo
							try_porcent=true;
							break; // força sair do while mas n operar mais nada depois 
						}				
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Valor inválido");
							try_porcent = true;
						}
						
					} while (try_porcent);
					
					this.emplyoee[j].Increase(porcent);
					break;
				}else if (j+1==cont) {
					JOptionPane.showMessageDialog(null, "ID não encontrado! Operação cancelada!");
				}
			}
		}
	}

	@Override
	public String toString() {
		String a="______Employee List______\n";
		for(int i =0 ;i<cont ;i++) {
			a += "\nEmployee #" + i+1 +"\n" + this.emplyoee[i].toString()  ;
		}
		return a;
	}

}
