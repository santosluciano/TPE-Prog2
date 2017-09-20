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
		int tamaño;
		int i = 0;
		if (mazo.size()%2 != 0) {
			tamaño = mazo.size() - 1;
		}else {
			tamaño = mazo.size();
		}
		while (i < tamaño) {
			j1.addCarta(mazo.get(i));
			i++;
			j2.addCarta(mazo.get(i));
			i++;
		}
	}
	public boolean vacio() {
		return mazo.isEmpty();
	}
}
