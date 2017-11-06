import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Juego { 

	
	public static void main(String[] args) {

		String a = "Fuerza";
		String b = "Velocidad";
		String c = "Mental";

		
		Carta uno = new Carta();
		Carta dos = new Carta();
		Carta tres = new Carta();
		Carta cuatro = new Carta();
		Carta cinco = new Carta();
		Carta seis = new Carta();
		Carta siete = new Carta();
		Carta ocho = new Carta();
		Carta nueve = new Carta();
		Carta diez = new Carta();

		uno.setNombre("carta uno");
		uno.addAtributo(a, 15);
		uno.addAtributo(b, 15);
		uno.addAtributo(c, 15);

		dos.setNombre("carta dos");

		dos.addAtributo(a, 10);
		dos.addAtributo(b, 10);
		dos.addAtributo(c, 10);

		tres.setNombre("carta tres");

		tres.addAtributo(a, 2);
		tres.addAtributo(b, 2);
		tres.addAtributo(c, 2);

		cuatro.setNombre("carta cuatro");

		cuatro.addAtributo(a, 10);
		cuatro.addAtributo(b, 20);
		cuatro.addAtributo(c, 10);

		seis.setNombre("carta seis");

		seis.addAtributo(a, 3);
		seis.addAtributo(b, 3);
		seis.addAtributo(c, 3);

		siete.setNombre("carta siete");

		siete.addAtributo(a, 20);
		siete.addAtributo(b, 20);
		siete.addAtributo(c, 20);

		ocho.setNombre("carta ocho");

		ocho.addAtributo(a, 9);
		ocho.addAtributo(b, 9);
		ocho.addAtributo(c, 9);

		nueve.setNombre("carta nueve");

		nueve.addAtributo(a, 9);
		nueve.addAtributo(b, 9);
		nueve.addAtributo(c, 9);

		diez.setNombre("carta diez");

		diez.addAtributo(a, 15);
		diez.addAtributo(b, 15);
		diez.addAtributo(c, 15);
		
		
		Mazo mazo = new Mazo();
		mazo.addCarta(uno);
		mazo.addCarta(dos);
		mazo.addCarta(tres);
		mazo.addCarta(cuatro);
		mazo.addCarta(cinco);
		mazo.addCarta(seis);
		mazo.addCarta(siete);
		mazo.addCarta(ocho);
		mazo.addCarta(nueve);
		mazo.addCarta(diez);

		
		System.out.println(mazo.toString());

		Mazo nuevo = mazo.getCartas(new EsMayor("Fuerza", 10));
		
		System.out.println(nuevo.toString());
		
		
//		
//				int cantidadCartas = 0;
//		int primero = 0;
//		int segundo = 0;
//		int tercero = 0;
//		int opcion = 0;
//		String nombreMazo = "";
//		String nombreCarta = "";
//		String nombreJ1 = "";
//		String nombreJ2 = "";
//		
//		System.out.println("¿Cuantas cartas tiene el mazo? ");
//		cantidadCartas = obtnerValor();
//		
//		Mazo maso = new Mazo();
//		for (int i=0;i<cantidadCartas;i++) {
//
//			System.out.println("Nombre de la Carta: ");
//			nombreCarta = obtenerNombreCarta();
//				
//			System.out.println("Fuerza: ");
//			primero = obtnerValor();
//			String a = "Fuerza";
//
//			System.out.println("Velocidad: ");
//			segundo = obtnerValor();
//			String b = "Velocidad";
//
//			System.out.println("Mental: ");
//			tercero = obtnerValor();
//			String c = "Mental";
//			
//			Carta nuevaCarta = new Carta ();
//			nuevaCarta.addAtributo(a,primero);
//			nuevaCarta.addAtributo(b,segundo);
//			nuevaCarta.addAtributo(c,tercero);
//			nuevaCarta.setNombre(nombreCarta);
//		
//			
//			maso.addCarta(nuevaCarta);
//		}
//		
//		System.out.println("¿Cual es el nombre del mazo creado? ");
//		nombreMazo = obtenerNombreCarta();
//		maso.setNombreMazo(nombreMazo);
//		
//		System.out.println("Nombre Jugador 1:");
//		nombreJ1 = obtenerNombreCarta();
//		System.out.println("Nombre Jugador 2:");
//		nombreJ2 = obtenerNombreCarta();
//    	JuegoCartas partida;
//    	do {
//    			System.out.println ("Elija el tipo de partida:");
//    			System.out.println ("1.Partida normal");
//    			System.out.println ("2.Partida por turnos");
//    			opcion = obtnerValor();
//    	}while(opcion!=1&&opcion!=2); 
//        switch (opcion) {
//        	case 1: 
//        		partida = new JuegoCartas(nombreJ1,nombreJ2,maso);
//        		partida.jugar();
//        		break;
//        	case 2:
//        		System.out.println ("Cuantos turnos va a durar la partida?");
//        		opcion = obtnerValor();
//        		partida = new JuegoTurnos(nombreJ1,nombreJ2,maso,opcion);
//        		partida.jugar();
//        		break;
//        };
//	}
//	public static String obtenerNombreCarta(){
//		boolean nombreValido;
//		String nombreCarta="";
//		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//
//		do {
//			
//			 try {
//				 nombreCarta = entrada.readLine();
//				 nombreValido=true;
//				}
//					
//			catch (Exception exc) {
//				  System.out.println( exc );
//				  nombreValido=false;
//				  }				
//		}while (!nombreValido || nombreCarta.equals(""));
//		
//		return nombreCarta;
//	}
//	public static int obtnerValor(){
//		boolean valorValido;
//		int valor = 0;
//		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//
//		do {
//			
//			 try {
//				 valor = new Integer(entrada.readLine());
//				 valorValido=true;
//				}
//			 catch (NumberFormatException e){
//					System.out.println("numero invalido");
//					valorValido = false;
//				}	
//			catch (Exception exc) {
//				  System.out.println( exc );
//				  valorValido=false;
//				  }
//		}while (!valorValido || (valor <= 0));
//		
//		return valor;
//
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//		int cantidadCartas = 0;
//		int primero = 0;
//		int segundo = 0;
//		int tercero = 0;
//		int opcion = 0;
//		String nombreMazo = "";
//		String nombreCarta = "";
//		String nombreJ1 = "";
//		String nombreJ2 = "";
//		
//		System.out.println("¿Cuantas cartas tiene el mazo? ");
//		cantidadCartas = obtnerValor();
//		
//		Mazo maso = new Mazo();
//		for (int i=0;i<cantidadCartas;i++) {
//
//			System.out.println("Nombre de la Carta: ");
//			nombreCarta = obtenerNombreCarta();
//				
//			System.out.println("Fuerza: ");
//			primero = obtnerValor();
//			String a = "Fuerza";
//
//			System.out.println("Velocidad: ");
//			segundo = obtnerValor();
//			String b = "Velocidad";
//
//			System.out.println("Mental: ");
//			tercero = obtnerValor();
//			String c = "Mental";
//			
//			Carta nuevaCarta = new Carta ();
//			nuevaCarta.addAtributo(a,primero);
//			nuevaCarta.addAtributo(b,segundo);
//			nuevaCarta.addAtributo(c,tercero);
//			nuevaCarta.setNombre(nombreCarta);
//		
//			
//			maso.addCarta(nuevaCarta);
//		}
//		
//		System.out.println("¿Cual es el nombre del mazo creado? ");
//		nombreMazo = obtenerNombreCarta();
//		maso.setNombreMazo(nombreMazo);
//		
//		System.out.println("Nombre Jugador 1:");
//		nombreJ1 = obtenerNombreCarta();
//		System.out.println("Nombre Jugador 2:");
//		nombreJ2 = obtenerNombreCarta();
//    	JuegoCartas partida;
//    	do {
//    			System.out.println ("Elija el tipo de partida:");
//    			System.out.println ("1.Partida normal");
//    			System.out.println ("2.Partida por turnos");
//    			opcion = obtnerValor();
//    	}while(opcion!=1&&opcion!=2); 
//        switch (opcion) {
//        	case 1: 
//        		partida = new JuegoCartas(nombreJ1,nombreJ2,maso);
//        		partida.jugar();
//        		break;
//        	case 2:
//        		System.out.println ("Cuantos turnos va a durar la partida?");
//        		opcion = obtnerValor();
//        		partida = new JuegoTurnos(nombreJ1,nombreJ2,maso,opcion);
//        		partida.jugar();
//        		break;
//        };
//	}
//	public static String obtenerNombreCarta(){
//		boolean nombreValido;
//		String nombreCarta="";
//		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//
//		do {
//			
//			 try {
//				 nombreCarta = entrada.readLine();
//				 nombreValido=true;
//				}
//					
//			catch (Exception exc) {
//				  System.out.println( exc );
//				  nombreValido=false;
//				  }				
//		}while (!nombreValido || nombreCarta.equals(""));
//		
//		return nombreCarta;
//	}
//	public static int obtnerValor(){
//		boolean valorValido;
//		int valor = 0;
//		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//
//		do {
//			
//			 try {
//				 valor = new Integer(entrada.readLine());
//				 valorValido=true;
//				}
//			 catch (NumberFormatException e){
//					System.out.println("numero invalido");
//					valorValido = false;
//				}	
//			catch (Exception exc) {
//				  System.out.println( exc );
//				  valorValido=false;
//				  }
//		}while (!valorValido || (valor <= 0));
//		
//		return valor;
//	}


