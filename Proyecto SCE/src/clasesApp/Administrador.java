package clasesApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.db4o.ObjectContainer;

import guideUserInterface.PrincipalLog;
import guideUserInterface.VentanaAdmin;

public class Administrador {
    private String       contrasena;
    private VentanaAdmin adminV;

    public Administrador(String pass, ObjectContainer oC, ArrayList<Cliente> dbC, PrincipalLog p) {
        contrasena = pass;
        adminV = new VentanaAdmin();
        llenarTabla(dbC);
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
        adminV.getBtnEliminarCliente().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dbC.remove(adminV.getTable().getSelectedRow());
                adminV.setModelo(new DefaultTableModel());
                adminV.getModelo().addColumn("Cliente");
                adminV.getModelo().addColumn("Nombre");
                adminV.getModelo().addColumn("Contrasena");
                adminV.getModelo().addColumn("Numero de Targeta");
                adminV.getModelo().addColumn("Saldo");
                adminV.getTable().setModel(adminV.getModelo());
                llenarTabla(dbC);
                almacenarEnBaseD(oC, dbC);
                JOptionPane.showMessageDialog(null, "Cliente Eliminado");
            }
        });
        adminV.setVisible(true);

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

    public Cliente buscarPorPocision(ArrayList<Cliente> listaCliente, int i) {
        return listaCliente.get(i);
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

}
