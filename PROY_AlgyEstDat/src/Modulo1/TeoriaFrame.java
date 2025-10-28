package Modulo1;

import javax.swing.*;
import java.awt.*;

public class TeoriaFrame extends JFrame{
    public TeoriaFrame() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Teoría - Estructuras Lineales");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();

        JTextArea txtVectores = new JTextArea();
        txtVectores.setEditable(false);
        txtVectores.setLineWrap(true);
        txtVectores.setWrapStyleWord(true);
        txtVectores.setText(getTextoVectores());

        JTextArea txtMatrices = new JTextArea();
        txtMatrices.setEditable(false);
        txtMatrices.setLineWrap(true);
        txtMatrices.setWrapStyleWord(true);
        txtMatrices.setText(getTextoMatrices());

        JTextArea txtListas = new JTextArea();
        txtListas.setEditable(false);
        txtListas.setLineWrap(true);
        txtListas.setWrapStyleWord(true);
        txtListas.setText(getTextoListas());

        tabs.addTab("Vectores", new JScrollPane(txtVectores));
        tabs.addTab("Matrices", new JScrollPane(txtMatrices));
        tabs.addTab("Listas", new JScrollPane(txtListas));

        add(tabs, BorderLayout.CENTER);
    }

    // --- Contenido teórico (puedes editar directamente aquí) ---
    private String getTextoVectores() {
        return "Vectores (Arreglos unidimensionales)\n\n"
             + "Definición:\n"
             + "Un vector (array) es una estructura de datos que almacena una colección de elementos del mismo tipo en posiciones indexadas (0..n-1).\n\n"
             + "Operaciones comunes:\n"
             + "- Declaración: int[] a = new int[5];\n"
             + "- Inicialización: int[] b = {1,2,3};\n"
             + "- Recorrido: for (int i=0; i<a.length; i++) {...}\n"
             + "- Búsqueda lineal, suma de elementos, inversión.\n\n"
             + "Ejemplo en Java:\n"
             + "int[] v = {3, 6, 1, 9};\n"
             + "for (int i = 0; i < v.length; i++) {\n"
             + "    System.out.println(v[i]);\n"
             + "}\n";
    }

    private String getTextoMatrices() {
        return "Matrices (Arreglos bidimensionales)\n\n"
             + "Definición:\n"
             + "Una matriz es un arreglo de dos dimensiones (filas x columnas). En Java se declara como: int[][] m = new int[3][4];\n\n"
             + "Operaciones comunes:\n"
             + "- Recorrido doble con bucles for anidados\n"
             + "- Transposición (filas↔columnas)\n"
             + "- Suma de matrices, multiplicación (más avanzado)\n\n"
             + "Ejemplo en Java (recorrido):\n"
             + "for (int i = 0; i < m.length; i++) {\n"
             + "    for (int j = 0; j < m[i].length; j++) {\n"
             + "        System.out.print(m[i][j] + \" \");\n"
             + "    }\n"
             + "    System.out.println();\n"
             + "}\n";
    }

    private String getTextoListas() {
        return "Listas (Estructuras dinámicas enlazadas)\n\n"
             + "Definición:\n"
             + "Una lista enlazada es una colección de nodos donde cada nodo contiene un dato y una referencia al siguiente nodo.\n\n"
             + "Tipos:\n"
             + "- Lista enlazada simple (cada nodo apunta al siguiente)\n"
             + "- Lista doblemente enlazada (nodo apunta a siguiente y anterior)\n"
             + "- Lista circular (último apunta al primero)\n\n"
             + "Operaciones comunes:\n"
             + "- Inserción al inicio/fin\n"
             + "- Eliminación\n"
             + "- Recorrido\n\n"
             + "Ejemplo conceptual de nodo (pseudo-Java):\n"
             + "class Nodo { int dato; Nodo siguiente; }\n"
             + "Para insertar: crear nodo y ajustar referencias.\n";
    }
}
