package documento;

import java.util.ArrayList;

public class DocumentoController {
	private DocumentoRepository repositorio;
	
	public DocumentoController() {
		this.repositorio = new DocumentoRepository();
	}
	
	public boolean addDocumento(String titulo) {
		if (composedOfSpaces(titulo) || titulo == "") throw new IllegalArgumentException("Título vazio");

		return(repositorio.add(titulo));
	}
	
	public boolean addDocumento(String titulo, int tamanhoMaximo) {
		if (composedOfSpaces(titulo) || titulo == "") throw new IllegalArgumentException("Título vazio");

		return(repositorio.add(titulo, tamanhoMaximo));
	}
	
	public void removerDocumento(String titulo) {
		if (composedOfSpaces(titulo) || titulo == "") throw new IllegalArgumentException("Título vazio");
		
		repositorio.remove(titulo);
	}
	
	public int getQtdeElementos(String titulo) {
		if (composedOfSpaces(titulo) || titulo == "") throw new IllegalArgumentException("Título vazio");
		
		return repositorio.get(titulo).getQtdeElementos();
	}
	
	public String[] getDocumento(String titulo) {
		if (composedOfSpaces(titulo) || titulo == "") throw new IllegalArgumentException("Título vazio");
		
		return repositorio.get(titulo).getDocumento();
	}
	
	private boolean composedOfSpaces(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!(str.charAt(i) == ' ')) {
				return true;
			}
		}
		return false;
	}
}
