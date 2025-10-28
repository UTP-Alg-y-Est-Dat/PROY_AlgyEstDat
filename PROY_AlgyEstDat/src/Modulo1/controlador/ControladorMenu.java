package Modulo1.controlador;

import Modulo1.MenuModulo1;

public class ControladorMenu {
    public static void abrirMenuDesdeLogin(String usuario) {
        MenuModulo1 menu = new MenuModulo1(usuario);
        menu.setVisible(true);
    }
}
