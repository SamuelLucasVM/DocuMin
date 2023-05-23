package elemento;

import java.util.HashMap;

public class ElementoController {
	ElementoRepository repositorio;
	
	public ElementoController() {
		this.repositorio = new ElementoRepository();
	}
	
	public int addElemento(int prioridade, String valor, HashMap<String, String> propriedades) {
		Elemento elemento = new Elemento(prioridade, valor, propriedades);
		
		return(repositorio.add(elemento));
	}
	
	public void elevaElemento() {
		
	}
}
