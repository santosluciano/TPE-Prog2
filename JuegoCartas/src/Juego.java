import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Juego { 


	public static void main(String[] args) {
		int cantidadCartas = 0;
		int primero = 0;
		int segundo = 0;
		int tercero = 0;
		String nombreMazo = "";
		String nombreCarta = "";
		
		System.out.println("¿Cuantas cartas tiene el mazo? ");
		cantidadCartas = obtnerValor();
		
		Mazo maso = new Mazo();
		for (int i=0;i<cantidadCartas;i++) {

			System.out.println("Nombre de la Carta: ");
			nombreCarta = obtenerNombreCarta();
				
			System.out.println("Fuerza: ");
			primero = obtnerValor();
			Atributo a = new Atributo("Fuerza",primero);

			System.out.println("Velocidad: ");
			segundo = obtnerValor();
			Atributo b = new Atributo("Velocidad",segundo);

			System.out.println("Mental: ");
			tercero = obtnerValor();
			Atributo c = new Atributo("Mental",tercero);
			
			Carta nuevaCarta = new Carta ();
			nuevaCarta.addAtributo(a);
			nuevaCarta.addAtributo(b);
			nuevaCarta.addAtributo(c);
			nuevaCarta.setNombre(nombreCarta);
		
			
			maso.addCarta(nuevaCarta);
		}
		
		System.out.println("¿Cual es el nombre del mazo creado? ");
		nombreMazo = obtenerNombreCarta();
		maso.setNombreMazo(nombreMazo);
		
		System.out.println("Este juego se hara con el mazo: " + maso.getNombreMazo());
		JuegoCartas partida = new JuegoTurnos("Lucho","Agu",maso,2);
		partida.jugar();
	}
	public static String obtenerNombreCarta(){
		boolean nombreValido;
		String nombreCarta="";
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		do {
			
			 try {
				 nombreCarta = entrada.readLine();
				 nombreValido=true;
				}
					
			catch (Exception exc) {
				  System.out.println( exc );
				  nombreValido=false;
				  }
				
		}while (!nombreValido || nombreCarta.equals(""));
		
		return nombreCarta;
	}
	public static int obtnerValor(){
		boolean valorValido;
		int valor = 0;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		do {
			
			 try {
				 valor = new Integer(entrada.readLine());
				 valorValido=true;
				}
			 catch (NumberFormatException e){
					System.out.println("numero invalido");
					valorValido = false;
				}	
			catch (Exception exc) {
				  System.out.println( exc );
				  valorValido=false;
				  }
		}while (!valorValido || (valor <= 0));
		
		return valor;
	}

}

