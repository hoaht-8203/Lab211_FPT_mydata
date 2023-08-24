
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
        
        Graph graph = new Graph(6);
        graph.addEdge(1, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);
        
        System.out.println("Enter the start point: ");
        int pos1 = sc.nextInt();
        System.out.println("Enter the end point: ");
        int pos2 = sc.nextInt();
        
        boolean b = graph.isEdge(pos1, pos2);
        
        if(b) System.out.println("This is an edge");
        else System.out.println("This is not an edge");
    }
    
}
