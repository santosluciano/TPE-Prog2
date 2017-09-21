
public class Juego {
	private Jugador j1;
	private Jugador j2;
	private int turno;
	private Mazo mazocartas;
	public Juego(String n1, String n2) {
		j1 = new Jugador(n1);
		j2 = new Jugador(n2);
		this.mazocartas = new Mazo();
		turno = 1;
	}
	public Juego(String n1, String n2, Mazo mazocartas) {
		j1 = new Jugador(n1);
		j2 = new Jugador(n2);
		this.mazocartas = mazocartas;
		turno = 1;
	}
	public void jugar() {
		if (!mazocartas.vacio()){
			mazocartas.repartir(j1,j2);
			while (Ganador() == null) {
				Carta c1 = j1.tomarCarta();			
				Carta c2 = j2.tomarCarta();
				Atributo a;
				if (turno==1) {
					a = j1.elegirAtributo(c1);
				}else {	
					a = j2.elegirAtributo(c2);
				}
				if (c1.isMenor(a,c2)) {
					j2.addCartas(c1,c2);
					turno = 2;
				}else if (c2.isMenor(a,c1)) {
					j1.addCartas(c1,c2);
					turno = 1;
				}else {
					j1.addCarta(c1);
					j2.addCarta(c2);
				}
			}
			System.out.println("gano el jugador "+ Ganador().getNombre());
		}else {
			System.out.println("El mazo no tiene cartas");			
		}
	}
	public Jugador Ganador() {
		if (j1.hayCartas() && !j2.hayCartas()) {
			return j1;
		} else if (!j1.hayCartas() && j2.hayCartas()) {
			return j2;
		} else
			return null;
	}
	public int getTurno() {
		return turno;
	}
	public void cambiarMazo(Mazo nuevoMazo) {
		this.mazocartas = nuevoMazo;
	}
}
