
public class JuegoTurnos extends Juego{
	private int cantTurnos;
	public JuegoTurnos(String n1, String n2,int cantTurnos) {
		super(n1,n2);
		this.cantTurnos = cantTurnos;
	}
	public JuegoTurnos(String n1, String n2,Mazo mazocartas,int cantTurnos){
		super(n1,n2,mazocartas);
		this.cantTurnos = cantTurnos;
	}
	public void setCantTurnos(int cantTurnos) {
		this.cantTurnos = cantTurnos;
	}
	public void jugar() {
		int i = 0;
		this.mazocartas.barajar();
		this.mazocartas.repartir(j1,j2);
		if (this.j1.hayCartas()&&this.j2.hayCartas()){
			while (Ganador() == null && i!=cantTurnos) {
				jugarMano();
				i++;
			}
		if (Ganador() != null) {
			System.out.println("gano el jugador "+ this.Ganador().getNombre());
		}else
			System.out.println("Empataron");
		}else {
			System.out.println("Imposible jugar con este mazo");			
		}
	}
	public Jugador Ganador() {
		if (this.j1.CantidadCartas() == this.j2.CantidadCartas()) {
			return null;
		} else if (this.j1.CantidadCartas() > this.j2.CantidadCartas()) {
			return this.j1;
		} else
			return this.j2;
	}
}
