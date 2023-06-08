package visao;

/**
 * Subclasse de visão que retorna a representação resumida dos elementos
 * do documento do tipo "Titulo" através do método "exibirVisao".
 * @author Samuel Lucas Vieira Matos
 */

import java.util.ArrayList;

import documento.Documento;
import elemento.Elemento;
import elemento.Titulo;

public class VisaoTitulo implements Visao {
	private Documento documento;
	
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
		
		String[] finalResponse = response.toArray(new String[0]);
		
		return finalResponse;
	}
}
