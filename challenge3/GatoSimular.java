package isaac.challenge3;

import java.util.*;

public class GatoSimular {
    public static void main(String[] args) {
        char [][] gato = new char[3][3];
        gato = iniciar(gato);
        //Inicia juego del gato.
        System.out.println("JUEGO DEL GATO\n El jugador 1 tendra las X y el jugador 2 tendra las O.");
        System.out.println("Jugador 1 ingresa tu nombre: ");
        //Ingreso del jugador 1.
        Scanner lect1 = new Scanner(System.in);
        String namejugador1 = lect1.next();
        //Registro del jugador 1.
        jugador Jugador1 = new jugador();
        Jugador1.JugadorRe('X', namejugador1);
        //Ingreso del jugador 2.
        System.out.println("Jugador 2 ingresa tu nombre: ");
        Scanner lect2 = new Scanner(System.in);
        String namejugador2 = lect2.next();
        //Registro del jugador 2.
        jugador Jugador2 = new jugador();
        Jugador2.JugadorRe('O', namejugador2);

        imprimirmatriz(gato);//Visualizacion de las posiciones y del gato en blanco.
        
        System.out.println("Comienza: "+Jugador1.getName());
        int Position = pedirposicion();//Pedir la primera posicion para tirar la primer jugada.
        char tiro=Jugador1.getTiro();//Caracter para hacer la primera jugada.
        while(hayEspacio(gato) == true){//Comprobar que el gato tiene casillas para seguir jugando.
            //Verificar si ya hay un ganador.
            if(ConsGanador(gato, tiro) == true){
                if(tiro =='X'){
                    System.out.println("El ganador es: "+ Jugador1.getName());
                    return;
                }else{
                    System.out.println("El ganador es: "+ Jugador2.getName());
                    return;
                }
            }
            else{//Si no hay ganador se actualiza el turno
                if(tiro == 'X'){
                    gato = Actualizar(gato, Position, Jugador1);//Actualizacion del tablero del gato.
                    imprimirmatriz(gato);//Mostrar el gato actualizado y posiciones para tirar.
                    if(ConsGanador(gato, tiro) == false){
                        System.out.print("Turno de: "+Jugador2.getName()+" con O ");
                        Position = pedirposicion();//Colocar posición a tirar.
                        tiro = Jugador2.getTiro();//Actualizacion del jugador del cual es su turno.
                    }
                }
                else{
                    gato = Actualizar(gato, Position, Jugador2);//Actualizacion del tablero del gato.
                    imprimirmatriz(gato);//Mostrar el gato actualizado y posiciones para tirar.
                    if(ConsGanador(gato, tiro) == false){    
                        System.out.print("Turno de: " +Jugador1.getName()+"  con X ");
                        Position = pedirposicion();//Colocar posición a tirar.
                        tiro = Jugador1.getTiro();//Actualizacion del jugador del cual es su turno.
                    }
                }
            }
        }
        //Al ya no haber casillas se comprueba si hay un ganador o es un empate.
        if(ConsGanador(gato, tiro) == true){
            //Verificar si hay un ganador.
            if(tiro =='X'){
                System.out.println("El ganador es: "+ Jugador1.getName());
                return;
            }else{
                System.out.println("El ganador es: "+ Jugador2.getName());
                return;
            }
        }else{//De lo contrario es un empate.
            System.out.println("Es un empate. No hay mas casillas.");
        }

    }

    //Metodos para la simulacion del juego del gato.
    public static char[][] iniciar(char [][] gato) {
        //Función para inicializar el gato.
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                gato[i][j] = '-';// Se rellena con guiones.
            }
        }
        return gato;
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
        return lect.nextInt();
    }
    
    public static void imprimirmatriz(char[][] gat) {
        //Función para darle formato a la impresión del gato.
        System.out.print("Gato: \n");
        for (int i = 0; i < gat.length; i++) {//Recorrido de las filas
            for (int j = 0; j < gat.length; j++) {//Recorrido de las columnas
                    System.out.print(" "+gat[i][j]+" ");
            }
            System.out.println("  ");
        }
        System.out.println(" Posiciones del gato");
        //Impresion de las posiciones para que los jugadores puedan hacer su jugada.
        int x = 1;
        for (int i = 0; i < gat.length; i++) {//Recorrido de las filas
            for (int j = 0; j < gat.length; j++) {//Recorrido de las columnas
                System.out.print("  "+ x); x++;
            }
            System.out.println("  ");
        }
        System.out.println(" ");
        
    }

    private static int pedirposicion() {
        //Función para solicitar la posicion en donde el jugador va a tirar.
        System.out.println("Introduzca la posición donde desea tirar.");
        Scanner lec = new Scanner(System.in);
        return Pedirvalor(lec);//Verifica si el valor es valido para tomarlo como posición.
    }

    public static char[][] Actualizar(char[][] gat, int posicion, jugador ju) {
        //Función para la actualización del gato.
        boolean salir = false;//Bandera.
        while(!salir){
            //Revisar si posicion de la casilla esta vacía.
            switch(posicion){
            //Si la casilla contiene un guíon se campia por la X o la O dependiendo 
            //del jugador en turno.
                case 1: 
                    if(gat[0][0] == '-'){
                        gat[0][0] = ju.getTiro(); salir = true;
                    }else{
                        System.out.println("La casilla que selecciono se encuentra ocupada. Elija otra.");
                        posicion = pedirposicion();
                    }
                    break;
                case 2:
                    if(gat[0][1] == '-'){
                        gat[0][1] = ju.getTiro(); salir = true;
                    }else{
                        System.out.println("La casilla que selecciono se encuentra ocupada. Elija otra.");
                        posicion = pedirposicion();
                    }    
                    break;
                case 3: 
                    if(gat[0][2] == '-'){
                        gat[0][2] = ju.getTiro(); salir = true;
                    }else{
                        System.out.println("La casilla que selecciono se encuentra ocupada. Elija otra.");
                        posicion = pedirposicion();
                    }    
                    break;
                case 4: 
                    if(gat[1][0] == '-'){
                        gat[1][0] = ju.getTiro(); salir = true;
                    }else{
                        System.out.println("La casilla que selecciono se encuentra ocupada. Elija otra.");
                        posicion = pedirposicion();
                    }    
                    break;
                case 5: 
                    if(gat[1][1] == '-'){
                        gat[1][1] = ju.getTiro(); salir = true;
                    }else{
                        System.out.println("La casilla que selecciono se encuentra ocupada. Elija otra.");
                        posicion = pedirposicion();
                    }    
                    break;
                case 6: 
                    if(gat[1][2] == '-'){
                        gat[1][2] = ju.getTiro(); salir = true;
                    }else{
                        System.out.println("La casilla que selecciono se encuentra ocupada. Elija otra.");
                        posicion = pedirposicion();
                    }    
                    break;
                case 7: 
                    if(gat[2][0] == '-'){
                        gat[2][0] = ju.getTiro(); salir = true;
                    }else{
                        System.out.println("La casilla que selecciono se encuentra ocupada. Elija otra.");
                        posicion = pedirposicion();
                    }    
                    break;
                case 8: 
                    if(gat[2][1] == '-'){
                        gat[2][1] = ju.getTiro(); salir = true;
                    }else{
                        System.out.println("La casilla que selecciono se encuentra ocupada. Elija otra.");
                        posicion = pedirposicion();
                    }    
                    break;
                case 9: 
                    if(gat[2][2] == '-'){
                        gat[2][2] = ju.getTiro(); salir = true;
                    }else{
                        System.out.println("La casilla que selecciono se encuentra ocupada. Elija otra.");
                        posicion = pedirposicion();
                    }    
                    break;
                default://En caso de colocar un valor erroneo como posición se solicita cambiarlo o revisar el gato. 
                    System.out.println("Casilla no encontrada o a escrito algo mal. Vuelva a introducir "+ ju.getName());
                    posicion = pedirposicion();
            }
        }
        return gat;//Retorna el gato actualizado.
    }

    public static boolean ConsGanador(char [][] gat, char tiro) {
        //Función para verificar si hay un ganador.
        char v1; char v2; char v3;
        for (int i = 0; i < 3; i++) {
            //Ganador por renglón o fila.            
            v1=gat[i][0]; v2=gat[i][1]; v3=gat[i][2];
            if (v1==tiro && v2==tiro && v3==tiro) {
                //Ganó haciendo gato en un renglón o fila.
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            //Ganador por columna o en vertical.
            v1=gat[0][i]; v2=gat[1][i]; v3=gat[2][i];
            if (v1==tiro && v2==tiro && v3==tiro) {
                //Ganó haciendo gato en una columna o en vertical.
                return true;
            }
        }
        //Revisar diagonal. Esquina superior izquierda a esquina inferior derecha.
        v1=gat[0][0]; v2=gat[1][1]; v3=gat[2][2];
        if (v1==tiro && v2==tiro && v3==tiro) {
            //Ganó haciendo gato en una diagonal.
            return true;
        }
        //Revisar diagonal. Esquina superior derecha a esquina inferior izquierda.
        v1=gat[0][2]; v2=gat[1][1]; v3=gat[2][0];
        if (v1==tiro && v2==tiro && v3==tiro) {
            //Ganó haciendo gato en una diagonal.
            return true;
        }
        return false;
    }

    public static boolean hayEspacio(char [][] gato){
        //Función para revisar si hay casillas disponibles en el gato.
        for (char[] gato1 : gato) {
            for (int j = 0; j<gato.length; j++) {
                //Verificar si el gato aun tiene guiones para una jugada.
                if (gato1[j] == '-') { 
                    return true;
                }
            }
        }
        return false;
    }
    
}
