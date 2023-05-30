package elemento;

import java.util.HashMap;

public class Atalho extends Elemento{
	public Atalho(int prioridade, String valor, HashMap<String, String> propriedades) {
		super(prioridade, valor, propriedades);
	}

	@Override
	public String exibirCompleto() {
		return getPropriedades().get("representacaoCompleta");
	}
	
	@Override
	public String exibirResumido() {
		return getPropriedades().get("representacaoResumido");
	}
}
