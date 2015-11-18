package Interfaz;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;

import com.db4o.ObjectContainer;

import Aplicacion.Administrador;
import Aplicacion.Cliente;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class VentanaAdmin extends JInternalFrame {
    private JTable     table;
    private JComboBox  comboBox;
    String[]           selectedCliente;
    private JTextArea  txtpnInformacionDelCliente;
    private JTextField txtReposnuevopass;
    private JTextField txtReposnuevosaldo;
    private JButton    btnCambiarSaldo;
    private JTextField textField;
    private JButton    btnNewButton;
    private JButton    btnEliminarCliente;
    private JButton    btnCambiarContrasena;

    public VentanaAdmin(Administrador admin, ObjectContainer oC, ArrayList<Cliente> dbC, PrincipalLog p) {
        getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().setLayout(null);

        table = new JTable();
        table.setBounds(101, 57, 1, 1);
        getContentPane().add(table);
        setBounds(100, 100, 554, 511);

        txtpnInformacionDelCliente = new JTextArea();
        txtpnInformacionDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtpnInformacionDelCliente.setBounds(15, 93, 283, 223);
        txtpnInformacionDelCliente.setBorder(null);
        txtpnInformacionDelCliente.setForeground(Color.white);
        txtpnInformacionDelCliente.setBackground(Color.DARK_GRAY);
        getContentPane().add(txtpnInformacionDelCliente);

        comboBox = new JComboBox();
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                selectedCliente = comboBox.getSelectedItem().toString().split("#");
                txtpnInformacionDelCliente
                        .setText(admin.buscarCliente(dbC, selectedCliente[0], selectedCliente[1]).toString());

            }
        });
        comboBox.setBounds(15, 51, 198, 26);
        getContentPane().add(comboBox);
        llenarCombobox(comboBox, dbC);

        txtReposnuevopass = new JTextField();
        txtReposnuevopass.setBounds(15, 347, 146, 26);
        getContentPane().add(txtReposnuevopass);
        txtReposnuevopass.setColumns(10);

        btnCambiarContrasena = new JButton("Cambiar pass");
        btnCambiarContrasena.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                admin.setContrasenaCliente(dbC, selectedCliente[0], selectedCliente[1], txtReposnuevopass.getText());
                almacenarEnBaseD(oC, dbC);
                JOptionPane.showMessageDialog(null, "Contrasena cambiada");
                llenarCombobox(comboBox, dbC);
            }
        });
        btnCambiarContrasena.setBounds(15, 389, 146, 29);
        getContentPane().add(btnCambiarContrasena);

        txtReposnuevosaldo = new JTextField();
        txtReposnuevosaldo.setBounds(189, 347, 146, 26);
        getContentPane().add(txtReposnuevosaldo);
        txtReposnuevosaldo.setColumns(10);

        btnCambiarSaldo = new JButton("Cambiar Saldo");
        btnCambiarSaldo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                admin.setCreditoCliente(dbC, selectedCliente[0], selectedCliente[1],
                        Double.valueOf(txtReposnuevosaldo.getText()));
                almacenarEnBaseD(oC, dbC);
                JOptionPane.showMessageDialog(null, "Saldo actualisado");
                llenarCombobox(comboBox, dbC);
            }
        });
        btnCambiarSaldo.setBounds(189, 389, 146, 29);
        getContentPane().add(btnCambiarSaldo);

        textField = new JTextField();
        textField.setBounds(361, 347, 162, 26);
        getContentPane().add(textField);
        textField.setColumns(10);

        btnNewButton = new JButton("Cambiar targeta");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                admin.setTargetaDeCredito(dbC, selectedCliente[0], selectedCliente[1],
                        Long.valueOf(textField.getText()));
                almacenarEnBaseD(oC, dbC);
                JOptionPane.showMessageDialog(null, "Numero de targeta actualisado");
                llenarCombobox(comboBox, dbC);
            }
        });
        btnNewButton.setBounds(361, 389, 162, 29);
        getContentPane().add(btnNewButton);
        btnEliminarCliente = new JButton("Eliminar Cliente");
        btnEliminarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dbC.remove(admin.buscarCliente(dbC, selectedCliente[0], selectedCliente[1]));
                almacenarEnBaseD(oC, dbC);
                JOptionPane.showMessageDialog(null, "Cliente Eliminado");
                llenarCombobox(comboBox, dbC);
            }
        });
        btnEliminarCliente.setBounds(372, 50, 151, 29);
        getContentPane().add(btnEliminarCliente);
    }

    public void llenarCombobox(JComboBox<String> cb, ArrayList<Cliente> dbC) {
        cb.removeAll();
        for (Cliente cliente : dbC) {
            cb.addItem(cliente.getNombre() + "#" + cliente.getPassword());
        }
        cb.repaint();

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
}
