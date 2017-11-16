package FiltrosCartas;
import CartasJuego.Carta;

public class EsIgual extends Simple{

	public EsIgual (String atributo, double valor){
		super(atributo, valor);
	}
	
	public boolean cumple(Carta carta){
		
		return carta.getValorAtributo(this.getAtributo()) == this.getValor();
	}
}
