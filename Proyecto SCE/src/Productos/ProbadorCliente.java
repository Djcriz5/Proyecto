package Productos;

import Aplicacion.Cliente;

public class ProbadorCliente {
    public static void main(String[] args) {
        Cliente pancho = new Cliente();
        pancho.setNombre("pancho");
        pancho.comprar(pancho.getProducto("Bebida", 4));
        System.out.println(pancho);
        System.out.println("/////añadiendo targeta de credito/////");
        pancho.setNumeroTargeta(219891273);
        pancho.comprar(pancho.getProducto("Lacteo", 1));
        System.out.println(pancho);
    }
}
