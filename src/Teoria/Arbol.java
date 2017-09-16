/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teoria;

import java.util.ArrayList;
import javafx.scene.control.TreeItem;

/**
 *
 * @author usuario
 */
public class Arbol {
    ArrayList<TreeItem> contenidos = new ArrayList();
    public Arbol(){
        
    }
    public ArrayList<TreeItem> getContenidos(){
        // cargo todo en contenidos 
        TreeItem Cinematica= new TreeItem("Cinématica");
        // le adiero los hijos o ramas
        Cinematica.getChildren().addAll(getCinematica());
        TreeItem Dinamica= new TreeItem("Dinámica");
        Dinamica.getChildren().addAll(getDinamica());
        TreeItem Dsistemas= new TreeItem("Dinámica de Sistemas");
        Dsistemas.getChildren().addAll(getDsistemas());
        TreeItem Ondas= new TreeItem("Ondas");
        Ondas.getChildren().addAll(getOndas());
        TreeItem Hidroestatica= new TreeItem("Hidroestática");
        Hidroestatica.getChildren().addAll(getHidroestatica());
        contenidos.add(Cinematica);
        contenidos.add(Dinamica);
        contenidos.add(Dsistemas);
        contenidos.add(Ondas);
        contenidos.add(Hidroestatica);
        return this.contenidos;
    }
    private ArrayList getCinematica(){
        ArrayList<TreeItem> cosas= new ArrayList();
        TreeItem opcion1 = new TreeItem("Vectores");
        opcion1.getChildren().addAll(getVectores());
        TreeItem opcion2 = new TreeItem("MRU");
        TreeItem opcion3 = new TreeItem("MRUV");
        TreeItem opcion4 = new TreeItem("Caida Libre/ Lanzamiento Vertical");
        TreeItem opcion5 = new TreeItem("Movimiento de Proyectiles");
        cosas.add(opcion1);cosas.add(opcion2);
        cosas.add(opcion3);cosas.add(opcion4);
        cosas.add(opcion5);
        return cosas;
    }
    private ArrayList getDinamica(){
        ArrayList<TreeItem> cosas= new ArrayList();
        TreeItem opcion1 = new TreeItem("Leyes de Newton");
        opcion1.getChildren().addAll(getLeyes());
        TreeItem opcion2 = new TreeItem("Diagrama de cuerpo libre");
        TreeItem opcion3 = new TreeItem("Rozamiento");
        TreeItem opcion4 = new TreeItem("Trabajo y Energía");
        TreeItem opcion5 = new TreeItem("Energía Cinética");
        TreeItem opcion6 = new TreeItem("Energía Potencial Gravitacional");
        TreeItem opcion7 = new TreeItem("Energía Potencial Elástica");
        TreeItem opcion8 = new TreeItem("Energía Mecánica");
        TreeItem opcion9 = new TreeItem("Potencia");
        TreeItem opcion10 = new TreeItem("Impluso y cant de movimiento");
        TreeItem opcion11= new TreeItem("Choque");
        cosas.add(opcion1);cosas.add(opcion2);
        cosas.add(opcion3);cosas.add(opcion4);
        cosas.add(opcion5);cosas.add(opcion6);
        cosas.add(opcion7);cosas.add(opcion8);
        cosas.add(opcion9);cosas.add(opcion10);
        cosas.add(opcion11);
        return cosas;
    }
    private ArrayList getDsistemas(){
        ArrayList<TreeItem> cosas= new ArrayList();
        TreeItem opcion1 = new TreeItem("Centro de masa");
        TreeItem opcion2 = new TreeItem("Cuerpo rigido: Cinématica");
        TreeItem opcion3 = new TreeItem("Momento de inercia");
        TreeItem opcion4 = new TreeItem("Energía en el movimiento");
        TreeItem opcion5 = new TreeItem("Cuepo rigido: Dinámica");
        TreeItem opcion6 = new TreeItem("Rotrotraslación de un cuerpo");
        TreeItem opcion7 = new TreeItem("Equilibrio de un cuerpo");
        TreeItem opcion8 = new TreeItem("Gravitación");
        TreeItem opcion9 = new TreeItem("Elasticidad");
        cosas.add(opcion1);cosas.add(opcion2);
        cosas.add(opcion3);cosas.add(opcion4);
        cosas.add(opcion5);cosas.add(opcion6);
        cosas.add(opcion7);cosas.add(opcion8);
        cosas.add(opcion9);
        return cosas;
    }
    private ArrayList getOndas(){
        ArrayList<TreeItem> cosas= new ArrayList();
        TreeItem opcion1 = new TreeItem("Movimiento periódico");
        TreeItem opcion2 = new TreeItem("Movimiento armónico simple");
        TreeItem opcion3 = new TreeItem("Movimiento armónico simple angular");
        TreeItem opcion4 = new TreeItem("Movimiento oscilatorio amortiguado");
        TreeItem opcion5 = new TreeItem("Movimiento oscilatorio forzado");
        TreeItem opcion6 = new TreeItem("Ondas mecánicas");
        cosas.add(opcion1);cosas.add(opcion2);
        cosas.add(opcion3);cosas.add(opcion4);
        cosas.add(opcion5);cosas.add(opcion6);
        return cosas;
    }
    private ArrayList getHidroestatica(){
        ArrayList<TreeItem> cosas= new ArrayList();
        TreeItem opcion1 = new TreeItem("Fluidos");
        TreeItem opcion2 = new TreeItem("Hidroestática");
        TreeItem opcion4 = new TreeItem("Hidrodinámica");
        cosas.add(opcion1);cosas.add(opcion2);cosas.add(opcion4);
        return cosas;
    }
    private ArrayList getVectores(){
        ArrayList<TreeItem> cosas= new ArrayList();
        TreeItem opcion1 = new TreeItem("Posición");
        TreeItem opcion2 = new TreeItem("Desplazamiento");
        TreeItem opcion4 = new TreeItem("Aceleración");
        TreeItem opcion3 = new TreeItem("Velocidad");
        cosas.add(opcion1);cosas.add(opcion2);
        cosas.add(opcion3);cosas.add(opcion4);
        return cosas;
    }
    private ArrayList getLeyes(){
        ArrayList<TreeItem> cosas= new ArrayList();
        TreeItem opcion1 = new TreeItem("Primera ley");
        TreeItem opcion2 = new TreeItem("Segunda ley");
        TreeItem opcion4 = new TreeItem("Tercer ley");
        cosas.add(opcion1);cosas.add(opcion2);cosas.add(opcion4);
        return cosas;
    }
}
