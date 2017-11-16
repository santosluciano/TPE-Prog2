package FiltrosCartas;
import CartasJuego.Carta;

public abstract class Compuesto implements Filtro{

	private Filtro filtroUno;
	private Filtro filtroDos;
	
	public Compuesto (Filtro filtroUno, Filtro filtroDos) {
		this.filtroUno = filtroUno;
		this.filtroDos = filtroDos;
	}
	
	public Filtro getFiltroUno() {
		return filtroUno;
	}

	public void setFiltroUno(Filtro filtroUno) {
		this.filtroUno = filtroUno;
	}

	public Filtro getFiltroDos() {
		return filtroDos;
	}

	public void setFiltroDos(Filtro filtroDos) {
		this.filtroDos = filtroDos;
	}

	public abstract boolean cumple(Carta carta);

}
