package documento;

import java.util.ArrayList;
import java.util.HashMap;

import elemento.Atalho;
import elemento.Elemento;
import elemento.Lista;
import elemento.Termos;
import elemento.Texto;
import elemento.Titulo;

public class Documento {
	private String titulo;
	ArrayList<Elemento> elementos;
	private int tamanho;
	private int qtdeElementos;
	boolean haveDoc;
	
	public Documento(String titulo, int tamanho) {
		if (tamanho <= 0) throw new IllegalArgumentException("Tamanho inválido");
		
		this.titulo = titulo;
		this.elementos = new ArrayList<Elemento>();
		this.tamanho = tamanho;
		this.qtdeElementos = 0;
		this.haveDoc = false;
	}
	
	public Documento(String titulo) {
		this(titulo, -1);
	}
	
	public int getQtdeElementos() {
		return this.qtdeElementos;
	}
	
	public String[] getDocumento() {
		String[] stringsElementos = new String[elementos.size()];
		
		for (int i = 0; i < elementos.size(); i++) {
			stringsElementos[i] = elementos.get(i).toString();
		}
		
		return stringsElementos;
	}
	
	public int addTexto(String valor, int prioridade) {
		if (elementos.size() == tamanho) throw new IndexOutOfBoundsException("Tamanho limite atingido");
		
		Texto texto = new Texto(prioridade, valor);
		elementos.add(texto);
		
		return elementos.size();
	}
	
	public int addTitulo(String valor, int prioridade, int nivel, boolean linkavel) {
		if (elementos.size() == tamanho) throw new IndexOutOfBoundsException("Tamanho limite atingido");
		
		HashMap<String, String> propriedades = new HashMap<String, String>();
		propriedades.put("nivel", Integer.toString(nivel));
		propriedades.put("linkavel", Boolean.toString(linkavel));
		
		Titulo titulo = new Titulo(prioridade, valor, propriedades);
		elementos.add(titulo);
		
		return elementos.size();
	}
	
	public int addLista(String valorLista, int prioridade, String separador, String charLista) {
		if (elementos.size() == tamanho) throw new IndexOutOfBoundsException("Tamanho limite atingido");
		
		HashMap<String, String> propriedades = new HashMap<String, String>();
		propriedades.put("separador", separador);
		propriedades.put("charLista", charLista);
		
		Lista lista = new Lista(prioridade, valorLista, propriedades);
		elementos.add(lista);
		
		return elementos.size();
	}
	
	public int addTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
		if (elementos.size() == tamanho) throw new IndexOutOfBoundsException("Tamanho limite atingido");
		
		HashMap<String, String> propriedades = new HashMap<String, String>();
		propriedades.put("separador", separador);
		propriedades.put("ordem", ordem);
		
		Termos termo = new Termos(prioridade, valorTermos, propriedades);
		elementos.add(termo);
		
		return elementos.size();
	}
	
	public String getRepresentacaoCompleta(int posicao) {
		return elementos.get(posicao).exibirCompleto();
	}
	
	public String getRepresentacaoResumida(int posicao) {
		return elementos.get(posicao).exibirResumido();
	}
	
	public void elevaElemento(int posicao) {
		if (posicao > 0) {
			Elemento aux = elementos.get(posicao - 1);
			elementos.set(posicao - 1, elementos.get(posicao));
			elementos.set(posicao, aux);
		}
	}
	
	public void cedeElemento(int posicao) {
		if (posicao == elementos.size() - 1) {
			Elemento aux = elementos.get(posicao + 1);
			elementos.set(posicao + 1, elementos.get(posicao));
			elementos.set(posicao, aux);
		}
	}
	
	public Elemento getElemento(int posicao) {
		return elementos.get(posicao);
	}
	
	public ArrayList<Elemento> getElementos() {
		return elementos;
	}
	
	public boolean removeElemento(int posicao) {
		if (posicao < 0 || posicao >= elementos.size()) return false;
		
		elementos.remove(posicao);
		return true;
	}
	
	public int addAtalho(int prioridade, String valor, HashMap<String, String> propriedades) {
		if (elementos.size() == tamanho) throw new IndexOutOfBoundsException("Tamanho limite atingido");
		
		haveDoc = true;
		
		Atalho atalho = new Atalho(prioridade, valor, propriedades);
		
		elementos.add(atalho);
		
		return elementos.size();
	}
	
	public boolean haveDoc() {
		return haveDoc;
	}
}