package Modulo2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class EjerciciosDinamicosFrame extends JFrame {

    public EjerciciosDinamicosFrame() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Ejercicios - Estructuras de Datos Dinámicas");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("TAD", crearPanelTAD());
        tabs.addTab("Lista Simple", crearPanelListaSimple());
        tabs.addTab("Lista Doble", crearPanelListaDoble());
        tabs.addTab("Lista Circular", crearPanelListaCircular());

        add(tabs, BorderLayout.CENTER);
    }
    private JPanel crearPanelTAD() {
        JPanel p = new JPanel(new BorderLayout(8, 8));

        JTextArea salida = new JTextArea(15, 70);
        salida.setEditable(false);

        JButton btnEjemplo = new JButton("Ejecutar ejemplo TAD");

        btnEjemplo.addActionListener(e -> {
            TAD_Entero tad = new TAD_Entero();
            tad.insertar(10);
            tad.insertar(20);
            tad.insertar(30);
            salida.setText("Contenido del TAD: \n" + tad.mostrar());
        });

        p.add(btnEjemplo, BorderLayout.NORTH);
        p.add(new JScrollPane(salida), BorderLayout.CENTER);
        return p;
    }
    class TAD_Entero {
        private ArrayList<Integer> datos = new ArrayList<>();

        public void insertar(int x) { datos.add(x); }
        public String mostrar() { return datos.toString(); }
    }
    private JPanel crearPanelListaSimple() {
        JPanel p = new JPanel(new BorderLayout(8, 8));
        JTextArea salida = new JTextArea(12, 70);
        salida.setEditable(false);

        JTextField txt = new JTextField(10);
        JButton btnInsertar = new JButton("Insertar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnMostrar = new JButton("Mostrar");

        ListaSimple lista = new ListaSimple();

        btnInsertar.addActionListener(e -> {
            try {
                int v = Integer.parseInt(txt.getText().trim());
                lista.insertar(v);
                salida.setText("Insertado: " + v);
            } catch (Exception ex) {
                salida.setText("Ingrese un número válido.");
            }
        });

        btnEliminar.addActionListener(e -> {
            lista.eliminar();
            salida.setText("Primer elemento eliminado.");
        });

        btnMostrar.addActionListener(e -> salida.setText(lista.mostrar()));

        JPanel top = new JPanel();
        top.add(new JLabel("Valor: ")); top.add(txt);
        top.add(btnInsertar); top.add(btnEliminar); top.add(btnMostrar);

        p.add(top, BorderLayout.NORTH);
        p.add(new JScrollPane(salida), BorderLayout.CENTER);
        return p;
    }
    class Nodo {
        int dato;
        Nodo sig;

        Nodo(int d) { dato = d; sig = null; }
    }

    class ListaSimple {
        Nodo cabeza;

        void insertar(int x) {
            Nodo nuevo = new Nodo(x);
            nuevo.sig = cabeza;
            cabeza = nuevo;
        }

        void eliminar() {
            if (cabeza != null)
                cabeza = cabeza.sig;
        }

        String mostrar() {
            StringBuilder sb = new StringBuilder();
            Nodo aux = cabeza;
            while (aux != null) {
                sb.append(aux.dato).append(" -> ");
                aux = aux.sig;
            }
            sb.append("null");
            return sb.toString();
        }
    }
    private JPanel crearPanelListaDoble() {
        JPanel p = new JPanel(new BorderLayout(8, 8));
        JTextArea salida = new JTextArea(12, 70);
        salida.setEditable(false);

        JTextField txt = new JTextField(10);
        JButton btnInsertar = new JButton("Insertar");
        JButton btnMostrar = new JButton("Mostrar");

        ListaDoble lista = new ListaDoble();

        btnInsertar.addActionListener(e -> {
            try {
                int v = Integer.parseInt(txt.getText().trim());
                lista.insertar(v);
                salida.setText("Insertado: " + v);
            } catch (Exception ex) {
                salida.setText("Ingrese un número válido.");
            }
        });

        btnMostrar.addActionListener(e -> salida.setText(lista.mostrar()));

        JPanel top = new JPanel();
        top.add(new JLabel("Valor: ")); top.add(txt);
        top.add(btnInsertar); top.add(btnMostrar);

        p.add(top, BorderLayout.NORTH);
        p.add(new JScrollPane(salida), BorderLayout.CENTER);
        return p;
    }

    class NodoDoble {
        int dato;
        NodoDoble ant, sig;
        NodoDoble(int d) { dato = d; }
    }

    class ListaDoble {
        NodoDoble inicio;

        void insertar(int x) {
            NodoDoble nuevo = new NodoDoble(x);
            nuevo.sig = inicio;
            if (inicio != null) inicio.ant = nuevo;
            inicio = nuevo;
        }

        String mostrar() {
            StringBuilder sb = new StringBuilder();
            NodoDoble aux = inicio;
            while (aux != null) {
                sb.append(aux.dato).append(" <-> ");
                aux = aux.sig;
            }
            sb.append("null");
            return sb.toString();
        }
    }
    private JPanel crearPanelListaCircular() {
        JPanel p = new JPanel(new BorderLayout(8, 8));
        JTextArea salida = new JTextArea(12, 70);
        salida.setEditable(false);

        JTextField txt = new JTextField(10);
        JButton btnInsertar = new JButton("Insertar");
        JButton btnMostrar = new JButton("Mostrar");

        ListaCircular lista = new ListaCircular();

        btnInsertar.addActionListener(e -> {
            try {
                int v = Integer.parseInt(txt.getText().trim());
                lista.insertar(v);
                salida.setText("Insertado: " + v);
            } catch (Exception ex) {
                salida.setText("Ingrese un número válido.");
            }
        });

        btnMostrar.addActionListener(e -> salida.setText(lista.mostrar()));

        JPanel top = new JPanel();
        top.add(new JLabel("Valor: ")); top.add(txt);
        top.add(btnInsertar); top.add(btnMostrar);

        p.add(top, BorderLayout.NORTH);
        p.add(new JScrollPane(salida), BorderLayout.CENTER);
        return p;
    }

    class NodoCircular {
        int dato;
        NodoCircular sig;
        NodoCircular(int d) { dato = d; }
    }

    class ListaCircular {
        NodoCircular ultimo;

        void insertar(int x) {
            NodoCircular nuevo = new NodoCircular(x);
            if (ultimo == null) {
                ultimo = nuevo;
                nuevo.sig = nuevo;
            } else {
                nuevo.sig = ultimo.sig;
                ultimo.sig = nuevo;
                ultimo = nuevo;
            }
        }

        String mostrar() {
            if (ultimo == null) return "Lista vacía";
            StringBuilder sb = new StringBuilder();
            NodoCircular aux = ultimo.sig;
            do {
                sb.append(aux.dato).append(" -> ");
                aux = aux.sig;
            } while (aux != ultimo.sig);
            sb.append("(circular)");
            return sb.toString();
        }
    }
}

