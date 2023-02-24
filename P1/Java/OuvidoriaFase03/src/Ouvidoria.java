import java.util.Arrays;

import javax.swing.JOptionPane;

public class Ouvidoria {

	private int count;
	private Type[] manifestacao =  new Type[100];
	private int total;
	
	public Ouvidoria(int count, Type[] manifestacao) {
		this.count = count;
		this.manifestacao = manifestacao;
		}
	
	public Ouvidoria() {
		this.count = 0;
		for(int i=0;i<100;i++) {
			this.manifestacao[i] = new Type();
		}
		this.total = 0;
	}
	
	public void Add() {
		boolean try_tipo = false;
		int confirmation = 1;
		String descricao =null;
		String nome=null;
		int confirmation_nome = 1;

		int tipo=0;
		
		do {
			do {
			nome = JOptionPane.showInputDialog("Informe seu nome:");
			confirmation_nome = JOptionPane.showConfirmDialog(null,"O seu nome é " + nome + "?");
			}while(confirmation_nome==1);// y -0  n - 1 cancelar - 2
			
			if(confirmation_nome == 0) {
				do {
					try {
						tipo = Integer.parseInt(JOptionPane.showInputDialog(
								  "Tipo de Manifestação:"
								+ "\n1 - Elogio"
								+ "\n2 - Sugestao"
								+ "\n3 - Reclamacao"));
	
						try_tipo = false;
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Valor inválido");
						try_tipo = true;
						continue;
					}
					if(tipo<1 || tipo>3) {
						JOptionPane.showMessageDialog(null, "Selecione uma das opções apresentadas");
						try_tipo = true;
					}
				} while (try_tipo); // sair com um valor valido e desejado para o tipo
			
				descricao = JOptionPane.showInputDialog("Descrição da Manifestação:");
				if(tipo == 1) {
					confirmation = JOptionPane.showConfirmDialog(null, 
						"Deseja inserir a seguinte manifestação:\n"
						+ "\nNome: " + nome
						+ "\nTipo: Elogio"
						+ "\nDescrição: " + descricao
						+ "\nCódigo: " + (total +1));
				}else if (tipo == 2) {
					confirmation = JOptionPane.showConfirmDialog(null, 
							"Deseja inserir a seguinte manifestação:\n"
							+ "\nNome: " + nome
							+ "\nTipo: Sugestão"
							+ "\nDescrição: " + descricao
							+ "\nCódigo: " + (total +1));
				}else if(tipo == 3) {
					confirmation = JOptionPane.showConfirmDialog(null, 
							"Deseja inserir a seguinte manifestação:\n"
							+ "\nNome: " + nome
							+ "\nTipo: Reclamação"
							+ "\nDescrição: " + descricao
							+ "\nCódigo: " + (total +1));
				}
			} // fim do if se a pessoa não cancelar quando digitar o nome
		}while(confirmation ==1); // y -0  n - 1 cancelar - 2
		if(confirmation == 0 ) {
			manifestacao[count] = new Type(descricao,nome,(total+1),tipo);
			count++;
			total++;
		}
	}
	
	public void Remover() {
		int codigo=-1;
		String c=null;
		boolean try_codigo=false;
		do {
			try {
				c = JOptionPane.showInputDialog( "informe o código da manifestação que deseja excluir:");
				if(c == null) { // cancelou a digitação do codigo
					try_codigo=true;
					break; // força sair do while mas n operar mais nada depois 
				}
				codigo = Integer.parseInt(c);
				try_codigo = false;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Valor inválido");
				try_codigo = true;
				continue;
			}
			if(codigo <1 || codigo > total) {
				JOptionPane.showMessageDialog(null, "Código digitado é inexistente");
				try_codigo = true;
			}
			
		} while (try_codigo); // sair com um valor valido e desejado para o tipo
		if(try_codigo == false) {// digitou um codigo valido e não cancelou a operação
			int posicao=-1;
			for(int i = 0;i<count;i++) {
				if(manifestacao[i].getCode() == codigo) {
					posicao = i;
					break;
				}
			}
			if(posicao>=0) {
				int confirmar_remocao = JOptionPane.showConfirmDialog(null, 
						"Deseja excluir realmente  a manifestação:"
						+ manifestacao[posicao].toString());
				if(confirmar_remocao == 0) {
					for(int i = posicao;i<count;i++) {
						manifestacao[i] = manifestacao[i+1];
					}
					count--;
				}//fim da remoção
			}else {
				JOptionPane.showMessageDialog(null, "Não foi póssivel encontrar nenhuma manifestação com esse código");

			}
		}// fim if com codigo valido
	}

	public void PorCodigo() {
		int codigo=-1;
		String c=null;
		boolean try_codigo=false;
		do {
			try {
				c = JOptionPane.showInputDialog( "informe o código da manifestação que deseja pesquisar:");
				if(c == null) { // cancelou a digitação do codigo
					try_codigo=true;
					break; // força sair do while mas n operar mais nada depois 
				}
				codigo = Integer.parseInt(c);
				try_codigo = false;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Valor inválido");
				try_codigo = true;
				continue;
			}
			if(codigo <1 || codigo > total) {
				JOptionPane.showMessageDialog(null, "Código digitado é inexistente");
				try_codigo = true;
			}
			
		} while (try_codigo); // sair com um valor valido e desejado para o tipo
		if(try_codigo == false) {// digitou um codigo valido e não cancelou a operação
			int posicao=-1;
			for(int i = 0;i<count;i++) {
				if(manifestacao[i].getCode() == codigo) {
					posicao = i;
					break;
				}
			}
			if(posicao>=0) {
				JOptionPane.showMessageDialog(null, manifestacao[posicao].toString());		
			}else {
				JOptionPane.showMessageDialog(null, "Não foi póssivel encontrar nenhuma manifestação com esse código");

			}
		}// fim if com codigo valido}
	}
	
	public void PorNome() {
		String nome = null;
		boolean try_nome=false;
		do {
			try {
				nome = JOptionPane.showInputDialog( "informe o código da manifestação que deseja pesquisar:");
				if(nome == null) { // cancelou a digitação do codigo
					try_nome=true;
					break; // força sair do while mas n operar mais nada depois 
				}
				try_nome = false;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Valor inválido");
				try_nome = true;
				continue;
			}
						
		} while (try_nome); // sair com um valor valido e desejado para o tipo
		if(try_nome == false) {// digitou um codigo valido e não cancelou a operação
			int posicao=-1;
			for(int i = 0;i<count;i++) {
				if(manifestacao[i].getName().equalsIgnoreCase(nome)) {
					posicao = i;
					break;
				}
			}
			if(posicao>=0) {
				JOptionPane.showMessageDialog(null, manifestacao[posicao].toString());		
			}else {
				JOptionPane.showMessageDialog(null, "Não foi póssivel encontrar nenhuma manifestação com esse nome");

			}
		}// fim if com codigo valido}
	}
	
	public  void Listar() {
		JOptionPane.showMessageDialog(null, this.toString());

	}

	@Override
	public String toString() {
		if(count==0) {
			return "Nenhuma manifestação foi encontrada";
		}else {	
			return  "Lista de Manifestação\n" +this.toString(manifestacao) + "\n" ;
		}
		
	}
	public static String toString(Type[] a) { // editando codigo baseado na biblioteca Array.toString()
	    if (a == null)
	        return null;

	    int iMax = a.length - 1;
	    if (iMax == -1)
	        return null;

	    StringBuilder b = new StringBuilder();
	    b.append("");
	    for (int i = 0; ; i++) {
	        b.append(String.valueOf(a[i]));
	        if (i == iMax)
	            return b.append("").toString();
	        //b.append("\n");
	        	
	        }
	    }
	
	
	
}
