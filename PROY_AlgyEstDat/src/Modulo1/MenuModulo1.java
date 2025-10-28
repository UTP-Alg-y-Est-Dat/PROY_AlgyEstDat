package Modulo1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Modulo1.modelo.Usuario;

public class MenuModulo1 extends JFrame{
    private Usuario usuario;

    public MenuModulo1(String nombreUsuario) {
        this.usuario = new Usuario(nombreUsuario);
        initComponents();
    }

    private void initComponents() {
        setTitle("Sistema Educativo - Estructuras Lineales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 380);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel top = new JPanel(new BorderLayout());
        JLabel lblTitulo = new JLabel("Módulo: Estructuras de Datos Lineales", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        top.add(lblTitulo, BorderLayout.CENTER);
        add(top, BorderLayout.NORTH);

        JPanel centro = new JPanel();
        centro.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton btnTeoria = new JButton("Teoría");
        JButton btnEjercicios = new JButton("Ejercicios");
        JButton btnSalir = new JButton("Volver al menu principal");

        btnTeoria.setPreferredSize(new Dimension(180, 50));
        btnEjercicios.setPreferredSize(new Dimension(180, 50));
        btnSalir.setPreferredSize(new Dimension(180, 50));

        gbc.gridx = 0; gbc.gridy = 0;
        centro.add(btnTeoria, gbc);
        gbc.gridy = 1;
        centro.add(btnEjercicios, gbc);
        gbc.gridy = 2;
        centro.add(btnSalir, gbc);

        add(centro, BorderLayout.CENTER);

        btnTeoria.addActionListener(e -> {
            TeoriaFrame tf = new TeoriaFrame();
            tf.setVisible(true);
        });

        btnEjercicios.addActionListener(e -> {
            EjerciciosFrame ef = new EjerciciosFrame();
            ef.setVisible(true);
        });

        btnSalir.addActionListener(e -> {
            //cambio el dispose() para que envíe al menú principal.
        Menus.Menu GN = new Menus.Menu();
        GN.setVisible(true);
        dispose();
        });
    }
}
