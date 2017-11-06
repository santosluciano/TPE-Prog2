
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;




public class LectorCartas {
	
	
	int mazosLeidos;
	
	private static final String ELEMENTS_SEPARATOR = ",";
	private static final String ATTRIBUTES_SEPARATOR = "|";
	private static final String ATTRIBUTE_VALUE_SEPARATOR = "=";

	public static final String NOMBRE= "Nombre"; //SABER COMO LEER el unico atributo distinto
	
	
	/**
	 * Recibe un String, el cual contiene la informacion de una carta
	 * @param La carta en un Sctrin
	 * @return Tabla de hash con la carta
	 */
	private  Hashtable transformarCarta (String l) {
		//Ejemplo: "Card_0,Valentía=1.0|Liderazgo=8.0|Ternura=48.0"
		String[] split_lvl1 = l.split(ELEMENTS_SEPARATOR); //Result: [ "Card_0", "Valentía=1.0|Liderazgo=8.0|Ternura=48.0" ]

		if (split_lvl1.length == 0)
			return null; //error

		Hashtable carta = new Hashtable();
		
		carta.put(NOMBRE, split_lvl1[0]);  //GUARDO EL NOMBRE
		
		
		//Resto de la carta
		StringTokenizer t = new StringTokenizer(split_lvl1[1], ATTRIBUTES_SEPARATOR); //Result: [ "Valentía=1.0", "Liderazgo=8.0", "Ternura=48.0" ]

		while (t.hasMoreTokens()) {
			String token = t.nextToken(); //
			String attName = token.split(ATTRIBUTE_VALUE_SEPARATOR)[0]; //Ex: token="Valentía=1.0" => attPair.split("=")[0] = "Valentía"
			String attValue = token.split(ATTRIBUTE_VALUE_SEPARATOR)[1]; //Ex: token="Valentía=1.0" => attPair.split("=")[1] = "1.0"
			
			carta.put(attName, Double.valueOf(attValue)); //Guardo el Atributo Leido
		
		}

		return carta;
	}


	public  Vector<Hashtable> leerMazo (String folderPath, String fileName){
		Vector<Hashtable> mazo = new Vector<Hashtable>();
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			//  Archivo
			file = new File (folderPath+"\\"+fileName);
			fr = new FileReader (file);
			br = new BufferedReader(fr);

			// Reads the file, cada Linea es una carta
			String line;
			while((line=br.readLine())!=null){
				mazo.add(transformarCarta(line)); //agrega una carta al mazo
			}
            // TODO OK
			mazosLeidos++;
		}
		catch(IOException e){
			 e.printStackTrace();
		}finally{
			//Close the file
			try{                    
				if(fr != null ){   
					fr.close();     
				}                  
			}catch (IOException e){ 
				e.printStackTrace();
			}
		}
		return mazo;
	}
	
	
	public LectorCartas(){
		
		mazosLeidos = 0;
		
	}
	
	
	
	public static void main(String[] args){
		
		LectorCartas lector = new LectorCartas();
		
		String carpeta = "C://Cartas";
		String mazoC1 = "minions.txt";
		Vector<Hashtable> mazo1 = lector.leerMazo(carpeta, mazoC1);
	
		System.out.println("MAZO: "+ mazoC1 + " en: " + carpeta);
		for (int i = 0; i< mazo1.size(); i++){
			Hashtable carta = mazo1.elementAt(i);
			
			System.out.println("Carta : " + carta.get(LectorCartas.NOMBRE));
		
			Iterator it= carta.keySet().iterator();
			
			while (it.hasNext()){
				String key = (String) it.next();
				
				if (!key.equals(LectorCartas.NOMBRE)){ // OJO Nombre No queremos mostrarlo
					System.out.println(" Atributo: "+ key + "\t\tvalor: " + carta.get(key));
				}
				
			}
			
           System.out.println("---------------------------------");			
		}
			
	}
	
	
	public int getCantidadMazosLeidos(){
		return mazosLeidos;
	}
}
