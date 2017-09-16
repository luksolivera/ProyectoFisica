/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofisica;

/**
 *
 * @author MCristopher
 */
public class VacioExcepcion extends Exception {
    private int contador;
    public VacioExcepcion(int contador) {
        this.contador = contador;
    }

    @Override
    public String toString() {
        return "Error: "+this.contador+" campos vacíos";
    }
    
    
}
