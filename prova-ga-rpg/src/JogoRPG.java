
public class JogoRPG {
	private String nome;
	private double vida;
	private double magia;
	private double carisma;
	private double forca;
	private String classe;


	public JogoRPG() {

	}

	public JogoRPG(String nome, double vida, double magia, double carisma, double forca, String classe) {
		this.nome = nome;
		this.vida = vida;
		this.magia = magia;
		this.carisma = carisma;
		this.forca = forca;
		this.classe = classe;
	}

	public double getForca() {
		return forca;
	}

	public void setForca(double forca) {
		this.forca = forca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getVida() {
		return vida;
	}

	public void setVida(double vida) {
		this.vida = vida;
	}

	public double getMagia() {
		return magia;
	}

	public void setMagia(double magia) {
		this.magia = magia;
	}

	public double getCarisma() {
		return carisma;
	}

	public void setCarisma(double carisma) {
		this.carisma = carisma;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public void exibeDados() {
		System.out.println("O nome do seu personagem �: " + nome);
		System.out.println("A quantidade de vida do seu personagem �: " + vida);
		System.out.println("A quantidade de magia do seu personagem �: " + magia);
		System.out.println("A quantidade de carisma do seu personagme �: " + carisma);
		System.out.println("A quantidade de for�a do seu personagem �: " + forca);
		System.out.println("A classe do seu personagem �: " + classe);
	}
	
	
}
