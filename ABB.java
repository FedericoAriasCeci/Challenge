package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo actual;
    private Nodo raiz;
    private int tamaño;

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
        tamaño = 0;
    }

    public int cardinal() {
        return tamaño;
    }

    public T minimo(){
        actual = raiz;
        while (actual.nodoizquierdo != null) {
            actual = actual.nodoizquierdo;   
        }
        return actual.valor;
    }

    public T maximo(){
        actual = raiz;
        while (actual.nododerecho != null) {
            actual = actual.nododerecho;   
        }
        return actual.valor;
    }

    public void insertar(T elem){
        if(raiz == null){
            raiz = new Nodo(elem);
            actual = raiz;
            tamaño = 1;
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
                        tamaño += 1;
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
                        tamaño += 1;
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
        actual = raiz;
        int i = 0;
        Nodo nodoempalme = raiz;

        if (raiz.valor == elem) {
            raiz = actual.nodoizquierdo;
            nodoempalme = actual.nodoizquierdo;
                while(nodoempalme.nododerecho != null){
                    nodoempalme = nodoempalme.nododerecho;
                }
            raiz.padre = null;
            actual.nododerecho.padre = nodoempalme;
            nodoempalme.nododerecho = actual.nododerecho; 
            tamaño -= 1;                      
        }

        else{
        while (actual.valor != elem && i < tamaño) {
            if (actual.valor.compareTo(elem) > 0) {
                actual = actual.nodoizquierdo;
                i += 1;                
            }
            if (actual.valor.compareTo(elem) < 0) {
                actual = actual.nododerecho;
                i += 1;                
            }
        }
        if (i == tamaño && actual.valor != elem){;}
        if (actual.nododerecho == null && actual.nodoizquierdo == null){
            if(actual.padre.nododerecho == actual){
                actual.padre.nododerecho = null;
                tamaño -= 1;
            }
            else{
                actual.padre.nodoizquierdo = null;
                tamaño -= 1;
            }
        }
        else{
            tamaño -= 1;
                if (actual.nodoizquierdo != null){
                        nodoempalme = actual.nodoizquierdo;
                    while(nodoempalme.nododerecho != null){
                        nodoempalme = nodoempalme.nododerecho;
                    }
                    actual.nodoizquierdo.padre = actual.padre;
                    if (actual.padre.nododerecho == actual) {
                    actual.padre.nododerecho = actual.nodoizquierdo;  
                    } 
                    if (actual.padre.nodoizquierdo == actual) {
                    actual.padre.nodoizquierdo = actual.nodoizquierdo;
                    }
                    actual.nododerecho.padre = nodoempalme;
                    nodoempalme.nododerecho = actual.nododerecho;
                }
                if (actual.nodoizquierdo == null) {
                    actual.nododerecho.padre = actual.padre;
                    if (actual.padre.nododerecho == actual) {
                    actual.padre.nododerecho = actual.nododerecho;  
                    } 
                    if (actual.padre.nodoizquierdo == actual) {
                    actual.padre.nodoizquierdo = actual.nodoizquierdo;
                    }
                }
            }
        }
    }

    public String toString(){
        String listaStr = "{";
        actual = raiz;
        Nodo tope = raiz;
        int i = 0;

        while (actual.nodoizquierdo != null) {
            actual = actual.nodoizquierdo;   
            tope = tope.nodoizquierdo;
        }        

        while (i < tamaño) {
            if (tope.nododerecho != null) {
                actual = tope.nododerecho;
                while (actual.nodoizquierdo != null) {
                        actual = actual.nodoizquierdo;
                    }
                listaStr = listaStr + actual.valor.toString() + ", ";
                i +=1 ;
                    if (actual.padre == tope) {
                        tope = actual;
                    }
                    else{
                        tope = actual.padre;
                    }    
                }
            else{
                while(tope.valor.compareTo(actual.valor) < 0){
                    actual = tope;
                    listaStr = listaStr + actual.valor.toString() + ", ";
                    actual = actual.padre;
                    i += 1;
                }
                tope = actual;
            }
        }           
        listaStr = listaStr + actual.valor.toString() + ", ";
        return listaStr;
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
