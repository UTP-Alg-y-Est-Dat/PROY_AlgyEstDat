package Modulo1;

import javax.swing.SwingUtilities;
import Modulo1.MenuModulo1;

public class mainprueba {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuModulo1 menu = new MenuModulo1("usuario_prueba");
            menu.setVisible(true);
        });
    }
}
