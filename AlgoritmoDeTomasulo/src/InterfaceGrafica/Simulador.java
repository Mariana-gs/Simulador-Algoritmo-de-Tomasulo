package InterfaceGrafica;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Simulador {
	
	// VARIÁVEIS
	public String path;
	
	/*
	 * Um vetor de instrucoes, cada posicao 
	 * do vetor se refere a um tipo de instrucao e
	 * tem uma lista de string (instrucoes)
	 */
	
    public Instrucoes[] filaInstrucoes;
    
	public EstacaoInstrucao[] carregarTabela1;
	
	
	public void inserirInstrucao(int id, String instrucao){
        //inserir no vetor se não existirem
        if(filaInstrucoes[id] == null){
            Instrucoes instrucoes = new Instrucoes();
            filaInstrucoes[id] = instrucoes;
        }
        
        filaInstrucoes[id].inserir(instrucao);
        
    }
	
	
	
	// MÉTODOS 
	public void chamarFilaInstrucoes() {
		
		//Variáveis
        String[] linhaSeparada;
        String instrucao;
        int id;
        int numeroInstrucoes;
        int numeroTiposInstrucoes;

        //Leitura e tratamento do Arquivo + Atualizar Atributos
        Manipulador arquivo = new Manipulador(path);
        linhaSeparada = arquivo.read();
        numeroInstrucoes = Integer.parseInt(linhaSeparada[0]);
        linhaSeparada = arquivo.read();
        numeroTiposInstrucoes = Integer.parseInt(linhaSeparada[0]);
        
        
        filaInstrucoes = new Instrucoes[numeroTiposInstrucoes+1];
        
        
        linhaSeparada = arquivo.read();
        while (linhaSeparada != null) { //para todas as linhas do arquivo
        	id = Integer.parseInt(linhaSeparada[0]);
        	instrucao = linhaSeparada[1];
        	
        	inserirInstrucao(id, instrucao);
        	
        	 System.out.println("filaInstrucoes posicao: " + id);
        	
        	 /*
        	 if(filaInstrucoes[id] != null) {
        		 filaInstrucoes[id].Mostrar();
        	 }*/
        	linhaSeparada = arquivo.read();
        }
        
        
        for(int j = 0; j < numeroTiposInstrucoes; j++) {
        	if(filaInstrucoes[j] != null) {
        		filaInstrucoes[j].Mostrar();
        	}
        	
        }

        
        arquivo.close();
	}
	
	//OUTROS MÉTODOS
	
	public void inicializarSimulador() {
		chamarFilaInstrucoes();
		
		/*
		carregarTabela1 = new EstacaoInstrucao[filaInstrucoes.size()];
		
		for(int i = 0; i < filaInstrucoes.size(); i ++) {
			carregarTabela1[i] = new EstacaoInstrucao();
			if(filaInstrucoes.get(i).size() != 0) {
				int j = 0;
				
				carregarTabela1[i].setInstruction(filaInstrucoes.get(i).get(j));
				System.out.println(filaInstrucoes.get(i).get(j));
				
				j++;
			}
			carregarTabela1[i].setIssue("-");
			carregarTabela1[i].setExecute("-");
			carregarTabela1[i].setWriteResult("-");
		}*/
	}
}









