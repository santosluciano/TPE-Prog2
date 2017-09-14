import java.util.*;
public class Mazo {
	ArrayList mazo;
	public Mazo() {
		mazo = new ArrayList<Carta>();
	}
	public void addCarta(Carta c) {
		mazo.add(c);
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
}
