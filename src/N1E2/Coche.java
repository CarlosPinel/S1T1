package N1E2;

/*
* Crea una classe "Cotxe" amb els atributs: marca, model i potència. 
* La marca ha de ser estàtic final, el model estàtic i la potència final. 
* Demostra la diferència entre els tres. N’hi ha algun que es pugui inicialitzar al constructor de la classe?
* Afegeix dos mètodes a la classe "Cotxe". Un mètode estàtic anomenat frenar() i un altre no estàtic anomenat accelerar(). 
* El mètode accelerar ha de mostrar per consola: “El vehicle està accelerant” i el mètode frenar() ha de mostrar: “El vehicle està frenant”. 
* Demostra com invocar el mètode estàtic i el no estàtic des del main() de la classe principal.
*/

public class Coche {

	// Attribute
	private static final String marca = "Ford";
	private static String modelo;
	private final int potencia;

	// Constructor
	public Coche() {
		this.potencia = 125;
	};
	public Coche(String modelo, int potencia) {
		Coche.modelo = modelo;
		this.potencia = potencia;
		
		/*
		 * el static final no permite recibirlo por parametro del constructor, ya que no
		 * tiene sentido que cada vez que instancies un objeto tengas que introducir el
		 * mismo valor de parametro al ser final (no lo puedes modificar) y static a la vez (se cambiará en todos los objetos) 
		 * En este ejemplo sería poner el parametro "Ford" cada vez que crees un objeto. 
		 * Si tiene sentido poder recibir el parametro de potencia (ya que puede ser
		 * diferente en cada objeto, aunque luego no puedas sobreescribirlo) Si tiene
		 * sentido poder recibir el paramentro de modelo (aunque sea igual en todos los
		 * objetos) por si quisieras modificarlo en todos los objetos a través del
		 * constructor de un objeto.
		 */
	}

	// getters/setters (no habrá setters de los finals al no poderse modificar)
	public static String getModelo() {
		return modelo;
	}

	public static void setModelo(String modelo) {
		Coche.modelo = modelo;
	}

	public static String getMarca() {
		return marca;
	}

	public int getPotencia() {
		return potencia;
	}

	// General Methods
	static public String acelerar() {
		return "El vehiculo está acelerando.";
	}

	public String frenar() {
		return "El vehiculo está frenando.";
	}

	@Override
	public String toString() {
		return "Coche " + Coche.marca + " modelo " + Coche.modelo + " con potencia de " + this.potencia + " CV.";
	}

}
