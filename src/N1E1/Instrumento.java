package N1E1;

public abstract class Instrumento {

//	Bloque de inicializacion estatico (se llama UNA vez cuando la clase se inicializa)
	static {
		System.out.println("Vamos a crear un grupo de música");		
	}
//	Boque de inicializacion no-estatico (se llama cada vez que se instancia un objeto)
	{
		System.out.println("El instrumento está preparado para tocar.");
	}
	
//	Attributes
	private String nombre;
	private double precio;

//	Constructor
	public Instrumento() {
	}

	public Instrumento(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

//	Setters/Getters
	public String getNombre() {
		return this.nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

//	Methods generals
	abstract public String tocar();
	
	static public String dejarDeTocar() {
		return "El instrumento deja de sonar";
	}
	//es un metodo de prueba para ver el funcionamiento del bloque de inicializacion estatico y no-estatico.

	@Override
	public String toString() {
		return "Instrumento [nombre=" + this.nombre + ", precio=" + this.precio + "]";
	}
}
