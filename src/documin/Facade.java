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
    	return this.documentoController.exibirDocumento(titulo);
    }
    
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
    	return this.documentoController.getDocumento(tituloDoc).addTexto(valor, prioridade);
    }
    
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
    	return this.documentoController.getDocumento(tituloDoc).addTitulo(valor, prioridade, nivel, linkavel);
    }
    
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
    	return this.documentoController.getDocumento(tituloDoc).addLista(valorLista, prioridade, separador, charLista);
    }
    
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
    	return this.documentoController.getDocumento(tituloDoc).addTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
    }
    
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
    	return this.documentoController.getDocumento(tituloDoc).getRepresentacaoCompleta(elementoPosicao);
    }
    
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
    	return this.documentoController.getDocumento(tituloDoc).getRepresentacaoResumida(elementoPosicao);
    }
    
    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
    	return this.documentoController.getDocumento(tituloDoc).removeElemento(elementoPosicao);
    }
    
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
    	this.documentoController.getDocumento(tituloDoc).elevaElemento(elementoPosicao);
    }
    
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
    	this.documentoController.getDocumento(tituloDoc).cedeElemento(elementoPosicao);
    }

}
