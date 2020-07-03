
public class ItemLocalExtra extends ItemLocal {
	private double peso;

	public ItemLocalExtra(String nome, double preco, Data dataFabricacao, int codigo, String cor, String textura,
			double peso) {
		super(nome, preco, dataFabricacao, codigo, cor, textura);
		this.peso = peso;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + " 	Peso: " + peso;
	}
}
