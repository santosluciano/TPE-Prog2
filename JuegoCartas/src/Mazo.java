import java.util.*;
public class Mazo {
	private final int PRIMERA = 0;
	private final int ESPAR = 2;
	private String nombreMazo;
	private ArrayList<Carta> mazo;
	public Mazo() {
		this.nombreMazo = "";
		this.mazo = new ArrayList<Carta>();
	}	
	public void setNombreMazo(String nombreMazo){
		this.nombreMazo=nombreMazo;
	}
	public String getNombreMazo(){
		return nombreMazo;
	}
	public void addCarta(Carta c) {
		if (this.vacio()) {
			this.mazo.add(c);
		}else if (c.equals(this.mazo.get(PRIMERA))) {
			this.mazo.add(c);
		}else {
			System.out.println("Carta Invalida");
		}		
	}
	public Carta tomarPrimera() {
		if (!this.mazo.isEmpty()){
			Carta c = this.mazo.get(PRIMERA);
			this.mazo.remove(PRIMERA);
			return c;
		}else
			return null;
	}
	public void repartir(Jugador j1,Jugador j2) {
		int tamaño;
		int i = 0;
		if (this.mazo.size() % ESPAR != 0) {
			tamaño = this.mazo.size() - 1;
		}else {
			tamaño = this.mazo.size();
		}
		while (i < tamaño) {
			j1.addCarta(this.mazo.get(i));
			i++;
			j2.addCarta(this.mazo.get(i));
			i++;
		}
	}
	public boolean vacio() {
		return this.mazo.isEmpty();
	}
	public void vaciarMazo() {
		this.mazo.clear();
	}
	public int getTamañoMazo(){
		return mazo.size();
}
	public String toString(){ 
		String datosMazo = "";
		datosMazo += this.nombreMazo + "\n";
			
			for (int i=0; i<getTamañoMazo();i++) {
				datosMazo += this.mazo.get(i).toString() + "\n";		
				
			}
		return datosMazo;
	}
	public void barajar() {   
		Collections.shuffle(mazo);
	}
	
	public Mazo getCartas(Filtro filtro){
		Mazo nuevoMazo = new Mazo();
		
		for (Carta carta : mazo) {
			
			if (filtro.cumple(carta)){
				nuevoMazo.addCarta(carta);
			}
		}
		return nuevoMazo;
	}
}
