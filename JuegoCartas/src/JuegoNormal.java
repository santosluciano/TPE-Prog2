
public class JuegoNormal extends Juego{
	public JuegoNormal(String n1, String n2) {
		super(n1,n2);		
	}
	public JuegoNormal(String n1, String n2,Mazo mazocartas){
		super(n1,n2,mazocartas);
	}
	public void jugar() {
			this.mazocartas.barajar();
			this.mazocartas.repartir(j1,j2);
			if (this.j1.hayCartas()&&this.j2.hayCartas()){
				while (Ganador() == null) {
					jugarMano();			}
				System.out.println("gano el jugador "+ this.Ganador().getNombre());
			}else {
				System.out.println("Imposible jugar con este mazo");			
			}
		}
}
