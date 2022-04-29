package isaac.challenge;

import java.util.Scanner;
/**
 *
 * @author Isaac
 * Programa con un menu de opciones que me permite diseñar un Sistema de
 * conversion de numeros de diferentes bases. Como resultado muestra el 
 * numero entero a su binario correspondiente, un entero a octal y un 
 * entero a hexadecimal.
 */
public class Conversion_Numeros {
    public static void main(String[] args) {
        Menu();
        Scanner lec= new Scanner(System.in);//Lectura de opcion.
        while(!validarDecimal(lec)){//Validar que sea entero.
            System.out.println("Debe ingresar un número, no introduzca letras ni caracteres.");
            Menu();
            lec = new Scanner(System.in);
        }
        int opcion = lec.nextInt();
        while(opcion < 1 || opcion > 3){//Verifica que la opcion este dentro del menu.
            System.out.println("Opción no válida. Seleccione una opcion valida.");
            lec= new Scanner(System.in);//Lectura de opcion.
            if(!validarDecimal(lec)){//Validar que sea entero
                System.out.println("Debe ingresar un número, no introduzca letras ni caracteres.");
                Menu();
            }else{
                opcion = lec.nextInt();
            }
        }
        Scanner lec2 = new Scanner(System.in);//Lectura del número a convertir.
        int num; String res;
        switch(opcion){
            case 1://Conversion de Decimal a Binario.
                System.out.println("Escriba el número a convertir:");
                while(!validarDecimal(lec2)){//Validar que sea un valor decimal.
                    lec2 =new Scanner(System.in);
                }
                num = lec2.nextInt();
                Conversion DeciBinar =new Conversion();
                DeciBinar.ConsConver(2, num);
                res = DeciBinar.Convertir();
                System.out.println(num+" convertido a Binario es: "+res);
                break;
            case 2://Conversion de Decimal a Octal.
                System.out.println("Escriba el número a convertir:");
                while(!validarDecimal(lec2)){//Validar que sea un valor decimal.
                    lec2 =new Scanner(System.in);
                }
                num = lec2.nextInt();
                Conversion DeciOctal =new Conversion();
                DeciOctal.ConsConver(8, num);
                res = DeciOctal.Convertir();
                System.out.println(num+" convertido a Octal es: "+res);
                break;
            case 3://Conversion de Decimal a Hexadecimal.
                System.out.println("Escriba el número a convertir:");
                while(!validarDecimal(lec2)){//Validar que sea un valor decimal.
                    lec2 =new Scanner(System.in);
                }
                num = lec2.nextInt();
                Conversion DeciHexa =new Conversion();
                DeciHexa.ConsConver(16, num);
                res = DeciHexa.Convertir();
                System.out.println(num+" convertido a Hexadecimal es: "+res);
                break;
            
        }
    }
    
    public static void Menu() {
        System.out.println("\n MENU \nEscriba el numero de la opción correspondiente del menu.");
        System.out.println("1. Decimal a Binario.\n"
                        + "2. Decimal a octal.\n"
                        + "3. Decimal a Hexadecimal.");
    }
    public static boolean validarDecimal(Scanner lectura) {
        if(lectura.hasNextInt()){
            return true;
        }
        else{
            System.out.println("El numero no es valido. Insertar nuevamente.");
            return false;
        }
    }
}
