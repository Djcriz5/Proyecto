package Aplicacion;

public class IngredienteEspecial {
    int     index;
    String  tipo;
    double  precioIngrediente;
    boolean disponibilidad;

    public IngredienteEspecial() {
        this(0);
    }

    public IngredienteEspecial(int cual) {
        index = cual;
        tipo = setTipo(index);
        precioIngrediente=setPrecio(tipo);
        disponibilidad=setDisponibilidad();

    }

    private String setTipo(int indexP) {
        switch (indexP) {
        case 1:
            tipo = "jamon extra";
            break;
        case 2:
            tipo = "Pechuga de pavo";
            break;
        case 3:
            tipo = "queso extra";
            break;
        case 4:
            tipo = "Aguacate";
            break;
        case 5:
            tipo = "Aderezos";
            break;
        case 6:
            tipo = "caramelo";
            break;
        case 7:
            tipo = "miel";
            break;
        case 8:
            tipo = "chocolate";
            break;

        default:
            index=0;
            tipo = "ingrediente no especificado";
            break;
        }
        return tipo;
    }

    private double setPrecio(String cual) {
        switch (cual) {
        case "jamon extra":
            precioIngrediente=7.50;

            break;
        case "Pechuga de pavo":
            precioIngrediente=9.50;
            break;
        case "queso extra":
            precioIngrediente=7.50;
            break;
        case "Aderezos":
            precioIngrediente=3.75;
            break;
        case "caramelo":
            precioIngrediente=3.25;
            break;
        case "miel":
            precioIngrediente=4.55;
            break;
        case "chocolate":
            precioIngrediente=5.55;

            break;
        default:
            precioIngrediente=0;
            break;
        }
        return precioIngrediente;
    }
    private boolean setDisponibilidad(){
      return(index!=0); 
    }
    public void setIndex(int id){
        index=id;
    }
    public double getPrecio(){
        return precioIngrediente;
    }

}
