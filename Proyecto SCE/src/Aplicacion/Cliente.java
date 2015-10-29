package Aplicacion;

import Productos.*;

public class Cliente {
    private String nombre;
    private long   numeroTargeta;
    private String password;
    private Orden  pedido;
    private double credito;

    public Cliente(String name, String pass, long num, double saldo) {
        nombre = name;
        password = pass;
        numeroTargeta = num;
        credito = saldo;
        pedido = new Orden();
    }

    public Cliente() {
        this("", "", 0, 800);
    }

    public Producto getProducto(String cual, int idx) {
        Producto p = null;
        switch (cual) {
        case "Bebida":
            p = new Bebida(idx);
            break;
        case "Golosina":
            p = new Golosina(idx);
            break;
        case "Helado":
            p = new Helado(idx);
            break;
        case "Lacteo":
            p = new Lacteo(idx);
            break;
        case "Paquete del dia":
            if (idx == 0) {
                p = new Lacteo();
            } else {
                p = new Lacteo(idx);
            }
            break;
        case "Preparado":

            break;

        default:
            break;
        }
        return p;
    }

    public void comprar(Producto e) {
        if (numeroTargeta != 0) {
            if (credito > 0) {
                pedido.addProductos(e);
                credito-=pedido.getPrecio();
            } else {
                System.out.println("lo sentimos credito ecxedido");
            }
        } else {
            pedido.addProductos(e);
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        nombre = name;
    }

    public long getNumeroTargeta() {
        return numeroTargeta;
    }

    public void setNumeroTargeta(long num) {
        numeroTargeta = num;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        password = pass;
    }

    public Orden getPedido() {
        return pedido;
    }

    public void setPedido(Orden pedido) {
        this.pedido = pedido;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (numeroTargeta != 0) {
            builder.append("\nCliente: " + nombre).append("\nNumero de Targeta: " + numeroTargeta)
                    .append("\nCredito restante: " + credito);
        } else {
            builder.append("\nCliente : " + nombre);
        }
        if (pedido.getNumeroDeProductos() > 0) {
            builder.append("\n" + pedido);
        }
        return builder.toString();
    }

}
