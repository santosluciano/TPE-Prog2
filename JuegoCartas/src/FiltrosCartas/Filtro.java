package FiltrosCartas;
import CartasJuego.Carta;

public interface Filtro {

	public abstract boolean cumple(Carta carta);
}
