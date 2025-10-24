package Temp;

import java.util.ArrayList;

public class BaseDatos {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static Usuario buscarUsuario(String nombre, String contraseña) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(nombre) && u.getContraseña().equals(contraseña)) {
                return u;
            }
        }
        return null;
    }
}
