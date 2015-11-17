package Interfaz;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.TextArea;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import com.db4o.ObjectContainer;

import Aplicacion.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Properties;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class VentanaSugerencias extends JInternalFrame {
    /**
     * 
     */
    private static final long serialVersionUID = -993343925484792976L;
    private JScrollPane       textPane;
    private JTextArea         txtCAS;
    private ImageIcon         iconoEnviar;
    private File              name;
    private BufferedWriter    bw;

    /**
     * Create the frame.
     */
    public VentanaSugerencias(Cliente uncliente, ObjectContainer oC, ArrayList<Cliente> dbC, PrincipalLog p) {
        getContentPane().setBackground(Color.DARK_GRAY);
        setBounds(100, 100, 587, 576);
        getContentPane().setLayout(null);
        txtCAS = new JTextArea();
        textPane = new JScrollPane();
        textPane.setBounds(55, 150, 464, 353);
        textPane.setViewportView(txtCAS);
        getContentPane().add(textPane);

        JLabel lblLabelenviar = new JLabel("");
        lblLabelenviar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    guardar(uncliente);
                    enviarEmail(uncliente);
                    VentanaUsuario vC = new VentanaUsuario(uncliente, oC, dbC, p);
                    vC.setVisible(true);
                    p.getDesktopPane().add(vC);
                    p.getDesktopPane().repaint();
                    setClosed(true);
                    setClosed(true);
                } catch (PropertyVetoException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        lblLabelenviar.setBounds(416, 29, 103, 91);
        iconoEnviar = new ImageIcon(
                new ImageIcon(VentanaSugerencias.class.getResource("/Imagenes/enviar.png")).getImage()
                        .getScaledInstance(lblLabelenviar.getWidth(), lblLabelenviar.getHeight(), Image.SCALE_DEFAULT));
        lblLabelenviar.setIcon(iconoEnviar);
        getContentPane().add(lblLabelenviar);

        JLabel lblQuejasYSugerencias = new JLabel("Quejas y sugerencias");
        lblQuejasYSugerencias.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblQuejasYSugerencias.setForeground(Color.WHITE);
        lblQuejasYSugerencias.setBounds(71, 61, 264, 46);
        getContentPane().add(lblQuejasYSugerencias);
        setVisible(true);

    }

    public void enviarEmail(Cliente uncliente) {
        try {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "proyectoscepoo@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("proyectoscepoo@gmail.com.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("proyectoscepoo@gmail.com"));
            message.setSubject(uncliente.getNombre());
            message.setText(hacerMensaje(uncliente));

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("proyectoscepoo@gmail.com", "proyectosceescom");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String hacerMensaje(Cliente uncliente) {
        String mensaje = new String();
        mensaje = "Cliente:  " + uncliente.getNombre() + "\n" + txtCAS.getText();
        return mensaje;
    }

    public void guardar(Cliente uncliente) {
        name = new File("quejas.txt");
        if (name.exists()) {
            try {
                BufferedReader input = new BufferedReader(new FileReader(name));
                StringBuffer buffer = new StringBuffer();
                String text;
                while ((text = input.readLine()) != null)
                    buffer.append(text);
                PrintWriter output = new PrintWriter(new FileWriter(name));
                output.write("///////////////////////// \n" + hacerMensaje(uncliente) + "\n " + buffer.toString()
                        + "\n////////////////////////////////");
                output.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error en el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            try {
                bw = new BufferedWriter(new FileWriter(name));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
