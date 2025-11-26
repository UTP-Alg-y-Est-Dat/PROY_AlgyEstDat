package Modulo2;

import javax.swing.*;
import java.awt.*;

public class TeoriaModulo2 extends JFrame {

    public TeoriaModulo2() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Teoría - Estructuras de Datos Dinámicas");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();

        JTextArea txtTAD = new JTextArea();
        txtTAD.setEditable(false);
        txtTAD.setLineWrap(true);
        txtTAD.setWrapStyleWord(true);
        txtTAD.setText(getTextoTAD());

        JTextArea txtListas = new JTextArea();
        txtListas.setEditable(false);
        txtListas.setLineWrap(true);
        txtListas.setWrapStyleWord(true);
        txtListas.setText(getTextoListas());

        JTextArea txtOperaciones = new JTextArea();
        txtOperaciones.setEditable(false);
        txtOperaciones.setLineWrap(true);
        txtOperaciones.setWrapStyleWord(true);
        txtOperaciones.setText(getTextoOperaciones());

        JTextArea txtDoblesCirculares = new JTextArea();
        txtDoblesCirculares.setEditable(false);
        txtDoblesCirculares.setLineWrap(true);
        txtDoblesCirculares.setWrapStyleWord(true);
        txtDoblesCirculares.setText(getTextoDoblesCirculares());

        tabs.addTab("Tema 04: TAD", new JScrollPane(txtTAD));
        tabs.addTab("Tema 05: Listas Enlazadas", new JScrollPane(txtListas));
        tabs.addTab("Tema 06: Operaciones Básicas", new JScrollPane(txtOperaciones));
        tabs.addTab("Tema 07: Dobles y Circulares", new JScrollPane(txtDoblesCirculares));

        add(tabs, BorderLayout.CENTER);
    }

    private String getTextoTAD() {
        return "TEMA 04: ESTRUCTURAS DE DATOS DINÁMICAS - TAD\n\n"
            + "Concepto de TAD (Tipo Abstracto de Datos):\n"
            + "Un TAD define un conjunto de datos y las operaciones que se pueden realizar sobre ellos,\n"
            + "sin especificar cómo se implementan internamente.\n\n"
            + "Especificación informal de un TAD:\n"
            + "Describe con palabras las operaciones, ejemplo:\n"
            + "- insertar(x)\n"
            + "- eliminar()\n"
            + "- esVacia()\n"
            + "- primero()\n\n"
            + "Especificación formal de un TAD:\n"
            + "- Se definen precondiciones y postcondiciones.\n"
            + "- Se detalla el dominio de valores.\n"
            + "- Se definen operaciones y comportamiento esperado.\n\n"
            + "Implementación del TAD:\n"
            + "Se usan estructuras de datos dinámicas como nodos, punteros y listas para\n"
            + "materializar el comportamiento del TAD.\n";
    }

    private String getTextoListas() {
        return "TEMA 05: LISTAS ENLAZADAS - CONCEPTOS E IMPLEMENTACIÓN\n\n"
            + "Concepto básico:\n"
            + "Una lista enlazada está formada por nodos. Cada nodo tiene dos partes:\n"
            + "- Dato\n"
            + "- Referencia al siguiente nodo\n\n"
            + "Nodo en pseudo-Java:\n"
            + "class Nodo {\n"
            + "    int dato;\n"
            + "    Nodo siguiente;\n"
            + "}\n\n"
            + "Inserción en una lista simple:\n"
            + "1) Crear un nuevo nodo\n"
            + "2) Apuntar el nuevo nodo al primer nodo actual\n"
            + "3) Actualizar la cabeza\n\n"
            + "Eliminación:\n"
            + "- Localizar el nodo anterior al que se eliminará\n"
            + "- Ajustar los punteros para saltar el nodo\n";
    }

    private String getTextoOperaciones() {
        return "TEMA 06: LISTA ENLAZADA SIMPLE – OPERACIONES\n\n"
            + "Recorrido:\n"
            + "Nodo actual = cabeza; mientras actual != null → imprimir dato.\n\n"
            + "Búsqueda:\n"
            + "- Recorrer la lista comparando el valor.\n"
            + "- Si se encuentra, devolver posición.\n\n"
            + "Ordenamiento:\n"
            + "- Se aplican algoritmos como burbuja, selección o inserción\n"
            + "  adaptados al uso de referencias.\n\n"
            + "Ejemplo de recorrido:\n"
            + "Nodo aux = cabeza;\n"
            + "while (aux != null) {\n"
            + "    System.out.println(aux.dato);\n"
            + "    aux = aux.siguiente;\n"
            + "}\n";
    }

    private String getTextoDoblesCirculares() {
        return "TEMA 07: LISTAS DOBLEMENTE ENLAZADAS Y CIRCULARES\n\n"
            + "Listas doblemente enlazadas:\n"
            + "- Cada nodo tiene referencia al siguiente y al anterior.\n"
            + "Nodo:\n"
            + "class NodoDoble {\n"
            + "    int dato;\n"
            + "    NodoDoble siguiente;\n"
            + "    NodoDoble anterior;\n"
            + "}\n\n"
            + "Ventaja:\n"
            + "- Permiten recorridos hacia adelante y hacia atrás.\n\n"
            + "Listas circulares:\n"
            + "- El último nodo apunta al primero.\n"
            + "- Pueden ser simples o dobles.\n\n"
            + "Operaciones:\n"
            + "- Inserción\n"
            + "- Eliminación\n"
            + "- Recorridos circulares\n\n"
            + "Recorrido circular simple:\n"
            + "Nodo aux = cabeza;\n"
            + "do {\n"
            + "    imprimir(aux.dato);\n"
            + "    aux = aux.siguiente;\n"
            + "} while (aux != cabeza);\n";
    }

}
