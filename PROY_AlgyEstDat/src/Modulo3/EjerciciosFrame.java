package Modulo3;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

class Pila<T> {
    private final int MAX = 5; 
    private int cima = -1;
    private final Object[] arrayPila = new Object[MAX];

    public boolean estaVacia() { return cima == -1; }
    public boolean estaLlena() { return cima == MAX - 1; }

    @SuppressWarnings("unchecked")
    public void apilar(T elemento) throws IllegalStateException {
        if (estaLlena()) throw new IllegalStateException("Pila Llena. Capacidad máxima alcanzada.");
        cima++;
        arrayPila[cima] = elemento;
    }

    @SuppressWarnings("unchecked")
    public T desapilar() throws NoSuchElementException {
        if (estaVacia()) throw new NoSuchElementException("Pila Vacía. No hay elementos para desapilar.");
        T elemento = (T) arrayPila[cima];
        arrayPila[cima] = null;
        cima--;
        return elemento;
    }

    @SuppressWarnings("unchecked")
    public T cima() throws NoSuchElementException {
        if (estaVacia()) throw new NoSuchElementException("Pila Vacía.");
        return (T) arrayPila[cima];
    }

    public String estadoToString() {
        if (estaVacia()) return "[] (Pila Vacía)";
        StringBuilder sb = new StringBuilder();
        sb.append("Pila (CIMA -> Fondo): [");
        for (int i = cima; i >= 0; i--) {
            sb.append(arrayPila[i]);
            if (i > 0) sb.append(", ");
        }
        sb.append("]\n");
        sb.append("Espacios disponibles: " + (MAX - (cima + 1)));
        return sb.toString();
    }
}

class Cola<T> {
    private final int MAX = 5; // Límite para el ejercicio en GUI
    private int frente = -1;
    private int fin = -1;
    private final Object[] arrayCola = new Object[MAX];

    public boolean estaVacia() { return frente == -1; }
    public boolean estaLlena() { return fin == MAX - 1; }

    public void encolar(T elemento) throws IllegalStateException {
        if (estaLlena()) throw new IllegalStateException("Cola Llena. Capacidad máxima alcanzada.");
        if (estaVacia()) frente = 0;
        fin++;
        arrayCola[fin] = elemento;
    }

    @SuppressWarnings("unchecked")
    public T desencolar() throws NoSuchElementException {
        if (estaVacia()) throw new NoSuchElementException("Cola Vacía. No hay elementos para desencolar.");
        T elemento = (T) arrayCola[frente];
        arrayCola[frente] = null;

        if (frente == fin) {
            frente = -1;
            fin = -1;
        } else {
            frente++;
        }
        return elemento;
    }

    @SuppressWarnings("unchecked")
    public T frente() throws NoSuchElementException {
        if (estaVacia()) throw new NoSuchElementException("Cola Vacía.");
        return (T) arrayCola[frente];
    }

    public String estadoToString() {
        if (estaVacia()) return "[] (Cola Vacía)";
        StringBuilder sb = new StringBuilder();
        sb.append("Cola (FRENTE -> FINAL): [");
        for (int i = frente; i <= fin; i++) {
            sb.append(arrayCola[i]);
            if (i < fin) sb.append(", ");
        }
        sb.append("]\n");
        sb.append("Elementos: " + (fin