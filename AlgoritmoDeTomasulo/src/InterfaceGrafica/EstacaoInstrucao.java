package InterfaceGrafica;

public class EstacaoInstrucao {
	
	public static Instrucao instruction;
	public static String issue;
	public static String execute;
	public static String writeResult;
	
	public String getInstruction() {
		String aux = instruction.getInstrucao();
		return aux;
	}
	
	public void setInstruction(Instrucao instruction) { 
		this.instruction = instruction;	
	}
	
	public String getIssue() {
		return issue;
	}
	
	public void setIssue(String issue) { 
		this.issue = issue;	
	}
	
	public String getExecute() {
		return execute;
	}
	
	public void setExecute(String execute) { 
		this.execute = execute;	
	}
	
	public String getWriteResult() {
		return writeResult;
	}
	
	public void setWriteResult(String writeResult) { 
		this.writeResult = writeResult;	
	}
	
}
