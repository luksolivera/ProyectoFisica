/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generales;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Cola {
    ArrayList cola;

    public Cola(){
        cola= new ArrayList ();
    }
    
    public void push(Object elemento){
        cola.add(elemento);
    }
    public Object pop(){
        Object elemento=cola.get(0);
        cola.remove(0);
        return elemento;
    }
    
    public boolean esVacio(){
        return cola.isEmpty();
    }

    public void setCola(ArrayList lista) {
        this.cola = lista;
    }
}
