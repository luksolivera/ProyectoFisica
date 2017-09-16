package grafos;
import java.util.ArrayList;
public class Dfs {
	private Arista[][] matrizAdyacencia;
	private ArrayList<Vertice> camino;
	private Calculo parametro;
        int l=0;
        double menorCosto;
	
	public Dfs(Calculo parametro){
		this.matrizAdyacencia = Grafo.getInstance().getMatrizDeAdyacencia();
		this.camino = new ArrayList<Vertice>();
		this.parametro = parametro;
	}
	public double mejorCamino(Vertice origen, Vertice destino){
		menorCosto = 1000000;
		boolean[] visitados = new boolean[this.matrizAdyacencia.length];
		ArrayList<Vertice> recorrido = new ArrayList<Vertice>();
		this.camino.clear();
		for(int i=0; i < this.matrizAdyacencia.length; i++)
			visitados[i] = false;
		this.obtenerMejorCamino(origen,destino,visitados,recorrido);
		return menorCosto;
	}
	private void obtenerMejorCamino(Vertice origen, Vertice destino, boolean[] visitados, ArrayList<Vertice> recorrido){
		
                visitados[origen.getPosicion()] = true;
		recorrido.add(origen);
		if(origen == destino)
		{
			double costo = this.parametro.calcular(recorrido);
                        
			if(costo < menorCosto)
			{
				menorCosto = costo;
                                this.camino.clear();
				for(Vertice vertice : recorrido)
					this.camino.add(vertice);
			}	
		}
		else
		{
                    
			for(int i=0;i < this.matrizAdyacencia.length;i++)
			{
				Arista arista = this.matrizAdyacencia[origen.getPosicion()][i];
				if(arista == null)
					continue;
				if(visitados[arista.getVerticeDestino().getPosicion()] == false)
					this.obtenerMejorCamino(arista.getVerticeDestino(),destino,visitados,recorrido);
			}
		}
                
		recorrido.remove(recorrido.size()-1);
		visitados[origen.getPosicion()] = false;
	}
        
        public ArrayList<Vertice> getCamino(){
            return camino;
        }
}