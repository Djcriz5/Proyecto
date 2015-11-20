package guideUserInterface;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.db4o.ObjectContainer;

import clasesApp.Cliente;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

public class Informacion extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private ImageIcon    iconoQuejas;
    private ImageIcon    iconoApp;
    private ImageIcon    iconoHome;

    /**
     * informacion y contacto de los desarrolladores
     */
    public Informacion(Cliente uncliente, ObjectContainer oC, ArrayList<Cliente> dbC, PrincipalLog p,
            VentanaUsuario vU) {
        setVisible(true);
        getContentPane().setBackground(Color.DARK_GRAY);
        setBounds(100, 100, 523, 371);
        getContentPane().setLayout(null);

        JLabel lblInonoapp = new JLabel("");
        lblInonoapp.setBounds(369, 16, 103, 103);
        iconoApp = new ImageIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/homeicon.png")).getImage()
                .getScaledInstance(lblInonoapp.getWidth(), lblInonoapp.getHeight(), Image.SCALE_DEFAULT));
        lblInonoapp.setIcon(iconoApp);
        getContentPane().add(lblInonoapp);

        JLabel lblSistemaDeCafeteria = new JLabel("Sistema de Cafeteria");
        lblSistemaDeCafeteria.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblSistemaDeCafeteria.setForeground(Color.WHITE);
        lblSistemaDeCafeteria.setBounds(15, 16, 241, 46);
        getContentPane().add(lblSistemaDeCafeteria);

        JTextArea txtrDesarrolladores = new JTextArea();
        txtrDesarrolladores.setBorder(null);
        txtrDesarrolladores.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtrDesarrolladores.setEditable(false);
        txtrDesarrolladores.setForeground(Color.WHITE);
        txtrDesarrolladores.setBackground(Color.DARK_GRAY);
        txtrDesarrolladores.setText(
                "Desarrolladores: \nSantuario  Parra Luis Fernando\nCastro Maya Cristopher\nRoberto Nava \nen caso de presentarce una eventualidad contactarnos \natraves de la ventana de quejas de sugerencia\no directamente al correo proyectoscepoo@gmail.com");
        txtrDesarrolladores.setBounds(25, 78, 421, 130);
        getContentPane().add(txtrDesarrolladores);

        JLabel lblHome = new JLabel("");
        lblHome.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                Informacion.this.dispose();
                Informacion.this.setVisible(false);

            }
        });
        lblHome.setBounds(349, 208, 97, 97);
        iconoHome = new ImageIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/home-icon.png")).getImage()
                .getScaledInstance(lblHome.getWidth(), lblHome.getHeight(), Image.SCALE_DEFAULT));
        lblHome.setIcon(iconoHome);
        getContentPane().add(lblHome);

        JLabel lblQuejasys = new JLabel("");
        lblQuejasys.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    VentanaSugerencias t = new VentanaSugerencias(uncliente, oC, dbC, p);
                    t.setVisible(true);
                    p.getDesktopPane().add(t);
                    p.getDesktopPane().repaint();
                    vU.setClosed(true);
                } catch (PropertyVetoException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        lblQuejasys.setBounds(35, 208, 97, 97);
        iconoQuejas = new ImageIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/quejas.png")).getImage()
                .getScaledInstance(lblQuejasys.getWidth(), lblQuejasys.getHeight(), Image.SCALE_DEFAULT));
        lblQuejasys.setIcon(iconoQuejas);
        getContentPane().add(lblQuejasys);
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

    }
}
