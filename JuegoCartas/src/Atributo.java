
public class Atributo {
	String nombre;
	int valor;
	public Atributo(String n,int v) {
		nombre = n;
		valor = v;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public boolean equals(Atributo a) {
		return (this.nombre == a.getNombre());
	}
}
