package elemento;

import java.util.HashMap;

public class Lista extends Elemento{
	public Lista(int prioridade, String valor, HashMap<String, String> propriedades) {
		super(prioridade, valor, propriedades);
	}
	
	@Override
	public String exibirCompleto() {
		String response = preparaCompleto(valor);
		return response;
	}
	
	@Override
	public String exibirResumido() {
		String response = valor;
		return response;
	}
	
	private String preparaCompleto(String str) {
		String parts[] = str.split(propriedades.get("separador"));
		
		String splited = "";
		
		for (String part : parts) {
			splited += propriedades.get("charLista") + " " + part + "\n";
		}
		
		return splited;
	}
}
