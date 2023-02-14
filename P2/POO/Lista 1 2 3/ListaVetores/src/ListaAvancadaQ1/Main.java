package ListaAvancadaQ1;

import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) {
		Company company = new Company();
		
		int opcao=0;
		boolean try_opcao=false;
		String o=null;
		int encerramento=1;
		
		do {
			do {
				try {
					o =  JOptionPane.showInputDialog("__________________MENU_________________"
												 + "\n1) Registrar Funcionario"
												 + "\n2) Aumento de salario a funcioanrio"
												 + "\n3) Listar todos os funcionarios"
												 );
					if(o == null) { // cancelou a digitação do codigo
						try_opcao=true;
						break; // força sair do while mas n operar mais nada depois 
					}
					opcao = Integer.parseInt(o);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor inválido");
					try_opcao = true;
					continue;
				}
				if(opcao<1 || opcao>3) {
					JOptionPane.showMessageDialog(null, "A opcão escolhida é inválida");

				}
			} while (try_opcao);
			if(try_opcao == false) {
				switch(opcao) {
				case 1:
					company.Register();
					break;
				case 2:
					company.Increase();
					break;
				case 3:
					JOptionPane.showMessageDialog(null, company.toString());
					break;
				default:
					break;
				}//fim switch
			}//fim if
			
			encerramento = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?");
		}while(encerramento == 1); // y-0 n-1 cancelar-2
	
	
		
	}

}
