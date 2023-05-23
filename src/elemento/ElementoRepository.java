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
	
	public void elevaElemento() {
		
	}
	
	public void get() {

	}
	
	public void remove() {

	}
}
