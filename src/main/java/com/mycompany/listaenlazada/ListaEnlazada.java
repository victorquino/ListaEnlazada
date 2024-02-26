/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.listaenlazada;

/**
 *
 * @author Victor
 */
public class ListaEnlazada {

    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.AgreInicio(10);
        lista.AgreFinal(5);
        lista.AgreFinal(100);
        lista.AgreFinal(80);
        lista.AgreFinal(1);
        lista.AgreInicio(55);
        
        lista.BorrarValor(100);
        lista.mostrar();
    }

}

class nodo {

    int valor;
    nodo siguiente;

    nodo(int valor) {
        this.valor = valor;
    }
}

class Lista {

    nodo cabeza;

    public void AgreFinal(int valor) {
        /*verifica si lista esta vacia,de ser verdadero 
           agrega valor y se convierte en cabeza
         */
        if (vacia() == true) {
            cabeza = new nodo(valor);
            return;
        }
        //existe lista, busca hasta encontrar(null)
        nodo apuntador = cabeza;
        while (apuntador.siguiente != null) {
            apuntador = apuntador.siguiente;
        }
        //al encontrar null agregar el nuevo valor
        apuntador.siguiente = new nodo(valor);
    }

    public void AgreInicio(int valor) {
        /*verifica si lista esta vacia,de ser verdadero 
           agrega valor y se convierte en cabeza
         */
        if (vacia() == true) {
            cabeza = new nodo(valor);
            return;
        }
        // encuentra valor, crea nuevo nodo
        nodo nuevo = new nodo(valor);
        //indicar que el nodo que debe seguir despues es el nodo cabeza 
        nuevo.siguiente = cabeza;
        //Asignar nodo nuevo como cabeza
        cabeza = nuevo;

    }

    public void BorrarValor(int valor) {
        //verificar si esta vacia y es verdadero retorna
        if (vacia() == true) {
            return;
        }
        /*si el valor a eliminar es cabeza
        asigna al siguiente el valor de cabeza*/
        if (cabeza.valor == valor) {
            cabeza = cabeza.siguiente;
            return;
        }
        //buscar el nodo a eliminar,
        nodo apuntador = cabeza;
        while (apuntador.siguiente != null) {
            if (apuntador.siguiente.valor == valor) {
                apuntador.siguiente = apuntador.siguiente.siguiente;
                return;
            }
            apuntador = apuntador.siguiente;

        }
    }

    public void mostrar() {
        //verificar si lista esta vacia
        if (vacia() == true) {
            System.out.println("Lista vacia");
            return;
        }
        nodo apuntador = cabeza;
        while (apuntador != null) {
            System.out.println( + apuntador.valor);
            apuntador = apuntador.siguiente;
        }
    }

    //metodo para verificar si lista esta vacia
    public boolean vacia() {
        if (cabeza == null) {
            return true;
        } else {
            return false;
        }

    }
}
