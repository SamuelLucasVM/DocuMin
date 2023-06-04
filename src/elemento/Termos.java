package elemento;

import java.util.Arrays;
import java.util.HashMap;

public class Termos extends Elemento{
	public Termos(int prioridade, String valor, HashMap<String, String> propriedades) {
		super(prioridade, valor, propriedades);
	}
	
	@Override
	public String exibirCompleto() {
		int qtdeTermos = getQtdeTermos(super.getValor(), super.getPropriedades().get("separador"));
		String[] termos = splitedTermos(super.getValor(), super.getPropriedades().get("separador"), super.getPropriedades().get("ordem"));
		
		String response = "Total de Termos: " + qtdeTermos + "\n" + "- ";
		
		for (int i = 0; i < termos.length; i++) {
			response += termos[i];
			if (i != termos.length - 1) {
				response += ", ";
			}
		}
		
		return response;
	}
	
	@Override
	public String exibirResumido() {
		String[] termos = splitedTermos(super.getValor(), super.getPropriedades().get("separador"), super.getPropriedades().get("ordem"));
		String response = "";

		for (int i = 0; i < termos.length; i++) {
			response += termos[i];
			if (i != termos.length - 1) {
				response += " " + super.getPropriedades().get("separador") + " ";
			}
		}
		
		return response;
	}
	
	private int getQtdeTermos(String str, String separador) {
		int qtdeTermos = str.split(separador).length;
		
		return qtdeTermos;
	}
	
	private String[] splitedTermos(String str, String separador, String ordem) {
		String[] termos = str.split(separador);
		
		switch (ordem) {
		case "ALFABETICA": {
			Arrays.sort(termos);
		}
		case "TAMANHO": {
			Arrays.sort(termos, (a, b) -> Integer.compare(b.length(), a.length()));
		}
		}
	
		return termos;
	}
}