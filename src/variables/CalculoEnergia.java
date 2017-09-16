/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

import generales.Fisica;
import generales.Util;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;

/**
 *
 * @author usuario
 */
public class CalculoEnergia {
    
    private double masa, constante, coeficiente, alturaInicial, alturaFinal, longuitudResorte, longuitudRoce,radio;
    private double [][] resultados= new double [5][5];
    public CalculoEnergia(double masa,double constante,double coeficiente,double alturaInicial,double alturaFinal,double longuitudResorte,double longuitudRoce,double radio){
        this.masa=masa;
        this.constante=constante;
        this.coeficiente=coeficiente;
        this.alturaInicial= alturaInicial;
        this.alturaFinal= alturaFinal;
        this.longuitudResorte=longuitudResorte;
        this.longuitudRoce= longuitudRoce;
        this.radio=radio;
    }
    public CalculoEnergia(){}
    public double getMasa() {
        return masa;
    }
    public void setMasa(double masa) {
        this.masa = masa;
    }
    public double getConstante() {
        return constante;
    }
    public void setConstante(double constante) {
        this.constante = constante;
    }
    public double getCoeficiente() {
        return coeficiente;
    }
    public void setCoeficiente(double coeficiente) {
        this.coeficiente = coeficiente;
    }
    public double getAlturaInicial() {
        return alturaInicial;
    }
    public void setAlturaInicial(double alturaInicial) {
        this.alturaInicial = alturaInicial;
    }
    public double getAlturaFinal() {
        return alturaFinal;
    }
    public void setAlturaFinal(double alturaFinal) {
        this.alturaFinal = alturaFinal;
    }
    public double getLonguitudResorte() {
        return longuitudResorte;
    }
    public void setLonguitudResorte(double longuitudResorte) {
        this.longuitudResorte = longuitudResorte;
    }
    public double getLonguitudRoce() {
        return longuitudRoce;
    }
    public void setLonguitudRoce(double longuitudRoce) {
        this.longuitudRoce = longuitudRoce;
    }
    public double getRadio() {
        return radio;
    }
    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double[][] hacerCalculos(ComboBox resorte){
        //calculo en A
        // 0            1           2       3           4
        // Mecanica, cinetica, potencial, elastica, velocidad;
        resultados[0][4]= 0.0;
        resultados[0][1]= Fisica.energiaCinetica(masa,resultados[0][4]);
        resultados[0][2]= Fisica.energiaPotencial(masa, alturaInicial);
        if (String.valueOf(resorte.getValue())== "principio"){
            resultados[0][3]=Fisica.energiaElastica(constante, longuitudResorte);
        }
        else{
            resultados[0][3]= 0.0;
        }
        
        resultados[0][0]= resultados[0][1] + resultados[0][2]+ resultados[0][3];
        // calculo en B
        // 0            1           2       3           4
        // Mecanica, cinetica, potencial, elastica, velocidad;
        resultados[1][2]= Fisica.energiaPotencial(masa, radio); 
        resultados[1][4]= Fisica.velocidadMecanica(resultados[0][0], 0.0, resultados[1][2], masa);
        resultados[1][1]= Fisica.energiaCinetica(masa,resultados[1][4]);
        resultados[1][3]=0.0;
        resultados[1][0]= resultados[1][1] + resultados[1][2]+ resultados[1][3];
        // calculo en c
        // 0            1           2       3           4
        // Mecanica, cinetica, potencial, elastica, velocidad;
        resultados[2][2]= 0.0; 
        resultados[2][4]= Fisica.velocidadMecanica(resultados[1][0], 0.0, resultados[2][2], masa);
        resultados[2][1]= Fisica.energiaCinetica(masa,resultados[2][4]);
        resultados[2][3]=0.0;
        resultados[2][0]= resultados[2][1] + resultados[2][2]+ resultados[2][3];
        // calculo en d
        // 0            1           2       3           4
        // Mecanica, cinetica, potencial, elastica, velocidad;
        resultados[3][0]= resultados[2][0] + Fisica.trabajoFuerzaRoce(Fisica.fuerzaDeRozamiento(coeficiente,Fisica.fuerzaPeso(masa)),longuitudRoce);
        resultados[3][2]= 0.0; 
        resultados[3][4]= Fisica.velocidadMecanica(resultados[3][0], 0.0, resultados[2][2], masa);
        resultados[3][1]= Fisica.energiaCinetica(masa,resultados[3][4]);
        resultados[3][3]=0.0;
        
        //calculo en e
        // 0            1           2       3           4
        // Mecanica, cinetica, potencial, elastica, velocidad;
        
        resultados[4][2]= Fisica.energiaPotencial(masa, alturaFinal); 
        resultados[4][4]= Fisica.velocidadMecanica(resultados[3][0], 0.0, resultados[4][2], masa);
        resultados[4][1]= Fisica.energiaCinetica(masa,resultados[4][4]);
        if (String.valueOf(resorte.getValue())== "final"){
            resultados[4][3]=Fisica.energiaElastica(constante, longuitudResorte);
        }
        else{
            resultados[4][3]= 0.0;
        }
        resultados[4][0]= resultados[4][3] + resultados[4][1] + resultados[4][2] ;
        return resultados;
    }
}
