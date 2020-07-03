//Guilherme Lemos da Silva, Jean Lukas Andrade Restelli e Eduardo Debarba Scheuermann
public class Teste {
	public static void main(String[] args) {
		Teclado t = new Teclado();

		Pedido p = new Pedido("Guilherme");
		
		System.out.println("1. Incluir novo item local");
		System.out.println("2. Incluir novo item local extra");
		System.out.println("3. Incluir novo item auxiliar");
		System.out.println("4. incluir novo item especial");
		System.out.println("5 Mostrar lista de itens");
		System.out.println("6. Mostrar valor total do pedido");
		System.out.println("7. Encerrar programa");
		for (;;) {
		int opcao = t.leInt("Digite uma opção de 1 a 7: ");
		
			if (opcao == 1) {
				ItemLocal il = new ItemLocal(t.leString("Digite o nome do item:"),
						t.leDouble("Digite o preço do item:"),
						new Data(t.leInt("Digite o dia:"), t.leInt("Digite o mês:"), t.leInt("Digite o ano:")),
						t.leInt("Digite o código do item:"), t.leString("Digite a cor do item:"),
						t.leString("Digite a textura do item:"));
				p.incluiItemNoPedido(il);
			} else if (opcao == 2) {
				ItemLocalExtra ile = new ItemLocalExtra(t.leString("Digite o nome do item:"),
						t.leDouble("Digite o preço do item:"),
						new Data(t.leInt("Digite o dia:"), t.leInt("Digite o mês:"), t.leInt("Digite o ano:")),
						t.leInt("Digite o código do item:"), t.leString("Digite a cor do item:"),
						t.leString("Digite a textura do item:"), t.leDouble("Digite o peso do item:"));
				p.incluiItemNoPedido(ile);
			} else if (opcao == 3) {
				for(;;) {
				ItemAux ia = new ItemAux(t.leString("Digite o nome do item:"), t.leDouble("Digite o preço do item:"),
						new Data(t.leInt("Digite o dia:"), t.leInt("Digite o mês:"), t.leInt("Digite o ano:")),
						t.leInt("Digite o código do item:"), new Data(t.leInt("Digite o dia da validade:"),
								t.leInt("Digite o mês da validade"), t.leInt("Digite o ano da validade:")),
						t.leDouble("Digite o percentual de desconto entre 0 e 100:"));
				if(ia.getDescontoPercentual() >= 0 && ia.getDescontoPercentual() <= 100) {
				ia.decrescentaPreco();
				p.incluiItemNoPedido(ia);
				break;
				}
				else {
					System.out.println("Digite novamente o pedido");
				}
			}
			} else if (opcao == 4) {
				ItemEspecial ie = new ItemEspecial(t.leString("Digite o nome do item:"),
						t.leDouble("Digite o preço do item:"),
						new Data(t.leInt("Digite o dia:"), t.leInt("Digite o mês:"), t.leInt("Digite o ano:")),
						t.leInt("Digite o código do item:"),t.leDouble("Digite o valor adicional do item:"));
				ie.acrescentaPreco();
				p.incluiItemNoPedido(ie);
			}else if (opcao == 5) {
				p.mostraListaItens();
			}else if (opcao == 6) {
				p.mostraValorTotal();
			}else if (opcao == 7) {
				break;
			}
		
		}

	}
}
