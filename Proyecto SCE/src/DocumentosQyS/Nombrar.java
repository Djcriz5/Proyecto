/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DocumentosQyS;

/**
 *
 * @author LuisFernando
 */


public class Nombrar{
   private String nombre;
   
   public Nombrar(Nombrar n){
   n.nombre=nombre;
   }
   public Nombrar(){
   nombre="";
   }
   public Nombrar(String nombre){
   this.nombre=nombre;
   }
   
public String pasarNombre(){
return nombre;
}
public String obtenerNombre(){
return nombre;
}
public void destruir(){
   nombre=null;
    System.gc();
   }

}
