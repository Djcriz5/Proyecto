package Productos;

import java.io.Serializable;

public class IngredienteEspecial implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -6622215012398760316L;
    private int     index;
    private String  tipo;
    double  precioIngrediente;
    boolean disponibilidad;

    public IngredienteEspecial() {
        this(0);
    }

    public IngredienteEspecial(int cual) {
        setIndex(cual);
        setTipo(index);
        precioIngrediente=setPrecio(getTipo());
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
        case 0:
            tipo="no ingrediente extra";
            
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
      return(getIndex()!=0); 
    }
    public double getPrecio(){
        return precioIngrediente;
    }
    public void setIndex(int cual){
        index=cual;
        setTipo(cual);
    }

    public int getIndex() {
        return index;
    }

    public String getTipo() {
        return tipo;
    }
    
}
