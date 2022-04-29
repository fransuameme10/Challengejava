package isaac.challenge2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Isaac
 * Programa que genera una matriz de n x n validando que solo
 * sean numeros enteros y en caso de que el numero ya exista 
 * en la matriz no se debera guardar.
 * Mostrara como resultado el total de numeros pares y primos 
 * en un vector unidimensional ordenados descendentemente.
 */
public class ParesPrimos {
    public static void main(String[] args) {
        System.out.println("Introduzca el numero de filas de la matriz:");
        Scanner lec = new Scanner(System.in);
        int filas = Pedirvalor(lec);
        System.out.println("Introduzca el numero de columnas de la matriz:");
        Scanner lec2 = new Scanner(System.in);
        int columnas = Pedirvalor(lec2);
        System.out.println("Introduzca los valores de la matriz(Se ingresa uno a uno y presionando la tecla enter para continuar).");
        Crearmatriz(filas, columnas);//Función para crear y mostrar el resultado de los numeros pares e impares
        
    }

    public static boolean validarDecimal(Scanner lectura) {
        //Validar que los números ingresados sean enteros.
        if(lectura.hasNextInt()){
            return true;
        }
        else{
            System.out.println("El numero no es valido. Insertar nuevamente.");
            return false;
        }
    }

    public static int Pedirvalor(Scanner lect) {
        //Función para reingresar valores correctos.
        while(!validarDecimal(lect)){
            lect = new Scanner(System.in);
        }
        int value = lect.nextInt();
        return value;
    }

    public static void imprimirmatriz(int filas, int columnas, int [][] mat) {
        //Función para darle formato a la impresión de la matriz.
        System.out.print("Matriz: \n[ ");
        for (int i = 0; i < filas; i++) {//Recorrido de las filas
            for (int j = 0; j < columnas; j++) {//Recorrido de las columnas
                System.out.print(""+mat[i][j]+", ");
            }
            System.out.println(" ");
        }
        System.out.println(" ]");
        
    }

    public static void Crearmatriz(int filas, int columnas) {
        
        ArrayList<Integer> temp = new ArrayList<Integer>();//Variable temporal para verificar los valores repetidos.
        int value;
        int [][] matriz = new int [filas][columnas];
        for(int x=0; x < filas; x++){//Recorrido de las filas.
            for(int y=0; y < columnas; y++){//Recorrido de las colunas.
                Scanner lect = new Scanner(System.in);
                value = Pedirvalor(lect);//Validación de los valores de la matriz que sean enteros.
                while(temp.contains(value)) {
                    //Buscar valores repetidos en la lista para solicitar cambiarlo.
                    System.out.println("El número ya se encuentra en la matriz. Cambie el valor.");
                    value = Pedirvalor(lect);
                }
                //Agregar los valores.
                temp.add(value);
                matriz[x][y] = value;             
            }
        }
        int par = 0, impar = 0;
        ArrayList<Integer> Pares = new ArrayList<Integer>();
        ArrayList<Integer> Impares = new ArrayList<Integer>();

        imprimirmatriz(filas, columnas, matriz);//Impresión de matriz.

        for (int i = 0; i < temp.size(); i++) {
            //Conteo de números pares e impares.
            if (temp.get(i)%2 == 0) {
                par += 1;
                Pares.add(temp.get(i));//Separar números pares.
            }else{
                impar += 1;
                Impares.add(temp.get(i));//Separar números impares.
            }
        }
        Collections.sort(Pares); Collections.reverse(Pares);//Ordenar de forma descendente los números pares.
        Collections.sort(Impares); Collections.reverse(Impares);//Ordenar de forma descendente los números impares.
        System.out.println("La matriz tiene "+par+" números pares, los cuales son:");
        Pares.forEach(System.out::println);//Impresión de los números pares.
        System.out.println("La matriz tiene "+impar+" números impares, los cuales son:");
        Impares.forEach(System.out::println);//impresión de los números impares.
    }

}
