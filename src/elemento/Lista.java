package elemento;

import java.util.HashMap;

public class Lista extends Elemento{
	public Lista(int prioridade, String valor, HashMap<String, String> propriedades) {
		super(prioridade, valor, propriedades);
	}
	
	@Override
	public String exibirCompleto() {
		String response = preparaCompleto(super.getValor());
		return response;
	}
	
	@Override
	public String exibirResumido() {
		String response = super.getValor();
		return response;
	}
	
	private String preparaCompleto(String str) {
		String parts[] = str.split(super.getPropriedades().get("separador"));
		
		String splited = "";
		
		for (String part : parts) {
			splited += super.getPropriedades().get("charLista") + " " + part + "\n";
		}
		
		return splited;
	}
}
