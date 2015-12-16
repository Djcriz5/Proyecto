package Controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import com.db4o.ObjectContainer;

import clasesApp.Cliente;
import guideUserInterface.PrincipalLog;
import guideUserInterface.VentanaDeInformacion;
import guideUserInterface.VentanaUsuario;

public class GestionadorInformacion {
    VentanaDeInformacion vInformacion;

    public GestionadorInformacion(Cliente uncliente, ObjectContainer oC, ArrayList<Cliente> dbC, PrincipalLog p,
            VentanaUsuario vU) {
        vInformacion = new VentanaDeInformacion();
        vInformacion.getLblHome().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                vInformacion.dispose();
                vInformacion.setVisible(false);

            }
        });
        vInformacion.getLblQuejasys().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    p.getDesktopPane()
                            .add(new GestionadorDeQuejasySugerencias(uncliente, oC, dbC, p).getVentanaSugerencias());
                    p.getDesktopPane().repaint();
                    vU.setClosed(true);
                } catch (PropertyVetoException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        vInformacion.setVisible(true);
    }

    public VentanaDeInformacion getVentanaInformacion() {
        return vInformacion;
    }

}
