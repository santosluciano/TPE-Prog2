
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Atributo uno = new Atributo("Fuerza",3);
		Atributo dos = new Atributo("Velocidad",2);
		Atributo tres = new Atributo("Mental",7);
		Atributo cuatro = new Atributo("Fuerza",8);
		Atributo cinco = new Atributo("Velocidad",1);
		Atributo seis = new Atributo("Mental",4);
		Carta primera = new Carta3("primera",uno,dos,tres);
		Carta segunda = new Carta3("segunda",cuatro,cinco,seis);
		Mazo maso = new Mazo();
		maso.addCarta(primera);
		maso.addCarta(segunda);
		Juego partida = new Juego("lucho","pc",maso);
		partida.jugar();
		maso.vaciarMazo();
		partida.jugar();
		Mazo nuevoMazo = new Mazo();
		nuevoMazo.addCarta(primera);
		nuevoMazo.addCarta(segunda);
		partida.cambiarMazo(nuevoMazo);
		partida.jugar();
	}

}
