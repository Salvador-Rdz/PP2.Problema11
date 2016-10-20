/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp2.problema11;
import java.util.*;

/**
 *
 * @author Enano
 */
public class PP2Problema11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // Variables
        int Num;
        String [] romanDigits = {"I", "IV", "V", "IX", "X", "XL", "L","XC", "C", "CD", "D", "CM", "M"}; //Combinaciones de números romanos posibles. 
        int [] arabicDigits = {1,4,5,9,10,40,50,90,100,400,500,900,1000};                               //Equivalentes en arábigo.
        //Resolución                                                                                    //Sólo creo poder hasta el 3999, debido a que 4000+ usa caracteres especiales.
        Num=getNum();
        print(ConvToRoman(Num,arabicDigits, romanDigits));
    }
    public static int getNum ()
    {
        Scanner getinf = new Scanner (System.in);
        int Number;
        System.out.println("**** Bienvenid@ ****");
        System.out.println("Ingrese el número que desea convertir a número romano: ");
        Number=getinf.nextInt();
        return Number;
    }
    public static String ConvToRoman (int n, int[] aDigits, String[] rDigits)
    {
        String romNumbers="";          //*Se hace un ciclo que determine cuantas veces se repite un numero, sacando el residuo.
        {                                         
            for (int i=aDigits.length-1; i>=0; --i) //El for tiene como condición la longitud de el arreglo que contiene los equivalentes.
            {                                        
                int nTimes = n / aDigits[i];        //Se obtiene el número de veces que se agregará el número, iniciando desde el más alto.          
                while (nTimes > 0)                  //Si el número de veces resulta ser mas de 0, se agrega el número romano correspondiente
                {                                    //Se agrega "nTimes" veces, y como los equivalentes del arreglo usan la misma coordenada, solo se agrega.
                    romNumbers=romNumbers+rDigits[i];//Se van agregando los números romanos a una cadena.
                    nTimes--;                        //Se le resta 1 cada vez que ocurre esto.
                }
                n = n%aDigits[i];                    //El número se cambia al residuo del mismo.
            }
        return romNumbers;  
        }
    }
    public static void print (String conver)
    {
        System.out.println(conver);                   //Se imprime la cadena de caracteres
    }
}
