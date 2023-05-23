package documin;

import documento.DocumentoController;
import elemento.ElementoController;

public class Facade {
    private DocumentoController documentoController;
    private ElementoController elementoController;

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
    
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
    	
    }
    
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
    	
    }
    
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
    	
    }
    
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
    	
    }
    
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
    	
    }
    
    public String pegarrepresentacaoResumida(String tituloDoc, int elementoPosicao) {
    	
    }
    
    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
    	
    }
    
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
    	
    }
    
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
    	
    }

}
