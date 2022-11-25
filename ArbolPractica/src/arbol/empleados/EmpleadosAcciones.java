package arbol.empleados;

import javax.swing.JOptionPane;

public class EmpleadosAcciones {
	
	public void addEmpleado() {
		ArbolEmpleados<Empleados> ArbolEmpleados = new ArbolEmpleados<Empleados>();
		
		int idEmpleados = Integer. parseInt(JOptionPane.showInputDialog(null, "Ingresa tu ID: "));
		String nombre = JOptionPane.showInputDialog(null, "Ingresa tu nombre: ");
		String puesto = JOptionPane.showInputDialog(null, "Ingresa tu Puesto: ");
		float sueldo = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingresa tu sueldo: "));
		
		Empleados empleado = new Empleados(idEmpleados, nombre, puesto, sueldo);
		
		ArbolEmpleados.add(empleado);
	}
	
	public void mostrarEmpleados(Empleados empleado) {
		
		System.out.println("El ID es: "+empleado.getId());
		System.out.println("El nombre es: "+empleado.getNombre());
		System.out.println("El puesto es: "+empleado.getPuesto());
		System.out.println("El sueldo es: "+empleado.getSueldo());	
		
	}
}
