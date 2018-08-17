/*
 *Según las especificaciones del problema, se tiene que contamos con una matriz de MxN
 *En la que partimos en la posición [0,0] y viendo hacia la derecha, de ahí se puede
 *mover una posición a la vez, no puedes ocupar un espacio que ya has ocupado antes,
 *si estás en esta situación debes doblar a la derecha. De igual forma debes doblar
 *a la derecha si te encuentras en el borde la matriz. Por lo tanto, el flujo de este
 *problema nos da como resultado que se recorrerá dicha matriz en forma de espiral
 *de acuerdo al sentido de las manecillas del reloj.
 */

/**
 * Para la solución de éste problema pensé en una máquina de 4 estados. Donde el
 * primer estado es el viaje de izquierda a derecha (R), después el estado pasa a ser
 * el siguiente y entonces el viaje es de arriba a abajo (D), al terminar el viaje
 * pasa a ser de derecha a izquierda (L) y por último el viaje es de abajo a arriba
 * (U), repitiéndose esto hasta recorrer todos los elementos. De esta forma se puede
 * saber hacia donde terminó el viaje, esto conociendo el último estado de la máquina.
 */
package logic_test;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Manuel Zavala
 */
public class Logic_Test {
    private int arrayQty;
   private ArrayList<int[][]> array = new ArrayList<>();
   
    public Logic_Test()
    {
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Logic_Test l = new Logic_Test();
       l.print("Escribe la cantidad de casos:");
       l.numberTestCases();
       l.createArrays();
       l.print("////////////////////////////////");
       l.print("Se recorrerán todas las matrices");
       l.iterator();
       l.print("////////////////////////////////");
       l.print("Autor: Manuel Zavala");
    }
    /**
     * Función para crear la cantidad de matrices que se piden
     */
    public void createArrays()
    {
        Scanner s = new Scanner(System.in);
        for(int i=0;i<arrayQty;i++)
        {
            
           
           int y; int z;
           print("Matriz #"+Integer.toString(i+1));
           print("Escribe la cantidad de filas");
           y = Integer.parseInt(s.nextLine());
           print("Escribe la cantidad de columnas");
           z = Integer.parseInt(s.nextLine());
           int x[][] = new int[y][z];
           putArrays(x);
        }
    }
    /**
     * Función para agregar la matriz a una lista
     * @param x 
     */
    public void putArrays(int x[][])
    {
        array.add(x);
    }
    
    /**
     * Función para ingresar la cantidad de matrices que se requieren
     * analizar
     */
    public void numberTestCases()
    {
        int entry =0;
        Scanner s = new Scanner(System.in);
        String u = s.nextLine();
       // print(u);
        entry = stringToInt(u);
        this.arrayQty = entry;
    }
    
    /**
     * Función que imprime un valor en la ventana de comandos
     */
    public void print(String toPrint)
    {
        System.out.println(toPrint);
    }
    
    /**
     * Función para convertir enteros a String
     */
    public String intToString(int x)
    {
        return Integer.toString(x);
    }
    
    /**
     * Función para convertir String a entero
     */
    public int stringToInt(String x)
    {
        return Integer.parseInt(x);
    }
    
    public void travel(int x[][])
    {
          String pos = "";
          int z =0;    //Filas
          int y =0;     //Columnas
          int state = 0; //Manejador de la máquina de estados
          int qty = 0;   //Elementos recorridos
          int size = x.length*x[0].length; //Tamaño de la matriz
          
          print("Ruta: ");
          while(qty < size)
          {
              switch(state)
              {
                  case 0:
                      for(int w=z;w<x[0].length-y;w++)
                      {
                          System.out.print("("+intToString(z)+","+intToString(w)+")->");
                          qty++;
                          pos = "R";
                      }
                      state++;
                      break;
                  case 1:
                      for(int w=z+1;w<x.length-z;w++)
                      {
                          System.out.print(" ("+intToString(w)+","+intToString(x[0].length-1-y)+")->");
                          qty++;
                          
                          pos = "D";
                      }
                      state++;
                      break;
                  case 2: 
                      for(int w = x[0].length -2-y; w >= y; w--)
                      {
                          System.out.print(" ("+intToString(x.length-1-z)+","+intToString(w)+")->");
                          qty++;
                          
                          pos = "L";
                      }
                      state++;
                      break;
                  case 3:
                      for (int w = x.length - 2 - z; w >= z + 1; w--)
                      {
                          System.out.print(" ("+intToString(w)+","+intToString(y)+")->");
                          qty++;
                          
                          pos = "U";
                      }
                      state = 0;
                      z++;
                      y++;
                      break;
              }
          }
          print("");
          print("Posición final: ");
          print(pos);
          
          
    }
    
    public void iterator()
    {
        int i = 0;
        for(int x[][] :array)
        {
            print("////////////////////////////////");
            i++;
            print("Matriz #"+Integer.toString(i) + "["+Integer.toString(x.length)+"x"+Integer.toString(x[0].length)+"]");
            travel(x);
        }
    }
    
}
