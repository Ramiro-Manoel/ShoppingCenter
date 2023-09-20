import java.util.Arrays;

public class Shopping {
	private String nome;
	private Endereco endereco;
	private Loja[] lojas;
	
	
	public Shopping(String nome, Endereco endereco, int tam) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.lojas = new Loja[tam];
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public Loja[] getLojas() {
		return lojas;
	}


	public void setLojas(Loja[] lojas) {
		this.lojas = lojas;
	}


	@Override
	public String toString() {
		return "Shopping [nome=" + nome + ", endereco=" + endereco + ", lojas=" + Arrays.toString(lojas) + "]";
	}
	
	public boolean insereLoja(Loja loja) {
		for(int i =0; i<lojas.length; i++) {
			if(lojas[i] == null) {
				lojas[i] = loja;
				return true;
			}
		}
		return false;
	}
	
	public boolean removeLoja(String loja) {
		for(int i =0; i<lojas.length; i++) {
			if(lojas[i].getNome().equalsIgnoreCase(loja)) {
				lojas[i] = null;
				return true;
			}
		}
		return false;
	}
	
	public int quantidadeLojasPorTipo(String loja) {
		int quant = 0;
		if(loja.equalsIgnoreCase("Vestuario")) {
			for(int i =0; i<lojas.length; i++) {
				if(lojas[i] instanceof Vestuario) {
					quant += 1;
				}
			}
		}
		
		else if(loja.equalsIgnoreCase("Alimentacao")) {
			for(int i =0; i<lojas.length; i++) {
				if(lojas[i] instanceof Alimentacao) {
					quant += 1;
				}
			}
		}
		
		else if(loja.equalsIgnoreCase("Informatica")) {
			for(int i =0; i<lojas.length; i++) {
				if(lojas[i] instanceof Informatica) {
					quant += 1;
				}
			}
		}
		
		else
			return -1;
		
		return quant;
	}
	
	public Loja lojaSeguroMaisCaro() {
		double maior = 0;
		for(int i =0; i<lojas.length; i++) {
			if(lojas[i] instanceof Informatica) {
				maior = ((Informatica)lojas[i]).getSeguroEletronicos();
				if(((Informatica)lojas[i]).getSeguroEletronicos() > maior) {
					maior = ((Informatica)lojas[i]).getSeguroEletronicos();
				}
			}
			
			if (((Informatica)lojas[i]).getSeguroEletronicos() == maior){
				return lojas[i];
			}	
		}
		
		return null;
	}
	
}