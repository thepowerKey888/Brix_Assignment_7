/**
 * Write a program that takes a matrix of size n x n as input and
 * determines whether that matrix is the representation of a directed graph.
 */

public class DirectedOrUndirected {

    /**
     * Uses DFS to traverse the matrix.
     * Checks the connectivity.
     * @param m
     * @param visited
     * @param v
     */
    public static void depthFirstSearch(int[][] m, boolean[] visited, int v){

        visited[v] = true; //marking current vertex as visited

        for(int i = 0; i < visited.length; i++){

            if(m[v][i] != 0 && !visited[i]){
                depthFirstSearch(m, visited, i);
            }
        }
    }

    /**
     * Determines whether the matrix is directed or not.
     * @param m
     * @return
     */
    public static boolean directedGraph(int[][] m){

        //checks if matrix has same number of rows and columns
        if(m.length != m[0].length){

            return false;
        }



        //Using DFS to examine how the matrix is connected
        for(int i = 0; i < m.length; i++){

            //storing all visited vertices from i as visited
            boolean[] visited = new boolean[m.length];
             depthFirstSearch(m, visited, i);

             //checks how strongly the graph is connected
             for(boolean visit : visited){

                 //if there's a vertex that's not visited then
                 //it is an invaild directed graph
                 if(!visit){
                     return false; //not all vertices are reachable from the current vertex
                 }
            }
        }

        return true;
    }

    /**
     * Prints whether the matrix is directed or not.
     * @param result
     */
    public static void directedOrUndirected(boolean result){

        if(result){
            System.out.println("The matrix is a directed graph! ");
        }
        else{
            System.out.println("The matrix is not a directed graph!");
        }
    }

    /**
     * Main method.
     * @param args
     */
    public static void main(String[] args){

        int[][] m1 = {
                {0, 1, 0},
                {0, 0, 3},
                {4, 0, 0}
        };

        int[][] m2 = {
                {0, 5, 0},
                {6, 0, 7},
                {0, 0, 0}
        };

        int[][] m3 = {
                {6, 2, 5},
                {3, 3, 3},
                {9, 6, 1}
        };

        System.out.println();
        System.out.println("Matrix 1: ");
        directedOrUndirected(directedGraph(m1));

        System.out.println();
        System.out.println("Matrix 2: ");
        directedOrUndirected(directedGraph(m2));

        System.out.println();
        System.out.println("Matrix 3: ");
        directedOrUndirected(directedGraph(m3));

    }

}
