package Interfaz;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import com.db4o.ObjectContainer;

import Aplicacion.Cliente;
import Productos.Bebida;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaDeCompras extends JInternalFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 8045284595207835913L;
    private JComboBox    cbPaqueteDelDia;
    private ImageIcon    iconoBebida;
    private JLabel       lblBebida;
    private JComboBox    cbBebida;
    private JButton      btnConfirmarBebida;
    private JLabel       lblGolosina;
    private JComboBox    cbGolosina;
    private JButton      btnConfirmarGolosina;
    private JLabel       lblHelado;
    private JComboBox    cbHelado;
    private JButton      btnConfirmarHelado;
    private JLabel       lblLacteo;
    private JComboBox    cbLacteo;
    private JButton      btnConfirmarLacteo;
    private JLabel       lblPaqueteDelDia;
    private JRadioButton checkElegirBebida;
    private JComboBox    cbPreparado;
    private ImageIcon    iconoHelado;
    private ImageIcon    iconoGolosina;
    private ImageIcon    iconoLacteo;
    private ImageIcon    iconoPaqueteDelDia;
    private ImageIcon    iconoPreparado;
    private JButton      btnConfirmarPaqueteDelDia;
    private JLabel       lblPreparado;
    private JRadioButton rdbtnIngredienteExtra;
    private JComboBox    cbIngredienteEspecial;
    private JButton      btnConfirmarPreparado;
    private JButton      btnConfirmarCompra;

    /**
     * Create the frame.
     */
    public VentanaDeCompras(Cliente uncliente, ObjectContainer oC, ArrayList<Cliente> dbC) {
        getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().setLayout(null);
        // variables bebida
        lblBebida = new JLabel("Bebida");
        lblBebida.setBounds(98, 21, 105, 105);
        getContentPane().add(lblBebida);
        iconoBebida = new ImageIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/bebidaicon.png"))
                .getImage().getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblBebida.setIcon(iconoBebida);
        getContentPane().add(lblBebida);
        cbBebida = new JComboBox();
        cbBebida.setBounds(88, 135, 115, 26);
        cbBebida.addItem("coca cola");
        cbBebida.addItem("Sprite");
        cbBebida.addItem("Nestea");
        cbBebida.addItem("Manzanita");
        cbBebida.addItem("Fanta");
        cbBebida.addItem("Boing Guayaba");
        cbBebida.addItem("Boing uva");
        cbBebida.addItem("Boing manzana");
        cbBebida.addItem("Agua embotellada");
        getContentPane().add(cbBebida);

        btnConfirmarBebida = new JButton("");
        btnConfirmarBebida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                uncliente.comprar(uncliente.getProducto("Bebida", getIndexBebida((String) cbBebida.getSelectedItem())));
                System.out.println(uncliente);
            }
        });
        btnConfirmarBebida.setBackground(new Color(30, 144, 255));
        btnConfirmarBebida.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarBebida.setBounds(218, 124, 42, 37);
        getContentPane().add(btnConfirmarBebida);
        // variables golosina
        lblGolosina = new JLabel("Golosina");
        lblGolosina.setBounds(351, 16, 115, 115);
        iconoGolosina = new ImageIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/candyicon.png"))
                .getImage().getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblGolosina.setIcon(iconoGolosina);
        getContentPane().add(lblGolosina);
        cbGolosina = new JComboBox();
        cbGolosina.setBounds(351, 135, 115, 26);
        getContentPane().add(cbGolosina);
        btnConfirmarGolosina = new JButton("");
        btnConfirmarGolosina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnConfirmarGolosina.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarGolosina.setBackground(new Color(30, 144, 255));
        btnConfirmarGolosina.setBounds(481, 124, 42, 37);
        getContentPane().add(btnConfirmarGolosina);
        // variable helado
        lblHelado = new JLabel("Helado");
        lblHelado.setBounds(98, 172, 115, 115);
        iconoHelado = new ImageIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/icecreamicon.png"))
                .getImage().getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblHelado.setIcon(iconoHelado);
        getContentPane().add(lblHelado);
        cbHelado = new JComboBox();
        cbHelado.setBounds(88, 295, 115, 26);
        getContentPane().add(cbHelado);
        btnConfirmarHelado = new JButton("");
        btnConfirmarHelado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnConfirmarHelado.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarHelado.setBackground(new Color(30, 144, 255));
        btnConfirmarHelado.setBounds(218, 284, 42, 37);
        getContentPane().add(btnConfirmarHelado);
        // variables Lacteo

        lblLacteo = new JLabel("Lacteo");
        lblLacteo.setBounds(351, 172, 115, 115);
        iconoLacteo = new ImageIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/milkicon.png"))
                .getImage().getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblLacteo.setIcon(iconoLacteo);
        getContentPane().add(lblLacteo);
        cbLacteo = new JComboBox();
        cbLacteo.setBounds(351, 295, 115, 26);
        getContentPane().add(cbLacteo);
        btnConfirmarLacteo = new JButton("");
        btnConfirmarLacteo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnConfirmarLacteo.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarLacteo.setBackground(new Color(30, 144, 255));
        btnConfirmarLacteo.setBounds(481, 284, 42, 37);
        getContentPane().add(btnConfirmarLacteo);
        setBounds(0, 0, 700, 600);
        // variables paquete del dia
        lblPaqueteDelDia = new JLabel("Paquete del Dia");
        lblPaqueteDelDia.setBounds(108, 326, 120, 134);
        iconoPaqueteDelDia = new ImageIcon(
                new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/paqueteDelDia.png")).getImage()
                        .getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblPaqueteDelDia.setIcon(iconoPaqueteDelDia);
        getContentPane().add(lblPaqueteDelDia);
        cbPaqueteDelDia = new JComboBox();
        cbPaqueteDelDia.setBounds(88, 500, 154, 26);
        getContentPane().add(cbPaqueteDelDia);
        checkElegirBebida = new JRadioButton("Elegir bebida");
        checkElegirBebida.setBounds(88, 459, 155, 29);
        getContentPane().add(checkElegirBebida);

        cbPreparado = new JComboBox();
        cbPreparado.setBounds(517, 460, 152, 26);
        getContentPane().add(cbPreparado);

        btnConfirmarPaqueteDelDia = new JButton("");
        btnConfirmarPaqueteDelDia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnConfirmarPaqueteDelDia.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarPaqueteDelDia.setBackground(new Color(30, 144, 255));
        btnConfirmarPaqueteDelDia.setBounds(257, 489, 42, 37);
        getContentPane().add(btnConfirmarPaqueteDelDia);
        // variables Preparado
        lblPreparado = new JLabel("Preparado");
        lblPreparado.setBounds(361, 336, 115, 115);
        iconoPreparado = new ImageIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/preparadoIcon.png"))
                .getImage().getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblPreparado.setIcon(iconoPreparado);
        getContentPane().add(lblPreparado);
        rdbtnIngredienteExtra = new JRadioButton("ingrediente extra");
        rdbtnIngredienteExtra.setBounds(351, 459, 155, 29);
        getContentPane().add(rdbtnIngredienteExtra);
        cbIngredienteEspecial = new JComboBox();
        cbIngredienteEspecial.setBounds(351, 500, 152, 26);
        getContentPane().add(cbIngredienteEspecial);
        btnConfirmarPreparado = new JButton("");
        btnConfirmarPreparado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnConfirmarPreparado.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarPreparado.setBackground(new Color(30, 144, 255));
        btnConfirmarPreparado.setBounds(517, 489, 42, 37);
        getContentPane().add(btnConfirmarPreparado);

        btnConfirmarCompra = new JButton("Confirmar Compra");
        btnConfirmarCompra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                almacenarEnBaseD(oC, dbC);
                getContentPane().removeAll();
                getContentPane().repaint();
                getContentPane().add(new TicketDeCompra(uncliente, oC, dbC));
            }
        });
        btnConfirmarCompra.setBounds(517, 35, 167, 29);
        getContentPane().add(btnConfirmarCompra);
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
