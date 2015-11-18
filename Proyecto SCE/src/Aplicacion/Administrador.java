package Aplicacion;

import java.util.ArrayList;
import java.util.HashMap;

public class Administrador {
    private String                  contrasena;
    private HashMap<String, String> mapaClientes;

    public Administrador(String pass) {
        contrasena = pass;
        mapaClientes = new HashMap<String, String>();
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

    public HashMap<String, String> getMapaClientes() {
        return mapaClientes;
    }

    public void setMapaClientes(ArrayList<Cliente> dbClientes) {
        for (Cliente cliente : dbClientes) {
            mapaClientes.put(cliente.getNombre(), cliente.getPassword());
        }
    }

    public String getContrasena() {
        return contrasena;
    }

}
