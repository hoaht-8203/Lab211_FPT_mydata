/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoaht
 */
public class Graph {
    int vertex_number;
    int adjacency_matrix[][];

    public Graph() {
    }
    
    public Graph(int vertex_number) {
        this.vertex_number = vertex_number;
        adjacency_matrix = new int[vertex_number][vertex_number];
    }
    
    public void addEdge(int pos1, int pos2) {
        if(pos1 >= 0 && pos1 < vertex_number && pos2 >= 0 && pos2 < vertex_number) {
            adjacency_matrix[pos1][pos2] = 1;
            adjacency_matrix[pos2][pos1] = 1;
        }
    }
    
    public boolean isEdge(int pos1, int pos2) {
        return adjacency_matrix[pos1][pos2] == 1 || adjacency_matrix[2][1] == 1;
    }
}
