package entities;

public class Key implements Comparable<Key>{
	public Integer number;
	public Integer priority; // 1 será considerado preferêncial
	
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Key(Integer number, Integer priority) {
		this.number = number;
		this.priority = priority; 
	}
	
	public Key() {}
	


	@Override
	public int compareTo(Key o) {
		if(this.priority> o.getPriority()) { // compara as prioridade para organizar a PriorityQueue
			return -1;
		}else if(this.number > o.getNumber()) {
			return 1;
		}else {	//true se 0=0 ou 1=1	
			return 1;
		}
		/*
		 Usando o1 < o2 ? 1 : -1, obteremos o resultado em ordem descendente. Se tivéssemos usado o1 > o2 ? 1 : -1,
		  obteríamos o resultado em ordem ascendente. 
		 Sendo assim as Key que tiverem Prioridade seram apresentadas primeiro
		 */
	}

	@Override
	public String toString() {
		if(priority == 0) {
			return "Key:" + number + ", Priority: Normal\n";
		}else {
			return "Key:" + number + ", Priority: Prioritario\n";
		}
	}
	
	
	
}
