package br.com.unisinos.biblioteca.livro;

public class EBook extends Livro {

	private int tamanhoDoArquivo;

	public EBook(String nomeLivro, String nomeAutor, int codigoEditora, int numeroPaginas, int tamanhoDoArquivo) {
		super(nomeLivro, nomeAutor, codigoEditora, numeroPaginas);
		this.tamanhoDoArquivo = tamanhoDoArquivo;
	}

	public int getTamanhoDoArquivo() {
		return tamanhoDoArquivo;
	}

	public void setTamanhoDoArquivo(int tamanhoDoArquivo) {
		this.tamanhoDoArquivo = tamanhoDoArquivo;
	}

	@Override
	public String toString() {
		return super.toString() + "," + "Tamanho do arquivo: " + tamanhoDoArquivo;
	}
}
