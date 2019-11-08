package arbolavl;

public class NodoArbol {

    int dato;
    //FE: Factor de equilibrio
    int FE;
    NodoArbol hijoIz, hijoDer;

    public NodoArbol(int dato) {
        this.dato = dato;
        this.FE = 0;
        this.hijoIz = null;
        this.hijoDer = null;

    }

    @Override
    public String toString() {
        return "(" + dato + " FE=" + FE + ")";
    }

}
