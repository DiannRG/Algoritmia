
package grafo;

public class Arista {
    
    public int costo;
    public Nodo nodo1;
    public Nodo nodo2;
    
    public Arista(){
        
    }

    public Arista(int costo) {
        this.costo = costo;
        this.nodo1 = null;
        this.nodo2 = null;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Nodo getNodo1() {
        return nodo1;
    }

    public void setNodo1(Nodo nodo1) {
        this.nodo1 = nodo1;
    }

    public Nodo getNodo2() {
        return nodo2;
    }

    public void setNodo2(Nodo nodo2) {
        this.nodo2 = nodo2;
    }

    @Override
    public String toString() {
        return "Arista{" + "costo=" + costo + ", nodo1=" + nodo1 + ", nodo2=" + nodo2 + '}';
    }
    
    
    
}
