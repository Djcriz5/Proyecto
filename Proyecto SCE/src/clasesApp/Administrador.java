package clasesApp;

import java.util.ArrayList;

public class Administrador {
    private String contrasena;

    public Administrador(String pass) {
        contrasena = pass;
    }

    public Cliente buscarCliente(ArrayList<Cliente> dbClientes, String nom, String pass) {
        Cliente buscado = null;
        for (Cliente cliente : dbClientes) {
            if (cliente.getNombre().equals(nom) && cliente.getPassword().equals(pass)) {
                buscado = cliente;
            }
        }
        return buscado;
    }

    public void eliminarCliente(ArrayList<Cliente> dbClientes, String nom, String pass, long numeroT) {
        dbClientes.remove(buscarCliente(dbClientes, nom, pass));
    }

    public void setTargetaDeCredito(ArrayList<Cliente> dbClientes, String nom, String pass, long numeroT) {
        buscarCliente(dbClientes, nom, pass).setNumeroTargeta(numeroT);
    }

    public void setCreditoCliente(ArrayList<Cliente> dbClientes, String nom, String pass, Double nuevoCredito) {
        buscarCliente(dbClientes, nom, pass).setCredito(nuevoCredito);
    }

    public void setContrasenaCliente(ArrayList<Cliente> dbClientes, String nom, String pass, String nuevopass) {
        buscarCliente(dbClientes, nom, pass).setPassword(nuevopass);
    }

    public String getContrasena() {
        return contrasena;
    }

}
