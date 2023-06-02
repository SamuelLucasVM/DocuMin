package visao;

import java.util.ArrayList;

import documento.Documento;
import elemento.Elemento;

public class VisaoResumida implements Visao {
	private Documento documento;
	
	public VisaoResumida(Documento documento) {
		this.documento = documento;
	}
	
	@Override
	public String[] exibirVisao() {
		ArrayList<Elemento> elementos = documento.getElementos();
		String[] response = new String[elementos.size()];
		
		for (int i = 0; i < response.length; i++) {
			response[i] += elementos.get(i).exibirResumido();
		}
		
		return response;
	}
}
