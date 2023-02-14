package ListaRevisaoVetor;
import javax.swing.JOptionPane;
import java.lang.String;


public class TestarArrayAluno {
	public Aluno[] turma = new Aluno[5];

	public TestarArrayAluno() {
		Aluno cancel = new Aluno();

		for (int i =0; i<5;i++) {
			turma[i] = new Aluno();
			// nome
			boolean try_nome;
			String nome=null;
			do {
				try {
					
				try_nome=false;
				nome= JOptionPane.showInputDialog("Nome do " + (i+1) +"º Aluno:", (i+1));
				if(nome == null) { // cancelou a digitação do codigo
					try_nome=true;
					break; // força sair do while mas n operar mais nada depois 
				}				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor inválido");
					try_nome = true;
				}
				
			} while (try_nome);
			
			if(try_nome == true) { // caso de cancelamento da operação
				turma[i] = cancel;

				for(int j = i+1;j<5;j++) {
					turma[j] = new Aluno();
				}
				break;
			}
			
			this.turma[i]. setNome(nome);

			//nota1
			boolean try_nota1=false;
			String n1=null;

			do {
				try {
					
				try_nota1=false;
				n1 = JOptionPane.showInputDialog("1ª Nota de " + this.turma[i].getNome()+ ": ");
				
				if(n1 == null) { // cancelou a digitação do codigo
					try_nota1=true;
					break; // força sair do while mas n operar mais nada depois 
				}			
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor inválido");
					try_nota1 = true;
					
				}

			} while (try_nota1);
			
			if(try_nota1 == true){// caso de cancelamento da operação
				turma[i] = cancel;

				for(int j = i+1;j<5;j++) {
					turma[j] = new Aluno();
				}
				break;
			}
			
			
			this.turma[i]. setNota1(Double.parseDouble(n1));
			
			//nota2
			boolean try_nota2=false;
			String n2=null;

			do {
				try {
					
				try_nota2=false;
				n2 = JOptionPane.showInputDialog("2ª Nota de " + this.turma[i].getNome()+ ": ");
				
				if(n2 == null) { // cancelou a digitação do codigo
					try_nota2=true;
					break; // força sair do while mas n operar mais nada depois 
				}			
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor inválido");
					try_nota1 = true;
					
				}

			} while (try_nota2);
			
			if(try_nota2 == true){// caso de cancelamento da operação
				turma[i] = cancel;

				for(int j = i+1;j<5;j++) {
					turma[j] = new Aluno();
				}
				break;
			}
			
			
			this.turma[i]. setNota2(Double.parseDouble(n2));

			
		}	
	
	}
	
	
	public void All() {
		String apresentation = "";

		for(int i=0;i<5;i++) {
			if(this.turma[i]. getNome()!= null) {
				apresentation += this.turma[i].toString(); // concat
			}else {
				break;
			}
		}

		JOptionPane.showMessageDialog(null, apresentation);
	}
	
	public void Search() {
		String nome = JOptionPane.showInputDialog("Nome do aluno procurado: "); 
		int cont=0;
		String apresentation = "";
		for(int i =0;i<5;i++) {
			if(this.turma[i]. getNome()!= null) {
				if(this.turma[i].getNome().equals(nome)) {
					apresentation += this.turma[i].toString(); // concat
					cont++;
				}
			}else {
				break;
			}
		}
		
		if(cont==0) {
			JOptionPane.showMessageDialog(null, "Nenhum aluno com esse nome foi encontrado");
		}else {
			JOptionPane.showMessageDialog(null, "Foram encontrado os seguintes alunos:\n" + apresentation);

		}
	}
	
	public void Down() {
		int cont=0;
		for(int i=0;i<5;i++) {
			if(this.turma[i].Media()<6.0)
				cont++;
		}
		
		JOptionPane.showMessageDialog(null, "Existem " + cont + " abaixo da média.");
	}
	
	public void Up() {
		int cont=0;
		for(int i=0;i<5;i++) {
			if(this.turma[i].Media()>=6.0)
				cont++;
		}
		
		JOptionPane.showMessageDialog(null, "Existem " + cont + " abaixo da média.");
	}
	
}

	
