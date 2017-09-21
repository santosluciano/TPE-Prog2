package JuegoDeCartas;
import java.util.*;

public class Mazo {
	ArrayList<Carta> mazo;
	public Mazo() {
		mazo = new ArrayList<Carta>();
	}
	public void addCarta(Carta c) {
		if (this.vacio()) {
			mazo.add(c);
		}else if (c.equals(mazo.get(0))) {
			mazo.add(c);
		}else {
			System.out.println("Carta Invalida");
		}		
	}
	public Carta tomarPrimera() {
		if (!mazo.isEmpty()){
			Carta c = mazo.get(0);
			mazo.remove(0);
			return c;
		}else
			return null;
	}
	public void repartir(Jugador j1,Jugador j2) {
		int tama�o;
		int i = 0;
		if (this.mazo.size()%2 != 0) {
			tama�o = this.mazo.size() - 1;
		}else {
			tama�o = this.mazo.size();
		}
		while (i < tama�o) {
			j1.addCarta(mazo.get(i));
			i++;
			j2.addCarta(mazo.get(i));
			i++;
		}
	}
	public boolean vacio() {
		return mazo.isEmpty();
	}
	public void vaciarMazo() { //�Para que seria este mazo????
		this.mazo.clear();
	}
	
	public int getTama�oMazo(){ // Para consultar desde "juego" la cantidad de cartas de cada uno.
							   // Se consulta desde "Jugador" con otro metodo.
							  // Se puede borrar despues.
		return mazo.size();
	}
}
