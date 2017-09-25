import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main { //modifique y puse la clase "Main" con "M" en mayuscula...
				   // Desaparecio un error que me aparecia con el public static void main...

	public static void main(String[] args) {
		int cantidadCartasMazo = 0;
		int cantidadAtributos = 0;
		int ValorDelAtributo = 0;

		String nombreAtributo = "";
		
//		int Atributo = 0;
//		int segundo = 0;
//		int tercero = 0;
		boolean nombreValido;
		boolean valorValido;
		String nombreCarta = "";
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			
			 try {
				System.out.println("Cuantas cartas tiene el mazo? ");
				cantidadCartasMazo = new Integer(entrada.readLine());
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
		}while (!valorValido || (cantidadCartasMazo <= 0));
		do {
			
			 try {
				System.out.println("Cuantos atributos tienen las cartas? ");
				cantidadAtributos = new Integer(entrada.readLine());
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
		}while (!valorValido || (cantidadAtributos <= 0));
		
		for (int a=0; a<cantidadAtributos; a++) {
			do {
				
				 try {
					 System.out.println("Nombre del atributo: " + (a+1));
					 nombreAtributo = entrada.readLine();
					 nombreValido=true;
					}
						
				catch (Exception exc) {
					  System.out.println( exc );
					  nombreValido=false;
					  }
					
			}while (!nombreValido || nombreAtributo.equals(""));
		
		}
		
		Mazo maso = new Mazo();
		for (int i=0;i<cantidadCartasMazo;i++) {
			Carta nuevaCarta = new Carta (cantidadAtributos);
	
			do {
					
				 try {
					 System.out.println("Nombre de la Carta: ");
					 nombreCarta = entrada.readLine();
					 nombreValido=true;
					}
						
				catch (Exception exc) {
					  System.out.println( exc );
					  nombreValido=false;
					  }
					
			}while (!nombreValido || nombreCarta.equals(""));
				
			nuevaCarta.setNombre(nombreCarta);

			
			for (int j=0; j<cantidadAtributos; j++) {
				
				do {
			
					 try {
						 System.out.println("Valor del atributo " + nombreAtributo);
						 ValorDelAtributo = new Integer(entrada.readLine());
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
				}while (!valorValido || (ValorDelAtributo <= 0));
				
			
				Atributo nuevoAtributo = new Atributo(nombreAtributo, ValorDelAtributo);
				nuevaCarta.addAtributo(nuevoAtributo);
			}
								
			maso.addCarta(nuevaCarta);
		}
		Juego partida = new Juego("Lucho","Agu",maso);
		partida.jugar();
	
	}
}



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