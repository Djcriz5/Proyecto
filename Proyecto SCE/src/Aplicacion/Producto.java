package Aplicacion;

public class Producto {
    private int index;
    private String tipoDeProducto;
    private double Precio;
    private long numeroDeOrden;
    public Producto(long numeroOrden,int id) {
        numeroDeOrden=numeroOrden;
        index=id;
        tipoDeProducto=setTipoDeProducto(index);
        
    }
    public String getTipoDeProducto() {
        return tipoDeProducto;
    }
    public String setTipoDeProducto(int id) {
        switch (id) {
        case 1:
            tipoDeProducto="Papas";
            break;
        case 2:
            tipoDeProducto="Refresco";
            break;
        case 3:
            tipoDeProducto="Yogurth";
            break;
        case 4:
            tipoDeProducto="paletas";
            break;
        case 5:
            tipoDeProducto="gomitas";
            break;

        default:
            break;
        }
        return tipoDeProducto;
    }
    
}
