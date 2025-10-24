
package Main;

import Login.Login;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Login ventana = new Login();
            ventana.setVisible(true);
        });
    }
}