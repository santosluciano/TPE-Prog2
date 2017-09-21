package JuegoDeCartas;

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
		return !cartasJugador.vacio();
	}
	public void addCarta(Carta c1) {
		cartasJugador.addCarta(c1);
	}
	public void addCartas(Carta c1, Carta c2) {
		this.addCarta(c1);
		this.addCarta(c2);
	}
	public Atributo elegirAtributo(Carta c) {
		return c.atributoAzar();
	}
	
	public int CantidadCartas(){ // Para consultar desde "juego" la cantidad de cartas de cada uno.
								// Se puede borrar despues
		return cartasJugador.getTamañoMazo();
	}
}
