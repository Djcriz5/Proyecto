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
public class Texto {
    private String texto;
 
    public Texto(String texto){
    this.texto=texto;
    }
    public Texto(Texto t){
    t.texto=texto;
    }
    public Texto(){
    texto="";
    }
    public String introducirTexto(){
    return texto;
    }
    public  void destruir(){
    texto=null;
     System.gc();
    }
    
}
