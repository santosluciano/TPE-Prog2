
public class AND extends Compuesto{
	
	public AND (Filtro filtroUno, Filtro filtroDos) {
		super(filtroUno, filtroDos);
	}

	public boolean cumple(Carta carta) {
		return this.getFiltroUno().cumple(carta) && this.getFiltroDos().cumple(carta);
	}
}

