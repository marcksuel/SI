package application;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Program {
	public static void main(String[] args) {
		Queue<String> str = new LinkedList<String>();
		str.add("One");
		str.add("Dois");
		str.add("Three");
		str.add("Four");
		for (String x : str) {
			System.out.println(x);
		}
		
		System.out.println("_________");
		/*Iterator<String> iterador = str.iterator();
		
		while(iterador.hasNext()) {
			String element = iterador.next();
			System.out.println(element + "\n");
		}
		*/
		//remove o primeiro elemento da fila
		
		System.out.println("Elemento removido da fila:" + str.remove());
		System.out.println("_________");

		for (String x : str) {
			System.out.println(x);
		}
		
		System.out.println("_________");

		//retorna o primeiro elemento da fila e caso esta vazia , retorna exception
		System.out.println("Cabeça da fila: " + str.element());
		System.out.println("_________");


		for (String x : str) {
			System.out.println(x);
		}
		
		System.out.println("_________");
		
		//remove e retorna o primeiro elemento
		System.out.println("Cabeça da fila antes do poll: " + str.poll());
		System.out.println("_________");


		for (String x : str) {
			System.out.println(x);
		}
		
		System.out.println("_________");
		
		//imprimir toda a fila 
		System.out.println("final fila: " + str);
		
		/*Cada item tem uma prioridade.
		Elementos mais prioritários podem
		ser atendidos antes, mesmo não
		estando no início da fila;*/
        Queue<String> testStringsPQ = new PriorityQueue<>();
        
        /* Neste tipo de fila os elementos nem
		sempre são removidos ao serem
		atendidos, mas voltam ao fim da fila
		para serem atendidos novamente mais
		tarde.
		         * */
        Queue<Integer> deque = new ArrayDeque<>();

        /*
         Para maiores duvidas, consultar a documentação no link abaixo:
		➢ https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
         */
		
	}
}
