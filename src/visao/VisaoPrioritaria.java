package visao;

import java.util.ArrayList;

import documento.Documento;
import elemento.Elemento;

public class VisaoPrioritaria implements Visao {
	int prioridadeBase; 
	Documento documento;
	
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
		
		return (String[]) response.toArray();
	}
}
