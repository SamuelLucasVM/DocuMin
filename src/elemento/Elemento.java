package elemento;

import java.util.HashMap;

public abstract class Elemento implements Exibicionista{
	protected int prioridade;
	protected String valor;
	protected HashMap<String, String> propriedades;
	
	public Elemento(int prioridade, String valor, HashMap<String, String> propriedades) {
		this.prioridade = prioridade;
		this.valor = valor;
		this.propriedades = propriedades;
	}
}
