package arbol.javg;

public class Arbol <E> {
private NodoArbol<E> raiz;
	
	public Arbol() {
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
	
	
	public int cuentaHojas() {
		return cuentaHojas(raiz);
	}
	
	private int cuentaHojas(NodoArbol<E> raux) {
		if(raux==null)
			return 0;
		if(raux.getIzq()==null && raux.getDer()==null)
			return 1;
		return cuentaHojas(raux.getIzq())+cuentaHojas(raux.getDer());
	}
	
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
	
	public int cuentaNodos() {
		return cuentaNodos(raiz);
	}
	
	private int cuentaNodos(NodoArbol<E> raux) {
		if(raux==null)
			return 0;
		return 1+cuentaNodos(raux.getIzq())+cuentaNodos(raux.getDer());
	}
	
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
	
	// -------------- + Practica Arboles + --------------
	
	// 2.a
	private int numNodosIzquierdaRaiz() {
		if(raiz.getIzq() == null) return 0;
		return numNodosIzquierdaRaiz(raiz.getIzq());
	}
	
	private int numNodosIzquierdaRaiz(NodoArbol<E> raizAux) {
		if(raizAux == null) return 0;
		 
			return 1+numNodosIzquierdaRaiz(raizAux.getIzq())+numNodosIzquierdaRaiz(raizAux.getDer());
	}
	
	// 2.b
	
	private int numNodosDerechaRaiz() {
		if(raiz.getDer() == null) return 0;
		return numNodosIzquierdaRaiz(raiz.getDer());
	}
	
	private int numNodosDerechaRaiz(NodoArbol<E> raizAux) {
		if(raizAux == null) return 0;
		 
			return 1+numNodosDerechaRaiz(raizAux.getIzq())+numNodosDerechaRaiz(raizAux.getDer());
	}
	
	// 2.c
	private int numNodosSinHojas() {
		return numNodosIzquierdaRaiz(raiz);
	}
	
	private int numNodosSinHojas(NodoArbol<E> raizAux) {
		if(raizAux == null) return 0;
		if(raizAux.getDer() == null && raizAux.getIzq() == null) return 0;
		 
			return 1+numNodosSinHojas(raizAux.getIzq())+numNodosSinHojas(raizAux.getDer());
	}
	
	//------------------------------------------------------------------------------------------------
	public String  getInOrden() {
		return  getInOrden(raiz,"");
	}
	
	private String  getInOrden(NodoArbol<E> raux,String a) {
		if(raux==null)
			return a;
		a=getInOrden(raux.getIzq(),a);
		a+=raux.getItem()+",";
		a=getInOrden(raux.getDer(),a);
		return a;
	}
	
	public String getPreOrden() {
		return getPreOrden(raiz,"");
	}
	
	private String getPreOrden(NodoArbol<E> raux,String a) {
		if(raux==null)
			return a;
		a+=raux.getItem()+",";
		a=getPreOrden(raux.getIzq(),a);
		a=getPreOrden(raux.getDer(),a);
		return a;
	}

	public String getPostOrden() {
		return getPostOrden(raiz,"");
	}
	
	private String getPostOrden(NodoArbol<E> raux,String a) {
		if(raux==null)
			return a;
		a=getPostOrden(raux.getIzq(),a);
		a=getPostOrden(raux.getDer(),a);
		return a+raux.getItem()+",";
	}

}
