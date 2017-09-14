
public class Juego {
	private Jugador j1;
	private Jugador j2;
	private int turno;
	private Mazo mazocartas;
	public Juego(String n1, String n2) {
		j1 = new Jugador(n1);
		j2 = new Jugador(n2);
		mazocartas = new Mazo();
		turno = 1;
	}
	public void jugar(Atributo a) {
		if (!(j1.hayCartas()&&j2.hayCartas())) {
			mazocartas.repartir(j1,j2);
		}else {
			Carta c1 = j1.tomarCarta();
			Carta c2 = j2.tomarCarta();
			//c1.isMenor(a,c2) ? j2.sumarCartas(c1,c2) : j1.sumarCartas(c1,c2);
			if (c1.isMenor(a,c2)) {
				j2.addCartas(c1,c2);				
			}else if (c2.isMenor(a,c1)) {
				j1.addCartas(c1,c2);
			}else {
				j1.addCarta(c1);
				j2.addCarta(c2);
			}
		}
		if (Ganador() != null) {
			System.out.println("gano el jugador "+ Ganador().getNombre());
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
}
