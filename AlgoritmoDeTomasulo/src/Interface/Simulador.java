package Interface;

public class Simulador {
	
	// VARIÁVEIS
	public String path;
	
    public FilaDeInstrucoes[] filaDeInstrucoes;
  
    public EstacaoInstrucao instrucoes;
    public EstacaoInstrucao[] carregarTabela1;
	
	public EstacaoReserva[] load;
	public EstacaoReserva[] add;
	public EstacaoReserva[] mult;
	
	public EstacaoRegistrador registradores;
	
	// MÉTODOS 
	public void inserirInstrucao(int id, Instrucao instrucao) {
		if(filaDeInstrucoes[id] == null) {
			FilaDeInstrucoes inst = new FilaDeInstrucoes();
			filaDeInstrucoes[id] = inst;
		}
		
		filaDeInstrucoes[id].inserir(instrucao);
	}
	
	public void chamarFilaDeInstrucoes() {
        String[] linhaSeparada;
        String[] registradores;
        
        int id;
        Instrucao instrucao;
        
        int numeroInstrucoes;
        int numeroTiposInstrucoes;

        Manipulador arquivo = new Manipulador(path);

        linhaSeparada = arquivo.read();
        numeroInstrucoes = Integer.parseInt(linhaSeparada[0]);
        
        linhaSeparada = arquivo.read();
        numeroTiposInstrucoes = Integer.parseInt(linhaSeparada[0]);
        
        filaDeInstrucoes = new FilaDeInstrucoes[numeroInstrucoes];
        
        linhaSeparada = arquivo.read();
        
        while (linhaSeparada != null) {
        	id = Integer.parseInt(linhaSeparada[0]);
        	registradores = linhaSeparada[2].split(",");
        	
        	
        	if(registradores[1].contains("F")) {
        		
        		instrucao = new Instrucao(linhaSeparada[1], registradores[0], registradores[1], registradores[2], 0);
        		System.out.println(linhaSeparada[1] + registradores[0] + registradores[1] + registradores[2] + 0);
        		
        	} else {
        		
        		instrucao = new Instrucao(linhaSeparada[1], registradores[0], registradores[2], "", Integer.parseInt(registradores[1]));
        		System.out.println(linhaSeparada[1] + registradores[0] + registradores[2] + "" + Integer.parseInt(registradores[1]));
        		
        	}

        	inserirInstrucao(id, instrucao);
        	
        	System.out.println("Fila de instruções posição: " + id);
        	
        	linhaSeparada = arquivo.read();
        }

        for(int i = 0; i < numeroTiposInstrucoes; i++) {
        	if(filaDeInstrucoes[i] != null) {
        		filaDeInstrucoes[i].mostrar();
        	}
        }

        arquivo.close();
	}
	
	public void preencherEstacaoInstrucao() {
		carregarTabela1 = new EstacaoInstrucao[filaDeInstrucoes.length];
		
		for(int i = 1; i < filaDeInstrucoes.length; i++) {
			carregarTabela1[i] = new EstacaoInstrucao();
			
			if(filaDeInstrucoes[i].instrucoes.size() != 0) {
				int j = 0;
				
				carregarTabela1[i].setInstruction(filaDeInstrucoes[i].instrucoes.get(j));
				System.out.println("\n" + filaDeInstrucoes[i].instrucoes.get(j).getOpCode());
				
				j++;
			}
			
			carregarTabela1[i].setIssue("-");
			carregarTabela1[i].setExecute("-");
			carregarTabela1[i].setWriteResult("-");
		}
	}
	
	public void preencherEstacaoReserva() {
		load = new EstacaoReserva[2];
		add = new EstacaoReserva[3];
		mult = new EstacaoReserva[2];
		
		for(int i = 0; i < load.length; i++) {
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
		
		for(int i = 0; i < add.length; i++) {
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
		
		for(int i = 0; i < mult.length; i++) {
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
	
	// INICIAR O SIMULADOR
	public void inicializarSimulador() {
		chamarFilaDeInstrucoes();
			
		preencherEstacaoInstrucao();
		preencherEstacaoReserva();
		preencherEstacaoRegistrador();
	}
}









