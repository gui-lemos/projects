
public class Item {
	private String nome;
	private double preco;
	private Data dataFabricacao;
	private int codigo;
	
	public Item(String nome, double preco, Data dataFabricacao, int codigo) {
		this.nome = nome;
		this.preco = preco;
		this.dataFabricacao = dataFabricacao;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Data getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Data dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "		Preço: " + preco + "	Fabricação: " 
	+ dataFabricacao + " 	Código: " + codigo;
	}
	
}
