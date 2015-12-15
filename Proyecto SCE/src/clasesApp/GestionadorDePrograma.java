package clasesApp;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import guideUserInterface.PrincipalLog;
import guideUserInterface.VentanaAdmin;
import guideUserInterface.VentanaUsuario;

public class GestionadorDePrograma {
    private ArrayList<Cliente> listaDeClientes;
    private ArrayList<Cliente> dbClientes;
    private ObjectContainer    baseDeDatos;
    private PrincipalLog               window;
    private Administrador admin;

    public GestionadorDePrograma() {
        listaDeClientes = new ArrayList<Cliente>();
        ;
        dbClientes = listaDeClientes;
        setBaseDeDatos(Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "clientes.db4o"));
        window = new PrincipalLog();
        try {
            dbClientes = consultarBaseDeDatos(baseDeDatos, dbClientes);
            admin = new Administrador("contrasena");
            System.out.println("Base de datos sincronizada");
        } catch (Exception e) {
            System.out.println("error al leer base de datos");

        }
        window.getRdbtnAadirTargeta().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (window.getRdbtnAadirTargeta().isSelected()) {
                    window.getTxtRepostargeta().setVisible(true);
                    window.getTxtRepostargeta().setEnabled(true);
                } else {
                    window.getTxtRepostargeta().setVisible(false);
                    window.getTxtRepostargeta().setEnabled(false);
                }
            }
        });
        window.getLblExit().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cerrarConexion(baseDeDatos);
                window.frame.dispose();
            }
        });
        window.getRdbtnAadirTargeta().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (window.getRdbtnAadirTargeta().isSelected()) {
                    window.getTxtRepostargeta().setVisible(true);
                    window.getTxtRepostargeta().setEnabled(true);
                } else {
                    window.getTxtRepostargeta().setVisible(false);
                    window.getTxtRepostargeta().setEnabled(false);
                }
            }
        });
        ///
        window.getBtnSingIn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pass = new String(window.getPasswordField().getPassword());
                if (window.getReposNombre().getText().equals("Admin")) {
                    if (admin.getContrasena().equals(pass)) {
                        try {
                            VentanaAdmin va = new VentanaAdmin(admin, baseDeDatos, dbClientes, window);
                            window.getDesktopPane().add(va);
                            va.setVisible(true);
                            window.getInternalLogin().setClosed(true);
                        } catch (PropertyVetoException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        window.getDesktopPane().repaint();
                    } else {
                        JOptionPane.showMessageDialog(null, "Password Incorrecta");
                    }
                } else {
                    if (buscarCliente(window.getReposNombre().getText(), pass) != null) {
                        try {
                            VentanaUsuario vu = new VentanaUsuario(buscarCliente(window.getReposNombre().getText(), pass),
                                    baseDeDatos, dbClientes, window);
                            window.getDesktopPane().add(vu);
                            vu.setVisible(true);
                            window.getInternalLogin().setClosed(true);
                            window.getDesktopPane().repaint();
                        } catch (PropertyVetoException e1) {
                            System.out.println("se produjo un error al acceder");
                            e1.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no registrado verifique datos");
                    }
                }
            }
        });
        window.getBtnSingUp().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String passt = new String(window.getPasswordField().getPassword());
                addCliente(window.getReposNombre().getText(), passt);
            }
        });
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
    

    public ArrayList<Cliente> getDbClientes() {
        return dbClientes;
    }

    public void setDbClientes(ArrayList<Cliente> dbClientes) {
        this.dbClientes = dbClientes;
    }

    public ObjectContainer getBaseDeDatos() {
        return baseDeDatos;
    }

    public void setBaseDeDatos(ObjectContainer baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public PrincipalLog getWindow() {
        return window;
    }

    public void setWindow(PrincipalLog window) {
        this.window = window;
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
        if (nom.equals("Admin")) {
            JOptionPane.showMessageDialog(null, "usuario reservado escoja otro nombre");
        } else {
            if (buscarCliente(nom, pass) == null) {
                if (window.getRdbtnAadirTargeta().isSelected()) {
                    try {
                        dbClientes.add(new Cliente(nom, pass, Long.valueOf(window.getTxtRepostargeta().getText()), 800));
                        almacenarEnBaseD(baseDeDatos, dbClientes);
                        JOptionPane.showMessageDialog(null, "Registro exitoso");
                    } catch (Exception e) {
                        System.out.println("error al almacenar Cliente");
                    }
                } else {
                    try {
                        dbClientes.add(new Cliente(nom, pass));
                        almacenarEnBaseD(baseDeDatos, dbClientes);
                        JOptionPane.showMessageDialog(null, "Registro exitoso");
                    } catch (Exception e) {
                        System.out.println("error al almacenar Cliente");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario registrado escoja otro usuario");
            }
        }
    }

    public void cerrarConexion(ObjectContainer baseDatos) {
        try {
            baseDatos.close();
        } catch (Exception e) {
            System.out.println("error al cerrar la conexion");
        }
    }


    public void almacenarEnBaseD(ObjectContainer baseDatos, ArrayList<Cliente> listaCliente) {
        try {
            baseDatos.store(listaCliente);
            baseDatos.commit();
            System.out.println("Se ha almacenado correctamente en la base de datos");
        } catch (Exception e) {
            System.out.println("Se ha porducido un error en la insercion");
        }
    }

    public ArrayList<Cliente> consultarBaseDeDatos(ObjectContainer baseDatos, ArrayList<Cliente> listaCliente) {
        ObjectSet resultado = baseDatos.queryByExample(listaCliente);
        return (ArrayList<Cliente>) resultado.get(0);
    }

    public ArrayList<Cliente> getListaDeClientes() {
        return dbClientes;
    }
}
