package bean;

public class Casa {
	
	private int numeroCasa;
	private String proprietario;
	private String nomeCondominio;
	
	public Casa(int numeroCasa, String proprietario, String nomeCondominio) {
		this.numeroCasa = numeroCasa;
		this.proprietario = proprietario;
		this.nomeCondominio = nomeCondominio;
	}
	
	public Casa() {
	}

	@Override
	public String toString() {
		return "Casa [numeroCasa=" + numeroCasa + ", proprietario=" + proprietario + ", nomeCondominio="
				+ nomeCondominio + "]";
	}

	public int getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getNomeCondominio() {
		return nomeCondominio;
	}

	public void setNomeCondominio(String nomeCondominio) {
		this.nomeCondominio = nomeCondominio;
	}

}
