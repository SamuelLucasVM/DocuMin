package documento;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class DocumentoRepository {
	private HashMap<String, Documento> documentos;
	
	public DocumentoRepository() {
		this.documentos = new HashMap<String, Documento>();
	}
	
	public boolean add(String titulo) {
		if (documentos.containsKey(titulo)) return false;
		
		Documento doc = new Documento(titulo);
		documentos.put(titulo, doc);
		return true;
	}
	
	public boolean add(String titulo, int tamanhoMaximo) {
		if (documentos.containsKey(titulo)) return false;
		
		Documento doc = new Documento(titulo);
		documentos.put(titulo, doc);
		return true;
	}
	
	public Documento get(String titulo) {
		if (!documentos.containsKey(titulo)) throw new NoSuchElementException("Elemento não encontrado");
		
		return documentos.get(titulo);
	}
	
	public void remove(String titulo) {
		if (!documentos.containsKey(titulo)) throw new NoSuchElementException("Elemento não encontrado");
		
		documentos.remove(titulo);
	}
}
