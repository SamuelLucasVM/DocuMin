package elemento;

import java.util.HashMap;

public abstract class Elemento implements Exibicionista{
	private int prioridade;
	private String valor;
	private HashMap<String, String> propriedades;
	
	public Elemento(int prioridade, String valor, HashMap<String, String> propriedades) {
		this.prioridade = prioridade;
		this.valor = valor;
		this.propriedades = propriedades;
	}
	
	public String getValor() {
		return valor;
	}
	
	public HashMap<String, String> getPropriedades() {
		return propriedades;
	}
}
