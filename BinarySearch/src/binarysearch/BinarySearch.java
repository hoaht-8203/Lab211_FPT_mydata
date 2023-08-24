/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.Scanner;

/**
 *
 * @author hoaht
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        insertToArray(arr);
        
        System.out.println("Enter search value: ");
        int key = sc.nextInt();
        
        bubblesort(arr);
        System.out.print("Sorted array: ");
        printArray(arr);
        System.out.println("Found " + key + " at index: " + binarySearch(arr, key));
        
    }
    
    public static int binarySearch(int[] arr, int key) {
        int n = arr.length;
        
        int f_index = 0, l_index = arr.length - 1;
        
        while (f_index <= l_index) {
            int m_index = (f_index + l_index) / 2;
            
            if(arr[m_index] == key) {
                return m_index;
            }
            
            if(key > arr[m_index]) {
                f_index = m_index + 1;
            }
            
            if(key < arr[m_index]) {
                l_index = m_index - 1;
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
    
    public static void bubblesort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swap = false;
            
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swap = true;
                }
            }
            
            if(swap == false) {
                break;
            }
        }
    }
}
