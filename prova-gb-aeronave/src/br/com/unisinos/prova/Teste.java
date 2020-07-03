package br.com.unisinos.prova;

public class Teste {

    public static void main(String[] args) {

        Teclado teclado = new Teclado();
        Gerenciador gerenciador = new Gerenciador(10, 5);

        for (; ; ) {

            montarMenuPrincipal();

            int opcao = teclado.leInt("Digite uma opção de 1 a 7");

            if (opcao == 1) {

                gerenciador.listaFabricantes();

                String nomeFabricante = teclado.leString("Digite o nome do fabricante desejado: ");
                Fabricante fabricante = gerenciador.buscaFabricantePeloNome(nomeFabricante);
                if (fabricante == null) {
                    System.out.println("Fabricante escolhido não existente. ");
                    continue;
                }

                String nome = teclado.leString("Digite o nome da aeronave: ");
                String matricula = teclado.leString("Digite a matrícula da aeronave: ");
                Aeronave aeronave = new Aeronave(nome, matricula, fabricante.getCodigo());

                gerenciador.insereAeronave(aeronave);

            } else if (opcao == 2) {

                String nome = teclado.leString("Nome do fabricante: ");
                String pais = teclado.leString("País do fabricante: ");
                int codigo = teclado.leInt("Código internacional do fabricante: ");
                Fabricante fabricante = new Fabricante(nome, pais, codigo);

                gerenciador.insereFabricante(fabricante);

            } else if (opcao == 3) {
                gerenciador.removeAeronavePelaMatricula(teclado.leString("Digite a matrícula da aeronave: "));

            } else if (opcao == 4) {
                gerenciador.removeAeronavePeloCodigoFabricante(teclado.leInt("Digite o código internacional do fabricante: "));

            } else if (opcao == 5) {
                gerenciador.removeFabricantePorCodigo(teclado.leInt("Digite o código internacional do fabricante: "));

            } else if (opcao == 6) {
                gerenciador.listaAeronaves();

            } else if (opcao == 7) {
                break;
            }
        }

    }

    private static void montarMenuPrincipal() {
        System.out.println("1. Inserir aeronave");
        System.out.println("2. Inserir fabricante");
        System.out.println("3. Remover aeronave pela matrícula");
        System.out.println("4. Remover aeronave pelo código internacional do fabricante");
        System.out.println("5. Remover fabricante");
        System.out.println("6. Listar aeronaves");
        System.out.println("7. Encerrar programa");
    }
}
