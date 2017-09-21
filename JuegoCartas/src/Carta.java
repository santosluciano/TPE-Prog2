import java.util.*;

public class Carta {
	private String nombre;
	private ArrayList<Atributo> atributos;
	public Carta(String n){
		this.nombre = n;		
		this.atributos = new ArrayList<Atributo>(); 
	}
	public boolean isMenor(Atributo a,Carta c){
		int i = 0;
		while (i<this.cantidadAtributos()&&this.atributos.get(i).equals(a)) {
			i++;
		}
		return this.atributos.get(i).getValor()<c.getAtributo(i).getValor();
	}	
	public Atributo atributoAzar() {
		int i= (int) (Math.random() * (this.cantidadAtributos()-1));
		return this.getAtributo(i);
	}
	protected void add(Atributo a) {
		this.atributos.add(a);
	}
	public Atributo getAtributo(int i) {
		return this.atributos.get(i);
	}
	public String getNombre() {
		return this.nombre;
	}
	public boolean equals(Carta c) {
		if (this.cantidadAtributos() == c.cantidadAtributos()) {			
			for  (int i = 0; i < this.cantidadAtributos(); i++) {				
				if 	(this.getAtributo(i).equals(c.getAtributo(i))) {
					continue;
				}else {
					return false;
				}
			}return true;			
		}
		else {
			return false;
		}
	}
	public int cantidadAtributos() {
		return this.atributos.size();
	}
}
