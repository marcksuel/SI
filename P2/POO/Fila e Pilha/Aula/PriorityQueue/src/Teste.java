import java.util.Iterator;
import java.util.PriorityQueue;

public class Teste {
	public static void main(String[] args) {
		
		Queue<Integer> pq = new PriorityQueue<>();
		pq.add(7);
		pq.add(3);
		pq.add(1);
		pq.add(9);
		pq.add(8);
		pq.add(2);
		System.out.println("pq: " + pq);
		
		Iterator<Integer> iterador  = pq.iterator();
		Integer i = pq.size();
		while(iterador.hasNext()){
			if(i>0) {
			Integer x= pq.element();
			System.out.println(x+ " ");
			pq.add(x);
			pq.remove();
			i--;
			}

		}

	}//main
}//class

