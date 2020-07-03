public class ItemAux extends Item {

	private Data dataValidadeLote;
	private double descontoPercentual;

	public ItemAux(String nome, double preco, Data dataFabricacao, int codigo, Data dataValidadeLote,
			double descontoPercentual) {
		super(nome, preco, dataFabricacao, codigo);
		this.dataValidadeLote = dataValidadeLote;
		this.descontoPercentual = descontoPercentual;
	}

	public Data getDataValidadeLote() {
		return dataValidadeLote;
	}

	public void setDataValidadeLote(Data dataValidadeLote) {
		this.dataValidadeLote = dataValidadeLote;
	}

	public double getDescontoPercentual() {
		return descontoPercentual;
	}

	public void setDescontoPercentual(double descontoPercentual) {
		this.descontoPercentual = descontoPercentual;
	}

	@Override
	public String toString() {
		return super.toString() + " 	Validade : " + dataValidadeLote + " 	Desconto: " + descontoPercentual
				+ "		Preço final: " + super.getPreco();
	}

	public void decrescentaPreco() {
		if (getDataValidadeLote().getAno() < super.getDataFabricacao().getAno()) {
			super.setPreco((getPreco() * (descontoPercentual / 100)));
			return;
		}if(getDataValidadeLote().getAno() <= super.getDataFabricacao().getAno()
				&& getDataValidadeLote().getMes() < super.getDataFabricacao().getMes()) {
			super.setPreco((getPreco() * (descontoPercentual / 100)));
			return;
		}if(getDataValidadeLote().getAno() <= super.getDataFabricacao().getAno()
				&& getDataValidadeLote().getMes() <= super.getDataFabricacao().getMes()
				&& getDataValidadeLote().getDia() < super.getDataFabricacao().getDia()) {
			super.setPreco((getPreco() * (descontoPercentual / 100)));
			return;
		}
	}	
}
