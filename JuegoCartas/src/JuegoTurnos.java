
public class JuegoTurnos extends JuegoCartas{
	private int cantTurnos;
	private int turnoActual;
	public JuegoTurnos(String n1, String n2,Mazo mazocartas,int cantTurnos){
		super(n1,n2,mazocartas);
		this.cantTurnos = cantTurnos;
		this.turnoActual = 0;
	}
	public void setCantTurnos(int cantTurnos) {
		this.cantTurnos = cantTurnos;
	}
	public boolean hayGanador() {
		return (super.hayGanador()||!(turnoActual!=cantTurnos));
	}
	public void jugarMano() {
		super.jugarMano();
		turnoActual++;
	}
}
