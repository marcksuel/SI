import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Ouvidoria ouvidoria = new Ouvidoria();

		int opcao=0;
		boolean try_opcao=false;
		String o=null;
		int encerramento=1;
		
		do {
			do {
				try {
					o =  JOptionPane.showInputDialog("__________________MENU_________________"
												 + "\n1) Adicionar manifestação"
												 + "\n2) Pesquisar manifestação  pelo código"
												 + "\n3) Pesquisar manifestação por nome"
												 + "\n4) Listar todas manifestações"
												 + "\n5) Remover manifestação por código");
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
				if(opcao<1 || opcao>5) {
					JOptionPane.showMessageDialog(null, "A opcão escolhida é inválida");

				}
			} while (try_opcao);
			if(try_opcao == false) {
				switch(opcao) {
				case 1:
					ouvidoria.Add();
					break;
				case 2:
					ouvidoria.PorCodigo();
					break;
				case 3:
					ouvidoria.PorNome();
					break;
				case 4:
					ouvidoria.Listar();
					break;
				case 5: 
					ouvidoria.Remover();
				default:
					break;
				}//fim switch
			}//fim if
			
			encerramento = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?");
		}while(encerramento == 1); // y-0 n-1 cancelar-2
		
	}//fim void main

}//fim class
