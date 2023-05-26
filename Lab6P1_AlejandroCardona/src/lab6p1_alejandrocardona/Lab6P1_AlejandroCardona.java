/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_alejandrocardona;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author jets
 */
public class Lab6P1_AlejandroCardona {
    static Scanner read = new Scanner (System.in);
    static Random rng = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar){
            System.out.println("1. Ejercicio Práctico 1 - ¿Cuántos primos tienes?");
            System.out.println("2. Ejercicio Práctico 2 - Frecuencia de letras");
            System.out.println("3. Salir");
            int opcion = read.nextInt();
            switch (opcion){
                case 1 : {
                    int size, liminf, limsup;
                    int cont=0;
                    do{
                        System.out.print("Ingrese el tamaño del arreglo a generar: ");
                        size = read.nextInt();
                    } while ( size <= 1);
                    do {
                        System.out.print("Ingrese el límite inferior: ");
                        liminf = read.nextInt();
                        System.out.print("Ingrese el límite superior: ");
                        limsup = read.nextInt();
                    } while ( liminf >= limsup);
                    int [] rngarray = genRandArray(size,liminf,limsup);
                    System.out.print("Arreglo Generado: ");
                    print(rngarray);
                    int [] primes = new int [size];
                    primes = getTotalPrimeCount(rngarray);
                    System.out.print("No. Divisores Primos: ");
                    print(primes);
                }//fin case 1
                break;
                case 2 : {
                    char [] abecedario = new char [27];
                    for ( int i = 97; i<abecedario.length+97;i++){
                        char abc = (char)(i);
                        if ( i >= 97 && i <= 122){
                            abecedario[i-97] = abc;
                        }
                        else {
                            abecedario[26] = '*';
                        }//fin else
                    }
                    boolean minuscula = false;
                    String cadena;
                    do{
                        System.out.println("Ingrese una cadena de letras minúsculas");
                        cadena = read.next();
                        for ( int i = 0; i<cadena.length(); i++ ){
                            int x = cadena.charAt(i);
                            if ((x >= 97&&x<=122) || (x==65533)){
                                minuscula = true;
                            }
                            else if ( (x < 97||x>122)){
                                minuscula = false;
                                break;
                            }
                        }//fin validaciones minusculas
                    }while(minuscula == false);
                    print(extraerFrecuencias(cadena));
                    printchar(abecedario);

                }//fin case 2
                break;
                case 3 : {
                    continuar = false;
                }//fin case 3
                break;
                default : {
                    System.out.println("Se ingreso un número inválido");
                }//fin default
            }//fin switch opcion
        }//fin while menu
        // TODO code application logic here
    }//fin main method
    static int [] genRandArray ( int tamaño, int min , int max){
        int [] temporal = new int [tamaño];
        for ( int i = 0; i < temporal.length; i++){
            temporal [ i ] = rng.nextInt(max-min)+min;
        }//fin for array generation
        return temporal;
    }//fin genRandArray method
    static void print (int [] array){
        for (int i = 0; i < array.length; i++){
            System.out.print("["+array[i]+"]");
        }//fin for i print
        System.out.println("");
    }//fin print methdo
    static boolean isPrime(int num){
        int div = 0;
        boolean prime = true;
        for ( int j = 1; j<= num; j++){
            if ( num % j == 0){
                div++;
            }//es divisible?
        }//is prime moment
        if ( div != 2){
            prime = false;
        }
        return prime;
    }//fin method isPrime
    static int countPrimeFactors(int numero){
        int cantprimos = 0;
        for(int i = 1 ; i <= numero; i++){
            if (isPrime(i)){
                if(numero%i==0){
                    cantprimos++;
                }//fin cantprimos
            }//fin isPrime
        }//fin for i
        return cantprimos;
    }//fin method countPrimeFactors
    static int [] getTotalPrimeCount ( int [] rngarray){
        int [] primoss = new int[rngarray.length];
        for ( int i = 0; i<rngarray.length;i++){
            int x = rngarray[i];
            boolean primo = isPrime(x);
            if (primo){
                primoss[i] = 1;
            }//if prime , then 1
            else{
                primoss[i] = countPrimeFactors(x);
            }//not prime, then
        }//fin for i
        return primoss;
    }//fin method getTotalPrimeCount
    static int [] extraerFrecuencias (String chain){
        int [] frecuencias = new int [27];
        for (int i = 0; i < chain.length(); i++){
            char letra = chain.charAt(i);
            for (int j = 97; j <= 123; j++){
                char ascii = (char)(j);
                if (ascii == letra&&(j >= 97 || j<=122)){
                    frecuencias[j-97]++;
                }//if caracter normal, añadir a índice
                
            }//fin for caracteres normales
            if( letra == 65533){
                frecuencias[26]++;
            }//caracteres especiales buggeados?
        }//fin for longitud de cadena
        return frecuencias;
    }//fin method extraerFreecuencias
    static void printchar (char [] array){
        for (int i = 0; i < array.length; i++){
            System.out.print("["+array[i]+"]");
        }//fin for i print
        System.out.println("");
    }//fin print methdo
    
}//fin class
