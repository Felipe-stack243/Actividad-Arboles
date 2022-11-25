package arbol.empleados;

public class Empleados {

	private int idEmpleado;
	private String nombre;
	private String puesto;
	private float sueldo;
	
	public Empleados(int idEmpleado, String nombre, String puesto, float sueldo ) {
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.puesto = puesto;
		this.sueldo = sueldo;
	}

	public int getId() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	
}
