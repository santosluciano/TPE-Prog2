
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Atributo uno = new Atributo("Fuerza",3);
		Atributo dos = new Atributo("Velocidad",5);
		Atributo tres = new Atributo("Mental",8);
		Carta carta1 = new Carta3("guachin",uno,dos,tres);
		uno.setValor(8);
		dos.setValor(3);
		tres.setValor(2);
		Carta carta2 = new Carta3("amego",uno,dos,tres);
		uno.setValor(7);
		dos.setValor(5);
		tres.setValor(4);
		Carta carta3 = new Carta3("yuta",uno,dos,tres);
		uno.setValor(8);
		dos.setValor(9);
		tres.setValor(1);
		Carta carta4 = new Carta3("rati",uno,dos,tres);
		Mazo villero = new Mazo();
		villero.addCarta(carta1);
		villero.addCarta(carta2);
		villero.addCarta(carta3);
		villero.addCarta(carta4);
		Juego partida = new Juego("lucho","agustin");
		partida.jugar();
	}

}
