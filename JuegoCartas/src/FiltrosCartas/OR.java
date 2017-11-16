package FiltrosCartas;
import CartasJuego.Carta;

public class OR extends Compuesto{
	
	public OR (Filtro filtroUno, Filtro filtroDos) {
		super(filtroUno, filtroDos);
	}

	public boolean cumple(Carta carta) {
		return this.getFiltroUno().cumple(carta) || this.getFiltroDos().cumple(carta);
	}
}
