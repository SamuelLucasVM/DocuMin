package documento;

import java.util.ArrayList;
import elemento.Elemento;

public class Documento {
	private String titulo;
	private ArrayList<Elemento> elementos;
	private int tamanho;
	private int qtdeElementos;
	
	public Documento(String titulo, int tamanho) {
		if (tamanho <= 0) throw new IllegalArgumentException("Tamanho inválido");
		
		this.titulo = titulo;
		this.elementos = new ArrayList<Elemento>();
		this.tamanho = tamanho;
		this.qtdeElementos = 0;
	}
	
	public Documento(String titulo) {
		this(titulo, -1);
	}
	
	public int getQtdeElementos() {
		return this.qtdeElementos;
	}
	
	public String[] getDocumento() {
		String[] stringsElementos = new String[qtdeElementos];
		
		for (int i = 0; i < qtdeElementos; i++) {
			stringsElementos[i] = elementos.get(i).toString();
		}
		
		return stringsElementos;
	}
}