package Aplicacion;

public class PaqueteDelDia extends Producto {
    private Preparado platofuerte;
    private Bebida    bebidaPaquete;
    private String    guarnicion;
    private boolean   disponibilidad;
    private double    precio;

    public PaqueteDelDia() {
        super(8);
        platofuerte = new Preparado(9);
        bebidaPaquete=new Bebida();
        bebidaPaquete.bebidaRandom();
        guarnicion=setGuarnicion();
        precio=(platofuerte.getPrecio()+bebidaPaquete.getPrecio()+5);
        disponibilidad=setDisponibilidad();
        
        
    }

    public PaqueteDelDia(int bebida) {//el precio de este sera el costo del plato del dia + 5 guarnicion+ precio de la bebida 
        super(8);                   
        platofuerte = new Preparado(9);
        bebidaPaquete = new Bebida(bebida);
        guarnicion=setGuarnicion();
        precio=(platofuerte.getPrecio()+bebidaPaquete.getPrecio()+5);
        disponibilidad=setDisponibilidad();
        
    }

    public Preparado getPlatofuerte() {
        return platofuerte;
    }

    public Bebida getBebidaPaquete() {
        return bebidaPaquete;
    }

    public void setBebidaPaquete(int idx) {
        bebidaPaquete.setBebida(idx);
    }

    public String setGuarnicion() {
        String[] guarniciones={"Arroz","Sopa","spaguetti","frijoles"};
        int seleccion = (int) (Math.random() * 4);
        guarnicion=guarniciones[seleccion];
        guarniciones=null;
        seleccion=0;
        return guarnicion;
    }

    public String getGuarnicion() {
        return guarnicion;
    }

    public double getPrecio() {
        return precio;
    }

    private boolean setDisponibilidad(){
        return(platofuerte.getIndex()!=0); 
      }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (disponibilidad) {
            builder.append(
                    super.toString() + "\nPlato fuerte:\n" + platofuerte +"\nGuarnicion:"+guarnicion+"\nBebida: "+bebidaPaquete+"\nPrecio: $" + precio + "\nDisponible" );
        } else {
            builder.append("paquete No Disponible");
        }
        return builder.toString();

    }
    
}
