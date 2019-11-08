package arbolavl;

public class Arbol {

    private NodoArbol raiz;

    public NodoArbol obtenerRaiz() {
        return raiz;
    }

    public Arbol() {
        this.raiz = null;
    }

    public NodoArbol insertar(NodoArbol nuevo, NodoArbol subAr) {
        NodoArbol padre = subAr;
        if (nuevo.dato < subAr.dato) {
            if (subAr.hijoIz == null) {
                subAr.hijoIz = nuevo;

            } else {
                subAr.hijoIz = insertar(nuevo, subAr.hijoIz);
                if ((FE(subAr.hijoIz) - FE(subAr.hijoDer) == 2)) {
                    if (nuevo.dato < subAr.hijoIz.dato) {
                        padre = rotacionIzquierda(subAr);
                    } else {
                        padre = rotacionDobleIzquierda(subAr);
                    }
                }
            }
        } else if (nuevo.dato > subAr.dato) {
            if (subAr.hijoDer == null) {
                subAr.hijoDer = nuevo;
            } else {
                subAr.hijoDer = insertar(nuevo, subAr.hijoDer);
                if (FE(subAr.hijoDer) - FE(subAr.hijoIz) == 2) {
                    if (nuevo.dato > subAr.hijoDer.dato) {
                        padre = rotacionDerecha(subAr);
                    } else {
                        padre = rotacionDobleDerecha(subAr);
                    }
                }
            }
        } else {
            System.out.println("Nodo duplicado");
        }
        if ((subAr.hijoIz == null) && (subAr.hijoDer != null)) {
            subAr.FE = subAr.hijoDer.FE + 1;
        } else if ((subAr.hijoDer == null) && (subAr.hijoIz != null)) {
            subAr.FE = subAr.hijoIz.FE + 1;
        } else {
            subAr.FE = Math.max(FE(subAr.hijoIz), FE(subAr.hijoDer)) + 1;
        }
        return padre;
    }

    public void insertar2(int d) {
        NodoArbol nuevo = new NodoArbol(d);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            raiz = insertar(nuevo, raiz);
        }
    }

    public int FE(NodoArbol x) {
        if (x == null) {
            return -1;
        } else {
            return x.FE;
        }
    }

    public NodoArbol rotacionIzquierda(NodoArbol a) {
        NodoArbol aux = a.hijoIz;
        a.hijoIz = aux.hijoDer;
        aux.hijoDer = a;
        a.FE = Math.max(FE(a.hijoIz), FE(a.hijoDer)) + 1;
        aux.FE = Math.max(FE(aux.hijoIz), FE(aux.hijoDer)) + 1;
        return aux;
    }

    public NodoArbol rotacionDerecha(NodoArbol a) {
        NodoArbol aux = a.hijoDer;
        a.hijoDer = aux.hijoIz;
        aux.hijoIz = a;
        a.FE = Math.max(FE(a.hijoIz), FE(a.hijoDer)) + 1;
        aux.FE = Math.max(FE(aux.hijoIz), FE(aux.hijoDer)) + 1;
        return aux;
    }

    public NodoArbol rotacionDobleIzquierda(NodoArbol a) {
        NodoArbol tem;
        a.hijoIz = rotacionDerecha(a.hijoIz);
        tem = rotacionIzquierda(a);
        return tem;
    }

    public NodoArbol rotacionDobleDerecha(NodoArbol a) {
        NodoArbol tem;
        a.hijoDer = rotacionDerecha(a.hijoDer);
        tem = rotacionDerecha(a);
        return tem;
    }

    public void preOrden(NodoArbol raiz) {
        //PREORDEN: raiz, izquierda y derecha
        if (raiz != null) {
            System.out.print("{");
            System.out.print(raiz);
            preOrden(raiz.hijoIz);
            preOrden(raiz.hijoDer);
            System.out.print("}");
        }

    }

    public void inOrden(NodoArbol raiz) {
        //INORDEN: izquierda, raiz y derecha
        if (raiz != null) {
            System.out.print("{");
            inOrden(raiz.hijoIz);
            System.out.print(raiz);
            inOrden(raiz.hijoDer);
            System.out.print("}");
        }
    }

    public void postOrden(NodoArbol raiz) {
        //izquierda,derecha y raiz
        if (raiz != null) {
            postOrden(raiz.hijoIz);
            postOrden(raiz.hijoDer);
            System.out.println(raiz.dato);
        }
    }

    //Buscar
    public NodoArbol buscar(int n, NodoArbol t) {
        if (raiz == null) {
            return null;
        } else if (t.dato == n) {
            return t;
        } else if (t.dato < n) {
            return buscar(n, t.hijoDer);
        } else {
            return buscar(n, t.hijoIz);
        }
    }
}
