import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Juego { 

	public static void main(String[] args) {
		int cantidadCartas = 0;
		int primero = 0;
		int segundo = 0;
		int tercero = 0;
		int opcion = 0;
		String nombreMazo = "";
		String nombreCarta = "";
		String nombreJ1 = "";
		String nombreJ2 = "";
		
		System.out.println("�Cuantas cartas tiene el mazo? ");
		cantidadCartas = obtnerValor();
		
		Mazo maso = new Mazo();
		for (int i=0;i<cantidadCartas;i++) {

			System.out.println("Nombre de la Carta: ");
			nombreCarta = obtenerNombreCarta();
				
			System.out.println("Fuerza: ");
			primero = obtnerValor();
			String a = "Fuerza";

			System.out.println("Velocidad: ");
			segundo = obtnerValor();
			String b = "Velocidad";

			System.out.println("Mental: ");
			tercero = obtnerValor();
			String c = "Mental";
			
			Carta nuevaCarta = new Carta ();
			nuevaCarta.addAtributo(a,primero);
			nuevaCarta.addAtributo(b,segundo);
			nuevaCarta.addAtributo(c,tercero);
			nuevaCarta.setNombre(nombreCarta);
		
			
			maso.addCarta(nuevaCarta);
		}
		
		System.out.println("�Cual es el nombre del mazo creado? ");
		nombreMazo = obtenerNombreCarta();
		maso.setNombreMazo(nombreMazo);
		
		System.out.println("Nombre Jugador 1:");
		nombreJ1 = obtenerNombreCarta();
		System.out.println("Nombre Jugador 2:");
		nombreJ2 = obtenerNombreCarta();
    	JuegoCartas partida;
    	do {
    			System.out.println ("Elija el tipo de partida:");
    			System.out.println ("1.Partida normal");
    			System.out.println ("2.Partida por turnos");
    			opcion = obtnerValor();
    	}while(opcion!=1&&opcion!=2); 
        switch (opcion) {
        	case 1: 
        		partida = new JuegoCartas(nombreJ1,nombreJ2,maso);
        		partida.jugar();
        		break;
        	case 2:
        		System.out.println ("Cuantos turnos va a durar la partida?");
        		opcion = obtnerValor();
        		partida = new JuegoTurnos(nombreJ1,nombreJ2,maso,opcion);
        		partida.jugar();
        		break;
        };
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

