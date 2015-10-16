package Aplicacion;

public class Preparado extends Producto {
    IngredienteEspecial extra;
    int                 indexPreparado;
    String              tipoDePreparado;
    double              precio;
    boolean             disponibilidad;
    int                 FlagGuisadoDeldia;

    public Preparado(int id) {
        super(6);
        FlagGuisadoDeldia = 0;
        indexPreparado = id;
        extra = new IngredienteEspecial();
        tipoDePreparado = setTipoDePreparado(indexPreparado);
        if (indexPreparado == 9) {
            getGuisadoDeldia();
            FlagGuisadoDeldia++;
            tipoDePreparado = setTipoDePreparado(indexPreparado);
        }
        precio=setPrecio(tipoDePreparado);
    }

    public String setTipoDePreparado(int idx) {
        switch (idx) {
        case 1:
            tipoDePreparado = "Sandwich";
            break;
        case 2:
            tipoDePreparado = "Molletes";
            break;
        case 3:
            tipoDePreparado = "Tortas";
            break;
        case 4:
            tipoDePreparado = "Ensalada de Atun";
            break;
        case 5:
            tipoDePreparado = "Ensalada de pollo";
            break;
        case 6:
            tipoDePreparado = "Pechuga Empanisada con ensalada";
            break;
        case 7:
            tipoDePreparado = "Enchiladas";
            break;
        case 8:
            tipoDePreparado = "Orden de tacos";
            break;
        case 9:
            tipoDePreparado = "Guisado Del dia";
            break;
        default:
            indexPreparado = 0;
            tipoDePreparado = " no especificado";
            break;
        }
        return tipoDePreparado;
    }
    public double setPrecio(String tipo){
        switch (tipo) {
        case "Sandwich":
            precio=14.50;
            break;
        case "Molletes":
            precio=12.50;

            break;
        case "Tortas":
            precio=17.50;

            break;
        case "Ensalada de Atun":
            precio=18.50;

            break;
        case "Ensalada de pollo":
            precio=21.00;
            break;
        case "Pechuga Empanisada con ensalada":
            precio=22.00;
            break;
        case "Enchiladas":
            precio=18.50;
            break;
        case "Orden de tacos":
            precio=14.50;
            break;
        case "Guisado Del dia":
            precio=11.00;
            break;
        default:
            indexPreparado = 0;
            tipoDePreparado = " no especificado";
            break;
        }
        return precio;
        
    }
    public void getGuisadoDeldia() {
        indexPreparado = (int) (Math.random() * 8 + 1);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (FlagGuisadoDeldia != 0) {
            builder.append(super.toString()+"\nGuisado del dia:\n" + tipoDePreparado + "\n Precio :" + precio);
        }else
            builder.append(super.toString()+"\n"+ tipoDePreparado + "\n Precio :" + precio);
        if(disponibilidad=true){
            builder.append("\nDisponible");
        }
        return builder.toString();

    }
}
