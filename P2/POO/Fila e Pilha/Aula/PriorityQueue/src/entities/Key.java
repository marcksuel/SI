package entities;

public class Key implements Comparable<Key> {
	public Integer number;
	public Integer priority; // 1
	
	
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
		if(this.priority> o.getPriority()) { // true se 1(prioridade)>0(normal)
			return 1;
		}else if(this.priority <o.getPriority()) {// true se (normal)0<1 (prioridade)
			return -1;
		}else {	//true se 0=0 ou 1=1	
			return 0;
		}
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
