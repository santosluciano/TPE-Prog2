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
				System.out.println ("4.Filtrar Mazo");
				System.out.println ("5.Ver cartas de un mazo");
				System.out.println ("6.Salir del juego");
				opcion = obtnerValor();
			}while(opcion<1||opcion>5); 
	
			switch (opcion) {
			case 1: 
				System.out.println ("¿¿Con que mazo quieres jugar??");
				mazo = getMazo(mazos);
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
				mazo = getMazo(mazos);
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
				int valor = 0;
				Filtro filtro;
				Mazo mazoFiltrado;
				System.out.println ("¿Que mazo quieres filtrar?");
				mazo = getMazo(mazos);
				System.out.println ("¿Que filtro queres aplicar?");
				System.out.println ("opcion 1: simple");
				System.out.println ("opcion 2: compuesto");
				do {
					valor = obtnerValor();
				} while (valor < 1 && valor >2);
				getAtributos(mazo);

				if (valor == 1) {				
					System.out.println ("¿Que filtro seleccionas?");
					filtro = getFiltroSimple(mazo);
					mazoFiltrado = mazo.getCartas(filtro);
					mazoFiltrado.setNombreMazo(mazo.getNombreMazo()+ "-Con filtro Simple");
				}
				else{
					filtro = getFiltroCompuesto(mazo);
					mazoFiltrado = mazo.getCartas(filtro);
					mazoFiltrado.setNombreMazo(mazo.getNombreMazo()+ "-Con filtro Compuesto");
				}
				
				if (mazoFiltrado.vacio()){
					System.out.println("El filtro no se puede ejecutar");
				}
				else{
					mazos.add(mazoFiltrado);
				}
				break;
			case 5:
				mazo = getMazo(mazos);
				imprimirMazo(mazo);
				break;
			case 6:
				System.out.println ("Gracias por jugar");
				break;
			};
				volverMenu = volverMenu();
     	} while (volverMenu.equals("y"));
		System.out.println("Gracias por jugar");
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
			if (!nombreMazo.equals("minions") && !nombreMazo.equals("transformers") && !nombreMazo.equals("Mix2") && !nombreMazo.equals("Mix1")) {
				System.out.println("Mazo no encontrado: ");
				System.out.println("Los mazos disponibles son: ");
				System.out.println("minions");
				System.out.println("transformers");
				System.out.println("Mix1");
				System.out.println("Mix2");
				valido = false;
			}
			else if (nombreMazo.equals("minions") || nombreMazo.equals("transformers") || nombreMazo.equals("Mix2") || nombreMazo.equals("Mix1")){
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
	
	public static Filtro getFiltroSimple(Mazo mazo){
		Filtro filtroSimple;
		int opcionFiltro;
		String atributo;
		int valorAtributo;
				System.out.println ("opcion 1: mayor");
				System.out.println ("opcion 2: menor");
				System.out.println ("opcion 3: igual");
				do {
					opcionFiltro = obtnerValor();
				} while (opcionFiltro < 1 && opcionFiltro >3);
				System.out.println ("Ingrese nombre de atributo");
				atributo = obtenerNombre();
				System.out.println ("Ingrese Valor");
				valorAtributo = obtnerValor();
				if (opcionFiltro == 1) {		
					filtroSimple = new EsMayor(atributo, valorAtributo);
				}
				else if(opcionFiltro ==2){
					filtroSimple = new EsMenor(atributo, valorAtributo);
				}
				else{
					filtroSimple = new EsIgual(atributo, valorAtributo);
				}
		return filtroSimple;
	}
	
	public static Filtro getFiltroCompuesto(Mazo mazo) {
		Filtro filtroCompuesto;
		System.out.println ("Seleccione filtro 1");

		Filtro filtroUno = getFiltroSimple(mazo);
		System.out.println ("Seleccione filtro 2");

		Filtro filtroDos = getFiltroSimple(mazo);
		int opcionFiltro;
		System.out.println ("Seleccione comparador Logico");
		System.out.println ("opcion 1: AND");
		System.out.println ("opcion 2: OR");
		do {
			opcionFiltro = obtnerValor();
		} while (opcionFiltro < 1 && opcionFiltro >2);
		if(opcionFiltro == 1) {
			filtroCompuesto = new AND(filtroUno, filtroDos);
		}
		else {
			filtroCompuesto = new OR(filtroUno, filtroDos);
		}
		return filtroCompuesto;
	}
	
	public static Mazo getMazo(List <Mazo> mazos){
		int posicionMazo;
		Mazo mazo;
		System.out.println ("ingrese Valor numerico");
		getNombreMazo(mazos);
		do {
			posicionMazo = obtnerValor();
		} while (posicionMazo <=0 && posicionMazo >mazos.size());
		mazo = mazos.get(posicionMazo-1);
		return mazo;
	}
	
	public static void getAtributos(Mazo mazo){
		System.out.println("Carta de Ejemplo: ");
		System.out.println(mazo.tomarPrimera().toString());
	}
	
	public static void imprimirMazo(Mazo mazo){
		System.out.println(mazo.toString());
	}
}