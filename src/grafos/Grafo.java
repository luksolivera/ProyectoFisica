/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;


public class Grafo {
    ArrayList <Vertice> listaDeVertices;
    ArrayList <VerticeGrafico> listaDeVerticesGraficos;
    ArrayList <AristaGrafico> listaDeAristasGraficas;
    Arista [][] matrizDeAdyacencia;
    ArrayList <Autos> autos;
    FabricaDeVertice fabrica;
    
    static Grafo unicoGrafo=null;
	
    private Grafo() {
		this.listaDeVertices = new ArrayList <Vertice>();
                this.autos=new ArrayList<Autos>();
                this.listaDeVerticesGraficos= new ArrayList <VerticeGrafico>();
                this.fabrica= new FabricaDeVertice();
                this.listaDeAristasGraficas= new ArrayList <AristaGrafico>();
	}
	
	public void agregarVertice (Vertice nodo) {
		int PosicionVertice= this.listaDeVertices.size();
		nodo.setPosicion (PosicionVertice);
		this.listaDeVertices.add(nodo); //Corregir
        }
        
        public void agregarAuto(Autos auto){
            autos.add(auto);
        }
        public void agregarVerticeGrafico(VerticeGrafico nodo){
            this.listaDeVerticesGraficos.add(nodo);
        }
        
        public void agregarAristaGrafica(AristaGrafico aristaGrafica){
            if (buscarAristaGrafica((aristaGrafica.getVertices())[0],(aristaGrafica.getVertices())[1])==null)
                listaDeAristasGraficas.add(aristaGrafica);
        }
        @FXML
        public void agregarAristaGrafica(Vertice origen, Vertice destino){
            if (buscarAristaGrafica(origen,destino)==null)
                listaDeAristasGraficas.add(new AristaGrafico(destino, origen,new Line()));
        }
        
	public Arista conectar(Vertice origen,Vertice destino, Ruta Datos){
		Arista AristaOrigen= new Arista (destino,Datos);
		origen.agregarArista(AristaOrigen);
                return AristaOrigen;
	}
	
	
	public Vertice buscarVertice(int posicion){
		return (Vertice)this.listaDeVertices.get(posicion);
	}
	public Vertice buscarVertice(String ciudad){
            for (Vertice vertice:listaDeVertices){
                if(((Ciudad)vertice.getDato()).getCiudadNombre() == ciudad){
                    return vertice;
                }
            }
            return null;
        }
        public Vertice buscarVertice(Circle ciudad){
            for (VerticeGrafico vertice:listaDeVerticesGraficos){
                if (vertice.getCirculo()==ciudad)
                    return vertice.getVertice();
            }
            return null;
        }
        public VerticeGrafico buscarVerticeGrafico(Vertice nodo){
            for (VerticeGrafico vertice : listaDeVerticesGraficos){
                if (vertice.getVertice()==nodo)
                    return vertice;
            }
            return null;
        }
        
        public AristaGrafico buscarAristaGrafica(Vertice origen, Vertice destino){
            int contador= 0;
            while (contador <listaDeAristasGraficas.size()){                //VERIFICAR ESTE METODO
                AristaGrafico actual=listaDeAristasGraficas.get(contador);
                Vertice[] vertices=actual.getVertices();
                if ( (vertices[0]==origen & vertices[1]==destino) || (vertices[0]==destino & vertices [1]==origen))
                    return actual;
                contador++;
            }
            return null;
        }
        
        public Autos buscarAuto(String tipo){
            for (Autos auto:autos){
                if(auto.getTipo() == tipo)
                    return auto;
            }
            return null;
        }
        
        
	public static Grafo getInstance(){ /*SINGLETON*/
		if(unicoGrafo==null) {
			unicoGrafo=new Grafo();
		}
		return unicoGrafo;
	}
        
	public ArrayList<Vertice> getListaDeVertices() {
		return this.listaDeVertices;
	}
        public Arista [][] getMatrizDeAdyacencia(){
            return matrizDeAdyacencia;
        }
        public ArrayList<Autos> getVehiculos(){
            return this.autos;
        }

        public ArrayList<AristaGrafico> getListaDeAristasGraficas() {
            return listaDeAristasGraficas;
        }

        public ArrayList<VerticeGrafico> getListaDeVerticesGraficos() {
            return listaDeVerticesGraficos;
        }
        
        
        public void setCirculos(ArrayList<Circle> nodosGraficos){
            fabrica.setNodosGraficos(nodosGraficos);
        }
        
        public void setMatrizDeAdyacencia(Arista [][] matrizDeAristas){
            this.matrizDeAdyacencia=matrizDeAristas;
        }
}
