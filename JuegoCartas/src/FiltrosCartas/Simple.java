package FiltrosCartas;
import CartasJuego.Carta;

public abstract class Simple implements Filtro {

	private String atributo;
	private double valor;
	
	public Simple (String atributo, double valor){
		this.atributo = atributo;
		this.valor = valor;
	}
	
	public String getAtributo() {
		return atributo;
	}
	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public abstract boolean cumple(Carta carta);
}
