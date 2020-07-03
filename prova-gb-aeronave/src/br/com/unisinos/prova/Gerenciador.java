package br.com.unisinos.prova;

public class Gerenciador {

    private int totAeronaves;
    private int tamAeronaves;

    private int totFabricantes;
    private int tamFabricantes;

    Aeronave[] listaAeronaves;
    Fabricante[] listaFabricantes;

    public Gerenciador(int tamAeronaves, int tamFabricantes) {
        this.tamAeronaves = tamAeronaves;
        this.tamFabricantes = tamFabricantes;

        this.listaAeronaves = new Aeronave[tamAeronaves];
        this.listaFabricantes = new Fabricante[tamFabricantes];
    }

    public void listaFabricantes() {

        for (int i = 0; i < listaFabricantes.length; i++) {

            Fabricante fabricante = listaFabricantes[i];

            if (fabricante == null) {
                continue;
            }

            System.out.println("Nome do fabricante: " + fabricante.getNome());
        }
    }

    public Fabricante buscaFabricantePeloNome(String nomeFabricante) {

        for (int i = 0; i < listaFabricantes.length; i++) {

            Fabricante fabricante = listaFabricantes[i];

            if (fabricante == null) {
                continue;
            }

            if (fabricante.getNome().equalsIgnoreCase(nomeFabricante)) {
                return fabricante;
            }
        }

        return null;
    }

    public boolean insereAeronave(Aeronave aeronave) {

        if (this.totAeronaves == this.tamAeronaves) {
            System.out.println("N�o � poss�vel inserir a aeronave. O cadastro est� cheio.");
            return false;
        }

        int posicao = this.buscarPosicaoDaAeronavePelaMatricula(aeronave.getMatricula());
        if (posicao != -1) {
            System.out.println("N�o � poss�vel inserir a aeronave. J� existe uma aeronave com esta matr�cula.");
            return false;
        }

        for (int i = 0; i < listaAeronaves.length; i++) {
            if (listaAeronaves[i] == null) {
                listaAeronaves[i] = aeronave;
                totAeronaves++;
                return true;
            }
        }
        return false;
    }

    public boolean insereFabricante(Fabricante fabricante) {

        if (this.totFabricantes == this.tamFabricantes) {
            System.out.println("N�o � poss�vel inserir o fabricante. O cadastro est� cheio.");
            return false;
        }

        Fabricante fabricantePorNome = this.buscaFabricantePeloNome(fabricante.getNome());
        if (fabricantePorNome != null) {
            System.out.println("N�o � poss�vel inserir o fabricante. J� existe um fabricante com este nome.");
            return false;
        }

        Fabricante fabricantePorCodigo = this.buscaFabricantePeloCodigo(fabricante.getCodigo());
        if (fabricantePorCodigo != null) {
            System.out.println("N�o � poss�vel inserir o fabricante. J� existe um fabricante com este c�digo.");
            return false;
        }

        for (int i = 0; i < listaFabricantes.length; i++) {
            if (listaFabricantes[i] == null) {
                listaFabricantes[i] = fabricante;
                totFabricantes++;
                return true;
            }
        }
        return false;
    }

    public boolean removeAeronavePelaMatricula(String matricula) {

        int posicao = buscarPosicaoDaAeronavePelaMatricula(matricula);

        if (posicao < 0) {
            System.out.println("N�o � poss�vel remover a aeronave. Aeronave n�o existe.");
            return false;
        }

        listaAeronaves[posicao] = null;

        this.totAeronaves--;

        return true;
    }

    private int buscarPosicaoDaAeronavePelaMatricula(String matricula) {
        for (int i = 0; i < listaAeronaves.length; i++) {

            Aeronave aeronave = listaAeronaves[i];

            if (aeronave == null) {
                continue;
            }

            if (aeronave.getMatricula().equalsIgnoreCase(matricula)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAeronavePeloCodigoFabricante(int codigo) {

        Fabricante fabricante = buscaFabricantePeloCodigo(codigo);

        if (fabricante == null) {
            System.out.println("N�o � poss�vel remover a aeronave. Fabricante n�o existe.");
            return false;
        }

        boolean algumaAeronaveFoiRemovida = false;

        for (int i = 0; i < listaAeronaves.length; i++) {
            Aeronave aeronave = listaAeronaves[i];

            if (aeronave == null) {
                continue;
            }

            if (aeronave.getCodigoFabricante() == fabricante.getCodigo()) {
                listaAeronaves[i] = null;
                totAeronaves--;
                algumaAeronaveFoiRemovida = true;
            }
        }
        return algumaAeronaveFoiRemovida;
    }

    public Fabricante buscaFabricantePeloCodigo(int codigo) {
        for (int i = 0; i < listaFabricantes.length; i++) {
            Fabricante fabricante = listaFabricantes[i];

            if (fabricante == null) {
                continue;
            }
            if (fabricante.getCodigo() == codigo) {
                return fabricante;
            }
        }
        return null;
    }

    public boolean removeFabricantePorCodigo(int codigo) {

        Fabricante fabricanteEncontrado = buscaFabricantePeloCodigo(codigo);

        if (fabricanteEncontrado == null) {
            System.out.println("N�o � poss�vel remover o fabricante. Fabricante n�o existe.");
            return false;
        }

        removeAeronavePeloCodigoFabricante(codigo);

        for (int i = 0; i < listaFabricantes.length; i++) {

            Fabricante fabricanteAtual = listaFabricantes[i];

            if (fabricanteAtual == null) {
                continue;
            }

            if (fabricanteAtual.getCodigo() == codigo) {
                listaFabricantes[i] = null;
                totFabricantes--;
                return true;
            }
        }

        return false;
    }

    public void listaAeronaves() {

        for (int i = 0; i < listaAeronaves.length; i++) {

            Aeronave aeronaves = listaAeronaves[i];

            if (aeronaves == null) {
                continue;
            }

            Fabricante fabricante = this.buscaFabricantePeloCodigo(aeronaves.getCodigoFabricante());

            System.out.println(
                "Chave de identifica��o da aeronave: " + aeronaves.getChaveIdentificacao() + ", " +
                "Nome da aeronave: " + aeronaves.getNome() + ", " +
                "Matr�cula da aeronave: " + aeronaves.getMatricula() + ", " +
                "Nome do fabricante: " + fabricante.getNome() + ", " +
                "Pa�s do fabricante: " + fabricante.getPais());
        }
    }
}
