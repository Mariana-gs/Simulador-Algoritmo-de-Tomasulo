package InterfaceGrafica;

import java.util.LinkedList;
import java.util.Scanner;

public class Simulador {
	
	// VARIÁVEIS
	public static String path;
	
    public static LinkedList<LinkedList<String>> filaInstrucoes;
	
	public static EstacaoInstrucao[] carregarTabela1;
	
	
	
	// MÉTODOS 
	public static void chamarFilaInstrucoes() {
        String[] linhaSeparada;
        
        int id;
        String instrucao;
        
        int numeroInstrucoes;
        int numeroTiposInstrucoes;

        Manipulador arquivo = new Manipulador(path);

        linhaSeparada = arquivo.read();
        numeroInstrucoes = Integer.parseInt(linhaSeparada[0]);
        
        linhaSeparada = arquivo.read();
        numeroTiposInstrucoes = Integer.parseInt(linhaSeparada[0]);
        
        Instrucoes inst = new Instrucoes(numeroInstrucoes, numeroTiposInstrucoes);
        inst.construirFilaInstrucoes();
        
        while ((linhaSeparada = arquivo.read()) != null) {
        	id = Integer.parseInt(linhaSeparada[0]);
        	instrucao = linhaSeparada[1];

        	inst.addInstrucao(id, instrucao);
        }

        filaInstrucoes = inst.getFilaInstrucoes();
        inst.mostrar();

        arquivo.close();
	}
	
	//OUTROS MÉTODOS
	
	public static void inicializarSimulador() {
		chamarFilaInstrucoes();
		
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
		}
	}
}









