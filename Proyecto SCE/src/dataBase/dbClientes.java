package dataBase;

import java.io.Serializable;
import java.util.ArrayList;

import Aplicacion.Cliente;

public class dbClientes extends ArrayList<Cliente> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7611725436881382143L;

    public dbClientes() {
        super();
    }

}
