package Interface;

import java.util.LinkedList;
import java.util.Scanner;

public class Simulador {
	
	// VARIÁVEIS
	public static String path;
	
    public static LinkedList<LinkedList<String>> filaInstrucoes;
    
    public static EstacaoInstrucao instrucoes;
	
	public static EstacaoReserva[] load;
	public static EstacaoReserva[] add;
	public static EstacaoReserva[] mult;
	
	public static EstacaoRegistrador registradores;
	
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
	
	public static void preencherEstacaoInstrucao() {
		
	}
	
	public static void preencherEstacaoReserva() {
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
	
	public static void preencherEstacaoRegistrador() {
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
	
	public static void inicializarSimulador() {
		chamarFilaInstrucoes();
		
		preencherEstacaoInstrucao();
		
		preencherEstacaoReserva();
		
		preencherEstacaoRegistrador();
	}
}









