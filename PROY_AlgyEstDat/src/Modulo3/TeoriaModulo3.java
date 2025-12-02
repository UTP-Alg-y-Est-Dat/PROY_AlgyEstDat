package Modulo3;

import javax.swing.*;
import java.awt.*;

public class TeoriaFrame extends JFrame {
    
    public TeoriaFrame() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Teoría - Pilas y Colas");
        setSize(850, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JTabbedPane tabs = new JTabbedPane();

        JTextArea txtPilas = new JTextArea();
        txtPilas.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtPilas.setEditable(false);
        txtPilas.setLineWrap(true);
        txtPilas.setWrapStyleWord(true);
        txtPilas.setText(getTextoPilas());

        JTextArea txtColas = new JTextArea();
        txtColas.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtColas.setEditable(false);
        txtColas.setLineWrap(true);
        txtColas.setWrapStyleWord(true);
        txtColas.setText(getTextoColas());

        JTextArea txtEjercicio = new JTextArea();
        txtEjercicio.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtEjercicio.setEditable(false);
        txtEjercicio.setLineWrap(true);
        txtEjercicio.setWrapStyleWord(true);
        txtEjercicio.setText(getTextoEjercicio());

        tabs.addTab("Pilas (LIFO)", new JScrollPane(txtPilas));
        tabs.addTab("Colas (FIFO)", new JScrollPane(txtColas));
        tabs.addTab("Ejercicio Postfija", new JScrollPane(txtEjercicio));

        add(tabs, BorderLayout.CENTER);
    }

    private String getTextoPilas() {
        return "Pilas (Stacks)\n"
             + "=================================================\n\n"
             + "DEFINICIÓN:\n"
             + "Una pila es una estructura de datos lineal que almacena y recupera\n"
             + "sus elementos de acuerdo a un orden estricto. La inserción y la\n"
             + "eliminación se realizan solo por un extremo, llamado CIMA (TOP).\n\n"
             + "PRINCIPIO:\n"
             + "LIFO (Last In, First Out):\n"
             + "    El último elemento en entrar es el primero en salir.\n\n"
             + "IMPLEMENTACIÓN:\n"
             + "Comúnmente se implementa de forma estática (usando arreglos) o\n"
             + "dinámica (usando listas enlazadas).\n\n"
             + "OPERACIONES CLAVE:\n"
             + "1. APILAR (PUSH):\n"
             + "   - Inserta un nuevo elemento en la cima de la pila.\n"
             + "2. DESAPILAR (POP):\n"
             + "   - Elimina el elemento que se encuentra en la cima y lo retorna.\n"
             + "3. CIMA (PEEK):\n"
             + "   - Retorna el elemento de la cima sin eliminarlo.\n"
             + "4. isPilaVacia():\n"
             + "   - Verifica si la pila no contiene elementos.\n\n"
             + "EJEMPLO CONCEPTUAL:\n"
             + "Pila de platos o libros.\n";
    }

    private String getTextoColas() {
        return "Colas (Queues)\n"
             + "=================================================\n\n"
             + "DEFINICIÓN:\n"
             + "Una cola es una estructura de datos lineal que almacena y recupera\n"
             + "sus elementos en un orden estricto. La inserción se realiza por un\n"
             + "extremo (el FINAL) y la eliminación por el otro (el FRENTE).\n\n"
             + "PRINCIPIO:\n"
             + "FIFO (First In, First Out):\n"
             + "    El primer elemento en entrar es el primero en salir.\n"
             + "    (Primero en llegar, primero en ser servido).\n\n"
             + "IMPLEMENTACIÓN:\n"
             + "Comúnmente se implementa de forma estática (arreglos) o dinámica\n"
             + "(listas enlazadas). La implementación estática requiere manejo\n"
             + "especial (cola circular) para evitar el desplazamiento de elementos.\n\n"
             + "OPERACIONES CLAVE:\n"
             + "1. ENCOLAR (ENQUEUE):\n"
             + "   - Inserta un nuevo elemento en el final de la cola.\n"
             + "2. DESENCOLAR (DEQUEUE):\n"
             + "   - Elimina el elemento que se encuentra en el frente y lo retorna.\n"
             + "3. FRENTE (PEEK):\n"
             + "   - Retorna el elemento del frente sin eliminarlo.\n"
             + "4. isColaVacia():\n"
             + "   - Verifica si la cola no contiene elementos.\n\n"
             + "EJEMPLO CONCEPTUAL:\n"
             + "Cola en un banco, fila de impresión de documentos.\n";
    }

    private String getTextoEjercicio() {
        return "Ejercicio: Conversión Infija a Postfija\n"
             + "=================================================\n\n"
             + "APLICACIÓN DE PILAS:\n"
             + "La pila es fundamental para el manejo de expresiones aritméticas\n"
             + "debido a su naturaleza LIFO, que permite manejar la precedencia\n"
             + "de operadores.\n\n"
             + "NOTACIÓN INFIJA:\n"
             + "Forma habitual de escribir: El operador está entre los operandos.\n"
             + "Ejemplo: A + B * C\n\n"
             + "NOTACIÓN POSTFIJA (Notación Polaca Inversa):\n"
             + "El operador se coloca después de sus operandos.\n"
             + "Ventaja: No requiere paréntesis ni reglas de precedencia para\n"
             + "la evaluación.\n"
             + "Ejemplo: A B C * +\n\n"
             + "PROCESO DE CONVERSIÓN CON PILAS (Algoritmo Básico):\n"
             + "1. Si es OPERANDO (A, B, C): Se envía directamente a la salida.\n"
             + "2. Si es OPERADOR (+, -, * /): Se apila, desapilando previamente\n"
             + "   cualquier operador en la cima que tenga mayor o igual prioridad.\n"
             + "3. Si es PARÉNTESIS '(': Se apila inmediatamente.\n"
             + "4. Si es PARÉNTESIS ')': Se desapilan operadores hasta encontrar\n"
             + "   el '(' correspondiente (que también se desapila).\n\n"
             + "EJEMPLO:\n"
             + "   Infija: A + (B * C)\n"
             + "   Postfija: A B C * +\n";
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TeoriaFrame().setVisible(true);
        });
    }
}