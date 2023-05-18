package documin;

import documento.DocumentoController;

public class Facade {
    private DocumentoController documentoController;

    public Facade() {
        this.documentoController = new DocumentoController();
    }

    public boolean criarDocumento(String titulo) {
    	return this.documentoController.addDocumento(titulo);
    }
    
    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
    	return this.documentoController.addDocumento(titulo, tamanhoMaximo);
    }
    
    public void removerDocumento(String titulo) {
    	this.documentoController.removerDocumento(titulo);
    }
    
    public int contarElementos(String titulo) {
    	return this.documentoController.getQtdeElementos(titulo);
    }
    
    public String[] exibirDocumento(String titulo) {
    	return this.documentoController.getDocumento(titulo);
    }

}
