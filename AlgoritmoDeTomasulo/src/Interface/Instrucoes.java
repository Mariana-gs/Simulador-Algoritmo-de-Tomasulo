package Interface;

import java.util.LinkedList;

class Instrucoes {
    
    public int numeroInstrucoes;
    public int numeroTiposInstrucoes;
    public static LinkedList<LinkedList<String>> filaInstrucoes;
    
    Instrucoes(int numeroInstrucoes, int numeroTiposInstrucoes) {
        this.numeroInstrucoes = numeroInstrucoes;
        this.numeroTiposInstrucoes = numeroTiposInstrucoes;
        filaInstrucoes = new LinkedList<LinkedList<String>>();
    }
    
    public static LinkedList<LinkedList<String>> getFilaInstrucoes() {
    	return filaInstrucoes;
    }

    public void construirFilaInstrucoes() {
        for (int i = 0; i <= numeroTiposInstrucoes; i ++) {
        	filaInstrucoes.add(new LinkedList<String>());
        }
    }

    public void addInstrucao(int id, String instrucao) {
        filaInstrucoes.get(id).add(instrucao);
    }

    public void mostrar() {
        System.out.println("\nINFORMAÇÕES");
        System.out.println("\nNúmero de instruções -> " + numeroInstrucoes);
        System.out.println("Número de tipos de instruções -> " + numeroTiposInstrucoes);

        System.out.print("Instruções -> ");
        for(int j = 0; j < numeroInstrucoes; j ++) {
	        for(String i: filaInstrucoes.get(j)) {
	        	System.out.print(i + " ");
	        }
        }
        System.out.println();
    }

}
