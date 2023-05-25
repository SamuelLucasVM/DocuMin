package elemento;

import java.util.HashMap;

public class ElementoController {
	ElementoRepository repositorio;
	
	public ElementoController() {
		this.repositorio = new ElementoRepository();
	}
	
	public int addTexto(String valor, int prioridade) {
		Texto texto = new Texto(prioridade, valor);
		
		return(repositorio.add(texto));
	}
	
	public int addTitulo(String valor, int prioridade, int nivel, boolean linkavel) {
		HashMap<String, String> propriedades = new HashMap<String, String>();
		propriedades.put("nivel", Integer.toString(nivel));
		propriedades.put("linkavel", Boolean.toString(linkavel));
		
		Titulo titulo = new Titulo(prioridade, valor, propriedades);
		
		return(repositorio.add(titulo));
	}
	
	public int addLista(String valorLista, int prioridade, String separador, String charLista) {
		HashMap<String, String> propriedades = new HashMap<String, String>();
		propriedades.put("separador", separador);
		propriedades.put("charLista", charLista);
		
		Lista lista = new Lista(prioridade, valorLista, propriedades);
		
		return(repositorio.add(lista));
	}
	
	public int addTermos(String tituloDoc, String valorTermos, int prioridade, String separador, Ordem ordem) {
		HashMap<String, String> propriedades = new HashMap<String, String>();
		propriedades.put("separador", separador);
		switch (ordem) {
		case NENHUM: {
			propriedades.put("ordem", "NENHUM");
			}
		case ALFABETICA: {
			propriedades.put("ordem", "ALFABETICA");			
			}
		case TAMANHO: {
			propriedades.put("ordem", "TAMANHO");
			}
		}
		
		Termos termo = new Termos(prioridade, valorTermos, propriedades);
		
		return(repositorio.add(termo));
	}
	
	public void elevaElemento(int elementoPosicao) {
		repositorio.elevaElemento(elementoPosicao);
	}
	
	public void cedeElemento(int elementoPosicao) {
		repositorio.cedeElemento(elementoPosicao);
	}
	
	public boolean removeElemento(int elementoPosicao) {
		return(repositorio.remove(elementoPosicao));
	}
}
