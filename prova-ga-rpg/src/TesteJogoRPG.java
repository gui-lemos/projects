
public class TesteJogoRPG {
	public static void main(String[] args) {
		Teclado t = new Teclado();

		JogoRPG mago = new JogoRPG("Adolfo", 100, 10, 20, 1, "Mago");
		 JogoRPG personagem = new JogoRPG(t.leString("Digite um nome para o seu para o seu personagem: "),
		 t.leDouble("Digite uma quantidade de vida máxima para o seu personagem: "),
		 t.leDouble("Digite uma quantidade de magia para seu personagem:"),
		 t.leDouble("Digite uma quantidade de carisma para seu personagem:"),
		 t.leDouble("Digite uma quantidade de força para seu personagem:"),
		 t.leString("Digite a classe do seu personagem:"));
		JogoRPG guerreiro = new JogoRPG("Sarva", 100, 1, 20, 20, "Guerreiro");

		for (;;) {
			System.out.println("1: Você pode escolher um dos atributos deste novo personagem e fornecer o novo valor deste atributo.");
			System.out.println("2: Você pode chamar o método exibeDados deste novo personagem.");
			System.out.println("3: Você pdoe encerrar o menu de opções.");

			int codigo = t.leInt("Digite o número da sua opção: ");

			if (codigo == 1) {
				for (;;) {
					System.out.println("1: Nome");
					System.out.println("2: Vida");
					System.out.println("3: Magia");
					System.out.println("4: Carisma");
					System.out.println("5: Força");
					System.out.println("6: Classe");
					int opcao = t.leInt("Digite o numero do atributo que você quer alterar: ");

					if (opcao == 1) {
						guerreiro.setNome(t.leString("Digite o novo nome do seu personagem:"));
						break;
					} else if (opcao == 2) {
						guerreiro.setVida(t.leDouble("Digite a nova quantidade de vida máxima do seu personagem: "));
						break;
					} else if (opcao == 3) {
						guerreiro.setMagia(t.leDouble("Digite a nova quantidade de magia do seu personagem: "));
						break;
					} else if (opcao == 4) {
						guerreiro.setCarisma(t.leDouble("Digite a nova quantidade de carisma do seu personagem: "));
						break;
					} else if (opcao == 5) {
						guerreiro.setForca(t.leDouble("Digite a nova quantidade de força do seu personagem: "));
						break;
					} else if (opcao == 6) {
						guerreiro.setClasse(t.leString("Digite a nova classe do seu personagem: "));
						break;
					} else {
						System.out.println("Opção inválida");
					} 
				}break;
			} else if (codigo == 2) {
				guerreiro.exibeDados();
				break;
			} else if (codigo == 3) {
				break;
			} else {
				System.out.println("Opção inválida");
			}
		}
	}
}
