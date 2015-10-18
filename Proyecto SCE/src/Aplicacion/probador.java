package Aplicacion;

public class probador {

    public static void main(String[] args) {
         Preparado name = new Preparado(9);
         System.out.println(name);
         name.setIngredienteEspecial(3 );
         System.out.println(name);
         System.out.println("////////////////////////////////////");
         Bebida mibebida = new Bebida();
         System.out.println(mibebida);
         mibebida.setBebida(5);
         System.out.println(mibebida);
         System.out.println("////////////////////////////////////");
         Lacteos yogurt =new Lacteos();
        System.out.println(yogurt);
        yogurt.setLacteo(3);
        System.out.println(yogurt);
        System.out.println("////////////////////////////////////");
        Helados moyo=new Helados();
        System.out.println(moyo);
        moyo.setHelado(1);
        System.out.println(moyo);

    }

}
