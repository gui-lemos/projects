package br.com.unisinos.biblioteca.livro;

public class LivroRaro extends Livro {

	private String estadoDeConservacao;

	public LivroRaro(String nomeLivro, String nomeAutor, int codigoEditora, int numeroPaginas, String estadoDeConservacao) {
		super(nomeLivro, nomeAutor, codigoEditora, numeroPaginas);
		this.estadoDeConservacao = estadoDeConservacao;
	}

	public String getEstadoDeConservacao() {
		return estadoDeConservacao;
	}

	public void setEstadoDeConservacao(String estadoDeConservacao) {
		this.estadoDeConservacao = estadoDeConservacao;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + "Estado de conservação: " + estadoDeConservacao;
	}
}
