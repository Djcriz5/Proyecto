package guideUserInterface;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import com.db4o.ObjectContainer;

import clasesApp.Cliente;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;

public class VentanaUsuario extends JInternalFrame {

    private ImageIcon      iconoP;
    private ImageIcon      icaux;
    private JButton        btnHacerUnPedido;
    private JLabel         lblHacerP;
    private ImageIcon      iconoHacerP;
    private ImageIcon      iconoInformacion;
    private ImageIcon      iconoHistorial;
    private ImageIcon      iconoQuejas;
    private JButton        btnConsultarTickets;
    private AbstractButton btnInformacion;
    private JButton        btnQuejas;
    private JLabel         lblIconoP;
    private JLabel         lblInformacion;
    private JLabel         lblHistorial;
    private JLabel         blbQuejas;
    private ImageIcon      iconoPaux;

    /**
     * 
     * @param uncliente
     * @param oC
     * @param dbC
     * @param p
     */
    public VentanaUsuario(Cliente uncliente, ObjectContainer oC, ArrayList<Cliente> dbC, PrincipalLog p) {
        getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().setLayout(null);
        btnHacerUnPedido = new JButton("Hacer un Pedido");
        btnHacerUnPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    VentanaDeCompras shop = new VentanaDeCompras(uncliente, oC, dbC, p);

                    shop.setVisible(true);
                    p.getDesktopPane().add(shop);
                    setClosed(true);
                } catch (PropertyVetoException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btnHacerUnPedido.setBackground(new Color(255, 0, 51));
        btnHacerUnPedido.setBounds(15, 213, 170, 29);
        getContentPane().add(btnHacerUnPedido);

        btnConsultarTickets = new JButton("Consultar historial");
        btnConsultarTickets.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    TicketDeCompra t = new TicketDeCompra(uncliente, oC, dbC, p);
                    t.setVisible(true);
                    p.getDesktopPane().add(t);
                    setClosed(true);
                } catch (PropertyVetoException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btnConsultarTickets.setBackground(new Color(255, 0, 51));
        btnConsultarTickets.setBounds(318, 213, 181, 29);
        getContentPane().add(btnConsultarTickets);

        btnInformacion = new JButton("informacion");
        btnInformacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Informacion i = new Informacion(uncliente, oC, dbC, p, VentanaUsuario.this);
            }
        });
        btnInformacion.setBackground(new Color(255, 0, 51));
        btnInformacion.setBounds(15, 366, 170, 29);
        getContentPane().add(btnInformacion);

        btnQuejas = new JButton("Quejas y sugerencias");
        btnQuejas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaSugerencias t = new VentanaSugerencias(uncliente, oC, dbC, p);
                t.setVisible(true);
                p.getDesktopPane().add(t);
                try {
                    setClosed(true);
                } catch (PropertyVetoException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
        });
        btnQuejas.setBackground(new Color(255, 0, 51));
        btnQuejas.setBounds(318, 366, 181, 29);
        getContentPane().add(btnQuejas);

        lblIconoP = new JLabel("");
        iconoPaux = new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/home-icon.png"));
        lblIconoP.setBounds(27, 27, 142, 142);
        iconoP = new ImageIcon(iconoPaux.getImage().getScaledInstance(lblIconoP.getWidth(), lblIconoP.getHeight(),
                Image.SCALE_DEFAULT));
        lblIconoP.setIcon(iconoP);
        getContentPane().add(lblIconoP);

        lblHacerP = new JLabel("");
        lblHacerP.setBounds(200, 185, 80, 80);
        iconoHacerP = new ImageIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/shop.png")).getImage()
                .getScaledInstance(lblHacerP.getWidth(), lblHacerP.getHeight(), Image.SCALE_DEFAULT));
        lblHacerP.setIcon(iconoHacerP);
        getContentPane().add(lblHacerP);

        lblInformacion = new JLabel("");
        lblInformacion.setBounds(200, 338, 86, 86);
        iconoInformacion = new ImageIcon(
                new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/usericon.png")).getImage()
                        .getScaledInstance(lblInformacion.getWidth(), lblInformacion.getHeight(), Image.SCALE_DEFAULT));
        lblInformacion.setIcon(iconoInformacion);
        getContentPane().add(lblInformacion);

        lblHistorial = new JLabel("");
        lblHistorial.setBounds(514, 185, 88, 86);
        iconoHistorial = new ImageIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/historial.png"))
                .getImage().getScaledInstance(lblHistorial.getWidth(), lblHistorial.getHeight(), Image.SCALE_DEFAULT));
        lblHistorial.setIcon(iconoHistorial);
        getContentPane().add(lblHistorial);

        blbQuejas = new JLabel("");
        blbQuejas.setBounds(514, 338, 88, 86);
        iconoQuejas = new ImageIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/quejas.png")).getImage()
                .getScaledInstance(blbQuejas.getWidth(), blbQuejas.getHeight(), Image.SCALE_DEFAULT));
        blbQuejas.setIcon(iconoQuejas);
        getContentPane().add(blbQuejas);
        setBounds(100, 100, 633, 545);

    }

}
