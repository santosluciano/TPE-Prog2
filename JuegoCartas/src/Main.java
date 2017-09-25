import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main { //modifique y puse la clase "Main" con "M" en mayuscula...
				   // Desaparecio un error que me aparecia con el public static void main...

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
			
			Carta nuevaCarta = new Carta (3);
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
		Juego partida = new Juego("Lucho","Agu",maso);
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

//intente poner un switch para no repetir codigo en la iniciacion de variables pero no me funciono





//for (int h=0;h<3;h++){
//	
//	do {
//		
//		 try {
//			 
//			 switch(h){
//			 
//			 case 0 : System.out.println("Fuerza: ");
//			 			primero = new Integer(entrada.readLine());
//
//			 case 1 : System.out.println("Velocidad: ");
//			 			segundo = new Integer(entrada.readLine());
//			 case 2 : System.out.println("Mental: ");
//			 			tercero= new Integer(entrada.readLine());
//			 }
//	
//			 valorValido=true;
//			}
//		 catch (NumberFormatException e){
//				System.out.println("numero invalido");
//				valorValido = false;
//			}	
//		catch (Exception exc) {
//			  System.out.println( exc );
//			  valorValido=false;
//			  }
//	}while (!valorValido || (primero <= 0) ||(segundo <= 0)||(tercero <= 0));
//	
//}



//Version 1


//int opcion = 0;
//int primero = 0;
//int segundo = 0;
//int tercero = 0;
//boolean nombreValido;
//boolean valorValido;
//String nombre = "";
//
//BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//
//do {
//	
//	 try {
//		System.out.println("Cuantas cartas tiene el mazo? ");
//		opcion = new Integer(entrada.readLine());
//		 valorValido=true;
//		}
//	 catch (NumberFormatException e){
//			System.out.println("numero invalido");
//			valorValido = false;
//		}
//			
//	catch (Exception exc) {
//		  System.out.println( exc );
//		  valorValido=false;
//		  }
//}while (!valorValido || (opcion <= 0));
//
//
//
//
//
//Mazo maso = new Mazo();
//for (int i=0;i<opcion;i++) {
//	
//	
//
//	do {
//			
//		 try {
//			 System.out.println("Nombre: ");
//			 nombre = entrada.readLine();
//			 nombreValido=true;
//			}
//				
//		catch (Exception exc) {
//			  System.out.println( exc );
//			  nombreValido=false;
//			  }
//			
//	}while (!nombreValido || nombre.equals(""));
//		
//	do {
//		
//		 try {
//			 System.out.println("Fuerza: ");
//			 primero = new Integer(entrada.readLine());
//			 valorValido=true;
//			}
//		 catch (NumberFormatException e){
//				System.out.println("numero invalido");
//				valorValido = false;
//			}	
//		catch (Exception exc) {
//			  System.out.println( exc );
//			  valorValido=false;
//			  }
//	}while (!valorValido || (primero <= 0));
//	
//	do {
//		
//		 try {
//			 System.out.println("Velocidad: ");
//			segundo = new Integer(entrada.readLine());
//			 valorValido=true;
//			}
//		 catch (NumberFormatException e){
//				System.out.println("numero invalido");
//				valorValido = false;
//			}
//				
//		catch (Exception exc) {
//			  System.out.println( exc );
//			  valorValido=false;
//			  }
//	}while (!valorValido || (segundo <= 0));
//	
//	do {
//		
//		 try {
//			 System.out.println("Mental: ");
//			tercero = new Integer(entrada.readLine());
//			 valorValido=true;
//			}
//		 catch (NumberFormatException e){
//				System.out.println("numero invalido");
//				valorValido = false;
//			}	
//		catch (Exception exc) {
//			  System.out.println( exc );
//			  valorValido=false;
//			  }
//	}while (!valorValido || (tercero <= 0));
//
//			
//	
//	Atributo a = new Atributo("Fuerza",primero);
//	Atributo b = new Atributo("Velocidad",segundo);
//	Atributo c = new Atributo("Mental",tercero);
//	Carta nuevaCarta = new Carta (nombre, 3);
//	nuevaCarta.addAtributo(a);
//	nuevaCarta.addAtributo(b);
//	nuevaCarta.addAtributo(c);
//
//	
//	maso.addCarta(nuevaCarta);
//}
//Juego partida = new Juego("Lucho","Agu",maso);
//partida.jugar();







///                           Version 2
//





//
//int cantidadCartasMazo = 0;
//int cantidadAtributos = 0;
//int ValorDelAtributo = 0;
//
//String nombreAtributo = "";
//
//
//
//boolean nombreValido;
//boolean valorValido;
//String nombreCarta = "";
//
//BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//
//do {
//	
//	 try {
//		System.out.println("Cuantas cartas tiene el mazo? ");
//		cantidadCartasMazo = new Integer(entrada.readLine());
//		 valorValido=true;
//		}
//	 catch (NumberFormatException e){
//			System.out.println("numero invalido");
//			valorValido = false;
//		}
//			
//	catch (Exception exc) {
//		  System.out.println( exc );
//		  valorValido=false;
//		  }
//}while (!valorValido || (cantidadCartasMazo <= 0));
//
//Mazo maso = new Mazo();
//
//do {
//	
//	 try {
//		System.out.println("Cuantos atributos tienen las cartas? ");
//		System.out.println("Elija un valor entre 3 y 6");
//
//		cantidadAtributos = new Integer(entrada.readLine());
//		 valorValido=true;
//		}
//	 catch (NumberFormatException e){
//			System.out.println("numero invalido");
//			valorValido = false;
//		}
//			
//	catch (Exception exc) {
//		  System.out.println( exc );
//		  valorValido=false;
//		  }
//}while (!valorValido || (cantidadAtributos < 3)|| (cantidadAtributos > 6));
//
//
//for (int i=0;i<cantidadCartasMazo;i++) {
//	Carta nuevaCarta = new Carta (cantidadAtributos);
//
//	do {
//			
//		 try {
//			 System.out.println("Nombre de la Carta: ");
//			 nombreCarta = entrada.readLine();
//			 nombreValido=true;
//			}
//				
//		catch (Exception exc) {
//			  System.out.println( exc );
//			  nombreValido=false;
//			  }
//			
//	}while (!nombreValido || nombreCarta.equals(""));
//		
//	nuevaCarta.setNombre(nombreCarta);
//
//	
//	for (int j=0; j<cantidadAtributos; j++) {
//		do {
//			
//			 try {
//				 System.out.println("Nombre del atributo " + (j+1)+":");
//				 nombreAtributo = entrada.readLine();
//				 nombreValido=true;
//				}
//					
//			catch (Exception exc) {
//				  System.out.println( exc );
//				  nombreValido=false;
//				  }
//				
//		}while (!nombreValido || nombreAtributo.equals(""));
//		
//		do {
//	
//			 try {
//				 System.out.println("Valor del atributo " + nombreAtributo);
//				 ValorDelAtributo = new Integer(entrada.readLine());
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
//		}while (!valorValido || (ValorDelAtributo <= 0));
//		
//	
//		Atributo nuevoAtributo = new Atributo(nombreAtributo, ValorDelAtributo);
//		nuevaCarta.addAtributo(nuevoAtributo);
//		
//	}
//	maso.addCarta(nuevaCarta);
//	
////	System.out.println("La carta tiene: ");
////	System.out.println("Nombre: " + nuevaCarta.getNombre());
////	
////	nuevaCarta.imprimirAtributos();
//
//
//}
//
//
//maso.imprimirTodoelMazo();
//
//Juego partida = new Juego("Lucho","Agu",maso);
//partida.jugar();
//
//}
//}




//                          version 3


//Atributo[] atributos = {
//new Atributo("Fuerza", 9),
//new Atributo("Velocidad", 10),
//new Atributo("mental", 2)			
//};
//
//Mazo nuevoMazo = new Mazo();
//
//Carta[] cartas = {
//new Carta (3),
//new Carta (3),
//new Carta (3),
//};
//
//for (int i = 0; i<cartas.length;i++) {
//
//cartas[i].setNombre("Carta numero " + (i+1));
//
//
//for (int j=0; j < atributos.length; j++) {
//
//cartas[i].addAtributo(atributos[j]);
//int nuevoValor = (int)(Math.random()*9+1);
//cartas[i].getAtributo(j).setValor(nuevoValor);
//}
//
//
//nuevoMazo.addCarta(cartas[i]);
//}
//
//
//nuevoMazo.imprimirTodoelMazo();
//
//Juego partida = new Juego("Lucho","Agu",nuevoMazo);
//partida.jugar();
//
//