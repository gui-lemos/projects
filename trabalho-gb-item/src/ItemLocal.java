
public class ItemLocal extends Item {
	private String cor;
	private String textura;
	
	public ItemLocal(String nome, double preco, Data dataFabricacao, int codigo, String cor, String textura) {
		super(nome,preco, dataFabricacao, codigo);
		this.cor = cor;
		this.textura = textura;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTextura() {
		return textura;
	}

	public void setTextura(String textura) {
		this.textura = textura;
	}

	@Override
	public String toString() {
		return super.toString() + " 	Cor: " + cor + " 	Textura: " + textura;
	}


}
