package br.com.unisinos.biblioteca;

import br.com.unisinos.biblioteca.livro.EBook;
import br.com.unisinos.biblioteca.livro.Livro;
import br.com.unisinos.biblioteca.livro.LivroColecao;
import br.com.unisinos.biblioteca.livro.LivroRaro;
import br.com.unisinos.biblioteca.util.Teclado;

//Nomes: Eduardo Debarba Scheuermann, Guilherme Lemos da Silva e Jean Lukas Andrade Restelli.

public class Teste {

	public static void main(String[] args) {

		Teclado teclado = new Teclado();
		Biblioteca biblioteca = new Biblioteca(20, 10);

		for (;;) {

			montarMenuPrincipal();
			int opcao = teclado.leInt("Digite um código de 1 a 9");

			if (opcao == 1) {

				for (;;) {

					montarMenuDeLivros();

					String tipoDeLivro = teclado.leString("Digite qual tipo de livro você deseja inserir: ");
					int codigoEditora = teclado.leInt("Digite o código da editora:");

					Editora editora = biblioteca.buscarEditoraPeloCodigo(codigoEditora);

					if (tipoDeLivro.equalsIgnoreCase("Livro")) {
						Livro livro = new Livro(teclado.leString("Digite o nome do livro:"),
								teclado.leString("Digite o nome do Autor:"), codigoEditora,
								teclado.leInt("Digite o número de páginas do livro"));
						if (editora == null) {
							System.out.println("Editora não existe.");
						}
						biblioteca.insereLivro(livro);
						break;

					} else if (tipoDeLivro.equalsIgnoreCase("Livro Raro")) {
						LivroRaro livroRaro = new LivroRaro(teclado.leString("Digite o nome do livro raro:"),
								teclado.leString("Digite o nome do Autor:"), codigoEditora,
								teclado.leInt("Digite o número de páginas do livro"),
								teclado.leString("Digite o estado de conservação do livro:"));
						if (editora == null) {
							System.out.println("Editora não existe.");
						}
						biblioteca.insereLivro(livroRaro);
						break;

					} else if (tipoDeLivro.equalsIgnoreCase("Ebook")) {
						EBook ebook = new EBook(teclado.leString("Digite o nome do eBook:"),
								teclado.leString("Digite o nome do Autor:"), codigoEditora,
								teclado.leInt("Digite o número de páginas do livro"),
								teclado.leInt("Digite o tamanho do arquivo"));
						if (editora == null) {
							System.out.println("Editora não existe.");
						}
						biblioteca.insereLivro(ebook);
						break;

					} else if (tipoDeLivro.equalsIgnoreCase("Livro de Coleção")) {
						LivroColecao livroColecao = new LivroColecao(
								teclado.leString("Digite o nome do livro de coleção:"),
								teclado.leString("Digite o nome do Autor:"), codigoEditora,
								teclado.leInt("Digite o número de páginas do livro"),
								teclado.leInt("Digite o numero de volumes:"));
						if (editora == null) {
							System.out.println("Editora não existe.");
						}
						biblioteca.insereLivro(livroColecao);
						break;

					} else {
						System.out.println("Opção invalida, digite novamente o tipo de livro que deseja inserir.");
					}
				}

			} else if (opcao == 2) {

				String nomeColecao = teclado.leString("Digite o nome da coleção:");

				String nomeLivro = teclado.leString("Digite o nome do livro:");
				String nomeAutor = teclado.leString("Digite o nome do Autor:");
				int codigoEditora = teclado.leInt("Digite o código da editora:");
				int numeroPaginas = teclado.leInt("Digite o número de páginas do livro");

				Editora editora = biblioteca.buscarEditoraPeloCodigo(codigoEditora);
				if (editora == null) {
					System.out.println("Editora não existe.");
				}

				Livro livro = new Livro(nomeLivro, nomeAutor, codigoEditora, numeroPaginas);

				biblioteca.inserirLivroNaColecao(livro, nomeColecao);

			} else if (opcao == 3) {
				biblioteca.removeLivroPeloNome(teclado.leString("Digite o nome do livro que deseja remover:"));

			} else if (opcao == 4) {
				biblioteca.removeLivroPelaEditora(
						teclado.leInt("Digite o código da editora dos livros que deseja remover:"));

			} else if (opcao == 5) {
				biblioteca.listaLivros();

			} else if (opcao == 6) {
				Editora editora = new Editora(teclado.leString("Digite o nome da editora:"),
						teclado.leInt("Digite o código da editora:"));
				biblioteca.insereEditora(editora);

			} else if (opcao == 7) {
				int codigoEditora = teclado.leInt("Digite o codigo da editora que deseja remover:");
				biblioteca.removeEditora(codigoEditora);

			} else if (opcao == 8) {
				biblioteca.listaEditoras();

			} else if (opcao == 9) {
				break;

			} else {
				System.out.println("Opção inválida, digite novamente.");
			}
		}
	}

	private static void montarMenuPrincipal() {
		System.out.println("1. Insere livro");
		System.out.println("2. Insere livro em coleção");
		System.out.println("3. Remove livro pelo nome");
		System.out.println("4. Remove livro pela editora");
		System.out.println("5. Lista os livros da biblioteca");
		System.out.println("6. Insere editora");
		System.out.println("7. Remove editora");
		System.out.println("8. Lista as editoras");
		System.out.println("9. Encerra programa");
	}

	private static void montarMenuDeLivros() {
		System.out.println("Digite Livro para um livro comum");
		System.out.println("Digite Livro Raro para um livro raro");
		System.out.println("Digite Ebook para um Ebook");
		System.out.println("Digite Livro de Coleção para livro de coleção");
	}
}
