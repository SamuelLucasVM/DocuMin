package visao;

import java.util.ArrayList;
import java.util.List;

import documento.DocumentoController;

public class VisaoController {
	private List<Visao> visoes;
	
	public VisaoController() {
		visoes = new ArrayList<>();
	}
	
    public int criarVisaoCompleta(String tituloDoc, DocumentoController documentoController) {
    	VisaoCompleta visaoCompleta = new VisaoCompleta(documentoController.acessaDocumento(tituloDoc));
    	visoes.add(visaoCompleta);
    	
    	return visoes.size();
    }
    
    public int criarVisaoResumida(String tituloDoc, DocumentoController documentoController) {
    	VisaoResumida visaoResumida = new VisaoResumida(documentoController.acessaDocumento(tituloDoc));
    	visoes.add(visaoResumida);
    	
    	return visoes.size();    	
    }
    
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade, DocumentoController documentoController) {
    	VisaoPrioritaria visaoPrioritaria = new VisaoPrioritaria(prioridade, documentoController.acessaDocumento(tituloDoc));
    	visoes.add(visaoPrioritaria);
    	
    	return visoes.size(); 
    }
    
    public int criarVisaoTitulo(String tituloDoc, DocumentoController documentoController) {
    	VisaoTitulo visaoTitulo = new VisaoTitulo(documentoController.acessaDocumento(tituloDoc));
    	visoes.add(visaoTitulo);
    	
    	return visoes.size(); 
    }
    
    public String[] exibirVisao(int visaoId) {
    	if (visaoId <= 0 || visaoId > visoes.size()) throw new IndexOutOfBoundsException("Id inválido");
    	
    	return visoes.get(visaoId-1).exibirVisao();
    }
}
