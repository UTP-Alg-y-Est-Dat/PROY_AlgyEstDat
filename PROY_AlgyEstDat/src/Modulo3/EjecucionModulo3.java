package Modulo3;

import javax.swing.SwingUtilities;
import Modulo3.MenuModulo3; // Importa el menú del Modulo 3

public class mainprueba {
    public static void main(String[] args) {
        // Asegura que la interfaz gráfica de Swing se ejecute de forma segura
        SwingUtilities.invokeLater(() -> {
            // Se crea una instancia del MenuModulo3 para Pilas y Colas
            // y se le pasa un nombre de usuario de prueba.
            MenuModulo3 menu = new MenuModulo3("usuario_prueba");
            menu.setVisible(true);
        });
    }
}
