package Aplicacion;

import java.awt.EventQueue;

import guideUserInterface.PrincipalLog;

public class TiendaVirtual {

    /**
     * Clase principal se encarga de leer la base de datos de clietes y de
     * gestionar las demasfunciones de la aplicacion
     */
    public static void main(String[] args) {
        PrincipalLog window = new PrincipalLog();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            }
        });
    }

}
