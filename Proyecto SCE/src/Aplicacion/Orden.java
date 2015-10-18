package Aplicacion;

import java.util.Iterator;
import java.util.LinkedList;

import Productos.IContable;
import Productos.Producto;

public class Orden {
    private LinkedList<Producto> lista;
    private long                 numeroDeOrden;
    private double               precio;
    private boolean              confirmacion;
    private String               cheque;

    public Orden(LinkedList<Producto> L) {
        // setNumeroDeOrden(numOrden);
        lista = L;
        precio = setPrecio(lista);
        cheque = getCheque(lista);
        confirmacion=setConfirmacion();

    }

    public Orden() {
        lista = new LinkedList<Producto>();
        precio = setPrecio(lista);
        cheque = getCheque(lista);
        confirmacion=setConfirmacion();
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
        Iterator<Producto> it;
        it = list.iterator();
        while (it.hasNext()) {
            p = (IContable) it.next();
            precio += p.getPrecio();

        }
        return precio;
    }

    public String getCheque(LinkedList<Producto> list) {
        IContable p;
        Iterator<Producto> it;
        it = list.iterator();
        while (it.hasNext()) {
            p = (IContable) it.next();
            cheque += p.toString();

        }
        return cheque;
    }

    public void addProductos(Producto e) {
        precio = 0;
        cheque = "";
        lista.push(e);
        precio = setPrecio(lista);
        cheque = getCheque(lista);
    }

    public void removeProductos(Producto o) {
        precio = 0;
        cheque = "";
        lista.remove(o);
        precio = setPrecio(lista);
        cheque = getCheque(lista);
    }
    public boolean setConfirmacion(){
        return(lista.size()!=0);
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if(confirmacion){
        builder.append("\n Cheque:" + cheque);
        builder.append("\nel precio de la orden es de : $" + precio);}
        else{
            builder.append("Orden  errorea intente otra ves");
        }
        return builder.toString();

    }

}
