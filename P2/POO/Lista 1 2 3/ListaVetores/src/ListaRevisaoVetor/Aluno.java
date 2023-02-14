package ListaRevisaoVetor;
import java.text.DecimalFormat;


public class Aluno {
	private String nome;
	private double nota1,nota2;
	
	public Aluno(String nome, double nota1, double nota2) {
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}
	

	public Aluno() {
		this.nome = null;
		this.nota1 = 0.0;
		this.nota2 = 0.0;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	
	
	public double calcularMedia() {
		return (this.nota1 + this.nota2)/2 ;

	}

	public double Media() {
		return (nota1+nota2)/2;
	}
	@Override
	public String toString() {
		String media = new DecimalFormat("#,##0.00").format(this.Media());

		return "Aluno: " + nome + "    Média: " + media +"\n";
	}
	
}
