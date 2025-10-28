package Modulo1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.stream.Collectors;

public class EjerciciosFrame extends JFrame{
    public EjerciciosFrame() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Ejercicios - Estructuras Lineales");
        setSize(820, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("Vectores", crearPanelVectores());
        tabs.addTab("Matrices", crearPanelMatrices());
        tabs.addTab("Listas (Enlazada simple)", crearPanelListas());

        add(tabs, BorderLayout.CENTER);
    }

    private JPanel crearPanelVectores() {
        JPanel p = new JPanel(new BorderLayout(8,8));
        JPanel input = new JPanel(new FlowLayout(FlowLayout.LEFT));
        input.add(new JLabel("Ingrese números (separados por comas):"));
        JTextField txtNums = new JTextField(35);
        input.add(txtNums);

        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnSumar = new JButton("Sumar");
        JButton btnInvertir = new JButton("Invertir");
        JButton btnMax = new JButton("Máximo");
        acciones.add(btnSumar);
        acciones.add(btnInvertir);
        acciones.add(btnMax);

        JTextArea salida = new JTextArea(12, 70);
        salida.setEditable(false);
        salida.setLineWrap(true);
        salida.setWrapStyleWord(true);

        p.add(input, BorderLayout.NORTH);
        p.add(acciones, BorderLayout.CENTER);
        p.add(new JScrollPane(salida), BorderLayout.SOUTH);

        btnSumar.addActionListener(e -> {
            int[] arr = parseInts(txtNums.getText());
            if (arr == null) { showError(salida); return; }
            int sum = 0;
            for (int v : arr) sum += v;
            salida.setText("Vector: " + Arrays.toString(arr) + "\nSuma: " + sum);
        });

        btnInvertir.addActionListener(e -> {
            int[] arr = parseInts(txtNums.getText());
            if (arr == null) { showError(salida); return; }
            int[] inv = new int[arr.length];
            for (int i = 0; i < arr.length; i++) inv[i] = arr[arr.length - 1 - i];
            salida.setText("Vector original: " + Arrays.toString(arr) + "\nInvertido: " + Arrays.toString(inv));
        });

        btnMax.addActionListener(e -> {
            int[] arr = parseInts(txtNums.getText());
            if (arr == null) { showError(salida); return; }
            int max = arr[0];
            for (int v : arr) if (v > max) max = v;
            salida.setText("Vector: " + Arrays.toString(arr) + "\nMáximo: " + max);
        });

        return p;
    }

    private int[] parseInts(String s) {
        try {
            String[] parts = s.split(",");
            java.util.List<Integer> list = new ArrayList<>();
            for (String part : parts) {
                String t = part.trim();
                if (t.isEmpty()) continue;
                list.add(Integer.parseInt(t));
            }
            if (list.isEmpty()) return new int[]{};
            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);
            return arr;
        } catch (Exception ex) {
            return null;
        }
    }

    private JPanel crearPanelMatrices() {
        JPanel p = new JPanel(new BorderLayout(8,8));
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(new JLabel("Filas:"));
        JTextField txtFilas = new JTextField(3);
        top.add(txtFilas);
        top.add(new JLabel("Columnas:"));
        JTextField txtCols = new JTextField(3);
        top.add(txtCols);
        JButton btnGenerar = new JButton("Generar matriz (aleatoria)");
        top.add(btnGenerar);

        JTextArea txtMatriz = new JTextArea(10,70);
        txtMatriz.setEditable(false);
        txtMatriz.setLineWrap(true);
        txtMatriz.setWrapStyleWord(true);

        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnTransponer = new JButton("Transponer");
        acciones.add(btnTransponer);

        p.add(top, BorderLayout.NORTH);
        p.add(new JScrollPane(txtMatriz), BorderLayout.CENTER);
        p.add(acciones, BorderLayout.SOUTH);

        final int[][][] container = new int[1][][];

        btnGenerar.addActionListener(e -> {
            try {
                int f = Integer.parseInt(txtFilas.getText().trim());
                int c = Integer.parseInt(txtCols.getText().trim());
                if (f <= 0 || c <= 0) { txtMatriz.setText("Filas y columnas deben ser > 0"); return; }
                int[][] m = new int[f][c];
                Random r = new Random();
                for (int i = 0; i < f; i++)
                    for (int j = 0; j < c; j++)
                        m[i][j] = r.nextInt(10);
                container[0] = m;
                txtMatriz.setText(matrixToString(m));
            } catch (Exception ex) {
                txtMatriz.setText("Introduce filas y columnas válidas (enteros).");
            }
        });

        btnTransponer.addActionListener(e -> {
            int[][] m = container[0];
            if (m == null) { txtMatriz.setText("Primero genera una matriz."); return; }
            int f = m.length, c = m[0].length;
            int[][] t = new int[c][f];
            for (int i = 0; i < f; i++)
                for (int j = 0; j < c; j++)
                    t[j][i] = m[i][j];
            txtMatriz.setText("Original:\n" + matrixToString(m) + "\nTranspuesta:\n" + matrixToString(t));
            container[0] = t;
        });

        return p;
    }

    private String matrixToString(int[][] m) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) sb.append(String.format("%4d", m[i][j]));
            sb.append("\n");
        }
        return sb.toString();
    }

    private JPanel crearPanelListas() {
        JPanel p = new JPanel(new BorderLayout(8,8));
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField txtElemento = new JTextField(20);
        JButton btnAgregar = new JButton("Agregar al final");
        JButton btnMostrar = new JButton("Mostrar lista");
        JButton btnInvertir = new JButton("Invertir lista");
        JButton btnEliminar = new JButton("Eliminar primero");
        top.add(new JLabel("Elemento:"));
        top.add(txtElemento);
        top.add(btnAgregar);
        top.add(btnEliminar);
        top.add(btnMostrar);
        top.add(btnInvertir);

        JTextArea salida = new JTextArea(12,70);
        salida.setEditable(false);
        salida.setLineWrap(true);
        salida.setWrapStyleWord(true);

        LinkedList<String> lista = new LinkedList<>();

        btnAgregar.addActionListener(e -> {
            String el = txtElemento.getText().trim();
            if (el.isEmpty()) { salida.setText("Ingrese un elemento."); return; }
            lista.add(el);
            salida.setText("Elemento agregado: " + el + "\nLista actual: " + lista.toString());
            txtElemento.setText("");
        });

        btnEliminar.addActionListener(e -> {
            if (lista.isEmpty()) { salida.setText("La lista está vacía."); return; }
            String rem = lista.removeFirst();
            salida.setText("Elemento eliminado (primero): " + rem + "\nLista actual: " + lista.toString());
        });

        btnMostrar.addActionListener(e -> {
            salida.setText("Lista actual (" + lista.size() + " elementos): " + lista.toString());
        });

        btnInvertir.addActionListener(e -> {
            if (lista.isEmpty()) { salida.setText("La lista está vacía."); return; }
            Collections.reverse(lista);
            salida.setText("Lista invertida: " + lista.toString());
        });

        p.add(top, BorderLayout.NORTH);
        p.add(new JScrollPane(salida), BorderLayout.CENTER);

        return p;
    }

    private void showError(JTextArea salida) {
        salida.setText("Entrada inválida. Introduce números separados por comas, por ejemplo: 1, 2, 3");
    }
}
