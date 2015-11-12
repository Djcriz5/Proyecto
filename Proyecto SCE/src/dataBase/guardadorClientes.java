package dataBase;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Aplicacion.Cliente;

public class guardadorClientes {
    private String Archivo;
    private ObjectOutputStream oos;
    public guardadorClientes(){
        this("clientes.txt");
    }
    public guardadorClientes(String path){
        Archivo=path;   
    }
    public void abrirArchivo(){
        try {
            oos=new ObjectOutputStream(new FileOutputStream(Archivo));
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public void escribirArchivo(dbClientes p){
            try {
                System.out.println("se guardo el objeto"+ p+"\n");
                oos.writeObject(p);
            } catch (IOException ioe) {
                    ioe.printStackTrace();
            }
        
    }
    public void cerrarArchivo(){
        if (oos!=null){
            try {
                oos.close();
            } catch (IOException ioe ) {
               ioe.printStackTrace();
            }
        }
        
    }

}
