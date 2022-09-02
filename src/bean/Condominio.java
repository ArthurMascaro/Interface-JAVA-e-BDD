package bean;

public class Condominio {
	
	private String nome;
	private int qntCasas;
	private String cidade;
	
	public Condominio(String nome, int qntCasas, String cidade) {
		this.nome = nome;
		this.qntCasas = qntCasas;
		this.cidade = cidade;
	}

	public Condominio() {
	}

	@Override
	public String toString() {
		return "Condominio [nome=" + nome + ", qntCasas=" + qntCasas + ", cidade=" + cidade + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQntCasas() {
		return qntCasas;
	}

	public void setQntCasas(int qntCasas) {
		this.qntCasas = qntCasas;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
