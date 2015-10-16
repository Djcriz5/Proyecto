package Aplicacion;

public class Bebida extends Producto {
           int indexBebida;
           String  tipoDeBebida;
           
    public Bebida(long numeroOrden,int idBebida) {
        super(numeroOrden, 2);
        indexBebida=idBebida;
        
    }
    public String setTipoDeBebida(int id){
        
        switch (id) {
    case 1:
        tipoDeBebida="coca cola"; 
        break;
    case 2:
        tipoDeBebida="Sprite"; 
        break;
    case 3:
        tipoDeBebida="Nestea"; 
        break;
    case 4:
        tipoDeBebida="Manzanita"; 
        break;
    case 5:
        tipoDeBebida="Fanta"; 
        break;
    case 6:
        tipoDeBebida="Boing Guayaba"; 
        break;
    case 7:
        tipoDeBebida="Boing uva"; 
        break;
    case 8:
        tipoDeBebida="Boing manzana"; 
        break;
    case 9:
        tipoDeBebida="Agua embotellada"; 
        break;
    default:
        tipoDeBebida="Bebida no especificada";
        break;
     }
        return tipoDeBebida;
    }

}
