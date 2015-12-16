package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import com.db4o.ObjectContainer;

import clasesApp.Cliente;
import guideUserInterface.PrincipalLog;
import guideUserInterface.TicketDeCompra;

public class GestionadorTicket {
    private TicketDeCompra ticket;
    private String         contenido;

    public GestionadorTicket(Cliente uncliente, ObjectContainer oC, ArrayList<Cliente> dbC, PrincipalLog p) {
        contenido = uncliente.toString();
        ticket = new TicketDeCompra(contenido);
        ticket.getBtnNewButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    almacenarEnBaseD(oC, dbC);
                    p.getDesktopPane().add(new GestionadorDeUsuario(uncliente, oC, dbC, p).getVentanaUsuario());
                    p.getDesktopPane().repaint();
                    ticket.setClosed(true);
                } catch (PropertyVetoException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        ticket.setVisible(true);
    }

    public void almacenarEnBaseD(ObjectContainer baseDatos, ArrayList<Cliente> listaCliente) {
        try {
            baseDatos.delete(listaCliente);
            baseDatos.store(listaCliente);
            baseDatos.commit();
            System.out.println("Se ha almacenado correctamente en la base de datos");
        } catch (Exception e) {
            System.out.println("Se ha porducido un error en la insercion");
        }
    }

    public TicketDeCompra getTicket() {
        return ticket;
    }

    public void setTicket(TicketDeCompra ticket) {
        this.ticket = ticket;
    }

}
