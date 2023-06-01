package visao;

import java.util.ArrayList;

import documento.Documento;
import elemento.Elemento;
import elemento.Titulo;

public class VisaoTitulo implements Visao {
	Documento documento;
	
	public VisaoTitulo(Documento documento) {
		this.documento = documento;
	}
	
	@Override
	public String[] exibirVisao() {
		ArrayList<Elemento> elementos = documento.getElementos();
		ArrayList<String> response = new ArrayList<>();
		
		for (Elemento elemento : elementos) {
			if (elemento.getClass() == Titulo.class) {
				response.add(elemento.exibirResumido());
			}
		}
		
		return (String[]) response.toArray();
	}
}
