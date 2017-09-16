/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

/**
 *
 * @author USER
 */
public interface VariablesMRUV {
    @Override
    String toString();
    double calcular(MRUV tipo);
    String unidad();
}
