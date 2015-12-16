package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import com.db4o.ObjectContainer;

import clasesApp.Cliente;
import guideUserInterface.PrincipalLog;
import guideUserInterface.VentanaUsuario;

public class GestionadorDeUsuario {
    private VentanaUsuario vUsuario;

    public GestionadorDeUsuario(Cliente uncliente, ObjectContainer oC, ArrayList<Cliente> dbC, PrincipalLog p) {
        vUsuario = new VentanaUsuario();
        vUsuario.getBtnHacerUnPedido().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    p.getDesktopPane().add(new GestionadorDeCompras(uncliente, oC, dbC, p).getVentanaDeCompras());
                    vUsuario.setClosed(true);
                } catch (PropertyVetoException e1) {
                    e1.printStackTrace();
                }
            }
        });
        vUsuario.getBtnConsultarTickets().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    p.getDesktopPane().add(new GestionadorTicket(uncliente, oC, dbC, p).getTicket());
                    vUsuario.setClosed(true);
                } catch (PropertyVetoException e1) {
                    e1.printStackTrace();
                }
            }
        });
        vUsuario.getBtnInformacion().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GestionadorInformacion(uncliente, oC, dbC, p, vUsuario);
            }
        });
        vUsuario.getBtnQuejas().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p.getDesktopPane()
                        .add(new GestionadorDeQuejasySugerencias(uncliente, oC, dbC, p).getVentanaSugerencias());
                try {
                    vUsuario.setClosed(true);
                } catch (PropertyVetoException e1) {
                    e1.printStackTrace();
                }

            }
        });
        vUsuario.setVisible(true);
    }

    public VentanaUsuario getVentanaUsuario() {
        return vUsuario;
    }

    public void setvUsuario(VentanaUsuario vUsuario) {
        this.vUsuario = vUsuario;
    }

}
