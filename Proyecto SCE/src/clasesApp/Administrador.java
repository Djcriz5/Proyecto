package clasesApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import guideUserInterface.DialogoBuscar;
import guideUserInterface.DialogoNuevoCliente;
import guideUserInterface.PrincipalLog;
import guideUserInterface.VentanaAdmin;

public class Administrador {
    private String                contrasena;
    private VentanaAdmin          adminV;
    protected DialogoNuevoCliente dialogoCliente;

    public Administrador(String pass, ObjectContainer oC, ArrayList<Cliente> dbC, PrincipalLog p) {
        contrasena = pass;
        adminV = new VentanaAdmin();
        llenarTabla(dbC);
        addEventListener(dbC, oC);
        adminV.getBtnEliminarCliente().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dbC.remove(adminV.getTable().getSelectedRow());
                refrescarTabla();
                llenarTabla(dbC);
                almacenarEnBaseD(oC, dbC);
                JOptionPane.showMessageDialog(null, "Cliente Eliminado");
            }
        });
        adminV.getButtonAddCliente().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Thread addClientes = new Thread() {
                    public void run() {
                        dialogoCliente = new DialogoNuevoCliente();
                        p.getDesktopPane().repaint();
                        dialogoCliente.getOkButton().addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent arg0) {
                                addCliente(dbC, oC);
                                refrescarTabla();
                                llenarTabla(dbC);
                                addEventListener(dbC, oC);
                                dialogoCliente.setVisible(false);
                            }
                        });
                    }
                };
                addClientes.run();
            }
        });
        adminV.getButtonBuscar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DialogoBuscar buscarDialogo = new DialogoBuscar();
                buscarDialogo.getOkButton().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ArrayList<Cliente>  listaClasificada = getAllNombre(dbC,buscarDialogo.getReposNombre().getText());
                        refrescarTabla();
                        llenarTabla(listaClasificada);
                        addEventListener(listaClasificada,dbC,oC);
                        buscarDialogo.dispose();
                    }
                });
                
            }
        });
        adminV.setVisible(true);

    }

    public void addCliente(ArrayList<Cliente> dbC, ObjectContainer oC) {
        if (dialogoCliente.getReposNombre().getText().equals("Admin")) {
            JOptionPane.showMessageDialog(null, "usuario reservado escoja otro nombre");
        } else {
            if (buscarCliente(dialogoCliente.getReposNombre().getText(), dialogoCliente.getReposPassWord().getText(),
                    dbC) == null) {
                if (dialogoCliente.getRdbtnUsarTargeta().isSelected()) {
                    try {
                        dbC.add(new Cliente(dialogoCliente.getReposNombre().getText(),
                                dialogoCliente.getReposPassWord().getText(),
                                Long.valueOf(dialogoCliente.getRepostargeta().getText()), 800));
                        almacenarEnBaseD(oC, dbC);
                        JOptionPane.showMessageDialog(null, "Registro exitoso");
                    } catch (Exception e) {
                        System.out.println("error al almacenar Cliente");
                    }
                } else {
                    try {
                        dbC.add(new Cliente(dialogoCliente.getReposNombre().getText(),
                                dialogoCliente.getReposPassWord().getText()));
                        almacenarEnBaseD(oC, dbC);
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

    public Cliente buscarCliente(String nom, String pass, ArrayList<Cliente> dbC) {
        Cliente buscado = null;
        for (Cliente cliente : dbC) {
            if (cliente.getNombre().equals(nom) && cliente.getPassword().equals(pass)) {
                buscado = cliente;
            }
        }
        return buscado;
    }

    public VentanaAdmin getVentanaAdmin() {
        return adminV;
    }

    public void llenarTabla(ArrayList<Cliente> listaCliente) {
        int i = 0;
        for (Cliente cliente : listaCliente) {
            Object row[] = { i, cliente.getNombre(), cliente.getPassword(), cliente.getNumeroTargeta(),
                    cliente.getCredito() };
            ((DefaultTableModel) adminV.getTable().getModel()).addRow(row);
            i++;
        }
    }

    public ArrayList<Cliente> getAllNombre(ArrayList<Cliente> listaCliente, String clave) {
        ArrayList<Cliente> query = new ArrayList<>();
        for (Cliente cliente : listaCliente) {
            if (cliente.getNombre().contains(clave)) {
                query.add(cliente);
            }
        }
        if(query.size()<=0){
            JOptionPane.showMessageDialog(null, "la busqueda no arrojo resultados");
        }
        return query;
    }

    public Cliente buscarPorPocision(ArrayList<Cliente> listaCliente, int i) {
        return listaCliente.get(i);
    }

    public void refrescarTabla() {
        adminV.setModelo(new DefaultTableModel());
        adminV.getModelo().addColumn("Cliente");
        adminV.getModelo().addColumn("Nombre");
        adminV.getModelo().addColumn("Contrasena");
        adminV.getModelo().addColumn("Numero de Targeta");
        adminV.getModelo().addColumn("Saldo");
        adminV.getTable().setModel(adminV.getModelo());

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

    public Object getContrasena() {
        // TODO Auto-generated method stub
        return contrasena;
    }

    public void addEventListener(ArrayList<Cliente> dbC, ObjectContainer oC) {
        adminV.getModelo().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent tme) {
                if (tme.getType() == TableModelEvent.UPDATE) {
                    int columna = tme.getColumn();
                    int row = tme.getFirstRow();
                    if (columna == 1) {
                        buscarPorPocision(dbC, row).setNombre(adminV.getTable().getValueAt(row, columna).toString());
                        almacenarEnBaseD(oC, dbC);
                        JOptionPane.showMessageDialog(null, "Se actualizo el nombre");
                    }
                    if (columna == 2) {
                        buscarPorPocision(dbC, row).setPassword(adminV.getTable().getValueAt(row, columna).toString());
                        almacenarEnBaseD(oC, dbC);
                        JOptionPane.showMessageDialog(null, "Se actualizo el la contrasena");
                    }
                    if (columna == 3) {
                        try {
                            buscarPorPocision(dbC, row).setNumeroTargeta(
                                    Long.parseLong(adminV.getTable().getValueAt(row, columna).toString()));
                            almacenarEnBaseD(oC, dbC);
                            JOptionPane.showMessageDialog(null, "Se actualizo el Numero de Targeta");
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Targeta Invalida Intente de Nuevo");
                        }
                    }
                    if (columna == 4) {
                        try {
                            buscarPorPocision(dbC, row).setCredito(
                                    Double.parseDouble(adminV.getTable().getValueAt(row, columna).toString()));
                            almacenarEnBaseD(oC, dbC);
                            JOptionPane.showMessageDialog(null, "Se actualizo el Credito del cliente");
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Cantidad Invalida Intente de Nuevo");
                        }
                    }
                }
            }
        });
    }
    public void addEventListener(ArrayList<Cliente> clasificada,ArrayList<Cliente> dbC, ObjectContainer oC) {
        adminV.getModelo().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent tme) {
                if (tme.getType() == TableModelEvent.UPDATE) {
                    int columna = tme.getColumn();
                    int row = tme.getFirstRow();
                    if (columna == 1) {
                        buscarPorPocision(clasificada, row).setNombre(adminV.getTable().getValueAt(row, columna).toString());
                        almacenarEnBaseD(oC, dbC);
                        JOptionPane.showMessageDialog(null, "Se actualizo el nombre");
                    }
                    if (columna == 2) {
                        buscarPorPocision(clasificada, row).setPassword(adminV.getTable().getValueAt(row, columna).toString());
                        almacenarEnBaseD(oC, dbC);
                        JOptionPane.showMessageDialog(null, "Se actualizo el la contrasena");
                    }
                    if (columna == 3) {
                        try {
                            buscarPorPocision(clasificada, row).setNumeroTargeta(
                                    Long.parseLong(adminV.getTable().getValueAt(row, columna).toString()));
                            almacenarEnBaseD(oC, dbC);
                            JOptionPane.showMessageDialog(null, "Se actualizo el Numero de Targeta");
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Targeta Invalida Intente de Nuevo");
                        }
                    }
                    if (columna == 4) {
                        try {
                            buscarPorPocision(clasificada, row).setCredito(
                                    Double.parseDouble(adminV.getTable().getValueAt(row, columna).toString()));
                            almacenarEnBaseD(oC, dbC);
                            JOptionPane.showMessageDialog(null, "Se actualizo el Credito del cliente");
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Cantidad Invalida Intente de Nuevo");
                        }
                    }
                }
            }
        });
    }

}
