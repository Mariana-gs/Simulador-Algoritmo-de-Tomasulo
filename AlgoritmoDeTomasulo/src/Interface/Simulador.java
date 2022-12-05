package Interface;

import java.util.LinkedList;
import java.util.Scanner;

import Interface.EstacaoInstrucao;
import Interface.Instrucoes;
import Interface.Manipulador;

public class Simulador {
	
	// VARIÁVEIS
	
	/*
	 * Vetor de instrucoes, cada posicao 
	 * do vetor se refere uma classe Instrucoes
	 * com o tipo de instrucao que
	 * tem uma lista de string (instrucoes)
	 */
    public Instrucoes[] filaInstrucoes;
    
	public String path;
	
    
    public EstacaoInstrucao instrucoes;
    public EstacaoInstrucao[] carregarTabela1;
	
	public EstacaoReserva[] load;
	public EstacaoReserva[] add;
	public EstacaoReserva[] mult;
	
	public EstacaoRegistrador registradores;
	
	
	
	// MÉTODOS 
	
	public void inserirInstrucao(int id, String instrucao){
        //inserir no vetor se não existirem
        if(filaInstrucoes[id] == null){
            Instrucoes instrucoes = new Instrucoes();
            filaInstrucoes[id] = instrucoes;
        }
        filaInstrucoes[id].inserir(instrucao);
    }
	
	
	
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
        	 linhaSeparada = arquivo.read();
        }

        for(int j = 0; j < numeroTiposInstrucoes; j++) {
        	if(filaInstrucoes[j] != null) {
        		filaInstrucoes[j].Mostrar();
        	}
        	
        }

        arquivo.close();
	}
	
	public void preencherEstacaoInstrucao() {
		
	}
	
	public void preencherEstacaoReserva() {
		load = new EstacaoReserva[2];
		add = new EstacaoReserva[3];
		mult = new EstacaoReserva[2];
		
		for(int i = 0; i < load.length; i ++) {
			load[i] = new EstacaoReserva();
			load[i].setName("Load" + (i+1));
			load[i].setBussy("No");
			load[i].setOp("-");
			load[i].setVj("-");
			load[i].setVk("-");
			load[i].setQj("-");
			load[i].setQk("-");
			load[i].setA("-");
		}
		
		for(int i = 0; i < add.length; i ++) {
			add[i] = new EstacaoReserva();
			add[i].setName("Add" + (i+1));
			add[i].setBussy("No");
			add[i].setOp("-");
			add[i].setVj("-");
			add[i].setVk("-");
			add[i].setQj("-");
			add[i].setQk("-");
			add[i].setA("-");
		}
		
		for(int i = 0; i < mult.length; i ++) {
			mult[i] = new EstacaoReserva();
			mult[i].setName("Mult" + (i+1));
			mult[i].setBussy("No");
			mult[i].setOp("-");
			mult[i].setVj("-");
			mult[i].setVk("-");
			mult[i].setQj("-");
			mult[i].setQk("-");
			mult[i].setA("-");
		}
	}
	
	public void preencherEstacaoRegistrador() {
		registradores = new EstacaoRegistrador();
		
		registradores.setF0("-");
		registradores.setF2("-");
		registradores.setF4("-");
		registradores.setF6("-");
		registradores.setF8("-");
		registradores.setF10("-");
		registradores.setF12("-");
		registradores.setF14("-");
		registradores.setF16("-");
	}
	
	//OUTROS MÉTODOS
	
	public void inicializarSimulador() {
		chamarFilaInstrucoes();
		
		
		carregarTabela1 = new EstacaoInstrucao[filaInstrucoes.length];
		for(int i = 1; i < filaInstrucoes.length; i ++) {
			carregarTabela1[i] = new EstacaoInstrucao();
			
			if(filaInstrucoes[i].tiposInstrucao.size() != 0) {
				int j = 0;
				carregarTabela1[i].setInstruction(filaInstrucoes[i].tiposInstrucao.get(j));
				System.out.println(filaInstrucoes[i].tiposInstrucao.get(j));
				j++;
			}
			carregarTabela1[i].setIssue("-");
			carregarTabela1[i].setExecute("-");
			carregarTabela1[i].setWriteResult("-");
		}
	
		preencherEstacaoInstrucao();
		preencherEstacaoReserva();
		preencherEstacaoRegistrador();
		
	}
	
}









