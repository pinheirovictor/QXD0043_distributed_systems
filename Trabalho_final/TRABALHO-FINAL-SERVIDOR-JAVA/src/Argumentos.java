
public class Argumentos {
	
	private int decimal;
	private String funcao;
	private String resposta;
	
	public Argumentos(int decimal, String funcao, String resposta) {
		super();
		this.decimal = decimal;
		this.funcao = funcao;
		this.resposta = resposta;
	}
	
	public int getDecimal() {
		return decimal;
	}
	public void setDecimal(int decimal) {
		this.decimal = decimal;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	@Override
	public String toString() {
		return "Argumentos [decimal=" + decimal + ", funcao=" + funcao + ", resposta=" + resposta + "]";
	}
	
	
}
