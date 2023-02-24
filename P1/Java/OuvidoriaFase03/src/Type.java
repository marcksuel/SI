import javax.swing.JOptionPane;

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
		if(tipo == 1) {
			this.elogio = true;
			this.sugestao = false;
			this.reclamacao = false;
		}else if(tipo == 2) {
			this.elogio = false;
			this.sugestao = true;
			this.reclamacao = false;
		}else if(tipo == 3) {
			this.elogio = false;
			this.sugestao = false;
			this.reclamacao = true;
		}
	}

	@Override
	public String toString() {
		if(this.elogio) {
			return 
					 "\nNome: " + super.name
					+ "\nTipo: Elogio"
					+ "\nDescrição: " + super.description
					+ "\nCódigo: " + super.code
					+ "\n";
		}else if (this.sugestao) {
			return 
					 "\nNome: " + super.name
					+ "\nTipo: Sugestão"
					+ "\nDescrição: " + super.description
					+ "\nCódigo: " + super.code
					+ "\n";
		}else if(this.reclamacao) {
			return 
					 "\nNome: " + super.name
					+ "\nTipo: Reclamação"
					+ "\nDescrição: " + super.description
					+ "\nCódigo: " + super.code
					+ "\n";
			
		}else {
			return "";
		}
	}
	
	
	
}
