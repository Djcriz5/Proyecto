package guideUserInterface;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAdmin extends JInternalFrame {
    private JButton           btnEliminarCliente;
    private JTable            table;
    private DefaultTableModel modelo;
    private JLabel            lblNewLabel;
    private ImageIcon         iconoAdmin;
    private JScrollPane       scrollpane;
    private JButton           buttonAddCliente;
    private JButton           buttonBuscar;

    public VentanaAdmin() {
        getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().setLayout(null);
        setBounds(100, 100, 554, 511);
        btnEliminarCliente = new JButton("Eliminar Cliente");
        btnEliminarCliente.setBackground(Color.RED);
        btnEliminarCliente.setBounds(15, 425, 151, 29);
        getContentPane().add(btnEliminarCliente);

        table = new JTable();
        table.setBounds(15, 132, 508, 277);
        scrollpane = new JScrollPane(table);
        scrollpane.setBounds(15, 109, 508, 300);
        getContentPane().add(scrollpane);
        lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(430, 6, 93, 87);
        iconoAdmin = new ImageIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/lock.png")).getImage()
                .getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
        lblNewLabel.setIcon(iconoAdmin);
        getContentPane().add(lblNewLabel);

        buttonAddCliente = new JButton("Registrar un Cliente");
        buttonAddCliente.setBackground(Color.GREEN);
        buttonAddCliente.setBounds(181, 425, 171, 29);
        getContentPane().add(buttonAddCliente);

        buttonBuscar = new JButton("Buscar");
        buttonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        buttonBuscar.setBackground(Color.GREEN);
        buttonBuscar.setBounds(364, 425, 171, 29);
        getContentPane().add(buttonBuscar);
        modelo = (DefaultTableModel) table.getModel();
        modelo.addColumn("Cliente");
        modelo.addColumn("Nombre");
        modelo.addColumn("Contrasena");
        modelo.addColumn("Numero de Targeta");
        modelo.addColumn("Saldo");
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public JButton getBtnEliminarCliente() {
        return btnEliminarCliente;
    }

    public void setBtnEliminarCliente(JButton btnEliminarCliente) {
        this.btnEliminarCliente = btnEliminarCliente;
    }

    public JButton getButtonAddCliente() {
        return buttonAddCliente;
    }

    public void setButtonAddCliente(JButton buttonAddCliente) {
        this.buttonAddCliente = buttonAddCliente;
    }

    public JButton getButtonBuscar() {
        return buttonBuscar;
    }

    public void setButtonBuscar(JButton buttonBuscar) {
        this.buttonBuscar = buttonBuscar;
    }
}
