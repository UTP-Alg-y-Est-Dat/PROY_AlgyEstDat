package Modulo2.controlador;

import Modulo2.MenuModulo2;

public class ControladorMenu2 {
    public static void abrirMenuDesdeLogin(String usuario) {
        MenuModulo2 menu = new MenuModulo2(usuario);
        menu.setVisible(true);
    }
}
