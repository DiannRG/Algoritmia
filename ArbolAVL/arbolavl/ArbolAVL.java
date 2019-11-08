
package arbolavl;
public class ArbolAVL {
    public static void main(String[] args) {
        Arbol ar = new Arbol();
        
        ar.insertar2(10);
        ar.insertar2(5);
        ar.insertar2(13);
        ar.insertar2(1);
        ar.insertar2(6);
        ar.insertar2(17);
        ar.insertar2(0);
        ar.insertar2(18);
        ar.preOrden(ar.obtenerRaiz());
        System.out.println("");
        ar.inOrden(ar.obtenerRaiz());
    }
    
}
