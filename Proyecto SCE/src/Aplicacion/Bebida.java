package Aplicacion;

public class Bebida extends Producto {
    int     indexBebida;
    String  tipoDeBebida;
    double  precio;
    boolean disponibilidad;

    public Bebida() {
        this(0);
    }
    public Bebida(int idBebida) {
        super(2);
        indexBebida = idBebida;
        tipoDeBebida = setTipoDeBebida(indexBebida);
        precio = setPrecio(tipoDeBebida);
        disponibilidad = setDisponibilidad();

    }

    public String setTipoDeBebida(int id) {

        switch (id) {
        case 1:
            tipoDeBebida = "coca cola";
            break;
        case 2:
            tipoDeBebida = "Sprite";
            break;
        case 3:
            tipoDeBebida = "Nestea";
            break;
        case 4:
            tipoDeBebida = "Manzanita";
            break;
        case 5:
            tipoDeBebida = "Fanta";
            break;
        case 6:
            tipoDeBebida = "Boing Guayaba";
            break;
        case 7:
            tipoDeBebida = "Boing uva";
            break;
        case 8:
            tipoDeBebida = "Boing manzana";
            break;
        case 9:
            tipoDeBebida = "Agua embotellada";
            break;
        default:
            indexBebida = 0;
            tipoDeBebida = "Bebida no especificada";
            break;
        }
        return tipoDeBebida;
    }

    public void setPrecio(double prize) {
        precio = prize;
    }

    public double setPrecio(String tipo) {

        switch (tipo) {
        case "coca cola":
            precio = 9.50;
            break;
        case "Sprite":
            precio = 7.50;
            break;
        case "Nestea":
            precio = 10.00;
            break;
        case "Manzanita":
            precio = 7.50;
            break;
        case "Fanta":
            precio = 8.50;
            break;
        case "Boing Guayaba":
            precio = 7.50;
            break;
        case "Boing uva":
            precio = 7.50;
            break;
        case "Boing manzana":
            precio = 7.50;
            break;
        case "Agua embotellada":
            precio = 6.50;
            break;
        default:
            precio = 0;
            break;
        }
        return precio;
    }

    private boolean setDisponibilidad() {
        return (indexBebida != 0);
    }
    public void setBebida(int indx){
        indexBebida=indx;
        tipoDeBebida = setTipoDeBebida(indexBebida);
        precio = setPrecio(tipoDeBebida);
        disponibilidad = setDisponibilidad();
        
    }
    public double getPrecio() {
        return precio;
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (disponibilidad) {
            builder.append(
                    super.toString() + "\nTipo:\n" + tipoDeBebida + "\nPrecio: $" + precio + "\nDisponible" );
        } else {
            builder.append("Bebida No Disponible");
        }
        return builder.toString();

    }

}
