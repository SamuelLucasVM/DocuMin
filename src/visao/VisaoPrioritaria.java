package visao;

/**
 * Subclasse de visão que retorna a representação resumida dos elementos
 * do documento de prioridade maior ou igual a dela através do método 
 * "exibirVisao".
 * @author Samuel Lucas Vieira Matos
 */

import java.util.ArrayList;

import documento.Documento;
import elemento.Elemento;

public class VisaoPrioritaria implements Visao {
	private int prioridadeBase; 
	private Documento documento;
	
	public VisaoPrioritaria(int prioridadeBase, Documento documento) {
		this.documento = documento;
		this.prioridadeBase = prioridadeBase;
	}
	
	@Override
	public String[] exibirVisao() {
		ArrayList<Elemento> elementos = documento.getElementos();
		ArrayList<String> response = new ArrayList<>();
		
		for (Elemento elemento : elementos) {
			if (elemento.getPrioridade() >= prioridadeBase) {
				response.add(elemento.exibirResumido());
			}
		}

		String[] finalResponse = response.toArray(new String[0]);
		
		return finalResponse;
	}
}
