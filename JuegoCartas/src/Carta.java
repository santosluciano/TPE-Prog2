import java.util.*;

public class Carta {
	private String nombre;
	private ArrayList<Atributo> atributos;
	private int cantidadAtributos; // agregue la cantidad de atributos para controlar el tamaño
								  // del Array List --- Modificado el "add"
	public Carta(int cantidadAtributos){ // Cuando creas la de carta ya lo delimitas.
		//this.nombre = nombre; String nombre
		this.cantidadAtributos = cantidadAtributos;
		this.atributos = new ArrayList<Atributo>(); 
	}
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public boolean isMenor(Atributo a,Carta c){
		int i = 0;
		// En este while faltaba el "!"
		while (i<this.getCantidadAtributos()&&!this.atributos.get(i).equals(a)) {
			i++;
		}
		return this.atributos.get(i).getValor()<c.getAtributo(i).getValor();
	}	
	public Atributo atributoAzar() {
		int i= (int) (Math.random() * (this.getCantidadAtributos()-1));
		return this.getAtributo(i);
	}
	protected void addAtributo(Atributo a) {// modifique el nombre "add" por "addAtributo" para especificar.
		
			
		if (atributos.size() <= cantidadAtributos) {
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
	public int getCantidadAtributos() {  //this.atributos.size() ahora no es necesario... 
		
		return cantidadAtributos;
	}
	public int consultarValorAtributo(Atributo a){ //Método que se puede borrar despues
			  									  // Para consultar el valor desde "Juego".
	int i = 0;
	while (i<this.getCantidadAtributos()&&!atributos.get(i).equals(a)) {
		i++;
	}
	return this.atributos.get(i).getValor();
	}
	
	public void imprimirAtributos(){
		
		for (int i=0; i<getCantidadAtributos();i++) {
			
			System.out.println("Nombre Atributo: " + this.atributos.get(i).getNombre());
			System.out.println("Valor Atributo: " + this.atributos.get(i).getValor());

			
		}
		
		
	}
}
