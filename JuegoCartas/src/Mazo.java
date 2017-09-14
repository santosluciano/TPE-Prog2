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
		int tama�o;
		int i = 0;
		if (mazo.size()%2 != 0) {
			tama�o = mazo.size() - 1;
		}else {
			tama�o = mazo.size();
		}
		while (i < tama�o) {
			j1.addCarta(mazo.get(i));
			i++;
			j2.addCarta(mazo.get(i));
			i++;
		}
	}
}
