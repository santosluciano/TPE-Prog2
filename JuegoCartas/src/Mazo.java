import java.util.*;
public class Mazo {
	private final int PRIMERA = 0;
	private final int ESPAR = 2;
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
		int tama�o;
		int i = 0;
		if (this.mazo.size() % ESPAR != 0) {
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
	public int getTama�oMazo(){
		return mazo.size();
}
	public void imprimirTodoelMazo(){ 
		String nombreCarta;
			
			for (int i=0; i<getTama�oMazo();i++) {
				nombreCarta = this.mazo.get(i).getNombre();
				
				System.out.println("Nombre Carta: " + nombreCarta);
				this.mazo.get(i).imprimirAtributos();				
			}
	}
	public void barajar() {   
		if (mazo.size()>1) {
			for ( int carta = 0; carta < mazo.size(); carta++ ){	 
			 int segundaCarta = (int) (Math.random() * (getTama�oMazo()-1)+1);
			 Carta temp = mazo.get(carta);		 
			 mazo.set(carta, mazo.get(segundaCarta));
			 mazo.set(segundaCarta, temp);	 
			}
		}
	}
}
