import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class Juego { 

	
	public static void main(String[] args) {

			List <Mazo> mazos = new ArrayList<Mazo>(); 
			int opcion;
			
			
			
			
			

			do {
				System.out.println ("1.Partida normal");
				System.out.println ("2.Partida por turnos");
				System.out.println ("3.Cargar mazo");
				System.out.println ("4.Salir del juego");

				opcion = obtnerValor();
			}while(opcion<=0||opcion>=5); 
			
			
			switch (opcion) {
			case 1: 
				
				break;
			case 2:

				break;
			case 3:
				mazos.addAll(cargarMazo());				
				break;
			case 4:
				System.out.println ("Gracias por jugar");
				break;
			};
			
			for(Mazo mazo:mazos) {
				System.out.println(mazo.toString());
				System.out.println("!!!!!!!!!!!!!!!!!!");				
			}
			
			
			

			//JuegoTurnos partida = new JuegoTurnos("lucho","agustin",nuevoMazo,10);
			//partida.jugar();
			
//			Filtro mayor = new EsMayor("Ternura",95);
//			Filtro menor = new EsMenor("Liderazgo", 40);
//			Filtro compuesto = new OR(mayor,menor);
//			Mazo mazoFiltrado = nuevoMazo.getCartas(compuesto);
//			System.out.println(mazoFiltrado.toString());
		}
	
	public static List<Mazo> cargarMazo() {
		List <Mazo> mazos = new ArrayList<Mazo>();
		String carpeta = "/home/lucho/Documentos/TPE-Prog2/JuegoCartas/cartas";
		System.out.print("Ingrese el nombre del archivo con los datos del mazo: ");
		String nombreMazo = obtenerNombre();//"minions.txt";
		String mazoC1 = nombreMazo+".txt";
		LectorCartas lector = new LectorCartas();
		Vector<Hashtable> mazo1 = lector.leerMazo(carpeta, mazoC1);
		//String[] nombreMazo = mazoC1.split(".");
		// System.out.println(mazoC1);	
		Mazo nuevoMazo = new Mazo();
		nuevoMazo.setNombreMazo(nombreMazo);
		mazos.add(nuevoMazo);		
		System.out.println("MAZO: " +mazoC1  +" en: " + carpeta);
		for (int i = 0; i< mazo1.size(); i++){
			Hashtable carta = mazo1.elementAt(i);
			Carta nuevaCarta = new Carta();
			nuevaCarta.setNombre((String)carta.get(LectorCartas.NOMBRE));

			Iterator it= carta.keySet().iterator();
			
			while (it.hasNext()){
				String key = (String) it.next();
				
				if (!key.equals(LectorCartas.NOMBRE)){
					nuevaCarta.addAtributo(key, (Double) carta.get(key));
				}
				
			}
			int j = 0;
			boolean cargo = false;
			while(j<mazos.size()&&!cargo) {
				cargo = mazos.get(j).addCarta(nuevaCarta);
				j++;
			}
			if (!cargo) {
				mazos.add(new Mazo());
				mazos.get(j).addCarta(nuevaCarta);
				mazos.get(j).setNombreMazo(nombreMazo+"-"+j);
			}
		}
		return mazos;
	}
	
	 	public static String obtenerNombre(){
	 		boolean nombreValido;
	 		String nombre="";
	 		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	 
	 		do {
	 			
	 			 try {
	 				 nombre = entrada.readLine();
	 				 nombreValido=true;
	 				}
	 					
	 			catch (Exception exc) {
	 				  System.out.println( exc );
	 				  nombreValido=false;
	 				  }				
	 		}while (!nombreValido || nombre.equals(""));
	 		
	 		return nombre;
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
	 		}while (!valorValido);
	 		
	 		return valor;
	 	}
	
	
	
	
		//int cantidadCartas = 0;
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
	 //		for (int i=0;i<cantidadCartas;i) {
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

}
		



