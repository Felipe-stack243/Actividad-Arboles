package arbol.empleados;

public class ArbolEmpleados<E> {
private NodoArbol<E> raiz;
	
	public ArbolEmpleados() {
		raiz=null;
	}
	
	public void add(E item) {
		raiz=add(raiz,item);
	}
	
	public NodoArbol<E> add(NodoArbol<E> raux,E item){
		if(raux==null)
			return new NodoArbol<E>(item);
		Comparable citem=(Comparable)item;
		Comparable ritem=(Comparable)raux.getItem();
		if(citem.compareTo(ritem)<0)
				raux.setIzq(add(raux.getIzq(),item));
		else if(citem.compareTo(ritem)>0)
			     raux.setDer(add(raux.getDer(),item));
		return raux;     
	}
	
	//Te da la altura del arbol
	public int altura() {
		return altura(raiz);
	}
	
	private int altura(NodoArbol<E> raux) {
		if(raux==null)
			return 0;
		int aizq=altura(raux.getIzq());
		int ader=altura(raux.getDer());
		return 1+(aizq>ader?aizq:ader); 
	}
	
	//Cuenta los nodos que tiene el arbol
	
	public int cuentaNodos() {
		return cuentaNodos(raiz);
	}
	
	private int cuentaNodos(NodoArbol<E> raux) {
		if(raux==null)
			return 0;
		return 1+cuentaNodos(raux.getIzq())+cuentaNodos(raux.getDer());
	}
	
	//Busca si un item esta dentro del arbol
	public NodoArbol<E> searchItem(E item){
		return searchItem(raiz,item);
	}
	
	private NodoArbol<E> searchItem(NodoArbol<E> raux,E item) {
		if(raux==null)
			return null;
		Comparable citem=(Comparable)item;
		Comparable ritem=(Comparable)raux.getItem();
		if(citem.compareTo(ritem)==0)
			return raux;
		if(citem.compareTo(ritem)<0)
			return searchItem(raux.getIzq(),item);
		return searchItem(raux.getDer(),item);
	}
	
	
	//Te muestra los nodos en InOrden PreOrden y PostOrden
	
	public void  getInOrden() {
		EmpleadosAcciones empleados = new EmpleadosAcciones();
		getPreOrden(raiz, empleados);
	}
	
	private int  getInOrden(NodoArbol<E> raux, EmpleadosAcciones empleados) {
		if(raux==null)
			return 0;
		Empleados empleado =  (Empleados) raux.getItem();
		empleados.mostrarEmpleados(empleado);
		
		getInOrden(raux.getIzq(), empleados);
		
		getInOrden(raux.getDer(), empleados);
		return 0;
	}
	
	public void getPreOrden() {
		EmpleadosAcciones empleados = new EmpleadosAcciones();
		getPreOrden(raiz, empleados);
	}
	
	private int getPreOrden(NodoArbol<E> raux, EmpleadosAcciones empleados) {
		if(raux==null)
			return 0;
		Empleados empleado =  (Empleados) raux.getItem();
		empleados.mostrarEmpleados(empleado);
		
		getPreOrden(raux.getIzq(), empleados);
		
		getPreOrden(raux.getDer(), empleados);
		
		return 0;
		
	}

	public void getPostOrden() {
		EmpleadosAcciones empleados = new EmpleadosAcciones();
		getPostOrden(raiz, empleados);
	}
	
	private int getPostOrden(NodoArbol<E> raux, EmpleadosAcciones empleados) {
		if(raux==null)
			return 0;
		
		Empleados empleado =  (Empleados) raux.getItem();
		empleados.mostrarEmpleados(empleado);
		getPostOrden(raux.getIzq(), empleados);
		getPostOrden(raux.getDer(), empleados);
		return 0;
	}
}
