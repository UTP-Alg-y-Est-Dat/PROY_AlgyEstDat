package Modulo2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Modulo2.modelo.Usuario;

public class MenuModulo2 extends JFrame {
    private Usuario usuario;

    public MenuModulo2(String nombreUsuario) {
        this.usuario = new Usuario(nombreUsuario);
        initComponents();
    }

    private void initComponents() {
        setTitle("Sistema Educativo - Estructuras de Datos Dinámicas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 420);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel top = new JPanel(new BorderLayout());
        JLabel lblTitulo = new JLabel("Módulo: Estructuras de Datos Dinámicas", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        top.add(lblTitulo, BorderLayout.CENTER);
        add(top, BorderLayout.NORTH);

        JPanel centro = new JPanel();
        centro.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton btnTema4 = new JButton("Tema 04: TAD");
        JButton btnTema5 = new JButton("Tema 05: Listas Enlazadas Simples");
        JButton btnTema6 = new JButton("Tema 06: Operaciones en Listas Simples");
        JButton btnTema7 = new JButton("Tema 07: Listas Dobles y Circulares");
        JButton btnSalir = new JButton("Volver al menú principal");

        Dimension size = new Dimension(260, 50);
        btnTema4.setPreferredSize(size);
        btnTema5.setPreferredSize(size);
        btnTema6.setPreferredSize(size);
        btnTema7.setPreferredSize(size);
        btnSalir.setPreferredSize(size);

        gbc.gridx = 0; gbc.gridy = 0;
        centro.add(btnTema4, gbc);
        gbc.gridy = 1;
        centro.add(btnTema5, gbc);
        gbc.gridy = 2;
        centro.add(btnTema6, gbc);
        gbc.gridy = 3;
        centro.add(btnTema7, gbc);
        gbc.gridy = 4;
        centro.add(btnSalir, gbc);

        add(centro, BorderLayout.CENTER);

        btnTema4.addActionListener(e -> {
            Tema4Frame t4 = new Tema4Frame();
            t4.setVisible(true);
        });

        btnTema5.addActionListener(e -> {
            Tema5Frame t5 = new Tema5Frame();
            t5.setVisible(true);
        });

        btnTema6.addActionListener(e -> {
            Tema6Frame t6 = new Tema6Frame();
            t6.setVisible(true);
        });

        btnTema7.addActionListener(e -> {
            Tema7Frame t7 = new Tema7Frame();
            t7.setVisible(true);
        });

        btnSalir.addActionListener(e -> {
            Menus.Menu menu = new Menus.Menu();
            menu.setVisible(true);
            dispose();
        });
    }
}
