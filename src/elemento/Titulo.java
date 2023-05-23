package elemento;

import java.util.HashMap;

public class Titulo extends Elemento{
	public Titulo(int prioridade, String valor, HashMap<String, String> propriedades){
		super(prioridade, valor, propriedades);
	}
	
	@Override
	public String exibirCompleto() {
		String response = propriedades.get("nivel") + ". " + valor + " -- " + propriedades.get("linkavel");
		return response;
	}
	
	@Override
	public String exibirResumido() {
		String response = propriedades.get("nivel") + ". " + valor;
		return response;
	}
}
