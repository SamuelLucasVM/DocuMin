package elemento;

import java.util.ArrayList;

public class ElementoRepository {
	ArrayList<Elemento> elementos;
	
	public ElementoRepository() {
		this.elementos = new ArrayList<Elemento>();
	}
	
	public int add(Elemento elemento) {
		elementos.add(elemento);
		return elementos.size() - 1;
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
	
	public Elemento get(int posicao) {
		return elementos.get(posicao);
	}
	
	public boolean remove(int posicao) {
		if (posicao < 0 || posicao >= elementos.size()) return false;
		
		elementos.remove(posicao);
		return true;
	}
}
