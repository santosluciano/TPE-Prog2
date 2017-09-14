
public class Jugador {
	String nombre;
	Mazo cartasJugador;
	public Jugador(String n) {
		nombre = n;
		cartasJugador = new Mazo();
	}
	public String getNombre() {
		return nombre;
	}
	public Carta tomarCarta() {
		Carta c = cartasJugador.tomarPrimera();
		return c;
	}
	public boolean hayCartas() {
		return cartasJugador.vacio();
	}
	public void addCarta(Carta c1) {
		cartasJugador.add(c1);
	}
	public void addCartas(Carta c1, Carta c2) {
		this.addCarta(c1);
		this.addCarta(c2);
	}
}
