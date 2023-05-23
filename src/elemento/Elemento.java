package elemento;

import java.util.HashMap;

public class Elemento {
	private int prioridade;
	private String valor;
	private HashMap<String, String> propriedades;
	
	public Elemento(int prioridade, String valor, HashMap<String, String> propriedades) {
		this.prioridade = prioridade;
		this.valor = valor;
		this.propriedades = propriedades;
	}
	
	public String exibirCompleto() {
		
		return ;
	}
	
	public String exibirResumido() {
		
	}
}
