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
	private ArrayList<Elemento> elementos;
	private int tamanho;
	private boolean haveDoc;
	
	public Documento(String titulo, int tamanho) {
		this.titulo = titulo;
		this.elementos = new ArrayList<Elemento>();
		this.tamanho = tamanho;
		this.haveDoc = false;
	}
	
	public Documento(String titulo) {
		this(titulo, -1);
	}
	
	public int getQtdeElementos() {
		return this.elementos.size();
	}
	
	public String[] getDocumento() {
		String[] stringsElementos = new String[elementos.size()];
		
		for (int i = 0; i < elementos.size(); i++) {
			stringsElementos[i] = elementos.get(i).exibirResumido();
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
		if (nivel <= 0 || nivel > 5) throw new IllegalArgumentException("Nível inválido");
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
	
	public int addTermos(String valorTermos, int prioridade, String separador, String ordem) {
		if (ordem != "NENHUM" && ordem != "ALFABETICA" && ordem != "TAMANHO") throw new IllegalArgumentException("Ordem não existe");
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
		if (posicao <= 0 || posicao > elementos.size()) throw new IndexOutOfBoundsException("Posição inválida");
		
		if (posicao != 1) {
			Elemento aux = elementos.get(posicao - 1);
			elementos.set(posicao - 1, elementos.get(posicao - 2));
			elementos.set(posicao - 2, aux);			
		}
	}
	
	public void cedeElemento(int posicao) {
		if (posicao <= 0 || posicao > elementos.size()) throw new IndexOutOfBoundsException("Posição inválida");
		
		if (posicao != elementos.size()) {
			Elemento aux = elementos.get(posicao);
			elementos.set(posicao, elementos.get(posicao - 1));
			elementos.set(posicao - 1, aux);			
		}
	}
	
	public Elemento getElemento(int posicao) {
		if (posicao <= 0 || posicao > elementos.size()) throw new IndexOutOfBoundsException("Posição inválida");
		
		return elementos.get(posicao - 1);
	}
	
	public ArrayList<Elemento> getElementos() {
		return elementos;
	}
	
	public boolean removeElemento(int posicao) {
		if (posicao <= 0 || posicao > elementos.size()) return false;
		
		elementos.remove(posicao - 1);

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
	
	public String getTitulo() {
		return titulo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj.getClass() != this.getClass()) return false;
		
		Documento doc = (Documento) obj;
		
		return doc.getTitulo().equals(this.getTitulo());
	}

}