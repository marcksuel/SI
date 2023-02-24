package entities;

public class Type extends Manifestation {

	protected boolean elogio;
	protected boolean sugestao;
	protected boolean reclamacao;
	
	public Type(String description, String name ,int code, int tipo) {
		super(description,name ,code);
		AddType(tipo);
	}

	public Type(){
		super(null,null,0);
		this.elogio = false;
		this.sugestao = false;
		this.reclamacao = false;
	}

	public void AddType(int tipo) {
		if(tipo == 0) {
			this.elogio = true;
			this.sugestao = false;
			this.reclamacao = false;
		}else if(tipo == 1) {
			this.elogio = false;
			this.sugestao = true;
			this.reclamacao = false;
		}else if(tipo == 2) {
			this.elogio = false;
			this.sugestao = false;
			this.reclamacao = true;
		}
	}

	@Override
	public String toString() {
		if(this.elogio) {
			return  "\nTipo: Elogio"+super.toString();
		}else if (this.sugestao) {
			return  "\nTipo: Sugestão"+super.toString();
				
		}else if(this.reclamacao) {
			return  "\nTipo: Reclamação"+ super.toString();
			
		}else {
			return "";
		}
	}
	
	
	
}
