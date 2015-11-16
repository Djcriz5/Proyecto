package Interfaz;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextPane;

import com.db4o.ObjectContainer;

import Aplicacion.Cliente;
import Aplicacion.Orden;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TicketDeCompra extends JInternalFrame {
    private Orden             orden;
    private String            contenido;
    private JTextArea         txtCAS;

    /**
     * 
     */
    private static final long serialVersionUID = -5415219723574567702L;

    /**
     * Create the frame.
     */
    public TicketDeCompra(Cliente uncliente, ObjectContainer oC, ArrayList<Cliente> dbC, PrincipalLog p) {
        contenido = uncliente.toString();
        orden = uncliente.getPedido();
        setResizable(true);
        setBounds(100, 100, 538, 499);
        getContentPane().setLayout(null);
        txtCAS = new JTextArea();
        JScrollPane textPane = new JScrollPane();
        textPane.setBounds(0, 96, 522, 362);
        txtCAS.setText(contenido);
        textPane.setViewportView(txtCAS);
        getContentPane().add(textPane);

        JButton btnNewButton = new JButton("Ticket de compra");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    almacenarEnBaseD(oC, dbC);
                    VentanaUsuario vC = new VentanaUsuario(uncliente, oC, dbC, p);
                    vC.setVisible(true);
                    p.getDesktopPane().add(vC);
                    p.getDesktopPane().repaint();
                    setClosed(true);
                } catch (PropertyVetoException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton.setBackground(new Color(0, 153, 255));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBounds(0, 0, 522, 95);
        getContentPane().add(btnNewButton);
        setVisible(true);
    }

    public static void almacenarEnBaseD(ObjectContainer baseDatos, ArrayList<Cliente> listaCliente) {
        try {
            baseDatos.delete(listaCliente);
            baseDatos.store(listaCliente);
            baseDatos.commit();
            System.out.println("Se ha almacenado correctamente en la base de datos");
        } catch (Exception e) {
            System.out.println("Se ha porducido un error en la insercion");
        }
    }
}
