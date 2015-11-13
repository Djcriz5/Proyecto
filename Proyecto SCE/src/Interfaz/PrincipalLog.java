package Interfaz;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import Aplicacion.Cliente;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PrincipalLog {
    private ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();;
    private ArrayList<Cliente> dbClientes      = listaDeClientes;
    private JFrame             frame;
    private JDesktopPane       desktopPane;
    private ImageIcon          icono;
    private ImageIcon          iconoaux;
    private JLabel             lblNewLabel;
    private JInternalFrame     internalLogin;
    private JTextField         reposNombre;
    private JLabel             lblUsuario;
    private JPasswordField     passwordField;
    private JLabel             lblContrasena;
    private JButton            btnSingUp;
    private JLabel             Mensaje;
    private JButton            btnSingIn;
    private ObjectContainer    baseDeDatos     = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
            "clientes.db4o");

    /**
     * Clase principal se encarga de leer la base de datos de clietes y de
     * gestionar las demasfunciones de la aplicacion
     */
    public static void main(String[] args) {
        PrincipalLog window = new PrincipalLog();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        });
    }

    /**
     * Create the application.
     */
    public PrincipalLog() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        try {
            dbClientes = consultarQBEPonentesNombre(baseDeDatos, dbClientes);
        } catch (Exception e) {
            System.out.println("error al leer base de datos");
        }
        frame = new JFrame();
        frame.setSize(900, 700);
        frame.setResizable(false);
        desktopPane = new JDesktopPane();
        desktopPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        ;
        frame.setContentPane(desktopPane);

        lblNewLabel = new JLabel("Login");
        lblNewLabel.setBounds(new Rectangle(0, 0, 900, 660));
        icono = new ImageIcon(PrincipalLog.class.getResource("/Imagenes/desktop.png"));
        iconoaux = new ImageIcon(icono.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),
                Image.SCALE_DEFAULT));
        lblNewLabel.setIcon(iconoaux);
        desktopPane.add(lblNewLabel);

        internalLogin = new JInternalFrame("Login");
        internalLogin.setBackground(Color.DARK_GRAY);
        internalLogin.setBounds(184, 145, 489, 422);
        desktopPane.add(internalLogin);
        internalLogin.getContentPane().setLayout(null);

        reposNombre = new JTextField();
        reposNombre.setBounds(185, 97, 183, 26);
        internalLogin.getContentPane().add(reposNombre);
        reposNombre.setColumns(10);

        lblUsuario = new JLabel("Usuario");
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setBounds(70, 97, 85, 23);
        internalLogin.getContentPane().add(lblUsuario);

        passwordField = new JPasswordField();
        passwordField.setBounds(185, 156, 183, 26);
        internalLogin.getContentPane().add(passwordField);

        lblContrasena = new JLabel("Password");
        lblContrasena.setForeground(Color.WHITE);
        lblContrasena.setBounds(70, 159, 85, 23);
        internalLogin.getContentPane().add(lblContrasena);

        btnSingUp = new JButton("Sing Up");
        btnSingUp.setBackground(new Color(65, 105, 225));
        btnSingUp.setBounds(253, 218, 115, 29);
        internalLogin.getContentPane().add(btnSingUp);

        Mensaje = new JLabel("Ya tienes una cuenta?");
        Mensaje.setForeground(Color.WHITE);
        Mensaje.setBounds(70, 294, 162, 23);
        internalLogin.getContentPane().add(Mensaje);

        btnSingIn = new JButton("Sing in");
        btnSingIn.setBackground(new Color(65, 105, 225));
        btnSingIn.setBounds(253, 291, 115, 29);
        internalLogin.getContentPane().add(btnSingIn);
        internalLogin.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnSingIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pass = new String(passwordField.getPassword());
                if (buscarCliente(reposNombre.getText(), pass) != null) {
                    try {
                        internalLogin.setClosed(true);
                    } catch (PropertyVetoException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no registrado verifique datos");
                }
            }
        });
        btnSingUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String passt = new String(passwordField.getPassword());
                addCliente(reposNombre.getText(), passt);
            }
        });

    }

    public Cliente buscarCliente(String nom, String pass) {
        Cliente buscado = null;
        for (Cliente cliente : dbClientes) {
            if (cliente.getNombre().equals(nom) && cliente.getPassword().equals(pass)) {
                buscado = cliente;
            }
        }
        return buscado;
    }

    public void addCliente(String nom, String pass) {
        if (buscarCliente(nom, pass) == null) {
            dbClientes.add(new Cliente(nom, pass, 0, 0));
            try {
                almacenarEnBaseD(baseDeDatos, dbClientes);
            } catch (Exception e) {
                // TODO: handle exception
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario registrado escoja otro usuario");
        }
    }

    public static void cerrarConexion(ObjectContainer baseDatos) {
        try {
            baseDatos.close();
        } catch (Exception e) {
            System.out.println("error al cerrar la conexion");
        }
    }

    public ObjectContainer getBaseDeDatos() {
        return baseDeDatos;
    }

    public static void almacenarEnBaseD(ObjectContainer baseDatos, ArrayList<Cliente> listaCliente) {
        try {
            baseDatos.store(listaCliente);
            System.out.println("Se ha almacenado correctamente en la base de datos");
        } catch (Exception e) {
            System.out.println("Se ha porducido un error en la insercion");
        }
    }

    public ArrayList<Cliente> consultarQBEPonentesNombre(ObjectContainer baseDatos, ArrayList<Cliente> listaCliente) {
        ObjectSet resultado = baseDatos.queryByExample(listaCliente);
        return (ArrayList<Cliente>) resultado.next();
    }
}
