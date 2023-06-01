package documin;

import documento.DocumentoController;
import visao.VisaoController;

public class Facade {
    private DocumentoController documentoController;
    private VisaoController visaoController;

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
    
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
    	return this.documentoController.addAtalho(tituloDoc, tituloDocReferenciado);
    }
    
    public int criarVisaoCompleta(String tituloDoc) {
    	return this.visaoController.criarVisaoCompleta(tituloDoc, documentoController);
    }
    
    public int criarVisaoResumida(String tituloDoc) {
    	return this.visaoController.criarVisaoResumida(tituloDoc, documentoController);	
    }
    
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
    	return this.visaoController.criarVisaoPrioritaria(tituloDoc, prioridade, documentoController);
    }
    
    public int criarVisaoTitulo(String tituloDoc) {
    	return this.visaoController.criarVisaoTitulo(tituloDoc, documentoController);
    }
    
    public String[] exibirVisao(int visaoId) {
    	return this.visaoController.exibirVisao(visaoId);
    }
}