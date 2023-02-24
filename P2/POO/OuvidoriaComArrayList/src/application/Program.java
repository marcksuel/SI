package application;

import javax.swing.JOptionPane;

import entities.Ouvidoria;

public class Program {
	public static void main(String[] args) {
		Ouvidoria ouvidoria = new Ouvidoria();
		 /* Simple JOptionPane ShowOptionDialogJava example */    
	    String[] option = { "Adicionar Manifestação", 
	    					"Pesquisar manifestação  pelo código", 
	    					"Pesquisar manifestação por nome",
	    					"Listar todas manifestações",
	    					"Remover manifestação por código",
	    					"Sair"};
	  Integer op;
	   do {
		   op = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Ouvidoria",0, 3, null, option, option[0]);
		   if(op== -1) {
			   op=5;	
		   }
		   switch (op) {
				case 0: {
					ouvidoria.Add();
					break;
				}
				case 1: {
					ouvidoria.PorCodigo();
				    break;

				}
				case 2: {
					ouvidoria.PorNome();;
					break;

				}
				case 3: {
					ouvidoria.Listar();
				    break;
				}
				case 4: {
					ouvidoria.Remover();
					break;
				}
				case 5:{
				    JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso sistema!");
				    break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + op);
				}
	    
	    }while(op!=5);

	}

}
