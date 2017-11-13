import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class Juego { 


	public static void main(String[] args) {

		List <Mazo> mazos = new ArrayList<Mazo>(); 
		int opcion;
		int mazoSeleccionado;
		String nombreJ1;
		String nombreJ2;
		String volverMenu = "";
		Mazo mazo;
     	JuegoCartas partida;
     	
     	do {


			do {
				System.out.println ("1.Partida normal");
				System.out.println ("2.Partida por turnos");
				System.out.println ("3.Cargar mazo");
				System.out.println ("4.Salir del juego");
	
				opcion = obtnerValor();
			}while(opcion<1||opcion>4); 
	
	
			switch (opcion) {
			case 1: 
				 
				System.out.println ("¿¿Con que mazo quieres jugar??");
				System.out.println ("ingrese Valor numerico");
	
				getNombreMazo(mazos);
				
				do {
					mazoSeleccionado = obtnerValor();
				} while (mazoSeleccionado <=0 && mazoSeleccionado >mazos.size());
				
				mazo = mazos.get(mazoSeleccionado-1);
				
				System.out.println ("ingrese Nombre de los jugadores");
				System.out.print ("Nombre de Jugador 1: ");
				nombreJ1 = obtenerNombre();
				
				System.out.print ("Nombre de Jugador 2: ");
				nombreJ2 = obtenerNombre();
	
				
				partida = new JuegoCartas(nombreJ1,nombreJ2,mazo);
	     		partida.jugar();
				break;
			case 2:
				System.out.println ("¿¿Con que mazo quieres jugar??");
				System.out.println ("ingrese Valor numerico");
	
				getNombreMazo(mazos);
				
				do {
					mazoSeleccionado = obtnerValor();
				} while (mazoSeleccionado <=0 && mazoSeleccionado >mazos.size());
				
				mazo = mazos.get(mazoSeleccionado-1);
				
				System.out.println ("ingrese Nombre de los jugadores");
				System.out.print ("Nombre de Jugador 1: ");
				nombreJ1 = obtenerNombre();
				
				System.out.print ("Nombre de Jugador 2: ");
				nombreJ2 = obtenerNombre();
				
	        	System.out.println ("Cuantos turnos va a durar la partida?");
	     		opcion = obtnerValor();
	     		partida = new JuegoTurnos(nombreJ1,nombreJ2,mazo,opcion);
	     		partida.jugar();;
	     		break;
			case 3:
				mazos.addAll(cargarMazo());	
				
				for (Mazo mazoIterado : mazos) {
					if(mazoIterado.vacio()) {
						mazos.remove(mazoIterado);
					}
				}
				break;
			case 4:
				System.out.println ("Gracias por jugar");
				break;
			};
			
				volverMenu = volverMenu();
			
     	} while (volverMenu.equals("y"));
     	
     	
		System.out.println("Gracias por jugar");

     	
//		for(Mazo seleccionMazo:mazos) {
//			System.out.println(seleccionMazo.toString());
//			System.out.println("!!!!!!!!!!!!!!!!!!");				
//		}




		//JuegoTurnos partida = new JuegoTurnos("lucho","agustin",nuevoMazo,10);
		//partida.jugar();

		//			Filtro mayor = new EsMayor("Ternura",95);
		//			Filtro menor = new EsMenor("Liderazgo", 40);
		//			Filtro compuesto = new OR(mayor,menor);
		//			Mazo mazoFiltrado = nuevoMazo.getCartas(compuesto);
		//			System.out.println(mazoFiltrado.toString());
		
	}
	
	public static String volverMenu(){
		String opcion = "";
		
		do  {
			System.out.println("¿Quieres volver al menu? ingrese y/n");
			opcion = obtenerNombre();
		}while ((!opcion.equals("n")) && (!opcion.equals("y")));
		
		return opcion;
	}
	
	public static void getNombreMazo(List <Mazo> mazos){
		
			for (int i = 0; i < mazos.size(); i++) {
				System.out.println("opcion "+ (i+1) + ": " + mazos.get(i).getNombreMazo());
			}
	}

	public static List<Mazo> cargarMazo() {
		List <Mazo> mazos = new ArrayList<Mazo>();
		//String carpeta = "/home/lucho/Documentos/TPE-Prog2/JuegoCartas/cartas"; //computadora lucho
		String carpeta = "C://Cartas/"; // coputadora agustin
		String nombreMazo="";
		boolean valido=true;;
		
		do {
			System.out.println("Ingrese el nombre del archivo con los datos del mazo: ");

			nombreMazo = obtenerNombre();//"minions.txt";
			
			if (!nombreMazo.equals("minions") && !nombreMazo.equals("minions") && !nombreMazo.equals("Mix2") && !nombreMazo.equals("Mix1")) {
				System.out.println("Mazo no encontrado: ");
				valido = false;
			}
			else if (nombreMazo.equals("minions") || nombreMazo.equals("minions") || nombreMazo.equals("Mix2") || nombreMazo.equals("Mix1")){
				valido = true;
			}

		} while (!valido);
		
		
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
	

}
		



