 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generales;
import java.util.*;
/**
 
 *
 * @author Labinf
 */
public class Fisica {
    public static final double gravedad=(double) 10.0;
    public static double mruTiempo(double velocidad, double distancia){ //calcula eltiempo con MRU
        return distancia/velocidad;
    }
    public static double mruVelocidad(double tiempo, double distancia){//calcula la velocidad con MRU
        return distancia / tiempo;
    }
    public static double mruDistancia(double velocidad, double tiempo){//calcula la distancia con MRU
        return velocidad*tiempo;
    }
//    public static double mruvPosicionFinal(double posicion, double Vinicial, double aceleracion,double tiempo){
//        return posicion + (Vinicial * tiempo) + (0.5 * aceleracion * (tiempo *tiempo));
//    }
//    public static double mruvPosicionInicial(double posicion, double Vinicial, double aceleracion,double tiempo){
//        return posicion - Vinicial * tiempo - 0.5 * aceleracion * (tiempo *tiempo);
//    }
//    public static double mruvVelocidadFinal(double Vinicial, double aceleracion, double tiempo){
//        return Vinicial+ aceleracion*tiempo;
//    }
//    public static double mruvVelocidadInicial(double Vfinal, double aceleracion, double tiempo){
//        return Vfinal- (aceleracion * tiempo);
//    }
    public static double mruvEjeyVelocidadFinal(double Vinicial, double tiempo){
        return Vinicial + gravedad * tiempo;
    }
    public static double mruvEjeyPosicionFinal(double posicion, double Vinicial, double tiempo){
        return posicion + Vinicial * tiempo - 0.5 * gravedad *(tiempo* tiempo);
    }
    public static double mruvEjeyPosicionInicial(double posicionFinal,double Vinicial,double tiempo){
        return (posicionFinal-Vinicial*tiempo+gravedad*tiempo*tiempo/2);
    }
//    public static double mruvAceleracionPosicion(double Pfinal, double Pinicial, double Vinicial, double tiempo){
//        return 2*(Pfinal - Pinicial- Vinicial*tiempo)/(tiempo*tiempo);
//    }
//     public static double mruvPosicionFinalSinV0(double vFinal,double aceleracion,double tiempo,double pInicial){
//        return vFinal*tiempo - 0.5*aceleracion*(Math.pow(tiempo, 2))+ pInicial;
//    }
//    public static double mruvPosicionInicialSinV0(double vFinal,double aceleracion,double tiempo, double pFinal){
//        return pFinal - vFinal*tiempo + 0.5*aceleracion*(Math.pow(tiempo, 2));
//    }
//    public static double mruvVelocidadFinalSinV0(double aceleracion,double tiempo,double pInicial, double pFinal){
//        return (pFinal-pInicial)/tiempo + 0.5*aceleracion*(Math.pow(tiempo, 2));
//    }
//    public static double mruvAceleracionSinV0(double vFinal,double tiempo,double pInicial, double pFinal){
//        return 2*vFinal/tiempo - 2*(pFinal-pInicial)/(Math.pow(tiempo, 2));
//    }
//    public static double[] mruvTiempoSinV0(double vFinal,double aceleracion,double pInicial, double pFinal){
//        double[] lista = new double[2];
//        lista[0] = (-vFinal - Math.sqrt(vFinal*vFinal - 2*aceleracion*(pFinal-pInicial)))/aceleracion;
//        lista[1] = (-vFinal + Math.sqrt(vFinal*vFinal - 2*aceleracion*(pFinal-pInicial)))/aceleracion;
//        return lista;
//    }
//    
//    public static double mruvPosicionFinalSinT(double vFinal,double vInicial,double aceleracion,double pInicial){
//        return pInicial + (Math.pow(vInicial,2) - Math.pow(vFinal,2))/(2*aceleracion);
//    }
//    public static double mruvPosicionInicialSinT(double vFinal,double vInicial,double aceleracion, double pFinal){
//        return pFinal - (Math.pow(vInicial,2) - Math.pow(vFinal,2))/(2*aceleracion);
//    }
//    public static double[] mruvVelocidadFinalSinT(double vInicial,double aceleracion,double pInicial, double pFinal){
//        double[] lista = new double[2];
//        double aux = Math.pow(vInicial, 2) - 2*aceleracion*(pFinal - pInicial);
//        lista[0] = Math.sqrt(aux);
//        lista[1] = -Math.sqrt(aux);
//        return lista;
//    }
//    public static double[] mruvVelocidadInicialSinT(double vFinal,double aceleracion,double pInicial, double pFinal){
//        double[] lista = new double[2];
//        double aux = Math.pow(vFinal, 2) + 2*aceleracion*(pFinal - pInicial);
//        lista[0] = Math.sqrt(aux);
//        lista[1] = -Math.sqrt(aux);
//        return lista;
//    }
//    public static double mruvAceleracionSinT(double vFinal,double vInicial,double pInicial, double pFinal){
//        return (Math.pow(vInicial,2) - Math.pow(vFinal,2))/(2*(pFinal - pInicial));
//    }
//    
//    
//    public static double mruvPosicionFinalSinA(double vFinal,double vInicial,double tiempo,double pInicial){
//        return pInicial + (vFinal + vInicial)*tiempo/2;
//    }
//    public static double mruvPosicionInicialSinA(double vFinal,double vInicial,double tiempo, double pFinal){
//        return pFinal - (vFinal + vInicial)*tiempo/2;
//    }
//    public static double mruvVelocidadFinalSinA(double vInicial,double tiempo,double pInicial, double pFinal){
//        return 2*(pFinal - pInicial)/tiempo - vInicial;
//     }
//    public static double mruvVelocidadInicialSinA(double vFinal,double tiempo,double pInicial, double pFinal){
//        return 2*(pFinal - pInicial)/tiempo - vFinal;
//    }
//    public static double mruvTiempoSinA(double vFinal,double vInicial,double pInicial, double pFinal){
//        return 2*(pFinal - pInicial)/(vFinal - vInicial);
//    }
//    public static double mruvVelocidadInicialPosicion(double Pfinal, double Pinicial, double aceleracion, double tiempo){
//        return (Pfinal-Pinicial)/tiempo -(0.5 *aceleracion *tiempo);
//    }
    public static double[] buscarDatoMRUV(double[] datos){
        boolean[] datosentrada=new boolean[6];
        for(int x=0; x <= 5;x++){
            if (datos[x] == 123456){
               datosentrada[x]=false;
            }
            else{
                datosentrada[x]=true;
            }
        }
        for(int x=0; x <=5; x++){
            if (datos[x] == 123456){
                 switch(x+1){
                        case 1:
                            if (datosentrada[1] == true && datosentrada[3] == true && datosentrada[4] == true && datosentrada[5] == true){
                                 datos[x]=Fisica.mruvPosicionFinal(datos[1],datos[3],datos[4],datos[5]);
                                 datosentrada[x]=true;
                                 x=0;
                                 }
                            break;
                         case 2:
                             if(datosentrada[0] == true && datosentrada[3] == true && datosentrada[4] == true && datosentrada[5] == true){
                                 datos[x]=Fisica.mruvPosicionInicial(datos[0], datos [3], datos[4], datos[5]);
                                 datosentrada[x]=true;
                                 x=0;
                             }
                             break;
                         case 3:
                             if ( datosentrada[3] == true && datosentrada[4] == true && datosentrada[5] == true){
                                 datos[x]=Fisica.mruvVelocidadFinal(datos[3], datos[4], datos[5]);
                                 datosentrada[x]= true;
                                 x=0;
                             }
                             break;
                         case 4:
                             if(datosentrada[2] == true && datosentrada[4] == true && datosentrada[5] == true){
                                 datos[x]= Fisica.mruvVelocidadInicial(datos[2], datos[4], datos[5]);
                                 datosentrada[x]=true;
                                 x=0;
                             }
                             if(datosentrada[0] == true && datosentrada[1] == true && datosentrada[4]== true && datosentrada[5] == true){
                                 datos[x]= Fisica.mruvVelocidadInicialPosicion(datos[0],datos[1],datos[4], datos[5]);
                                 datosentrada[x]= true;
                                 x=0;
                             }
                             break;
                         case 5:
                             if (datosentrada[2] == true && datosentrada[3] == true && datosentrada[6] == true){
                                 datos[x]=Fisica.mruvAceleracionVelocidad(datos[2],datos[3],datos[6]);
                                 datosentrada[x]= true;
                                 x=0;
                                 break;
                             }
                             if (datosentrada[0] == true && datosentrada[1] == true && datosentrada[2] == true && datosentrada[5] == true){
                                 datos[x]=Fisica.mruvAceleracionPosicion(datos[0],datos[1], datos[3], datos[5]);
                                 datosentrada[x]= true;
                                 x=0;
                                 break;
                             }
                             break;
                         case 6:
                             if (datosentrada[0] == true && datosentrada[1] == true && datosentrada[3] == true && datosentrada[4] == true){
                                 datos[x]= Fisica.mruvTiempoPosicion(datos[0],datos[1],datos[3],datos[4])[1];
                                 datosentrada[x]=true;
                                 x=0;
                                 break;
                             }
                             if(datosentrada[2] == true && datosentrada[3] == true && datosentrada[4] == true){
                                 datos[x]= Fisica.mruvTiempoVelocidad(datos[2],datos[3],datos[4]);
                                 datosentrada[x]= true;
                                 x=0;
                                 break;
                             }
                             break;                
                 }
            }
        }
        return datos;
    }
//    public static double[] mruvTiempoPosicion(double Pfinal, double Pinicial, double Vinicial, double aceleracion){
//         double [] resultados=new double[2];
// //    try{
//            double t1;
//            double t2;
//            double posicionfinal= Pfinal-Pinicial;
//            t1= ((-1)*Vinicial + Math.sqrt((Vinicial*Vinicial) - (4*0.5*aceleracion*posicionfinal)))/2*0.5*aceleracion;
//            t2=((-1)*Vinicial + Math.sqrt((Vinicial*Vinicial) + (4*0.5*aceleracion*posicionfinal)))/2*0.5*aceleracion;
//            resultados[0]=t1;
//            resultados[1]=t2;
//            return resultados;
//  //    }
////      catch(Exception){
////          System.out.println("raiz negativa.......!!");
////      }       
//    }
//    public static double mruvTiempoVelocidad(double Vfinal,double Vinicial,double aceleracion){
//        return (Vfinal-Vinicial)/aceleracion;
//    }
//    public static double mruvAceleracionVelocidad(double Vfinal,double Vinicial, double tiempo){
//        return (Vfinal-Vinicial)/tiempo;
//    }
    public static double fuerzaEjex(double fuerza, double angulo){
        return fuerza * Math.cos(angulo*Math.PI/180);
    }
    public static double fuerzaEjey(double fuerza, double angulo){
        return fuerza*Math.sin(angulo*Math.PI/180);
    }
    public static double fuerzaDeRozamiento(double coeficiente, double normal){
        return coeficiente*normal;
    }
    public static double coeficienteDeRozamiento(double fuerza, double normal){
        return fuerza/normal;
    }
    public static double fuerzaNormal(double peso, double angulo){
        return peso* Math.cos(angulo*Math.PI/180);
    }
    public static double fuerzaPeso(double masa){
        return masa*gravedad;
    }
    public static double fuerzaPesoX(double peso, double angulo){
        return peso* Math.sin(angulo*Math.PI/180);
    }
    public static double fuerzaSinRozamiento(double masa, double aceleracion){
        return masa*aceleracion;
    }
    public static double aceleracionSinRozamiento(double fuerza, double masa){
        return fuerza/masa; 
    }
    public static double masaSinRozamiento(float fuerza, float aceleracion){
        return fuerza/aceleracion;
    }
    public static double sumaDeFuerzaPositiva(double [] fuerza){
        double suma=0;
        for (int x = 0; x<= fuerza.length -1;x++){
            suma = suma+ fuerza[x];
        }
        return suma;
       
     } 
    public static double sumaDeFuerzaNegativa(double [] fuerza){
        double suma=0;
        for (int x = 0; x<= fuerza.length -1;x++){
            suma = suma+ fuerza[x];
        }
        return suma;
       
     }
    public static double calculoDeTrabajo (double fuerza, double angulo){
        return fuerza * Math.cos(angulo * Math.PI/ 180);
    }
    
       //--------------agregados
    public static double jouleMRUV(double Dinicial, double Dfinal,double masa,double aceleracion, double sen0, double coeficiente){
        return (Dfinal-Dinicial)*(masa*aceleracion+masa*gravedad*sen0+(2/3)*coeficiente*Math.pow(2*aceleracion*(Dfinal-Dinicial),1/2));
    }
    public static double jouleMRU(double Dinicial, double Dfinal,double coeficiente, double Vinicial,double masa, double aceleracion, double sen0){
        return (Dfinal-Dinicial)*(masa*aceleracion*sen0+coeficiente*Vinicial);
    }
    public static double truncarDecimal(double numero, int cantDecimales){
        //System.out.println(numero);
        int multiplicador=1;
        double multiplicador2=1;
        double auxiliar;
        while (cantDecimales>0){
            multiplicador=multiplicador*10;
            multiplicador2=multiplicador2*10.0;
            cantDecimales--;
        }
        auxiliar=(int) (numero*multiplicador);
        numero=((double)auxiliar/multiplicador2);
        return numero;
    }
    //---FUNCIONES AGREGADAS
    //revisar parametros
    
    public static double mruvPosicionFinalSinV0(double vFinal,double aceleracion,double tiempo,double pInicial, double pFinal){
        return vFinal*tiempo - 0.5*aceleracion*(Math.pow(tiempo, 2))+ pInicial;
    }
    public static double mruvPosicionInicialSinV0(double vFinal,double aceleracion,double tiempo,double pInicial, double pFinal){
        return pFinal - vFinal*tiempo + 0.5*aceleracion*(Math.pow(tiempo, 2));
    }
    public static double mruvVelocidadFinalSinV0(double vFinal,double aceleracion,double tiempo,double pInicial, double pFinal){
        return (pFinal-pInicial)/tiempo + 0.5*aceleracion*(Math.pow(tiempo, 2));
    }
    public static double mruvAceleracionSinV0(double vFinal,double aceleracion,double tiempo,double pInicial, double pFinal){
        return 2*vFinal/tiempo - 2*(pFinal-pInicial)/(Math.pow(tiempo, 2));
    }
    public static double[] mruvTiempoSinV0(double vFinal,double aceleracion,double tiempo,double pInicial, double pFinal){
        double[] lista = new double[2];
        lista[0] = (-vFinal - Math.sqrt(vFinal*vFinal - 2*aceleracion*(pFinal-pInicial)))/aceleracion;
        lista[1] = (-vFinal + Math.sqrt(vFinal*vFinal - 2*aceleracion*(pFinal-pInicial)))/aceleracion;
        return lista;
    }
    public static double[] vascara(double a, double b, double c){
        try{
            double ter1=Math.sqrt(b*b-4.0*a*c);
        double ter2= 2.0*a;
        double res1= (-b+ter1)/ter2;
        double res2= (-b-ter1)/ter2;
        return new double[]{res1,res2};
        }
        catch(ArithmeticException e){
            return new double[]{0,0};
        }
    }
    public static double aRadianes(double anguloGrados){
        //Pasa de grados a radianes
        return (anguloGrados*Math.PI/180.0);
    }
    public static double sen(double grados){
        if (grados==360.0)
            return 0.0;
        if (grados==330.0)
            return -0.5;
        if (grados==270.0)
            return -1;
        if (grados==210)
            return -0.5;
        if (grados==180.0)
            return 0.0;
        if (grados==150.0)
            return 0.5;
        if (grados==90.0)
            return 1.0;
        if(grados==30)
            return 0.5;
        if (grados==0.0)
            return 0.0;
        return (Math.sin(aRadianes(grados)));
    }
    
    public static double cos(double grados){
        if (grados==0.0)
            return 1;
        if (grados==60.0)
            return 0.5;
        if (grados==90.0)
            return 0.0;
        if (grados==120.0)
            return -0.5;
        if (grados==180.0)
            return -1.0;
        if (grados==240.0)
            return -0.5;
        if (grados==270.0)
            return 0.0;
        if (grados==300.0)
            return 0.5;
        if (grados==360.0)
            return 1.0;
        return (Math.cos(aRadianes(grados)));
    }
    
    //Energia
public static double trabajoFuerza(double fuerza, double distancia, double angulo){
        return fuerza*distancia*Math.cos(angulo*Math.PI/180);
    }
    
    public static double trabajoFuerzaRoce(double fuerza, double distancia){
        return fuerza*distancia*-1;
    }
    public static double velocidadCinetica(double cinetica, double masa){
        return Math.sqrt(2*cinetica/ masa);
    }
    public static double energiaVelocidadTrabajo(double cinetica, double trabajo, double masa){
        return Math.sqrt(2*(trabajo - cinetica)/masa);
    }
    public static double energiaCinetica(double masa, double velocidad){
        return (masa * Math.pow(velocidad, 2))/2;
    }
    public static double energiaPotencial(double masa, double altura){
        return fuerzaPeso(masa)* altura;
    }
    public static double energiaElastica(double constante, double largo){
        return (constante * Math.pow(largo, 2))/2;
    }
    public static double velocidadMecanica(double mecanica, double elastica, double potencial, double masa){
        return Math.sqrt((2*(mecanica - elastica - potencial))/ masa);
    }

//MRUV
    public static double[] mruvTiempoPosicion(double Pfinal, double Pinicial, double Vinicial, double aceleracion){
         double [] resultados=new double[2];
               resultados = vascara(0.5*aceleracion, Vinicial,Pinicial-Pfinal);
            return resultados;
    }
    public static double mruvTiempoVelocidad(double Vfinal,double Vinicial,double aceleracion){
        return (Vfinal-Vinicial)/aceleracion;
    }
    public static double mruvAceleracionVelocidad(double Vfinal,double Vinicial, double tiempo){
        return (Vfinal-Vinicial)/tiempo;
    }
    
    public static double mruvPosicionFinal(double posicion, double Vinicial, double aceleracion,double tiempo){
        return posicion + (Vinicial * tiempo) + (0.5 * aceleracion * (tiempo *tiempo));
    }
    public static double mruvPosicionInicial(double posicion, double Vinicial, double aceleracion,double tiempo){
        return posicion - Vinicial * tiempo - 0.5 * aceleracion * (tiempo *tiempo);
    }
    public static double mruvVelocidadFinal(double Vinicial, double aceleracion, double tiempo){
        return Vinicial+ aceleracion*tiempo;
    }
    public static double mruvVelocidadInicial(double Vfinal, double aceleracion, double tiempo){
        return Vfinal- (aceleracion * tiempo);
    }
     public static double mruvAceleracionPosicion(double Pfinal, double Pinicial, double Vinicial, double tiempo){
        return 2*(Pfinal - Pinicial- Vinicial*tiempo)/(tiempo*tiempo);
    }
     public static double mruvPosicionFinalSinV0(double vFinal,double aceleracion,double tiempo,double pInicial){
        return vFinal*tiempo - 0.5*aceleracion*(Math.pow(tiempo, 2))+ pInicial;
    }
    public static double mruvPosicionInicialSinV0(double vFinal,double aceleracion,double tiempo, double pFinal){
        return pFinal - vFinal*tiempo + 0.5*aceleracion*(Math.pow(tiempo, 2));
    }
    public static double mruvVelocidadFinalSinV0(double aceleracion,double tiempo,double pInicial, double pFinal){//CORREGIDO
        return (pFinal-pInicial)/tiempo + 0.5*aceleracion*tiempo;
    }
    public static double mruvAceleracionSinV0(double vFinal,double tiempo,double pInicial, double pFinal){
        return 2*(pInicial - pFinal + vFinal*tiempo)/(tiempo*tiempo);
    }
    public static double[] mruvTiempoSinV0(double vFinal,double aceleracion,double pInicial, double pFinal){
        double[] lista = new double[2];
//        lista[0] = (vFinal - Math.sqrt(vFinal*vFinal + 2*aceleracion*(pFinal-pInicial)))/-aceleracion;
//        lista[1] = (vFinal + Math.sqrt(vFinal*vFinal + 2*aceleracion*(pFinal-pInicial)))/-aceleracion;
        lista = vascara(0.5*aceleracion,-vFinal,pFinal - pInicial);
//        lista[1] = vascara(pFinal - pInicial,- vFinal,0.5*a);
    
        return lista;
    }
    
    public static double mruvPosicionFinalSinT(double vFinal,double vInicial,double aceleracion,double pInicial){
        return pInicial - (Math.pow(vInicial,2) - Math.pow(vFinal,2))/(2*aceleracion);
    }
    public static double mruvPosicionInicialSinT(double vFinal,double vInicial,double aceleracion, double pFinal){
        return pFinal + (Math.pow(vInicial,2) - Math.pow(vFinal,2))/(2*aceleracion);
    }
    public static double[] mruvVelocidadFinalSinT(double vInicial,double aceleracion,double pInicial, double pFinal){
        double[] lista = new double[2];
        double aux = vInicial*vInicial + 2*aceleracion*(pFinal- pInicial);
        lista[0] = Math.sqrt(aux);
        lista[1] = -Math.sqrt(aux);
        return lista;
    }
    public static double[] mruvVelocidadInicialSinT(double vFinal,double aceleracion,double pInicial, double pFinal){
        double[] lista = new double[2];
        double aux = Math.pow(vFinal, 2) + 2*aceleracion*(pInicial - pFinal);
        lista[0] = Math.sqrt(aux);
        lista[1] = -Math.sqrt(aux);
        return lista;
    }
    public static double mruvAceleracionSinT(double vFinal,double vInicial,double pInicial, double pFinal){
        return (Math.pow(vFinal,2) - Math.pow(vInicial,2))/(2*(pFinal - pInicial));
    }
    
    
    public static double mruvPosicionFinalSinA(double vFinal,double vInicial,double tiempo,double pInicial){
        return pInicial + vInicial*tiempo + tiempo*(vFinal - vInicial)/2.0;
    }
    public static double mruvPosicionInicialSinA(double vFinal,double vInicial,double tiempo, double pFinal){
        return pFinal -(vFinal - vInicial)/2.0*tiempo - vInicial*tiempo;
    }
    public static double mruvVelocidadFinalSinA(double vInicial,double tiempo,double pInicial, double pFinal){
        return 2.0*(pFinal - pInicial - vInicial*tiempo)/tiempo + vInicial;
     }
    public static double mruvVelocidadInicialSinA(double vFinal,double tiempo,double pInicial, double pFinal){
        return (2.0*pFinal - 2.0*pInicial - tiempo*vFinal)/tiempo;
    }
    public static double mruvTiempoSinA(double vFinal,double vInicial,double pInicial, double pFinal){
        return 2*(pFinal - pInicial)/(vInicial + vFinal);
    }
    public static double mruvVelocidadInicialPosicion(double Pfinal, double Pinicial, double aceleracion, double tiempo){
        return ((Pfinal - Pinicial)- 0.5 *aceleracion *Math.pow(tiempo, 2))/tiempo;
    }
    public static double moaPosicion(double amplitud,double frecuencia,double faseInicial,double tiempo){
        double vAng = 2*Math.PI*frecuencia;
        return amplitud*Math.sin(vAng*tiempo+faseInicial);
    }
    public static double moaVelocidad(double amplitud,double frecuencia,double faseInicial,double tiempo){
        double vAng = 2*Math.PI*frecuencia;
        return amplitud*vAng*Math.cos(vAng*tiempo + faseInicial);
    }
    public static double moaAceleracion(double amplitud,double frecuencia,double faseInicial,double tiempo){
        double vAng = 2*Math.PI*frecuencia;
        return (-1)*amplitud*vAng*vAng*Math.sin(vAng*tiempo + faseInicial);
    }
    
    public static double moaTiempoConAceleracion(double aceleracion, double amplitud, double frecuencia, double faseInicial){
        double wAng = 2*Math.PI*frecuencia;
        double aux = (-1)*aceleracion/(amplitud*wAng*wAng);
        return (Math.asin(aux)- faseInicial)/wAng;
    }
    public static double moaTiempoConPosicion(double posicion, double amplitud, double frecuencia, double faseInicial){
        double wAng = 2*Math.PI*frecuencia;
        double aux = posicion/amplitud;
        return (Math.asin(aux)- faseInicial)/wAng;
    }
    public static double moaTiempoConVelocidad(double velocidad, double amplitud, double frecuencia, double faseInicial){
        double wAng = 2*Math.PI*frecuencia;
        double aux = velocidad/(amplitud*wAng);
        return (Math.asin(aux)- faseInicial)/wAng;
    }
}
   