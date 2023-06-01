package visao;

import java.util.ArrayList;

import documento.Documento;
import elemento.Elemento;

public class VisaoCompleta implements Visao {
	Documento documento;
	
	public VisaoCompleta(Documento documento) {
		this.documento = documento;
	}
	
	@Override
	public String[] exibirVisao() {
		ArrayList<Elemento> elementos = documento.getElementos();
		String[] response = new String[elementos.size()];
		
		for (int i = 0; i < response.length; i++) {
			response[i] += elementos.get(i).exibirCompleto();
		}
		
		return response;
	}
}
