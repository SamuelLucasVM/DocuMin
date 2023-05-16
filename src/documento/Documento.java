package documento;

public class Documento {
	private String titulo;
	private int tamanho;
	
	public Documento(String titulo, int tamanho) {
		if (tamanho <= 0) throw new IllegalArgumentException("Tamanho inválido");
		if (titulo.equals("") || composedOfSpaces(titulo)) throw new IllegalArgumentException("Título vazio");
		
		this.titulo = titulo;
		this.tamanho = tamanho;
	}
	
	public Documento(String titulo) {
		this(titulo, -1);
	}
	
	private boolean composedOfSpaces(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!(str.charAt(i) == ' ')) {
				return true;
			}
		}
		return false;
	}
}