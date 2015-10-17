        package Aplicacion;

public abstract class Producto {
    private int index;
    private String tipoDeProducto;
    public Producto(int id) {
        index=id;
        tipoDeProducto=setTipoDeProducto(index);
    }
    public String getTipoDeProducto() {
        return tipoDeProducto;
    }
    public String setTipoDeProducto(int idx) {
        switch (idx) {
        case 1:
            tipoDeProducto="Frituras";
            break;
        case 2:
            tipoDeProducto="Bebidas";
            break;
        case 3:
            tipoDeProducto="Lacteos";
            break;
        case 4:
            tipoDeProducto="Helados";
            break;
        case 5:
            tipoDeProducto="Dulces";
            break;
        case 6:
            tipoDeProducto="Preparado";
            break;
        case 7:
            tipoDeProducto="Paquete del dia";
            break;


        default:
            break;
        }
        return tipoDeProducto;
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\ntipo de producto:\n"+tipoDeProducto);
        return builder.toString();

    }
}
