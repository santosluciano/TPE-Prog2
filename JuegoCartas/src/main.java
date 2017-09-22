import java.io.BufferedReader;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion = 0;
		int primero = 0;
		int segundo = 0;
		int tercero = 0;
		boolean nombreValido;
		boolean valorValido;
		String nombre = "";
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			
			 try {
				System.out.println("Cuantas cartas tiene el mazo? ");
				opcion = new Integer(entrada.readLine());
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
		}while (!valorValido || (opcion <= 0));
		
		
		
		
		
		Mazo maso = new Mazo();
		for (int i=0;i<opcion;i++) {
			
			
		
			do {
					
				 try {
					 System.out.println("Nombre: ");
					 nombre = entrada.readLine();
					 nombreValido=true;
					}
						
				catch (Exception exc) {
					  System.out.println( exc );
					  nombreValido=false;
					  }
					
			}while (!nombreValido || nombre.equals(""));
				
			do {
				
				 try {
					 System.out.println("Fuerza: ");
					 primero = new Integer(entrada.readLine());
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
			}while (!valorValido || (primero <= 0));
			
			do {
				
				 try {
					 System.out.println("Velocidad: ");
					segundo = new Integer(entrada.readLine());
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
			}while (!valorValido || (segundo <= 0));
			
			do {
				
				 try {
					 System.out.println("Mental: ");
					tercero = new Integer(entrada.readLine());
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
			}while (!valorValido || (tercero <= 0));

					
			
			Atributo a = new Atributo("Fuerza",primero);
			Atributo b = new Atributo("Velocidad",segundo);
			Atributo c = new Atributo("Mental",tercero);
			maso.addCarta(new Carta3(nombre,a,b,c));
		}
		Juego partida = new Juego("lucho","pc",maso);
		partida.jugar();
	
	}
}
