package br.com.unisinos.prova;

public class Fabricante {

    private int chaveIdentificacao;
    private String nome;
    private String pais;
    private int codigo;

    public Fabricante(String nome, String pais, int codigo) {
        this.chaveIdentificacao = this.geraChaveId();
        this.nome = nome;
        this.pais = pais;
        this.codigo = codigo;
    }

    private int geraChaveId() {
        return GeradorChave.gerar();
    }

    public int getChaveIdentificacao() {
        return chaveIdentificacao;
    }

    public void setChaveIdentificacao(final int chaveIdentificacao) {
        this.chaveIdentificacao = chaveIdentificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(final String pais) {
        this.pais = pais;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(final int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Chave de identificação do fabricante: " + this.chaveIdentificacao + ", " +
            "Nome do fabricante: " + this.nome + ", " +
            "País do fabricante: " + this.pais + ", " +
            "Código internacional do fabricante: " + this.codigo;
    }
}
