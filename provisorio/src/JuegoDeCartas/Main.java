package JuegoDeCartas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Atributo uno = new Atributo("Fuerza",3);
		Atributo dos = new Atributo("Velocidad",2);
		Atributo tres = new Atributo("Mental",7);
		Atributo cuatro = new Atributo("Fuerza",8);
		Atributo cinco = new Atributo("Velocidad",1);
		Atributo seis = new Atributo("Mental",4);
		Atributo siete = new Atributo("Fuerza",9);
		Atributo ocho = new Atributo("Velocidad",3);
		Atributo nueve = new Atributo("Mental",1);
		Atributo diez = new Atributo("Fuerza",2);
		Atributo once = new Atributo("Velocidad",8);
		Atributo doce = new Atributo("Mental",6);

		
		Carta primera = new Carta3("primera",uno,dos,tres);
		Carta segunda = new Carta3("segunda",cuatro,cinco,seis);
		Carta tercera = new Carta3("tercera",siete,ocho,nueve);
		Carta cuarta = new Carta3("cuarta",diez,once,doce);

		
		Mazo maso = new Mazo();
		maso.addCarta(primera);
		maso.addCarta(segunda);
		maso.addCarta(tercera);
		maso.addCarta(cuarta);

		Juego partida = new Juego("Lucho","Agustin",maso);
		partida.jugar();
	}

}
