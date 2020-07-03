package br.com.unisinos.biblioteca;

public class Editora {

	private String nomeEditora;
	private int codigoEditora;

	public Editora(String nomeEditora, int codigoEditora) {
		this.nomeEditora = nomeEditora;
		this.codigoEditora = codigoEditora;
	}

	public String getNomeEditora() {
		return nomeEditora;
	}

	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}

	public int getCodigoEditora() {
		return codigoEditora;
	}

	public void setCodigoEditora(int codigoEditora) {
		this.codigoEditora = codigoEditora;
	}

	@Override
	public String toString() {
		return "Código da editora: " + codigoEditora + ", " + "Nome da editora: " + nomeEditora + "\n";
	}
}
