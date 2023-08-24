
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        insertToArray(arr);
        
        System.out.print("Unsorted array: ");
        printArray(arr);
        selectionsort(arr);
        System.out.print("Sorted array: ");
        printArray(arr);
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
    
    public static void selectionsort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min_index = i;
            
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            
            int tmp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = tmp;
        }
    }
}
