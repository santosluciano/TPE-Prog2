
public class Jugador {
	private String nombre;
	private Mazo cartasJugador;
	public Jugador(String n) {
		this.nombre = n;
		this.cartasJugador = new Mazo();
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String n) {
		this.nombre = n;
	}
	public Carta tomarCarta() {
		Carta c = this.cartasJugador.tomarPrimera();
		return c;
	}
	public boolean hayCartas() {
		return !this.cartasJugador.vacio();
	}
	public void addCarta(Carta c1) {
		this.cartasJugador.addCarta(c1);
	}
	// Eliminado el método addCartas... era innecesario... 
	// Me dijeron que es mejor llamar dos veces a add carta... ya esta corregido en "juego"
	public Atributo elegirAtributo(Carta c) {
		return c.atributoAzar();
	}
	public int CantidadCartas(){ // Para consultar desde "juego" la cantidad de cartas de cada uno.
		// Se puede borrar despues
		return cartasJugador.getTamañoMazo();
}
}
