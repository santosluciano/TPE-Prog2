
public class Juego {
	private Jugador j1;
	private Jugador j2;
	private int turno;
	private Mazo mazocartas;
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
	public void jugar() {
		this.prepararPartida();
		if (jugadoresAptos()){
			while (!hayGanador()) {
				jugarMano();
			}
		if (Ganador() == null) {
			System.out.println("empataron");
		}else {
			System.out.println("gano el jugador "+ this.Ganador().getNombre());
		}
		}else {
			System.out.println("Imposible jugar con este mazo");			
		}
	}
	public boolean hayGanador() {
		return !(this.jugadoresAptos());
	}
	private void prepararPartida() {
		this.mazocartas.barajar();
		this.mazocartas.repartir(j1,j2);
	}
	public Jugador Ganador() {
		if (this.j1.CantidadCartas() == this.j2.CantidadCartas()) {
			return null;
		} else if (this.j1.CantidadCartas() > this.j2.CantidadCartas()) {
			return this.j1;
		} else
			return this.j2;
	}
	public int getTurno() {
		return this.turno;
	}
	public void cambiarMazo(Mazo nuevoMazo) {
		this.mazocartas = nuevoMazo;
	}
	public boolean jugadoresAptos() {
		return (this.j1.hayCartas()&&this.j2.hayCartas());
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
