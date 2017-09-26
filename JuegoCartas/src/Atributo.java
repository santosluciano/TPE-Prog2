
public class Atributo {
	private String nombre;
	private int valor;
	public Atributo(String nombre,int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getValor() {
		return this.valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public boolean equals(Atributo a) {
		return (this.nombre == a.getNombre());
	}
	public boolean isMenor(Atributo a) {
		return this.valor<a.getValor();
	}
}
