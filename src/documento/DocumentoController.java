package documento;

import java.util.ArrayList;
import java.util.HashMap;

import elemento.Elemento;

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
	
	public String[] exibirDocumento(String titulo) {
		if (composedOfSpaces(titulo) || titulo == "") throw new IllegalArgumentException("Título vazio");
		
		return repositorio.get(titulo).getDocumento();
	}
	
	public Documento getDocumento(String titulo) {
		return repositorio.get(titulo);
	}
	
	public int addAtalho(String tituloDoc, String tituloDocReferenciado) {
		Documento docReferenciado = getDocumento(tituloDocReferenciado);
		
		int prioridade = getMediaPrioridades(docReferenciado.getElementos());
		String valor = tituloDocReferenciado;
		HashMap<String, String> propriedades = new HashMap<String, String>();
		propriedades["representacaoCompleta"] = criaRepresentacaoCompletaAtalho(docReferenciado.getElementos());
		
		return getDocumento(tituloDoc).addAtalho(prioridade, valor, propriedades);
	}
	
	private boolean composedOfSpaces(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!(str.charAt(i) == ' ')) {
				return true;
			}
		}
		return false;
	}
	
	private int getMediaPrioridades(ArrayList<Elemento> elementos) {
		int media = 0;
		
		for (Elemento elemento : elementos) {
			media += elemento.getPrioridade();
		}
		
		media /= elementos.size();
		
		return media;
	}
	
	private String criaRepresentacaoCompletaAtalho(ArrayList<Elemento> elementos) {
		String response = "";
		
		for (Elemento elemento : elementos) {
			if (elemento.getPrioridade() == 4 || elemento.getPrioridade() == 5) {
				response += elemento.exibirCompleto() += " ";
			}
		}
		
		return response;
	}
}
