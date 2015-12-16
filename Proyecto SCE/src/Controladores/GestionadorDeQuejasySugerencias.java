package Controladores;

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
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import com.db4o.ObjectContainer;

import clasesApp.Cliente;
import guideUserInterface.PrincipalLog;
import guideUserInterface.VentanaSugerencias;

public class GestionadorDeQuejasySugerencias {
    VentanaSugerencias vSugerencias;

    public GestionadorDeQuejasySugerencias(Cliente uncliente, ObjectContainer oC, ArrayList<Cliente> dbC,
            PrincipalLog p) {
        vSugerencias = new VentanaSugerencias();
        vSugerencias.getLblLabelenviar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    guardar(uncliente);
                    Thread hiloEmail = new Thread() {
                        public void run() {
                            enviarEmail(uncliente);
                        }
                    };
                    hiloEmail.start();
                    p.getDesktopPane().add(new GestionadorDeUsuario(uncliente, oC, dbC, p).getVentanaUsuario());
                    p.getDesktopPane().repaint();
                    vSugerencias.setClosed(true);
                    vSugerencias.setClosed(true);
                } catch (PropertyVetoException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        vSugerencias.setVisible(true);

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
            // aquien se manda el mensaje
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("proyectoscepoo@gmail.com"));
            message.setSubject(uncliente.getNombre());
            message.setText(hacerMensaje(uncliente));

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("proyectoscepoo@gmail.com", "proyectosceescom");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
            JOptionPane.showMessageDialog(null, "Mensaje enviado con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al enviar mensaje no estado conectado a internet");
        }
    }

    public String hacerMensaje(Cliente uncliente) {
        String mensaje = new String();
        mensaje = "Cliente:  " + uncliente.getNombre() + "\n" + vSugerencias.getTxtCAS().getText();
        return mensaje;
    }

    public void guardar(Cliente uncliente) {

        File name = new File("quejas.txt");
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
                BufferedWriter bw = new BufferedWriter(new FileWriter(name));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public VentanaSugerencias getVentanaSugerencias() {
        return vSugerencias;
    }

}
