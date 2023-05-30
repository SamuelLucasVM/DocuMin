package elemento;

public class Texto extends Elemento{	
	public Texto(int prioridade, String valor){
		super(prioridade, valor, null);
	}
	
	@Override
	public String exibirCompleto() {
		return super.getValor();
	}
	
	@Override
	public String exibirResumido() {
		return super.getValor();
	}
}
