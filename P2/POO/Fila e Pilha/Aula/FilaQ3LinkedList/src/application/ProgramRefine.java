package application;

import java.util.LinkedList;
import java.util.Queue;

import entities.Key;

public class ProgramRefine {
	static Queue<Key> line = new LinkedList<Key>();
	static Integer  normalAtendido=0, clear = 0;
	static Boolean start = true;
	static Queue<Key> aux = new LinkedList<Key>();
	
	public static void main(String[] args) {
		Integer n=20,p=1;
		for(int i=0;i<n;i++) {
			line.add(new Key(i,0));

		}		
		
		line.add(new Key(p,1));
		line.add(new Key(p+1,1));
		line.add(new Key(p+2,1));
		line.add(new Key(p+3,1));


		n=line.size();
		for(int i =0;i<n;i++) {			
			System.out.println ("|"+i+"| " + chamarAtendimento() + "\n_______________________________");
				}
	
	} // fim main
	
	public static String chamarAtendimento () {
		Boolean priorityPresent=false;
		String x=null;
		aux.clear();
		for(Key j :line) {
			if(line.element().compareTo(j) == -1 ) {
					priorityPresent = true;
				}
		}
		
			if(priorityPresent==true && normalAtendido>2) { // 0 1 2 atendidos 
				x = prioritario();
			}else if(priorityPresent==true && start == true){
				x = prioritario();
			}else if(line.element().getPriority()==0 || normalAtendido>2) {
				x = normal(line.element());
			
			
		}//fim for
		transfer();
		return x;
	}// fim peccorer
	
	public static String prioritario() {
		String x=null;
		start=false;
		for(Key j: line) {
			if(j.getPriority()!=1) {
				aux.add(j);
				clear++;
			}else {
				clear++;
				normalAtendido=0;
				x = "Atendendimento PREFERÊNCIAL\n" + j.toString();
				break;
			}
		}
		return x;
	}
	public static String normal(Key i) {
		clear++;
		normalAtendido++;
		String x =  "Atendendimento\n" + i.toString();
		return x;
	}
	
	public static void transfer() {
		for(int i=0;i<clear;i++) { // limpar os elementos antes do selecionado
			line.remove();
		}
		for (Key i : line) {// completar a lista com os que não foram removidos 
			aux.add(i);
		}
		clear=0;
		line.clear();// limpar a lista antes de receber os de volta todos
		for(Key i : aux) {
			line.add(i);
		}
	}
	
	
}
