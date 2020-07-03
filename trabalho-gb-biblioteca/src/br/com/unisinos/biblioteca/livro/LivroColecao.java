package br.com.unisinos.biblioteca.livro;

public class LivroColecao extends Livro {

	private int numeroDeLivrosDaColecao;
	private Livro[] volumes;

	public LivroColecao(String nomeLivro, String nomeAutor, int codigoEditora, int numeroPaginas,
		final int numeroDeLivrosDaColecao) {
		super(nomeLivro, nomeAutor, codigoEditora, numeroPaginas);
		this.numeroDeLivrosDaColecao = numeroDeLivrosDaColecao;
		this.volumes = new Livro[numeroDeLivrosDaColecao];
	}

	public int getNumeroDeLivrosDaColecao() {
		return numeroDeLivrosDaColecao;
	}

	public void setNumeroDeLivrosDaColecao(int numeroDeLivrosDaColecao) {
		this.numeroDeLivrosDaColecao = numeroDeLivrosDaColecao;
	}

	public Livro[] getVolumes() {
		return volumes;
	}

	public void setVolumes(Livro[] volumes) {
		this.volumes = volumes;
	}

	@Override
	public String toString() {
		return super.toString() + ", " +
			"Número de livros da coleção: " + numeroDeLivrosDaColecao + ", " +
			"Livros da coleção: [\n " + imprimeVolumes() + " \n]";
	}

	private String imprimeVolumes() {

		String livros = "";

		for (int i = 0; i < this.volumes.length; i++) {

			Livro livro = this.volumes[i];

			if (livro == null) {
				break;
			}

			livros += livro.toString();

		}

		return livros;
	}

	public boolean inserir(Livro livro) {

		if (!(livro instanceof Livro)) {
			System.out.println("O livro deve ser do tipo Livro.");
			return false;
		}

		for (int i = 0; i < this.volumes.length; i++) {

			if (this.volumes[i] == null) {

				this.volumes[i] = livro;

				int totalDePaginas = super.getNumeroPaginas() + livro.getNumeroPaginas();

				super.setNumeroPaginas(totalDePaginas);

				return true;
			}
		}

		System.out.println("Não foi possível inserir o livro na coleção. Coleção está cheia.");
		return false;
	}
}
