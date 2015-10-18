package Aplicacion;

import java.util.Iterator;
import java.util.LinkedList;

import Productos.IContable;
import Productos.Producto;


public class Orden {
    private LinkedList<Producto> lista;
    private long numeroDeOrden;
    private double precio;
    private boolean confirmacion;
    private String cheque;
    public Orden(LinkedList<Producto> L) {
        //setNumeroDeOrden(numOrden);
        lista=L;
        precio=setPrecio(lista); 
        cheque=getCheque(lista);
        
        
    }
    public long getNumeroDeOrden() {
        return numeroDeOrden;
    }
    public void setNumeroDeOrden(long numeroDeOrden) {
        this.numeroDeOrden = numeroDeOrden;
    }
    public double getPrecio() {
        return precio;
    }
    public double setPrecio(LinkedList<Producto> list) {
        IContable p;
        Iterator <Producto> it;
        it = list.iterator();
        while (it.hasNext()) {
            p=(IContable)it.next();
            precio+=p.getPrecio();
           
        }
        return precio;
    }
    public String getCheque(LinkedList<Producto> list){
        IContable p;
        Iterator <Producto>it;
        it = list.iterator();
        while (it.hasNext()) {
            p=(IContable)it.next();
            cheque+=p.toString();
           
        }
        return cheque;
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("el precio de la orden es :"+precio);
        builder.append("\n Cheque:"+cheque);
        return builder.toString();

    }

}
