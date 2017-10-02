import java.util.*;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Carta {
	private String nombre;
	private ArrayList<Atributo> atributos;
	private final int MAX_ATRIBUTOS = 6;
	private final int MIN_ATRIBUTOS = 3;
	public Carta(){ 
		this.atributos = new ArrayList<Atributo>(); 
	}
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	public boolean isValida() {
		return this.getCantidadAtributos()>=MIN_ATRIBUTOS && this.getCantidadAtributos()<=MAX_ATRIBUTOS;
	}
	public boolean isMenor(Atributo a,Carta c){
		int i = 0;
		while (i<this.getCantidadAtributos()&&!this.atributos.get(i).equals(a)) {
			i++;
		}
		return this.atributos.get(i).isMenor(c.getAtributo(i));
	}	
	public Atributo atributoAzar() {
		int i= (int) (Math.random() * (this.getCantidadAtributos()-1));
		return this.getAtributo(i);
	}
	protected void addAtributo(Atributo a) {
		if (atributos.size() <= MAX_ATRIBUTOS) {
			this.atributos.add(a);
		}
		else {
			System.out.println("No se pueden agregar mas atributos");
		}
	}
	public Atributo getAtributo(int i) {
		return this.atributos.get(i);
	}
	public String getNombre() {
		return this.nombre;
	}
	public boolean equals(Carta c) {
		if (this.getCantidadAtributos() == c.getCantidadAtributos()) {			
			for  (int i = 0; i < this.getCantidadAtributos(); i++) {				
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
	public int getCantidadAtributos() { 		
		return this.atributos.size();
	}
	public int consultarValorAtributo(Atributo a){ 
		int i = 0;
		while (i<this.getCantidadAtributos()&&!atributos.get(i).equals(a)) {
		i++;
	}
		return this.atributos.get(i).getValor();
	}
	public void imprimirAtributos(){
		String nombreAtributo;
		int valorAtributo;
		
		for (int i=0; i<getCantidadAtributos();i++) {
			nombreAtributo = this.atributos.get(i).getNombre();
			valorAtributo = this.atributos.get(i).getValor();
			
			System.out.println("Nombre Atributo: " + nombreAtributo);
			System.out.println("Valor Atributo: " + valorAtributo);
		}
	}
}
