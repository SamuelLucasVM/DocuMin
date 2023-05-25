package elemento;

import java.util.Arrays;
import java.util.HashMap;

public class Termos extends Elemento{
	public Termos(int prioridade, String valor, HashMap<String, String> propriedades) {
		super(prioridade, valor, propriedades);
	}
	
	@Override
	public String exibirCompleto() {
		int qtdeTermos = getQtdeTermos(valor, propriedades.get("separador"));
		String[] termos = splitedTermos(valor, propriedades.get("separador"), propriedades.get("ordem"));
		
		String response = "Total de Termos: " + qtdeTermos + "\n" + "- ";
		
		for (String termo : termos) {
			response += termo + ", ";
		}
		
		return response;
	}
	
	@Override
	public String exibirResumido() {
		String[] termos = splitedTermos(valor, propriedades.get("separador"), propriedades.get("ordem"));
		String response = "";

		for (String termo : termos) {
			response += termo + " " + propriedades.get("separador") + " ";
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
			Arrays.sort(termos, (a, b) -> Integer.compare(a.length(), b.length()));
		}
		}
	
		return termos;
	}
}