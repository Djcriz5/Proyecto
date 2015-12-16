package guideUserInterface;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class VentanaDeInformacion extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private ImageIcon    iconoQuejas;
    private ImageIcon    iconoApp;
    private ImageIcon    iconoHome;
    private JLabel       lblInonoapp;
    private JLabel       lblSistemaDeCafeteria;
    private JTextArea    txtrDesarrolladores;
    private JLabel       lblHome;
    private JLabel       lblQuejasys;

    /**
     * informacion y contacto de los desarrolladores
     */
    public VentanaDeInformacion() {
        getContentPane().setBackground(Color.DARK_GRAY);
        setBounds(100, 100, 523, 371);
        getContentPane().setLayout(null);
        lblInonoapp = new JLabel("");
        lblInonoapp.setBounds(369, 16, 103, 103);
        iconoApp = new ImageIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/homeicon.png")).getImage()
                .getScaledInstance(lblInonoapp.getWidth(), lblInonoapp.getHeight(), Image.SCALE_DEFAULT));
        lblInonoapp.setIcon(iconoApp);
        getContentPane().add(lblInonoapp);
        lblSistemaDeCafeteria = new JLabel("Sistema de Cafeteria");
        lblSistemaDeCafeteria.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblSistemaDeCafeteria.setForeground(Color.WHITE);
        lblSistemaDeCafeteria.setBounds(15, 16, 241, 46);
        getContentPane().add(lblSistemaDeCafeteria);
        txtrDesarrolladores = new JTextArea();
        txtrDesarrolladores.setBorder(null);
        txtrDesarrolladores.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtrDesarrolladores.setEditable(false);
        txtrDesarrolladores.setForeground(Color.WHITE);
        txtrDesarrolladores.setBackground(Color.DARK_GRAY);
        txtrDesarrolladores.setText(
                "Desarrolladores: \nSantuario  Parra Luis Fernando\nCastro Maya Cristopher\nRoberto Nava \nen caso de presentarce una eventualidad contactarnos \natraves de la ventana de quejas de sugerencia\no directamente al correo proyectoscepoo@gmail.com");
        txtrDesarrolladores.setBounds(25, 78, 421, 130);
        getContentPane().add(txtrDesarrolladores);
        lblHome = new JLabel("");
        lblHome.setBounds(349, 208, 97, 97);
        iconoHome = new ImageIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/home-icon.png")).getImage()
                .getScaledInstance(lblHome.getWidth(), lblHome.getHeight(), Image.SCALE_DEFAULT));
        lblHome.setIcon(iconoHome);
        getContentPane().add(lblHome);
        lblQuejasys = new JLabel("");
        lblQuejasys.setBounds(35, 208, 97, 97);
        iconoQuejas = new ImageIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/quejas.png")).getImage()
                .getScaledInstance(lblQuejasys.getWidth(), lblQuejasys.getHeight(), Image.SCALE_DEFAULT));
        lblQuejasys.setIcon(iconoQuejas);
        getContentPane().add(lblQuejasys);
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

    }

    public JLabel getLblQuejasys() {
        return lblQuejasys;
    }

    public void setLblQuejasys(JLabel lblQuejasys) {
        this.lblQuejasys = lblQuejasys;
    }

    public JLabel getLblHome() {
        return lblHome;
    }

    public void setLblHome(JLabel lblHome) {
        this.lblHome = lblHome;
    }
}
