package br.com.unisinos.biblioteca.livro;

public class Livro {

	private String nomeLivro;
	private String nomeAutor;
	private int codigoEditora;
	private int numeroPaginas;

	public Livro(String nomeLivro, String nomeAutor, int codigoEditora, int numeroPaginas) {
		this.nomeLivro = nomeLivro;
		this.nomeAutor = nomeAutor;
		this.codigoEditora = codigoEditora;
		this.numeroPaginas = numeroPaginas;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public int getCodigoEditora() {
		return codigoEditora;
	}

	public void setCodigoEditora(final int codigoEditora) {
		this.codigoEditora = codigoEditora;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	@Override
	public String toString() {
		return "Nome do livro: " + this.nomeLivro + ", " +
				"Nome do autor: " + this.nomeAutor + ", " +
				"Código editora: " + this.codigoEditora + ", " +
				"Número de páginas: " + this.numeroPaginas;
	}
}
