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
		
		for (int i = 0; i < parts.length; i++) {
			splited += super.getPropriedades().get("charLista") + " " + parts[i];
			if (i != parts.length - 1) {
				 splited += "\n";
			}
		}
		
		return splited;
	}
}
