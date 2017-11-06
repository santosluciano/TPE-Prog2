import java.util.*;

public class Carta {
	private String nombre;
	private HashMap<String, Double> atributos;

	public Carta(){ 
		this.atributos = new HashMap<String, Double>(); 
	}
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}

	public boolean isMenor(String nombre,Carta c){
		return this.getValorAtributo(nombre)<c.getValorAtributo(nombre);
	}	
	
	public String atributoAzar() {
		String clave = "";
		int r= (int) (Math.random() * (this.getCantidadAtributos()-1));
		Iterator<String> it = this.atributos.keySet().iterator();
		for (int i = 0;it.hasNext()&&i<=r;i++) {
			clave = it.next();
		}
		return clave;
	}//verificar si esta bien hecho
	
	protected void addAtributo(String nombre, double valor) {
		this.atributos.put(nombre, valor);
	}

	public Double getValorAtributo(String nombre) {
		return this.atributos.get(nombre);
	}
		
	public String getNombre() {
		return this.nombre;
	}
	
	public boolean containAtributo(String nombre) {
		return atributos.containsKey(nombre);
	}
	public boolean equals(Carta c) {
		if (this.getCantidadAtributos() == c.getCantidadAtributos()) {			
			for (String atributo : atributos.keySet()) {
				if(c.containAtributo(atributo)){
					continue;
				}
				else 
				{
					return false;
				}
			}
						
			return true;			
		}
		else {
			return false;
		}
	}
	
	public int getCantidadAtributos() { 		
		return this.atributos.size();
	}
	
	public String toString(){ // modificar
		String datosCarta = "";		
		datosCarta += this.getNombre() + "\n";
		
		for (String atributo : atributos.keySet()) {
			datosCarta += " - " + atributo + " = " + atributos.get(atributo) + "\n";
		}
		return datosCarta;
	}

}
