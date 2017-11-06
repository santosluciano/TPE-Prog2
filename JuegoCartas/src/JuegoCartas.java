
public class JuegoCartas {

	private Jugador j1;
	private Jugador j2;
	private String nombreJ1;
	private String nombreJ2;
	private Jugador turno;
	private String jugadorGanador;
	

	
	private Mazo mazocartas;
	public JuegoCartas(String n1, String n2, Mazo mazocartas) {
		this.j1 = new Jugador(n1);
		this.j2 = new Jugador(n2);
		this.mazocartas = mazocartas;
		this.turno = j1;
		this.nombreJ1 = j1.getNombre();
		this.nombreJ2= j2.getNombre();
	}
	public void jugar() {
		this.prepararPartida();
		if (jugadoresAptos()){
			while (!hayGanador()) {
				jugarMano();
			}
			if (getGanador() == null) {
				System.out.println("Empataron");
			}else {
				jugadorGanador = this.getGanador().getNombre();
				System.out.println("La partida la gano "+ jugadorGanador);
			}
		}else {
			System.out.println("Imposible jugar con este mazo");			
		}
	}
	public boolean hayGanador() {
		return (!this.j1.hayCartas()||!this.j2.hayCartas());
	}
	private void prepararPartida() {
		this.mazocartas.barajar();
		this.mazocartas.repartir(j1,j2);
	}
	public Jugador getGanador() {
		if (this.j1.CantidadCartas() == this.j2.CantidadCartas()) {
			return null;
		} else if (this.j1.CantidadCartas() > this.j2.CantidadCartas()) {
			return this.j1;
		} else
			return this.j2;
	}
	public Jugador getTurno() {
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
		String a;
		String nombreCartaJ1 = c1.getNombre();
		String nombreCartaJ2 = c2.getNombre();
		String nombreAtributo;
		Double valorAtributoJ1;
		Double valorAtributoJ2;
		int cantCartasJ1;
		int cantCartasJ2;

		if (this.getTurno().equals(j1)) {
			a = this.j1.elegirAtributo(c1);
		}else {	
			a = this.j2.elegirAtributo(c2);
		}
		
		nombreAtributo = a;
		valorAtributoJ1 = c1.getValorAtributo(a);
		valorAtributoJ2 = c2.getValorAtributo(a);
		
		System.out.println("Es el Turno de " + (this.getTurno().getNombre()));
		System.out.println("La carta de " + this.nombreJ1 + " es " + nombreCartaJ1);
		System.out.println("La carta de " + this.nombreJ2 + " es " + nombreCartaJ2);
		System.out.println("El atributo a comparar es " + nombreAtributo);
		System.out.println(nombreAtributo + " J1: " + valorAtributoJ1);
		System.out.println(nombreAtributo + " J2: " + valorAtributoJ2);		
		
		if (c1.isMenor(a,c2)) { 			
			this.j2.addCarta(c1); 
			this.j2.addCarta(c2);
			this.turno = j2;
		}else if (c2.isMenor(a,c1)) {
			this.j1.addCarta(c1);
			this.j1.addCarta(c2);
			this.turno = j1;
		}else {
			this.j1.addCarta(c1);
			this.j2.addCarta(c2);
		}
		cantCartasJ1 = j1.CantidadCartas();
		cantCartasJ2 = j2.CantidadCartas();
		System.out.println("El jugador uno tiene " + cantCartasJ1 + " cartas");
		System.out.println("El jugador dos tiene " + cantCartasJ2 + " cartas");
	}

}
