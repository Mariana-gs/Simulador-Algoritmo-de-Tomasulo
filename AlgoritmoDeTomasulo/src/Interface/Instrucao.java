package Interface;

public class Instrucao {
	
	public String opCode;
	public String registrador1;
	public String registrador2;
	public String registrador3;
	public int imediato;
	
	Instrucao(String opCode, String registrador1, String registrador2, String registrador3, int imediato) {
		this.opCode = opCode;
		this.registrador1 = registrador1;
		this.registrador2 = registrador2;
		this.registrador3 = registrador3;
		this.imediato = imediato;
	}

	public String getOpCode() {
		return opCode;
	}

	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}

	public String getRegistrador1() {
		return registrador1;
	}

	public void setRegistrador1(String registrador1) {
		this.registrador1 = registrador1;
	}

	public String getRegistrador2() {
		return registrador2;
	}

	public void setRegistrador2(String registrador2) {
		this.registrador2 = registrador2;
	}

	public String getRegistrador3() {
		return registrador3;
	}

	public void setRegistrador3(String registrador3) {
		this.registrador3 = registrador3;
	}

	public int getImediato() {
		return imediato;
	}

	public void setImediato(int imediato) {
		this.imediato = imediato;
	}
	
}

