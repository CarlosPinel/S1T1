package N2E1;

/*
* Crea una classe anomenada "Telèfon" amb els atributs marca i model, i el mètode trucar(). 
* Aquest mètode ha de rebre un String amb un número de telèfon. 
* El mètode ha de mostrar per consola un missatge dient que s’està trucant al número rebut per paràmetre. 
* Crea una interfície anomenada "Camera" amb el mètode fotografiar(), i una altra interfície anomenada Rellotge amb el mètode alarma().
* Crea una classe anomenada "Smartphone" que sigui subclasse de "Telèfon" i que a la vegada implementi les interfícies "Camera" i "Rellotge".
* El mètode fotografiar() ha de mostrar per consola: “S’està fent una foto” i el mètode alarma() ha de mostrar: “Està sonant l’alarma”.
* Des del main() de l’aplicació, crea un objecte Smartphone i crida als mètodes anteriors.
*/

public class Main {


	public static void main(String[] args) {
		//Data
		String result = "";
		String numTelef = "659675451";
		
		//Object
		Smartphone smartphone1 = new Smartphone("Google Pixel", "4a");
		
		//Methods
		result = smartphone1.llamar(numTelef);
		System.out.println(result);
		result = smartphone1.fotografiar();
		System.out.println(result);
		result = smartphone1.alarma();
		System.out.println(result);
	}
}
