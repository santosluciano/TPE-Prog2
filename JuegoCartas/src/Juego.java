
public abstract class Juego {
	protected Jugador j1;
	protected Jugador j2;
	protected int turno;
	protected Mazo mazocartas;
	public Juego(String n1, String n2) {
		this.j1 = new Jugador(n1);
		this.j2 = new Jugador(n2);
		this.mazocartas = new Mazo();
		this.turno = 1;
	}
	public Juego(String n1, String n2, Mazo mazocartas) {
		this.j1 = new Jugador(n1);
		this.j2 = new Jugador(n2);
		this.mazocartas = mazocartas;
		this.turno = 1;
	}
	public abstract void jugar(); 
	public Jugador Ganador() {
		if (this.j1.hayCartas() && !this.j2.hayCartas()) {
			return this.j1;
		} else if (!this.j1.hayCartas() && this.j2.hayCartas()) {
			return this.j2;
		} else
			return null;
	}
	public int getTurno() {
		return this.turno;
	}
	public void cambiarMazo(Mazo nuevoMazo) {
		this.mazocartas = nuevoMazo;
	}
	protected void jugarMano() {
		Carta c1 = this.j1.tomarCarta();			
		Carta c2 = this.j2.tomarCarta();
		Atributo a;
		if (this.turno==1) {
			a = this.j1.elegirAtributo(c1);
		}else {	
			a = this.j2.elegirAtributo(c2);
		}
		System.out.println("La carta de " + j1.getNombre() + " es " + c1.getNombre());
		System.out.println("La carta de " + j2.getNombre() + " es " + c2.getNombre());
		System.out.println("El atributo a comparar es " + a.getNombre());
		System.out.println(a.getNombre() + " J1: " + c1.consultarValorAtributo(a));
		System.out.println(a.getNombre() + " J2: " + c2.consultarValorAtributo(a));
		
		if (c1.isMenor(a,c2)) { //se puede mover al atributo
			
			//modificado el addCarta-addCartas... ver en "jugador"
			this.j2.addCarta(c1); 
			this.j2.addCarta(c2);
			this.turno = 2;
		}else if (c2.isMenor(a,c1)) {
			this.j1.addCarta(c1);
			this.j1.addCarta(c2);
			this.turno = 1;
		}else {
			this.j1.addCarta(c1);
			this.j2.addCarta(c2);
		}
		
		System.out.println("El jugador uno tiene " + j1.CantidadCartas() + " cartas");
		System.out.println("El jugador dos tiene " + j2.CantidadCartas() + " cartas");
	}
}
