
import java.util.Scanner;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        insertToArray(arr);
        
        System.out.println("Enter search value: ");
        int key = sc.nextInt();
        
        System.out.print("The array: ");
        printArray(arr);
        System.out.println("Found " + key + " at index: " + linearSearch(arr, key));
        
    }
    
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                return i;
            }
        }
        
        return -1;
    }
    
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1) {
                System.out.print(arr[i]);
            }else{
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }
    
    public static void insertToArray(int[] arr) {
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter ["+i+"]: ");
            arr[i] = sc.nextInt();
        }
    }
}
