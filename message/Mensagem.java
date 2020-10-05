package message;

public class Mensagem {
	
	public String conteudo;
	
	public Mensagem(String conteudo) {
		super();
		this.conteudo = conteudo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public String toString() {
		return "Mensagem [conteudo=" + conteudo + "]";
	}

}
