package entities;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ouvidoria {
	protected ArrayList<Type> list = new ArrayList<Type>();
	
	public Ouvidoria(ArrayList<Type> list) {
		this.list = list;
	}
	
	public Ouvidoria() {
	}
		
	public ArrayList<Type> getList() {
		return list;
		
	}

	public void setList(ArrayList<Type> list) {
		this.list = list;
	}

	public void Add() {// adiciona manifestação
		Integer confirmation = 2;
		String descricao =null;
		String nome=null;
		Integer confirmation_nome = 1;
		Integer confirmation_description=1;
		String[] menu = { "Elogio", "Sugestão","Reclamação"};
		Integer tipo=0;
		do {
			do {
				nome = JOptionPane.showInputDialog("Informe seu nome:");
				if(nome==null) { // Apertou no botão cancelar
					confirmation_nome= 2;
				}
				else {
					confirmation_nome = JOptionPane.showConfirmDialog(null,"O seu nome é " + nome + "?");
					if(confirmation_nome != 1 && confirmation_nome != 0)  // Apertou no botão cancelar
						confirmation_nome = 2;
					
				}
				
			}while(confirmation_nome==1);// y -0  n - 1 cancelar - 2
			
			if(confirmation_nome == 0) {
				tipo = JOptionPane.showOptionDialog(null, "Selecione um Tipo de Manifestação:", "Ouvidoria",0, 3, null, menu, menu[0]);
				do {
					descricao = JOptionPane.showInputDialog("Descrição da Manifestação:");
					if(descricao ==null){// apertou em cancelar
						confirmation_description=2;
						tipo= -1;
					}else {
						confirmation_description = JOptionPane.showConfirmDialog(null,"Confirme a descrição da manifestação:\n\n " + descricao);
						if(confirmation_description != 1 && confirmation_description != 0 ) {// apertou em cancelar
							tipo= -1;
							confirmation_description =2;
						}
					}					
				}while(confirmation_description==1);// y -0  n - 1 cancelar - 2
				
				if(tipo== -1){//apertou no X  da janela
					JOptionPane.showMessageDialog(null, "Operação encerrada");
					confirmation=2;
				}else if(tipo == 0) {
					
					confirmation = JOptionPane.showConfirmDialog(null, 
						"Deseja inserir a seguinte manifestação:\n"
						+ "\nNome: " + nome
						+ "\nTipo: Elogio"
						+ "\nDescrição: " + descricao
						+ "\nCódigo: " + (list.size()+1));
				}else if (tipo == 1) {
					confirmation = JOptionPane.showConfirmDialog(null, 
							"Deseja inserir a seguinte manifestação:\n"
							+ "\nNome: " + nome
							+ "\nTipo: Sugestão"
							+ "\nDescrição: " + descricao
							+ "\nCódigo: " + (list.size()+1));
				}else if(tipo == 2) {
					confirmation = JOptionPane.showConfirmDialog(null, 
							"Deseja inserir a seguinte manifestação:\n"
							+ "\nNome: " + nome
							+ "\nTipo: Reclamação"
							+ "\nDescrição: " + descricao
							+ "\nCódigo: " + (list.size()+1));
				}
			} // fim do if se a pessoa não cancelar quando digitar o nome
		}while(confirmation ==1); // y -0  n - 1 cancelar - 2
		if(confirmation == 0 ) { // so adiciona se aceitar tudo que foi apresentado
			list.add( new Type(descricao,nome,list.size()+1,tipo));
			
		}
	}
	
	public void Remover() {// remove uma manifestação
		Integer codigo=-1;
		String c;
		Boolean try_codigo=false;

		do {
			try {
				c = JOptionPane.showInputDialog( "informe o código da manifestação que deseja excluir:");
				try_codigo = false;

				if(c == null) { // cancelou a digitação do codigo
					try_codigo=true;
					break; // força sair do while mas não operar mais nada depois 
				}
				codigo = Integer.parseInt(c);

			} catch (Exception e) {
				
					JOptionPane.showMessageDialog(null, "Valor inválido");
					try_codigo = true;
					continue;
				
			}
			if(codigo <1 || codigo > list.size()	) {
				JOptionPane.showMessageDialog(null, "Código digitado é inexistente");
				try_codigo = true;
			}
			
		} while (try_codigo); // sair com um valor valido e desejado para o codigo
		
		
		if(try_codigo == false) {// digitou um codigo valido e não cancelou a operação

			Integer varredura=0;
			for(Type x: list) {
				if(x.getCode() == codigo) {
					int confirmar_remocao = JOptionPane.showConfirmDialog(null, 
							"Deseja excluir realmente  a manifestação:"
							+ x);
					if(confirmar_remocao == 0) {
						list.remove(x);
						JOptionPane.showMessageDialog(null, "Manifestação removida com sucesso");
					}
					varredura=-1;//como ocorre a remoção pode acarretar de o sice() ser igual depois da remoção, o - é para evitar a entrada no proximo if
					break;
				}else {
					varredura++;
				}
			}
			 if(varredura == list.size()) {
					JOptionPane.showMessageDialog(null, "Não foi possivel encontrar a manifestação com o código selecionado");

			}
		}// fim if com codigo valido
	}

	public void PorCodigo() { // Pesquisa por código
		Integer codigo=-1;
		String c= null;
		Boolean try_codigo=false;
		
		do {
			try {
				c = JOptionPane.showInputDialog( "informe o código da manifestação que deseja pesquisar:");
				try_codigo = false;
				if(c == null) { // cancelou a digitação do codigo
					try_codigo=true;
					break; // força sair do while mas n operar mais nada depois 
				}
				codigo = Integer.parseInt(c);
			}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor inválido");
					try_codigo = true;
					continue;
				
			}
			if(codigo <1 || codigo > list.size()+1) {
				JOptionPane.showMessageDialog(null, "Código digitado é inexistente");
				try_codigo = true;
			}
			
		} while (try_codigo); // sair com um valor valido e desejado para o tipo
		if(try_codigo == false) {// digitou um codigo valido e não cancelou a operação
			Integer varredura=0;
			for(Type x: list) {
				if(x.getCode()==codigo) {
					JOptionPane.showMessageDialog(null, x);
					break;
				}else {
					varredura++;
				}
			}
			if(varredura == list.size()) {
					JOptionPane.showMessageDialog(null, "Não foi possivel encontrar a manifestação com o código selecionado");

			}
						
		}// fim if com codigo valido}
	}
	
	public void PorNome() {// Pesquisa por nome
		String nome = null;
		boolean try_nome=false;
		do {
			try {
				nome = JOptionPane.showInputDialog( "informe o código da manifestação que deseja pesquisar:");
				try_nome = false;
				if(nome == null) { // cancelou a digitação do codigo
					try_nome=true;
					break; // força sair do while mas n operar mais nada depois 
				}
			} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor inválido");
					try_nome = true;
					continue;
				
			}
						
		} while (try_nome); // sair com um valor valido e desejado para o tipo
		if(try_nome == false) {// digitou um codigo valido e não cancelou a operação
			Integer varredura=0;
			for(Type x: list) {
				Boolean y =  x.getName().toUpperCase().equals(nome.toUpperCase());
				if(y) {
					JOptionPane.showMessageDialog(null, x);					
				}else {
					varredura++;
				}
			}
			if(varredura == list.size()) {
					JOptionPane.showMessageDialog(null, "Não foi possivel encontrar a manifestação com o código selecionado");
			}
		}// fim if com codigo valido}
	}
	
	public  void Listar() { // Lista todas as manifestações
		String format = "LIsta de Manifestações na Ouvidoria\n";
		for(Type x: list) {
			format += x.toString();
		}
		JOptionPane.showMessageDialog(null,format);					
		
	}

	
}
