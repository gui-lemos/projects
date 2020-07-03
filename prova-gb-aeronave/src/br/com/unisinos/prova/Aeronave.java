package br.com.unisinos.prova;

public class Aeronave {

	private int chaveIdentificacao;
	private String nome;
	private String matricula;
	private int codigoFabricante;

	public Aeronave(String nome, String matricula, int codigoFabricante) {
		this.chaveIdentificacao = geraChaveId();
		this.nome = nome;
		this.matricula = matricula;
		this.codigoFabricante = codigoFabricante;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(final String matricula) {
		this.matricula = matricula;
	}

	public int getCodigoFabricante() {
		return codigoFabricante;
	}

	public void setCodigoFabricante(final int codigoFabricante) {
		this.codigoFabricante = codigoFabricante;
	}

	@Override
	public String toString() {
		return "Chave de identificação da aeronave: " + this.chaveIdentificacao + ", " + "Nome da aeronave: "
				+ this.nome + ", " + "Matrícula da aeronave: " + this.matricula + ", "
				+ "Código internacional do fabricante da aeronave: " + this.codigoFabricante;
	}
}
