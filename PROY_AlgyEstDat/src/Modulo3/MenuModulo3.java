package Modulo3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Modulo3.modelo.Usuario; 

public class MenuModulo3 extends JFrame {
    private Usuario usuario;

    public MenuModulo3(String nombreUsuario) {
        this.usuario = new Usuario(nombreUsuario); 
        initComponents();
    }

    private void initComponents() {
        setTitle("Módulo 3 - Pilas y Colas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 380);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel top = new JPanel(new BorderLayout());
        JLabel lblTitulo = new JLabel("Módulo 3: Pilas y Colas", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        top.add(lblTitulo, BorderLayout.CENTER);
        add(top, BorderLayout.NORTH);

        JPanel centro = new JPanel();
        centro.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton btnTeoria = new JButton("Teoría (Pilas y Colas)");
        JButton btnEjercicios = new JButton("Ejercicios (Operaciones y Postfija)");
        JButton btnSalir = new JButton("Volver al menú principal");

        btnTeoria.setPreferredSize(new Dimension(280, 50)); 
        btnEjercicios.setPreferredSize(new Dimension(280, 50)); 
        btnSalir.setPreferredSize(new Dimension(280, 50));

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
            JOptionPane.showMessageDialog(this, "Volviendo al menú principal (simulado).", "Salir", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        class Usuario {
            public Usuario(String n) { /* dummy constructor */ }
        }
        SwingUtilities.invokeLater(() -> {
            new MenuModulo3("EstudianteEjemplo").setVisible(true);
        });
    }
}