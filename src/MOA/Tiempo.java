
package MOA;

/**
 *
 * @author User
 */
public class Tiempo extends Variable{
    public Tiempo(String unidad){
        super(unidad);
    }
    
    @Override
    public String toString() {
        return "Posición";
    }

    @Override
    public double calcularMOA(double amplitud, double frecuencia, double faseInicial, double tiempo) {
        return generales.Fisica.moaPosicion(amplitud, frecuencia, faseInicial, tiempo);
    }
    
}