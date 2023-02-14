package ListaRevisaoVetor;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		TestarArrayAluno teste = new TestarArrayAluno();
		int opcao=0;
		boolean try_opcao=false;
		String o=null;
		int encerramento=1;
		
		do {
			do {
				try {
					o =  JOptionPane.showInputDialog("__________________MENU_________________"
												 + "\n1) Procurar aluno"
												 + "\n2) Abaixo da média"
												 + "\n3) Acima da Média"
												 + "\n4) Todos os alunos e médias");
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
				if(opcao<1 || opcao>4) {
					JOptionPane.showMessageDialog(null, "A opcão escolhida é inválida");

				}
			} while (try_opcao);
			if(try_opcao == false) {
				switch(opcao) {
				case 1:
					teste.Search();
					break;
				case 2:
					teste.Down();
					break;
				case 3:
					teste.Up();
					break;
				case 4:
					teste.All();
					break;
				default:
					break;
				}//fim switch
			}//fim if
			
			encerramento = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?");
		}while(encerramento == 1); // y-0 n-1 cancelar-2
	
	}
	
}
