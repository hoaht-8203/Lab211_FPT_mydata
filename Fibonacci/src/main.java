/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoaht
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        printFibonacci(45);
    }
    
    public static void printFibonacci(int size) {
        int f0 = 0, f1 = 1, fn = 0;
        for (int i = 1; i <= size; i++) {
            
            if(i == size) System.out.print(fn);
            else System.out.print(fn + ", ");
            
            f0 = f1;
            f1 = fn;
            fn = f0 + f1;
        }
        System.out.println("");
    }
}
