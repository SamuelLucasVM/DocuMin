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
		if (tamanhoMaximo <= 0) throw new IllegalArgumentException("Tamanho inválido");
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
		if (composedOfSpaces(titulo) || titulo == "") throw new IllegalArgumentException("Título vazio");
		
		return repositorio.get(titulo);
	}
	
	public int addAtalho(String tituloDoc, String tituloDocReferenciado) {
		if (composedOfSpaces(tituloDoc) || tituloDoc == "") throw new IllegalArgumentException("Título vazio");
		if (composedOfSpaces(tituloDocReferenciado) || tituloDocReferenciado == "") throw new IllegalArgumentException("Título vazio");
		
		if (repositorio.get(tituloDoc).haveDoc()) throw new IllegalStateException("Documento possui atalho");
		
		Documento docReferenciado = getDocumento(tituloDocReferenciado);
		
		int prioridade = getMediaPrioridades(docReferenciado.getElementos());
		String valor = tituloDocReferenciado;
		HashMap<String, String> propriedades = new HashMap<String, String>();
		propriedades.put("representacaoCompleta", criaRepresentacaoCompletaAtalho(docReferenciado.getElementos()));
		propriedades.put("representacaoResumido", criaRepresentacaoResumidaAtalho(docReferenciado.getElementos()));
		
		return getDocumento(tituloDoc).addAtalho(prioridade, valor, propriedades);
	}
	
	private boolean composedOfSpaces(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				return false;
			}
		}
		return true;
	}
	
	private int getMediaPrioridades(ArrayList<Elemento> elementos) {
		int media = 0;
		
		for (Elemento elemento : elementos) {
			media += elemento.getPrioridade();
		}
		
		media = media != 0 ? media / elementos.size() : 0;
		
		return media;
	}
	
	private String criaRepresentacaoCompletaAtalho(ArrayList<Elemento> elementos) {
		String response = "";
		
		for (Elemento elemento : elementos) {
			if (elemento.getPrioridade() == 4 || elemento.getPrioridade() == 5) {
				response += elemento.exibirCompleto() + "\n";
			}
		}
		
		return response;
	}
	
	private String criaRepresentacaoResumidaAtalho(ArrayList<Elemento> elementos) {
		String response = "";
		
		for (Elemento elemento : elementos) {
			if (elemento.getPrioridade() == 4 || elemento.getPrioridade() == 5) {
				response += elemento.exibirResumido() + "\n";
			}
		}
		
		return response;
	}
}
