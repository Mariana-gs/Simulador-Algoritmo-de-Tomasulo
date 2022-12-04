package InterfaceGrafica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Simulador {

	public  File arquivo;
	private int qtdInstrucoes;
	public  EstacaoInstrucao[] carregar;
	public Instrucao[] filaInstrucoes; 
	
	
	/**
	 * Abre o Arquivo e Cria Fila de Instruções
	 */
	public void preencherFilaInstrucoes() {
		
		String linha;
		String[] linhaSeparada;
		int i = 0;
		int id;
		
		
		try {
			FileReader arq = new FileReader(arquivo);
	    	BufferedReader lerArq = new BufferedReader(arq);
	    	
	    	linha = lerArq.readLine();
	    	this.qtdInstrucoes = Integer.parseInt(linha);
	    	
	    	
			//filaInstrucoes é um atributo da classe
	    	this.filaInstrucoes = new Instrucao[this.qtdInstrucoes];
	    	
	    	linha = lerArq.readLine();
	    	while(i < this.qtdInstrucoes){
	    		
	    		linhaSeparada = linha.split(" ");
	    		id = Integer.parseInt(linhaSeparada[0]);
	    		
	    		this.filaInstrucoes[i] = new Instrucao(linhaSeparada[1], id);
	    		
	    		
	    		//Aqui ele preenche o vetor certo
	    		 
	    		System.out.println("filaInstrucoes: " + i);
	    		System.out.println(this.filaInstrucoes[i].getInstrucao());
	    		System.out.println(this.filaInstrucoes[i].getId());
	    		System.out.println("");
	    		
	    		i++;
	    		linha = lerArq.readLine();
	    	}
	    	
	    	//i = 0;
	    	arq.close();
	    	
		}catch (IOException e) {
			
			System.out.print("Erro na abertura do arquivo!");
		}
		
		
	}
	
	
	public void inicializarSimulador() {
		
		preencherFilaInstrucoes();
		
		
		//Quando volta para cá os valores estão errados
		 
				System.out.println("filaInstrucoes: " + 0);
				System.out.println(this.filaInstrucoes[0].getInstrucao());
				System.out.println(this.filaInstrucoes[0].getId());
				System.out.println("");
				
				System.out.println("filaInstrucoes: " + 1);
				System.out.println(this.filaInstrucoes[1].getInstrucao());
				System.out.println(this.filaInstrucoes[1].getId());
				System.out.println("");
				
				System.out.println("filaInstrucoes: " + 2);
				System.out.println(this.filaInstrucoes[2].getInstrucao());
				System.out.println(this.filaInstrucoes[2].getId());
				System.out.println("");
				
				System.out.println("filaInstrucoes: " + 3);
				System.out.println(this.filaInstrucoes[3].getInstrucao());
				System.out.println(this.filaInstrucoes[3].getId());
				System.out.println("");
				
				System.out.println("filaInstrucoes: " + 4);
				System.out.println(this.filaInstrucoes[4].getInstrucao());
				System.out.println(this.filaInstrucoes[4].getId());
				System.out.println("");
				
				System.out.println("filaInstrucoes: " + 4);
				System.out.println(this.filaInstrucoes[4].getInstrucao());
				System.out.println(this.filaInstrucoes[4].getId());
				System.out.println("");
				
		
		
		
		
		carregar = new EstacaoInstrucao[this.qtdInstrucoes];
		
		for(int i = 0; i < this.qtdInstrucoes; i ++) {
			carregar[i] = new EstacaoInstrucao();
			carregar[i].setInstruction(this.filaInstrucoes[i]);
			carregar[i].setIssue("-");
			carregar[i].setExecute("-");
			carregar[i].setWriteResult("-");
		}
		
		
		//quando coloca para imprimir filaInstrucoes[] embaixo desse for ele fica vazio
		
		 
		
	}
	
	
	

	
	
	
	
	
	
}













