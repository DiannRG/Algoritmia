
package grafo;

public class Nodo {
    
    public String nombre;

    public Nodo(String nombre) {
        this.nombre = nombre;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Nodo{" + "nombre=" + nombre + '}';
    }
    
    
    
}
