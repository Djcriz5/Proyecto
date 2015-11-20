package clasesApp;

import java.util.LinkedList;

public class probador {

    public static void main(String[] args) {
        Preparado name = new Preparado(9);
        System.out.println(name);
        name.setIngredienteEspecial(3);
        System.out.println(name);
        System.out.println("////////////////////////////////////");
        Bebida mibebida = new Bebida();
        System.out.println(mibebida);
        mibebida.setBebida(5);
        System.out.println(mibebida);
        System.out.println("////////////////////////////////////");
        Lacteo yogurt = new Lacteo();
        System.out.println(yogurt);
        yogurt.setLacteo(3);
        System.out.println(yogurt);
        System.out.println("////////////////////////////////////");
        Helado moyo = new Helado();
        System.out.println(moyo);
        moyo.setHelado(1);
        System.out.println(moyo);
        System.out.println("////////////////////////////////////");
        PaqueteDelDia paquete = new PaqueteDelDia();
        System.out.println(paquete);
        System.out.println("////////////////////////////////////");
        Golosina dulce = new Golosina();
        dulce.setGolosina(4);
        System.out.println(dulce);
        LinkedList<Producto> v = new LinkedList<Producto>();
        //v.add(name);
        //v.add(mibebida);
       // v.add(yogurt);
        v.add(moyo);
        //v.add(paquete);
        Orden ris = new Orden(v);
        ris.addProductos(dulce);
        System.out.println("/////TOTAL////////////");
        System.out.println(ris);
        ris.removeProductos(moyo);// arreglar
        System.out.println("/////Despues////////////");
        System.out.println(ris);
    }

}
