import java.io.BufferedReader;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		int primero;
		int segundo;
		int tercero;
		String nombre;
		try {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Cuantas cartas tiene el mazo? ");
		opcion = new Integer(entrada.readLine());
		Mazo maso = new Mazo();
		for (int i=0;i<opcion;i++) {
			System.out.println("Nombre: ");
			nombre = entrada.readLine();
			System.out.println("Fuerza: ");
			primero = new Integer(entrada.readLine());
			System.out.println("Velocidad: ");
			segundo = new Integer(entrada.readLine());
			System.out.println("Mental: ");
			tercero = new Integer(entrada.readLine());
			Atributo a = new Atributo("Fuerza",primero);
			Atributo b = new Atributo("Velocidad",segundo);
			Atributo c = new Atributo("Mental",tercero);
			maso.addCarta(new Carta3(nombre,a,b,c));
		}
		Juego partida = new Juego("lucho","pc",maso);
		partida.jugar();
		}catch (Exception exc) {
			System.out.println( exc );
		}
	}
}
