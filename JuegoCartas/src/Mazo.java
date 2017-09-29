import java.util.*;
public class Mazo {
	private String nombreMazo;
	private ArrayList<Carta> mazo;
	public Mazo() {
		this.mazo = new ArrayList<Carta>();
	}	
	public void setNombreMazo(String nombreMazo){
		this.nombreMazo=nombreMazo;
	}
	public String getNombreMazo(){
		return nombreMazo;
	}
	public void addCarta(Carta c) {
		if (this.vacio()&&c.isValida()) {
			this.mazo.add(c);
		}else if (c.equals(this.mazo.get(0))) {
			this.mazo.add(c);
		}else {
			System.out.println("Carta Invalida");
		}		
	}
	public Carta tomarPrimera() {
		if (!this.mazo.isEmpty()){
			Carta c = this.mazo.get(0);
			this.mazo.remove(0);
			return c;
		}else
			return null;
	}
	public void repartir(Jugador j1,Jugador j2) {
		int tamaño;
		int i = 0;
		if (this.mazo.size()%2 != 0) {
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
	public void imprimirTodoelMazo(){ 
			
			for (int i=0; i<getTamañoMazo();i++) {
				
				System.out.println("Nombre Carta: " + this.mazo.get(i).getNombre());
				this.mazo.get(i).imprimirAtributos();				

				
			}
	}
	public void barajar() {   
	 if (mazo.size()>1) {
		 for ( int carta = 0; carta < mazo.size(); carta++ ){	 
			 int segundaCarta = (int) (Math.random() * (getTamañoMazo()-1)+1);
			 Carta temp = mazo.get(carta);		 
			 mazo.set(carta, mazo.get(segundaCarta));
			 mazo.set(segundaCarta, temp);	 
		 }
	 }
	}
}
