package elemento;

import java.util.HashMap;

public class Atalho extends Elemento{
	public Atalho(int prioridade, String valor, HashMap<String, String> propriedades) {
		super(prioridade, valor, propriedades);
	}
	
	//concatenação das representações completas dos elementos internos de prioridade 4 e 5
	@Override
	public String exibirCompleto() {
		String response = "";
		
		return null;
	}
	
	@Override
	public String exibirResumido() {
		// TODO Auto-generated method stub
		return null;
	}
}
