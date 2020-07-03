package br.com.unisinos.biblioteca;

import br.com.unisinos.biblioteca.livro.Livro;
import br.com.unisinos.biblioteca.livro.LivroColecao;

public class Biblioteca {

	private int totLivros;
	private int tamLivros;

	private int totEditoras;
	private int tamEditoras;

	Livro[] listaLivros;
	Editora[] listaEditoras;

	public Biblioteca(int tamLivros, int tamEditoras) {

		this.tamLivros = tamLivros;
		this.tamEditoras = tamEditoras;

		this.listaLivros = new Livro[tamLivros];
		this.listaEditoras = new Editora[tamEditoras];
	}

	public boolean insereLivro(Livro livro) {

		if (this.totLivros == this.tamLivros) {
			System.out.println("Não é possível inserir o livro. O Cadastro está cheio.");
			return false;
		}

		for (int i = 0; i < listaLivros.length; i++) {
			if (listaLivros[i] == null) {
				listaLivros[i] = livro;
				this.totLivros++;
				return true;
			}
		}

		return false;
	}

	public boolean removeLivroPeloNome(String nomeLivro) {

		int posicao = buscarPosicaoDoLivroPorNome(nomeLivro);

		if (posicao < 0) {
			System.out.println("Não é possível remover o livro. Livro não existe.");
			return false;
		}

		listaLivros[posicao] = null;

		this.totLivros--;

		return true;
	}

	private int buscarPosicaoDoLivroPorNome(String nomeLivro) {

		for (int i = 0; i < listaLivros.length; i++) {

			Livro livro = listaLivros[i];

			if (livro == null) {
				continue;
			}

			if (livro.getNomeLivro().equalsIgnoreCase(nomeLivro)) {
				return i;
			}
		}

		return -1;
	}

	public boolean removeLivroPelaEditora(int codigoEditora) {

			Editora editora = buscarEditoraPeloCodigo(codigoEditora);

			if (editora == null) {
				System.out.println("Não é possível remover livro. Editora não encontrada.");
				return false;
			}
			
			boolean algumLivroFoiRemovido = false;

			for (int i = 0; i < listaLivros.length; i++) {

				Livro livro = listaLivros[i];

				if (livro == null) {
					continue;
				}

				if (livro.getCodigoEditora() == codigoEditora) {
					listaLivros[i] = null;
					this.totLivros--;
					algumLivroFoiRemovido = true;
				}
			}

			return algumLivroFoiRemovido;
		}

	public Editora buscarEditoraPeloCodigo(int codigoEditora) {
		for (int i = 0; i < listaEditoras.length; i++) {

			Editora editora = listaEditoras[i];

			if (editora == null) {
				continue;
			}

			if (editora.getCodigoEditora() == codigoEditora) {
				return editora;
			}
		}

		return null;
	}

	public void listaLivros() {

		for (int i = 0; i < listaLivros.length; i++) {

			Livro livro = listaLivros[i];

			if (livro == null) {
				continue;
			}

			Editora editora = buscarEditoraPeloCodigo(livro.getCodigoEditora());

			if(editora == null) {
				continue;
			}
			System.out.println(
				"Nome do livro:" + livro.getNomeLivro() + ", " +
				"Nome do autor: " + livro.getNomeAutor() + ", " +
				"Número de páginas: " + livro.getNumeroPaginas() + ", " +
				"Nome da editora: " + editora.getNomeEditora()
			);
		}
	}

	public boolean insereEditora(Editora editora) {

		if (this.totEditoras == this.tamEditoras) {
			System.out.println("Não é possível inserir a editora. O Cadastro está cheio.");
			return false;
		}

		Editora editoraEncontrada = this.buscarEditoraPeloCodigo(editora.getCodigoEditora());

		if (editoraEncontrada != null) {
			System.out.println("Não é possível inserir editora. Editora já existe.");
			return false;
		}

		for (int i = 0; i < listaEditoras.length; i++) {
			if (listaEditoras[i] == null) {
				listaEditoras[i] = editora;
				this.totEditoras++;
				return true;
			}
		}

		return false;
	}

	public void listaEditoras() {

		for (int i = 0; i < listaEditoras.length; i++) {

			Editora editora = listaEditoras[i];

			if (editora == null) {
				continue;
			}

			System.out.println(editora.toString());
		}
	}

	public boolean removeEditora(int codigoEditora) {

		Editora editoraEncontrada = this.buscarEditoraPeloCodigo(codigoEditora);

		if (editoraEncontrada == null) {
			System.out.println("Não é possível remover editora. Editora não existe.");
			return false;
		}

		removeLivroPelaEditora(codigoEditora);

		for (int i = 0; i < listaEditoras.length; i++) {

			Editora editora = listaEditoras[i];

			if (editora == null) {
				continue;
			}

			if (editora.getCodigoEditora() == codigoEditora) {
				listaEditoras[i] = null;
				this.totEditoras--;
				return true;
			}
		}

		return false;
	}

	public boolean inserirLivroNaColecao(Livro livro, String nomeColecao) {

		int posicao = buscarPosicaoDoLivroPorNome(nomeColecao);

		if (posicao < 0) {
			System.out.println("Não é possível inserir livro na coleção. Coleção não existe.");
			return false;
		}

		if (!(this.listaLivros[posicao] instanceof LivroColecao)) {
			System.out.println("Não é possível inserir livro na coleção. O livro encontrado com o nome digitado não é de uma coleção.");
			return false;
		}

		LivroColecao colecao = (LivroColecao) this.listaLivros[posicao];

		return colecao.inserir(livro);
	}
}
