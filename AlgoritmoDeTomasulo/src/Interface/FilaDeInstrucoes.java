package Interface;

import java.util.ArrayList;
import java.util.List;

class FilaDeInstrucoes {

	 public List<Instrucao> instrucoes;
	 
	 FilaDeInstrucoes() {
		 this.instrucoes = new ArrayList<>();
	 }
	 
	 FilaDeInstrucoes(Instrucao instrucao) {
		 this.instrucoes = new ArrayList<>();
		 this.instrucoes.add(instrucao);
	 }
	 
	 public void inserir(Instrucao instrucao) {
		 this.instrucoes.add(instrucao);
	 }
	 
	 public void mostrar() {
		 System.out.println("Lista de instruções: ");
		 
		 for(int i = 0; i < instrucoes.size(); i++) {
			 System.out.print("(" + instrucoes.get(i).getOpCode() + ")");
	     }
		 
		 System.out.println("");
	 }
	 
}