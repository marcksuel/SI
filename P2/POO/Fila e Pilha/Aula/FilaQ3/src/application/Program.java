package application;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.JOptionPane;

import entities.Key;

public class Program {
	static Boolean priorityPresent=false, priorityNormal=false;
	static List<Key> aux = new ArrayList<Key>();
	
	static Queue<Key> line = new PriorityQueue<>();
	static Integer atendimentoNormal=0;
	static Integer normal = 1, prioridade =1;
	static Integer registroN =1, registroP=1; 
	static Integer op, tipo;
	
	public static void main(String[] args) {
		// String para os bottões
		 String[] option = { "Retirada de  Senha", 
					"Chamar senha", 
					"Sair"};
		 
		 
		 
		   do {
			   op = JOptionPane.showOptionDialog(null, "Selecione uma opção:", 
					   	"PriorityQueue Marcksuel",0, 3, null, option, option[0]);
			   if(op== -1) {//fechou a janela
				   op=2;	
			   }
			   switch (op) {
					case 0: {// Retirada de Senha
						escolherAtendimento();
						break;
					}
					case 1: {
						chamarAtendimento();
					    break;
					}
					
					case 2:{
					    JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso sistema!");
					    break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + op);
					}
		    
		    }while(op!=2);

	
		
		
	}//fim main
	
	//Para obter o item mais recente da fila, usamos a função poll()
	//obter o item mais recente da fila sem removê-lo, podemos usar a função peek()
	static public void retornarALine() {
		/* Quando encontrar o valor respectivo  que deve ser apresentado no momento 
		ele devolve todas as varias  que estavam salvas no auxciliar  devolta pra lista
		*/
		for(Key c:aux) {
			line.add(c);
		}
		aux.clear();
		
	}
	
	static public void preferencialAtendimento() {
		JOptionPane.showMessageDialog(null, line.peek());// apresenta ao usuario a senha 
		line.poll(); // remove a senha do usurario da PriorityQueue
		atendimentoNormal=0;// reseta a ordem de atendimentos normais possibilitando que sejam atendidos 3 normais antes dos preferencias
		prioridade++; // informa ao programa qual deve ser a proxima senha preferêncial a ser chamada
		retornarALine();
	}
	static public void normalAtendimento() {
		JOptionPane.showMessageDialog(null,line.peek()); // apresneta ao usuario a senha 
		line.poll(); // remove a senha do usuario da PriorityQueue
		atendimentoNormal++;// informa a sequencia de atendimentos normais para respeitar a ordem de 3 pra 1
		normal++; //informa ao programa qual deve ser a proxima senha normal a ser chamada
		retornarALine();
	}
	
	static public void chamarAtendimento() {
		if(line.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não existe atendimento a serem feito");
		}
		// Usado para chamar o proximo atendimento seja normal ou preferêncial
		while (!line.isEmpty()) {

			for(Key j :line) {// veririficar se existe atendimento preferêncial a ser feito
				if(line.element().compareTo(j) == -1 ) {
						priorityPresent = true;
				}
			}
			
			for(Key j :line) { // verificar se existe atendimento normal a ser feito
				if(line.element().compareTo(j) == 1 ) {
						priorityNormal = true;
				}
			}
			
			if(priorityPresent && (atendimentoNormal >2 || prioridade == 1 || priorityNormal==false)){
				/* atender um preferencial a cada 3 normais ou caso seja  o primeiro preferencial a 
				 aparecer ou não tenha nenhum normal na fila
				
				 Devera vasculhar a PriorityQueue  e so entra nessa condição caso o numero esteja seguindoa
				a ordem  mantendo o atendimento prioritario acima do normal mas também respeitando a ordem
				de distribuição de senhas 
				 */
				if(line.peek().getNumber()==prioridade) {
					preferencialAtendimento();
					break; // Chamou a senha  espera a proxima operação 
				}else {

					aux.add(line.peek());
					line.poll();
				}
				
				
			}else {// Caso sejá um atendimento normal
				
					if(line.peek().getNumber()==normal && line.peek().getPriority()==0) {
						/*
						 Devera vasculhar a PriorityQueue  e so entra nessa condição caso o numero esteja seguindoa
						 a ordem  mantendo o atendimento prioritario acima do normal mas também respeitando a ordem
						 de distribuição de senhas 
						 */
						normalAtendimento();
						break;// Chamou a senha  espera a proxima operação 
					}else {
						aux.add(line.peek());
						line.poll();
					}
				}
			if (line.isEmpty()) {// evitar que a lista fique vazia antes de ser vasculhada
				retornarALine();
			}					
					
		
		}
	}
	
	static public void escolherAtendimento() {
		// usado no menu para escolher o tipo da senha 
		String[] type = { "Atendimento Normal", 
		"Atendimento Prefereêncial"};
		Boolean encerrar =false;

		do {
			tipo= JOptionPane.showOptionDialog(null, "Selecione uma opção de Atendimento:",
					"PriorityQueue Marcksuel",0, 3, null, type, type[0]);
			   if(tipo== -1) {// fechou a janela
				   encerrar = true;
			   }
			   switch (tipo) {
					case 0: { // senha normal
						JOptionPane.showMessageDialog(null, "Key: " + registroN 
								+ "\nAtendimento: Normal");
						line.add(new Key(registroN,0)); // adicionar a senha a fila 
						encerrar = true;
						registroN++;
						break;
					}
					case 1:{// senha preferêncial
						JOptionPane.showMessageDialog(null, "Key: " + registroP 
								+ "\nAtendimento: Preferêncial");
						line.add(new Key(registroP,1));// adicioanr a senha a fila
						registroP++;
						encerrar = true;
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + tipo);
					}
			   }while(!encerrar);
	}
}
