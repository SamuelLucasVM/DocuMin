package visao;

import java.util.ArrayList;
import java.util.List;

import documento.DocumentoController;
import documento.DocumentoRepository;

public class VisaoController {
	DocumentoRepository repositorioDocumentos;
	List<Visao> visoes;
	
	public VisaoController() {
		visoes = new ArrayList<>();
	}
	
    public int criarVisaoCompleta(String tituloDoc, DocumentoController documentoController) {
    	VisaoCompleta visaoCompleta = new VisaoCompleta(documentoController.getDocumento(tituloDoc));
    	visoes.add(visaoCompleta);
    	
    	return visoes.size();
    }
    
    public int criarVisaoResumida(String tituloDoc, DocumentoController documentoController) {
    	VisaoResumida visaoResumida = new VisaoResumida(documentoController.getDocumento(tituloDoc));
    	visoes.add(visaoResumida);
    	
    	return visoes.size();    	
    }
    
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade, DocumentoController documentoController) {
    	VisaoPrioritaria visaoPrioritaria = new VisaoPrioritaria(prioridade, documentoController.getDocumento(tituloDoc));
    	visoes.add(visaoPrioritaria);
    	
    	return visoes.size(); 
    }
    
    public int criarVisaoTitulo(String tituloDoc, DocumentoController documentoController) {
    	VisaoTitulo visaoTitulo = new VisaoTitulo(documentoController.getDocumento(tituloDoc));
    	visoes.add(visaoTitulo);
    	
    	return visoes.size(); 
    }
    
    public String[] exibirVisao(int visaoId) {
    	return visoes.get(visaoId).exibirVisao();
    }
}
