package elemento;

import java.util.HashMap;

public class Titulo extends Elemento{
	public Titulo(int prioridade, String valor, HashMap<String, String> propriedades){
		super(prioridade, valor, propriedades);
	}
	
	@Override
	public String exibirCompleto() {
		String response;
		if (super.getPropriedades().get("linkavel").equals("true")) {
			String link = linkaValor(super.getValor());
			
			response = super.getPropriedades().get("nivel") + ". " + super.getValor() + " -- " + link;
		}
		else {
			response = super.getPropriedades().get("nivel") + ". " + super.getValor();
		}
		
		return response;
	}
	
	@Override
	public String exibirResumido() {
		String response = super.getPropriedades().get("nivel") + ". " + super.getValor();
		return response;
	}
	
	private String linkaValor(String str) {
		String response = "";
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				response += str.charAt(i);
			}
		}
		
		response = response.toUpperCase();
		
		return response;
	}
}
