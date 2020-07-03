
public class ItemEspecial extends Item {
	private double valorAdicional;

	public ItemEspecial(String nome, double preco, Data dataFabricacao, int codigo, double valorAdicional) {
		super(nome, preco, dataFabricacao, codigo);
		this.valorAdicional = valorAdicional;
	}

	public double getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(double valorAdicional) {
		this.valorAdicional = valorAdicional;
	}
		
	
	@Override
	public String toString() {
		return super.toString() + " 	Valor adicional: " + valorAdicional + "		Preço final: " + super.getPreco();
	}
	
	public void acrescentaPreco() {
		super.setPreco((getPreco() + valorAdicional));
	}
}