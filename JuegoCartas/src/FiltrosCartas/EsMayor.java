package FiltrosCartas;
import CartasJuego.Carta;

public class EsMayor extends Simple{

	public EsMayor (String atributo, double valor){
		super(atributo, valor);
	}
		
	public boolean cumple(Carta carta){
		
		return carta.getValorAtributo(this.getAtributo()) > this.getValor();
	}

}
