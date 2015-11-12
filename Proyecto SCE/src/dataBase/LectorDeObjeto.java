package dataBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LectorDeObjeto {
    private String            archivo;
    private ObjectInputStream ois;

    public LectorDeObjeto() {
        this("clientes.txt");
    }

    public LectorDeObjeto(String path) {
        archivo = path;
    }

    public void abrirArchivo() {
        try {
            ois = new ObjectInputStream(new FileInputStream(archivo));
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public dbClientes leerArchivo() {
        dbClientes unaLista = null;
        try {
            unaLista = (dbClientes) ois.readObject();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return unaLista;
    }
    public void cerrarArchivo(){
        if (ois!=null){
            try {
                ois.close();
            } catch (IOException ioe ) {
               ioe.printStackTrace();
            }
        }
        
    }
     
}
