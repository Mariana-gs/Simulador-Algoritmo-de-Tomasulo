package InterfaceGrafica;

import java.util.LinkedList;


class Instrucoes {
    
    public int numeroInstrucoes;
    public int numeroTiposInstrucoes;
    public static LinkedList<TiposInstrucoes> filaInstrucoes;
    
    
    public static LinkedList<TiposInstrucoes> getFilaInstrucoes() {
    	return filaInstrucoes;
    }
    
    
    Instrucoes(int numeroInstrucoes, int numeroTiposInstrucoes) {
        this.numeroInstrucoes = numeroInstrucoes;
        this.numeroTiposInstrucoes = numeroTiposInstrucoes;
        filaInstrucoes = new LinkedList<TiposInstrucoes>();
        TiposInstrucoes tipos;
		tipos = new TiposInstrucoes();
		filaInstrucoes.add(tipos);
    }
    

    /*public void construirFilaInstrucoes() {
    	TiposInstrucoes tipos;
    	
        for (int i = 0; i <= numeroTiposInstrucoes; i ++) {
        	tipos = new TiposInstrucoes();
        	filaInstrucoes.add(tipos);
        	//DEBUG
        	System.out.println("tamanho da fila de instruções na posicao "+ i + ":" + filaInstrucoes.get(i).getTiposInstrucoes().size());
        }
        //DEBUG
        System.out.println("tamanho da fila de instruções: " + filaInstrucoes.size());
        
    }*/

    public void addInstrucao(int id, String instrucao) {
    	
    	if(filaInstrucoes.get(id) == null) {
    		TiposInstrucoes tipos;
    		tipos = new TiposInstrucoes();
    		filaInstrucoes.add(id, tipos);
    	}
    	filaInstrucoes.get(id).getTiposInstrucoes().add(instrucao);	
    	
    	//DEBUG
    	System.out.println("Adicionando instrução");
    	System.out.println("id: " + id);
    	System.out.println("instrução: " + instrucao);
    	System.out.println("fila de instrucoes na posicao " + id + " tem o tamanho: " + filaInstrucoes.get(id).getTiposInstrucoes().size());
    }

    public void mostrar() {
        System.out.println("\nINFORMAÇÕES");
        System.out.println("\nNúmero de instruções -> " + numeroInstrucoes);
        System.out.println("Número de tipos de instruções -> " + numeroTiposInstrucoes);

        System.out.print("Instruções -> ");
        for(int j = 0; j < numeroInstrucoes; j ++) {
	        for(String i: filaInstrucoes.get(j).getTiposInstrucoes()) {
	        	System.out.print(i + " ");
	        }
        }
        System.out.println();
    }

}
