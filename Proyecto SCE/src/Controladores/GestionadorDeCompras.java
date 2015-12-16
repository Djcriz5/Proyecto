package Controladores;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
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
import guideUserInterface.VentanaDeCompras;

public class GestionadorDeCompras {
    private VentanaDeCompras vCompras;

    public GestionadorDeCompras(Cliente uncliente, ObjectContainer oC, ArrayList<Cliente> dbC, PrincipalLog p) {
        vCompras = new VentanaDeCompras();
        vCompras.getBtnConfirmarPreparado().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (vCompras.getRdbtnIngredienteExtra().isSelected()) {
                    uncliente.comprar(uncliente.getProducto("Preparado",
                            getIndexPreparado((String) vCompras.getCbPreparado().getSelectedItem()),
                            getIndexIngredienteE((String) vCompras.getCbIngredienteEs().getSelectedItem())));
                    JOptionPane.showMessageDialog(null,
                            "Se a comprado" + uncliente.getProducto("Preparado",
                                    getIndexPreparado((String) vCompras.getCbPreparado().getSelectedItem()),
                                    getIndexIngredienteE((String) vCompras.getCbIngredienteEs().getSelectedItem())));
                    System.out.println(uncliente);
                } else {
                    uncliente.comprar(uncliente.getProducto("Preparado",
                            getIndexPreparado((String) vCompras.getCbPreparado().getSelectedItem())));
                    JOptionPane.showMessageDialog(null, "Se a comprado" + uncliente.getProducto("Preparado",
                            getIndexPreparado((String) vCompras.getCbPreparado().getSelectedItem())));
                    System.out.println(uncliente);
                }
            }
        });
        vCompras.getBtnConfirmarBebida().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                uncliente.comprar(uncliente.getProducto("Bebida",
                        getIndexBebida((String) vCompras.getCbBebida().getSelectedItem())));
                JOptionPane.showMessageDialog(null, "Se a comprado" + uncliente.getProducto("Bebida",
                        getIndexBebida((String) vCompras.getCbBebida().getSelectedItem())));
                System.out.println(uncliente);
            }
        });
        vCompras.getBtnConfirmarGolosina().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uncliente.comprar(uncliente.getProducto("Golosina",
                        getIndexGolosina((String) vCompras.getCbGolosina().getSelectedItem())));
                JOptionPane.showMessageDialog(null, "Se a comprado" + uncliente.getProducto("Golosina",
                        getIndexGolosina((String) vCompras.getCbGolosina().getSelectedItem())));
                System.out.println(uncliente);
            }
        });
        vCompras.getBtnConfirmarHelado().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uncliente.comprar(uncliente.getProducto("Helado",
                        getIndexHelado((String) vCompras.getCbHelado().getSelectedItem())));
                JOptionPane.showMessageDialog(null, "Se a comprado:" + uncliente.getProducto("Helado",
                        getIndexHelado((String) vCompras.getCbHelado().getSelectedItem())));
                System.out.println(uncliente);
            }
        });
        vCompras.getBtnConfirmarLacteo().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uncliente.comprar(uncliente.getProducto("Lacteo",
                        getIndexLacteo((String) vCompras.getCbLacteo().getSelectedItem())));
                JOptionPane.showMessageDialog(null, "Se a comprado" + uncliente.getProducto("Lacteo",
                        getIndexLacteo((String) vCompras.getCbLacteo().getSelectedItem())));
                System.out.println(uncliente);
            }
        });
        vCompras.getCheckElegirBebida().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (vCompras.getCheckElegirBebida().isSelected()) {
                    vCompras.getCbPaqueteDelDia().setBackground(new Color(30, 144, 255));
                    vCompras.getCbPaqueteDelDia().setEnabled(true);
                } else {
                    vCompras.getCbPaqueteDelDia().setBackground(Color.black);
                    vCompras.getCbPaqueteDelDia().setEnabled(false);
                }
            }
        });
        vCompras.getBtnConfirmarPaqueteDelDia().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (vCompras.getCheckElegirBebida().isSelected()) {
                    uncliente.comprar(uncliente.getProducto("Paquete del dia",
                            getIndexBebida((String) vCompras.getCbPaqueteDelDia().getSelectedItem())));
                    JOptionPane.showMessageDialog(null, "Se a comprado" + uncliente.getProducto("Paquete del dia",
                            getIndexBebida((String) vCompras.getCbPaqueteDelDia().getSelectedItem())));
                    System.out.println(uncliente);
                } else {
                    uncliente.comprar(uncliente.getProducto("Paquete del dia", 0));
                    JOptionPane.showMessageDialog(null, "Se a comprado" + uncliente.getProducto("Paquete del dia", 0));
                    System.out.println(uncliente);
                }
            }
        });
        vCompras.getRdbtnIngredienteExtra().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (vCompras.getRdbtnIngredienteExtra().isSelected()) {
                    vCompras.getCbIngredienteEs().setBackground(Color.white);
                    vCompras.getCbIngredienteEs().setEnabled(true);
                } else {
                    vCompras.getCbIngredienteEs().setBackground(Color.DARK_GRAY);
                    vCompras.getCbIngredienteEs().setEnabled(false);
                }
            }
        });
        vCompras.getLblLblconfirmar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                try {
                    almacenarEnBaseD(oC, dbC);

                    p.getDesktopPane().add(new GestionadorTicket(uncliente, oC, dbC, p).getTicket());
                    vCompras.setClosed(true);
                    p.getDesktopPane().repaint();
                    Thread hiloEmail = new Thread() {
                        public void run() {
                            enviarEmail(uncliente);
                        }
                    };
                    hiloEmail.start();
                } catch (PropertyVetoException e1) {
                    e1.printStackTrace();
                }
            }
        });
        vCompras.getLblLabelhome().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    p.getDesktopPane().add(new GestionadorDeUsuario(uncliente, oC, dbC, p).getVentanaUsuario());
                    p.getDesktopPane().repaint();
                    vCompras.setClosed(true);
                } catch (PropertyVetoException e1) {
                    e1.printStackTrace();
                }
            }
        });
        vCompras.setVisible(true);

    }

    private int getIndexBebida(String tipo) {
        int index = 0;
        switch (tipo) {
        case "coca cola":
            index = 1;
            break;
        case "Sprite":
            index = 2;
            break;
        case "Nestea":
            index = 3;
            break;
        case "Manzanita":
            index = 4;
            break;
        case "Fanta":
            index = 5;
            break;
        case "Boing Guayaba":
            index = 6;
            break;
        case "Boing uva":
            index = 7;
            break;
        case "Boing manzana":
            index = 8;
            break;
        case "Agua embotellada":
            index = 9;
            break;
        default:
            index = 0;
            break;
        }
        return index;
    }

    private int getIndexGolosina(String tipo) {
        int index = 0;
        switch (tipo) {
        case "Paleta":
            index = 1;
            break;
        case "Gomitas":
            index = 2;
            break;
        case "KitKat":
            index = 3;
            break;
        case "Pasitas":
            index = 4;
            break;
        case "gansito":
            index = 5;
            break;
        case "Carlos XV":
            index = 6;
            break;
        case "lunetas":
            index = 7;
            break;
        default:
            index = 0;
            break;
        }
        return index;
    }

    public int getIndexHelado(String tipo) {
        int index = 0;
        switch (tipo) {
        case "Helado de Yogurt":
            index = 1;
            break;
        case "Helado fresa":
            index = 2;
            break;
        case "Helado de Chocolate":
            index = 3;
            break;
        case "Paleta magnum Almendras":
            index = 4;
            break;
        case "Helado Vainilla":
            index = 5;
            break;
        case "Helado de yogurt Taro":
            index = 6;
            break;
        default:
            index = 0;
            break;
        }
        return index;
    }

    public int getIndexLacteo(String tipo) {
        int index = 0;
        switch (tipo) {
        case "Griego Yoplait":
            index = 1;
            break;
        case "Yoplait de fresa":
            index = 2;
            break;
        case "Yoplait de Manzana":
            index = 3;
            break;
        case "Leche 400ml Santa clara":
            index = 4;
            break;
        case "Leche Deslactosada 400ml Santa clara":
            index = 5;
            break;
        case "Jugo Ades":
            index = 6;
            break;
        default:
            index = 0;
            break;
        }
        return index;
    }

    private int getIndexIngredienteE(String cual) {
        int index = 0;
        switch (cual) {
        case "jamon extra":
            index = 1;
            break;
        case "Pechuga de pavo":
            index = 2;
            break;
        case "queso extra":
            index = 3;
            break;
        case "Aguacate":
            index = 4;
        case "Aderezos":
            index = 5;
            break;
        case "Guacamole":
            index = 6;
            break;
        case "BBq":
            index = 7;
            break;
        case "Wasabi":
            index = 8;
            break;
        default:
            break;
        }
        return index;
    }

    public int getIndexPreparado(String tipo) {
        int index = 0;
        switch (tipo) {
        case "Sandwich":
            index = 1;
            break;
        case "Molletes":
            index = 2;
            break;
        case "Tortas":
            index = 3;
            break;
        case "Ensalada de Atun":
            index = 4;
            break;
        case "Ensalada de pollo":
            index = 5;
            break;
        case "Pechuga Empanisada con ensalada":
            index = 6;
            break;
        case "Enchiladas":
            index = 7;
            break;
        case "Orden de tacos":
            index = 8;
            break;
        case "Guisado Del dia":
            index = 9;
            break;
        case "Sushi":
            index = 10;
            break;
        default:
            index = 0;
            break;
        }
        return index;

    }

    public static void almacenarEnBaseD(ObjectContainer baseDatos, ArrayList<Cliente> listaCliente) {
        try {
            baseDatos.store(listaCliente);
            baseDatos.commit();
            System.out.println("Se ha almacenado correctamente en la base de datos");
        } catch (Exception e) {
            System.out.println("Se ha porducido un error en la insercion");
        }
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
            message.setSubject("Orden");
            message.setText(hacerMensaje(uncliente));

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("proyectoscepoo@gmail.com", "proyectosceescom");
            t.sendMessage(message, message.getAllRecipients());
            JOptionPane.showMessageDialog(null, "la orden a sido enviada correctamente");
            // Cierre.

            t.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al enviar mensaje no estado conectado a internet");
        }
    }

    public String hacerMensaje(Cliente uncliente) {
        String mensaje = new String();
        mensaje = "El Cliente:  " + uncliente.getNombre() + "\nA pedido" + uncliente;
        return mensaje;
    }

    public VentanaDeCompras getVentanaDeCompras() {
        return vCompras;
    }
}
