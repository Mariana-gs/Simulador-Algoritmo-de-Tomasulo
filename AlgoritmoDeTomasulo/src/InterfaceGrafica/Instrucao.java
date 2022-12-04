package InterfaceGrafica;

public class Instrucao {
	
	public static String instrucao;
	public static int id;
	
	Instrucao(String instrucao, int id) {
		this.instrucao = instrucao;
		System.out.println("inseriu: " + instrucao);
		this.id = id;
	}
	
	Instrucao() {
		this.instrucao = "";
		this.id = 0;
	}
	
	public String getInstrucao() {
		return instrucao;
	}
	public int getId() {
		return id;
	}
}
