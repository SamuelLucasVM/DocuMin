package documin;

import documento.DocumentoController;

public class Facade {
    private DocumentoController documentoController;

    public Facade() {
        this.documentoController = new DocumentoController();
    }

    public boolean criarDocumento(String titulo) {
    	return this.documentoController.criarDocumento(titulo);
    }
    
    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
    	
    }
    
    public void removerDocumento(String titulo) {
    	
    }
    
    public int contarElementos(String titulo) {
    	
    }
    
    public String[] exibirDocumento(String titulo) {
    	
    }

}
