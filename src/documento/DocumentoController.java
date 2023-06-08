package documento;

/**
 * Classe que gerencia as requisições do sistema para as operações de documentos, 
 * tratando funcionalidades de armazenamento, de requisição de documentos e gerenciando
 * requisições aos métodos de documento.
 */

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
	
	public int addAtalho(String tituloDoc, String tituloDocReferenciado) {
		if (composedOfSpaces(tituloDoc) || tituloDoc == "") throw new IllegalArgumentException("Título vazio");
		if (composedOfSpaces(tituloDocReferenciado) || tituloDocReferenciado == "") throw new IllegalArgumentException("Título vazio");
		
		if (repositorio.get(tituloDoc).haveDoc()) throw new IllegalStateException("Documento possui atalho");
		
		Documento docReferenciado = acessaDocumento(tituloDocReferenciado);
		
		int prioridade = getMediaPrioridades(docReferenciado.getElementos());
		String valor = tituloDocReferenciado;
		HashMap<String, String> propriedades = new HashMap<String, String>();
		propriedades.put("representacaoCompleta", criaRepresentacaoCompletaAtalho(docReferenciado.getElementos()));
		propriedades.put("representacaoResumido", criaRepresentacaoResumidaAtalho(docReferenciado.getElementos()));
		
		return acessaDocumento(tituloDoc).addAtalho(prioridade, valor, propriedades);
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
	
	public Documento acessaDocumento(String titulo) {
		if (composedOfSpaces(titulo) || titulo == "") throw new IllegalArgumentException("Título vazio");
		
		return repositorio.get(titulo);
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
	
	public int getQtdeElementosDocumento(String idDocumento) {
		return acessaDocumento(idDocumento).getQtdeElementos();
	}
	
	public String[] getDocumento(String idDocumento) {
		return acessaDocumento(idDocumento).getDocumento();
	}
	
	public int addTextoDocumento(String idDocumento, String valor, int prioridade) {
		return acessaDocumento(idDocumento).addTexto(valor, prioridade);
	}
	
	public int addTituloDocumento(String idDocumento, String valor, int prioridade, int nivel, boolean linkavel) {
		return acessaDocumento(idDocumento).addTitulo(valor, prioridade, nivel, linkavel);
	}
	
	public int addListaDocumento(String idDocumento, String valorLista, int prioridade, String separador, String charLista) {
		return acessaDocumento(idDocumento).addLista(valorLista, prioridade, separador, charLista);
	}
	
	public int addTermosDocumento(String idDocumento, String valorTermos, int prioridade, String separador, String ordem) {
		return acessaDocumento(idDocumento).addTermos(valorTermos, prioridade, separador, ordem);
	}
	
	public String getRepresentacaoCompletaDocumento(String idDocumento, int posicao) {
		return acessaDocumento(idDocumento).getRepresentacaoCompleta(posicao);
	}
	
	public String getRepresentacaoResumidaDocumento(String idDocumento, int posicao) {
		return acessaDocumento(idDocumento).getRepresentacaoResumida(posicao);
	}
	
	public void elevaElementoDocumento(String idDocumento, int posicao) {
		acessaDocumento(idDocumento).elevaElemento(posicao);
	}
	
	public void cedeElementoDocumento(String idDocumento, int posicao) {
		acessaDocumento(idDocumento).cedeElemento(posicao);
	}
	
	public Elemento getElementoDocumento(String idDocumento, int posicao) {
		return acessaDocumento(idDocumento).getElemento(posicao);
	}
	
	public ArrayList<Elemento> getElementosDocumento(String idDocumento) {
		return acessaDocumento(idDocumento).getElementos();
	}
	
	public boolean removeElementoDocumento(String idDocumento, int posicao) {
		return acessaDocumento(idDocumento).removeElemento(posicao);
	}
}
