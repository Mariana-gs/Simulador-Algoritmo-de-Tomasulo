package InterfaceGrafica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Simulador {

	public static File arquivo;
	
	static HashMap<Integer, Instrucao> filaInstrucoes;
	
	public static EstacaoInstrucao[] carregar;
	
	
	/**
	 * Abre o Arquivo e Cria Fila de Instruções
	 */
	public static void preencherFilaInstrucoes() {
		int id;
		
		try {
			FileReader arq = new FileReader(arquivo);
	    	BufferedReader lerArq = new BufferedReader(arq);
	    	
	    	String linha = lerArq.readLine();
	    	
	    	while(linha != null) {
		    	String[] linhaSeparada = linha.split(" ");
	    		id = Integer.parseInt(linhaSeparada[0]);
	    		Instrucao instrucao = new Instrucao(linhaSeparada[1]);
	    		
	    		filaInstrucoes.put(id, instrucao);
	    		System.out.println(id + " " + instrucao.getInstrucao());
	    		
	    		linha = lerArq.readLine();
	    	}
	    	
	    	arq.close();
		}
		catch (IOException e) {
	        System.out.print("Erro na abertura do arquivo!");
	    }
	}
	
	//Outros métodos aqui
	
	public static void inicializarSimulador() {
		filaInstrucoes = new HashMap<>();
		
		preencherFilaInstrucoes();
		
		carregar = new EstacaoInstrucao[filaInstrucoes.size()];
		
		for(int i = 0; i < filaInstrucoes.size(); i ++) {
			carregar[i] = new EstacaoInstrucao();
			carregar[i].setInstruction(filaInstrucoes.get(i));
			carregar[i].setIssue("-");
			carregar[i].setExecute("-");
			carregar[i].setWriteResult("-");
		}
	}
}









