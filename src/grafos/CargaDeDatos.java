/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;
import com.sun.javaws.Main;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
/**
 *
 * @author USER
 */
public class CargaDeDatos {
    InputStream vehiculos = getClass().getResourceAsStream("vehiculos.txt");
    InputStream vertices = getClass().getResourceAsStream("vertices.txt");
    InputStream aristas = getClass().getResourceAsStream("aristas.txt");
    public void cargarGrafo(){
        this.cargarAutos(vehiculos);
        this.cargarCiudad(vertices);
        this.cargarAristas(aristas);
    }
    
    public ArrayList<String> leerArchivo(InputStream ubicacion) {
	BufferedReader stream;
        ArrayList<String> lineas= new ArrayList();
        byte contadorLineas=0;
//        File archivo=new File (ubicacion);
        try{
            stream=new BufferedReader(new InputStreamReader(ubicacion));
//            stream = new BufferedReader(new FileReader(ubicacion));
            String linea;
            while ((linea= stream.readLine())!=null) {
            	lineas.add(linea);
                contadorLineas++;
            }
        }
        catch(Exception e){}
        return lineas;
    }
    
    private void cargarAutos(InputStream ubicacion){ /*Hecho*/
        ArrayList<String> autos= leerArchivo(ubicacion);
        for (String unAuto:autos){
           String[] partesAuto= unAuto.split("@");
           String tipo= partesAuto[0];
           String modelo=partesAuto[1];
           double masa= Double.valueOf(partesAuto[2]);
           double aceleracionMax0a100= Double.valueOf(partesAuto[3]);
           double coeficienteAereodinamico= Double.valueOf(partesAuto[4]);
           Autos coche=new Autos(tipo,modelo, masa, aceleracionMax0a100, coeficienteAereodinamico);
           Grafo.getInstance().agregarAuto(coche);
        }
    }
    
    
    private void cargarCiudad(InputStream ubicacion){/*Bien*/
        ArrayList<String> vertices=leerArchivo(ubicacion);
        for(String nodo : vertices){
            String [] datos= nodo.split("@");
            String nombreCiudad = datos[0];
            double altura= Double.valueOf(datos[1]);
            double distancia= Double.valueOf(datos[2]);
            double velocidadMedia= Double.valueOf(datos[3]);
            Grafo.getInstance().fabrica.crearVertice(nombreCiudad, velocidadMedia, distancia, altura);
        }
    }
    private void cargarAristas(InputStream ubicacion){ /*Terminado*/
        ArrayList <String> aristas= leerArchivo(ubicacion);
        Grafo grafo=Grafo.getInstance();
        int cantElementos=grafo.getListaDeVertices().size();
        Arista [][] matriz= new Arista[cantElementos][cantElementos];
        int fila=0;
        
        for (String renglon:aristas){
            int columna=0;
            String [] aristasFila= renglon.split("@");
            for (String datosArista : aristasFila){
                if ("0".equals(datosArista)){
                    matriz[fila][columna]=null;
                }
                else{
                    String [] datos=datosArista.split("#");
                    double distancia= Double.valueOf(datos[0]);
                    double velocidadMax= Double.valueOf(datos[1]);
                    double pesoMax= Double.valueOf(datos[2]);
                    Ruta ruta=new Ruta(distancia, velocidadMax, pesoMax);
                    Vertice origen=grafo.buscarVertice(fila);
                    Vertice destino=grafo.buscarVertice(columna);
                    Arista arista=grafo.conectar(origen,destino , ruta);
                    matriz [fila][columna]=arista;
                    //Creacion de la linea
                    grafo.agregarAristaGrafica(destino, origen);
                    
                }
                columna++;
            }
            fila++;
        }
        grafo.setMatrizDeAdyacencia(matriz);
    }
}
