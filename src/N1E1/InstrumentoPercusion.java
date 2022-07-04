package N1E1;

public class InstrumentoPercusion extends Instrumento {

//	Constructor
	public InstrumentoPercusion() { super(); }
	public InstrumentoPercusion(String nombre, double precio) {
		super(nombre, precio);
	}
	
//	Methods generals
	public String tocar() {
		return "Está sonando un instrumento de percusión";
	}
	
	@Override
	public String toString() {
		return "Instrumento [nombre=" + super.getNombre() + ", precio=" + super.getPrecio() + "]";
	}
}

