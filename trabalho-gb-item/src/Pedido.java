
public class Pedido {

	private String nomeCliente;
	private double valorTotalDoPedido;
	private String nomesItensMaisCaros = "Lista itens mais caros: \n";
	private String listaItens = "Lista itens: \n";
	private Item item ;
	
	public Pedido(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	@Override
	public String toString() {
		return "O nome do cliente é: " + nomeCliente + " o valor total do pedido é: " + valorTotalDoPedido
				+ " os nomes dos itens mais caros são: " + nomesItensMaisCaros + " e a lista de itens é: " + listaItens;
	}

	public void mostraValorTotal() {
		System.out.println("O valor total do pedido é: " + valorTotalDoPedido);
	}

	public void mostraListaItens() {
		System.out.println(listaItens);
		System.out.println();
		System.out.println(nomesItensMaisCaros);
	}

	public void incluiItemNoPedido(Item item) {
		this.listaItens = listaItens + item.toString() + "\n";
		this.valorTotalDoPedido = valorTotalDoPedido + item.getPreco();
		itensMaisCaros(item);
	}

	private void itensMaisCaros(Item item) {
					
		if(this.item == null) {
			this.item = item;
			this.nomesItensMaisCaros += "Nome : " + item.getNome() + "\n";
			return;
	}
		
		if(this.item.getPreco() == item.getPreco()) {
			this.item = item;
			this.nomesItensMaisCaros += "Nome : " + item.getNome() + "\n";
			return;
		}
		
		if(this.item.getPreco() < item.getPreco()) {
			this.item = item;
			this.nomesItensMaisCaros = "Nome : " + item.getNome() + "\n";
		
		}
		
	
		
		
	}
		
		
}
