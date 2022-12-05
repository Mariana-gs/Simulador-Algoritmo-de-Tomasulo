package InterfaceGrafica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Instrucoes {
    
	 //public int numeroInstrucoes;
	 //public int numeroTiposInstrucoes;
	
	 public List<String> tiposInstrucao;
	 
	 
	 Instrucoes(){
		 //this.numeroTiposInstrucoes =  numeroTiposInstrucoes;
		 this.tiposInstrucao = new ArrayList<>();
		 
	 }
	 
	 Instrucoes(String instrucao){
		 //this.numeroTiposInstrucoes =  numeroTiposInstrucoes;
		 this.tiposInstrucao = new ArrayList<>();
		 this.tiposInstrucao.add(instrucao);
	 }
	 
	 public void inserir(String instrucao){
		 this.tiposInstrucao.add(instrucao);
	 }
	 
	 public void Mostrar() {
		 System.out.println("Lista de Instrucoes: ");
		 for(int i=0; i < tiposInstrucao.size(); i++){
	            System.out.print("(" + tiposInstrucao.get(i) + ")");
	        }
		 System.out.println("");
		 
	 }
	 
	 
}
