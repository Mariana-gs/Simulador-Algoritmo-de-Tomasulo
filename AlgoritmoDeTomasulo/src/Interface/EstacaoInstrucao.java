package Interface;

public class EstacaoInstrucao {
	
	public Instrucao instruction;
	public String issue;
	public String execute;
	public String writeResult;
	
	public Instrucao getInstruction() {
		return instruction;
	}
	
	public void setInstruction(Instrucao instrucao) { 
		this.instruction = instrucao;	
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
