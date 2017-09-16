package grafos;

import java.util.ArrayList;
public abstract class Calculo{
	protected Autos vehiculo;
	protected Arista[][] matrizAdyacencia;
        
	public Calculo(Autos auto){
            this.vehiculo=auto;
            this.matrizAdyacencia=Grafo.getInstance().getMatrizDeAdyacencia();
        }
	public abstract double calcular(ArrayList<Vertice> recorrido);
}
