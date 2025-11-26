package Modulo2;

import javax.swing.SwingUtilities;

public class mainModulo2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuModulo2 menu = new MenuModulo2("usuario_prueba");
            menu.setVisible(true);
        });
    }
}

