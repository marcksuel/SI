package application;

import java.util.LinkedList;
import java.util.Queue;

import entities.Key;

public class ProgramBrute {
	static Queue<Key> line = new LinkedList<Key>();
	static Integer  normalAtendido=0;
	static Key topo=new Key();
	static Boolean start = true;
	public static void main(String[] args) {
		
		line.add(new Key(1,0));
		line.add(new Key(2,0));
		line.add(new Key(3,0));
		line.add(new Key(4,0));
		line.add(new Key(5,0));// prioridade
		line.add(new Key(6,0));
		line.add(new Key(7,0));
		line.add(new Key(8,0));
		line.add(new Key(9,0));// prioridade
		line.add(new Key(1,1));
		line.add(new Key(2,1));
		line.add(new Key(3,1));
		line.add(new Key(10,0));
		line.add(new Key(11,0));// prioridade
		line.add(new Key(12,0));
		line.add(new Key(13,0));
		line.add(new Key(4,1));
		line.add(new Key(14,1));// prioridade
		line.add(new Key(15,0));
		line.add(new Key(16,0));
		line.add(new Key(17,0));
		line.add(new Key(18,0));
		line.add(new Key(19,0));// prioridade
		line.add(new Key(20,0));
		line.add(new Key(21,0));
		line.add(new Key(22,0));
		line.add(new Key(23,0));// prioridade
		line.add(new Key(5,1));
		line.add(new Key(6,1));
		line.add(new Key(7,1));
		line.add(new Key(24,0));
		line.add(new Key(25,0));// prioridade
		line.add(new Key(26,0));
		line.add(new Key(27,0));
		line.add(new Key(28,0));
		line.add(new Key(29,0));// prioridade
		//
		int x=line.size();
		for(int i =0;i<x;i++) {
			System.out.println ("|"+i+"| " +pecorrer()+"\n_______________________________");
				}
				
		
	} // fim main
	
	public static String pecorrer () {
		Queue<Key> antes = new LinkedList<Key>();
		Integer limpar=0;
		Boolean priorityPresent=false;
		String x=null;
		for(Key i: line) {
			for(Key j :line) {
				if(i.compareTo(j) == -1 ) {
					priorityPresent = true;
				}
			}
			if(priorityPresent==true && normalAtendido>2) { // 0 1 2 atendidos 
				for(Key j: line) {
					if(j.getPriority()!=1) {
						antes.add(j);
						limpar++;
					}else {
						limpar++;
						normalAtendido=0;
						x = "Atendendimento PREFERÊNCIAL\n" + j.toString();
						break;
					}
				}
				
				break;	
			}else if(priorityPresent==true && start == true){
				for(Key j: line) {
					if(j.getPriority()!=1) {
						antes.add(j);
						limpar++;						
					}else {
						limpar++;
						normalAtendido=0;
						start=false;
						x = "Atendendimento PREFERÊNCIAL\n" + j.toString();
						break;
					}
				}
				
				break;
			}else if(i.getPriority()==0 || normalAtendido>2) {
				limpar++;
				normalAtendido++;
				x =  "Atendendimento\n" + i.toString();
				break;

			}
			
		}//fim for
		for(int i=0;i<limpar;i++) { // limpar os elementos antes do selecionado
			line.remove();
		}
		for (Key i : line) {// completar a lista com os que não foram removidos 
			antes.add(i);
		}
		line.clear();// limpar a lista antes de receber os de volta todos
		for(Key i : antes) {
			line.add(i);
		}
		return x;
	}// fim peccorer

}
