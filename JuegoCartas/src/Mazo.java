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
		if (this.vacio()&&c.getCantidadAtributos()>=3&&c.getCantidadAtributos()<=6) {
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
		int tama�o;
		int i = 0;
		if (this.mazo.size()%2 != 0) {
			tama�o = this.mazo.size() - 1;
		}else {
			tama�o = this.mazo.size();
		}
		while (i < tama�o) {
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
	public int getTama�oMazo(){ // Para consultar desde "juego" la cantidad de cartas de cada uno.
		   // Se consulta desde "Jugador" con otro metodo.
		  // Se puede borrar despues.
		return mazo.size();
}
	
	public void imprimirTodoelMazo(){ // Por si se quieren ver todas las cartas que hay
			
			for (int i=0; i<getTama�oMazo();i++) {
				
				System.out.println("Nombre Carta: " + this.mazo.get(i).getNombre());
				this.mazo.get(i).imprimirAtributos();				

				
			}
	}
	
	public void barajar() {   // Abre metodo barajar
	 if (mazo.size()>1) {
		 for ( int carta = 0; carta < mazo.size(); carta++ ){ // Abre for
	 
			 int segundaCarta = (int) (Math.random() * (getTama�oMazo()-1)+1);
			 Carta temp = mazo.get(carta);
		 
			 mazo.set(carta, mazo.get(segundaCarta));
			 mazo.set(segundaCarta, temp);

	 
		 }
	 }
	} 

}
