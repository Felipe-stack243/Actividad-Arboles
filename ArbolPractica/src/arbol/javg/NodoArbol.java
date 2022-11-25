package arbol.javg;

public class NodoArbol <E> {
	private E item;
	private NodoArbol<E> izq,der;
	
	public NodoArbol(E item) {
		this.item=item;
		this.izq=null;
		this.der=null;
	}
	public E getItem() {
		return item;
	}
	public void setItem(E item) {
		this.item = item;
	}
	public NodoArbol<E> getIzq() {
		return izq;
	}
	public void setIzq(NodoArbol<E> izq) {
		this.izq = izq;
	}
	public NodoArbol<E> getDer() {
		return der;
	}
	public void setDer(NodoArbol<E> der) {
		this.der = der;
	}

}
