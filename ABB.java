package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo actual;
    private Nodo raiz;

    private class Nodo {
        private Nodo padre;
        private Nodo nodoizquierdo;
        private Nodo nododerecho;
        private T valor;

        public Nodo(T elem){
            valor = elem;
            padre = null;
            nodoizquierdo = null;
            nododerecho = null;
        }
    }

    public ABB() {
        raiz = null;
        actual = null;
    }

    public int cardinal() {
        if(raiz == null){
            return 0;
        }
        else{
            actual = raiz;
            int i = 1;
            while(actual.nodoizquierdo != null){
                actual = actual.nodoizquierdo;
            }
            while(actual.nododerecho != null){
                actual = actual.nodoizquierdo;
            }                
        }
    }

    public T minimo(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public T maximo(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void insertar(T elem){
        if(raiz == null){
            raiz = new Nodo(elem);
            actual = raiz;
        }
        else{
            actual = raiz;
            while(actual.valor != elem){
                if(elem.compareTo(actual.valor) > 0){
                    if(actual.nododerecho == null){
                        Nodo nuevo = new Nodo(elem);
                        nuevo.padre = actual;
                        actual.nododerecho = nuevo;
                        actual = nuevo;
                    }
                    else{
                        actual = actual.nododerecho;
                    }
                }
                if(elem.compareTo(actual.valor) < 0){
                    if(actual.nodoizquierdo == null){
                        Nodo nuevo = new Nodo(elem);
                        nuevo.padre = actual;
                        actual.nodoizquierdo = nuevo;
                        actual = nuevo;
                    }
                    else{
                        actual = actual.nodoizquierdo;
                    }
                }
            }
        }
    }

    public boolean pertenece(T elem){
        if(raiz == null){
            return false;
        }
        actual = raiz;
        while(actual.valor != elem){
                if(elem.compareTo(actual.valor) > 0){
                    if(actual.nododerecho == null){
                        return false;
                    }
                    else{
                        actual = actual.nododerecho;
                    }
                }
                if(elem.compareTo(actual.valor) < 0){
                    if(actual.nodoizquierdo == null){
                        return false;
                    }
                    else{
                        actual = actual.nodoizquierdo;
                    }
                }
            }
        return true;
    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
