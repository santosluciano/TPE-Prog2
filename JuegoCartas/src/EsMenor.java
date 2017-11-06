
public class EsMenor extends Simple{

	public EsMenor (String atributo, double valor){
		super(atributo, valor);
	}
	public boolean cumple(Carta carta){
		
		return carta.getValorAtributo(this.getAtributo()) < this.getValor();
	}
}