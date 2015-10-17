package Aplicacion;

public class probador {

    public static void main(String[] args) {
         Preparado name = new Preparado(9);
         System.out.println(name);
         name.setIngredienteEspecial(3 );
         System.out.println(name);
         Bebida mibebida = new Bebida();
         mibebida.setBebida(5);
         System.out.println(mibebida);
         Lacteos yogurt =new Lacteos();
        System.out.println(yogurt);
        yogurt.setLacteo(3);
        System.out.println(yogurt);

    }

}
