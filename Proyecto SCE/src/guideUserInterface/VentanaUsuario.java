package guideUserInterface;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class VentanaUsuario extends JInternalFrame {

    private ImageIcon iconoP;
    private ImageIcon icaux;
    private JButton   btnHacerUnPedido;
    private JLabel    lblHacerP;
    private ImageIcon iconoHacerP;
    private ImageIcon iconoInformacion;
    private ImageIcon iconoHistorial;
    private ImageIcon iconoQuejas;
    private JButton   btnConsultarTickets;
    private JButton   btnInformacion;
    private JButton   btnQuejas;
    private JLabel    lblIconoP;
    private JLabel    lblInformacion;
    private JLabel    lblHistorial;
    private JLabel    blbQuejas;
    private ImageIcon iconoPaux;

    public VentanaUsuario() {
        getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().setLayout(null);
        setBtnHacerUnPedido(new JButton("Hacer un Pedido"));
        getBtnHacerUnPedido().setBackground(new Color(255, 0, 51));
        getBtnHacerUnPedido().setBounds(15, 213, 170, 29);
        getContentPane().add(getBtnHacerUnPedido());
        btnConsultarTickets = new JButton("Consultar historial");
        btnConsultarTickets.setBackground(new Color(255, 0, 51));
        btnConsultarTickets.setBounds(318, 213, 181, 29);
        getContentPane().add(btnConsultarTickets);

        btnInformacion = new JButton("informacion");
        btnInformacion.setBackground(new Color(255, 0, 51));
        btnInformacion.setBounds(15, 366, 170, 29);
        getContentPane().add(btnInformacion);

        btnQuejas = new JButton("Quejas y sugerencias");
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

    public JButton getBtnHacerUnPedido() {
        return btnHacerUnPedido;
    }

    public void setBtnHacerUnPedido(JButton btnHacerUnPedido) {
        this.btnHacerUnPedido = btnHacerUnPedido;
    }

    public JButton getBtnConsultarTickets() {
        return btnConsultarTickets;
    }

    public void setBtnConsultarTickets(JButton btnConsultarTickets) {
        this.btnConsultarTickets = btnConsultarTickets;
    }

    public JButton getBtnInformacion() {
        return btnInformacion;
    }

    public void setBtnInformacion(JButton btnInformacion) {
        this.btnInformacion = btnInformacion;
    }

    public JButton getBtnQuejas() {
        return btnQuejas;
    }

    public void setBtnQuejas(JButton btnQuejas) {
        this.btnQuejas = btnQuejas;
    }

}
