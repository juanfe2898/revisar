/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchmethods;

import java.util.List;

/**
 *
 * @author Tania V
 */

public class DepthFirstSearch {
    
    /**
     *
     * 
     * @param maze
     * @param x //posicion de inicio de busqueda
     * @param y // posicion de inicio de busqueda
     * @param path
     * @return true -> si se encuentra el camino que resuelve el laberinto
     *  (Se indicara el camino que lo resuelve)
     */
public static boolean llenaUnos(int[][] maze, int x, int y, List<Integer> path, int filas, int columnas) {
   int [][] mazedfs = new int [filas+2] [columnas+2];
        
        for (int i = 0; i < filas+2; i++) { //fila 0
            for (int j = 0; j < columnas+2; j++) {
                    mazedfs[i][j]=1;
            }
        }
        
        for (int i = 1; i < filas+1; i++) { //fila 0
            for (int j = 1; j < columnas+1; j++) {
                    mazedfs[i][j]=maze[i-1][j-1];

            }
 
        }
        for (int i = 0; i < filas+2; i++) { //fila 0
            for (int j = 0; j < columnas+2; j++) {
                    System.out.print(mazedfs[i][j]+ " ");
            }
            System.out.println();
        }
        filas=filas+1;
        columnas=columnas+1;
        return searchPath(mazedfs, x, y, path);
    }

    

    public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path){
  
                     /**
          * si (x,y) es un nodo no visitado -> [0]
          * se marca como visitado [2]
          * pero se invierte el orden porque se toman:
          *  - columnas como filas
          *  - las filas como columnas
          */
       
         
         if(maze[y][x] == 9){ // confirmar si el nodo objetivo se alcanza
             path.add(x);
             path.add(y);
             return true;
         }
         
         
         if(maze[y][x] == 0){
             maze[y][x] = 2;
         
            int dx = -1;
            int dy = 0;
               /**
                * se visitan todos los vecinos de un punto de forma recursiva
               */
            if(searchPath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 1;
            dy = 0;
            if(searchPath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = -1;
            if(searchPath(maze, x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = 1;
            if(searchPath(maze, x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
       }
        return false;
    }
}

/*
package searchmethods;

import java.util.*;

// Data structure to store graph edges
class Edge
{
	int source, dest;

	public Edge(int source, int dest) {
		this.source = source;
		this.dest = dest;
	}
};

// Class to represent a graph object
class Graph
{
	// An array of Lists to represent adjacency list
	List<List<Integer>> adjList = null;

	// Constructor
	Graph(List<Edge> edges, int N) {
		adjList = new ArrayList<>(N);

		for (int i = 0; i < N; i++) {
			adjList.add(i, new ArrayList<>());
		}

		// add edges to the undirected graph
		for (int i = 0; i < edges.size(); i++)
		{
			int src = edges.get(i).source;
			int dest = edges.get(i).dest;

			adjList.get(src).add(dest);
			adjList.get(dest).add(src);
		}
	}
}

class DFS
{
	// Perform iterative DFS on graph g starting from vertex v
	public static void iterativeDFS(Graph graph, int v, boolean[] discovered)
	{
		// create a stack used to do iterative DFS
		Stack<Integer> stack = new Stack<>();

		// push the source node into stack
		stack.push(v);

		// run till stack is not empty
		while (!stack.empty())
		{
			// Pop a vertex from stack
			v = stack.pop();

			// if the vertex is already discovered yet, ignore it
			if (discovered[v])
				continue;

			// we will reach here if the popped vertex v
			// is not discovered yet. We print it and process
			// its undiscovered adjacent nodes into stack
			discovered[v] = true;
			System.out.print(v + " ");

			// do for every edge (v -> u)
			List<Integer> adj = graph.adjList.get(v);
			for (int i = adj.size() - 1; i >= 0; i--)
			{
				int u = adj.get(i);
				if (!discovered[u]) {
					stack.push(u);
				}
			}
		}
	}

	// Iterative Java implementation of Depth first search
	public static void main(String[] args)
	{
		// List of graph edges as per above diagram
		List<Edge> edges = Arrays.asList(
				// Notice that node 0 is unconnected node
				new Edge(1, 2), new Edge(1, 7), new Edge(1, 8),
				new Edge(2, 3), new Edge(2, 6), new Edge(3, 4),
				new Edge(3, 5), new Edge(8, 9), new Edge(8, 12),
				new Edge(9, 10), new Edge(9, 11)
				// , new Edge(6, 9) // introduce cycle
		);

		// Set number of vertices in the graph (0-12)
		final int N = 13;

		// create a graph from edges
		Graph graph = new Graph(edges, N);

		// stores vertex is discovered or not
		boolean[] discovered = new boolean[N];

		// Do iterative DFS traversal from all undiscovered nodes to
		// cover all unconnected components of graph
		for (int i = 0; i < N; i++) {
			if (!discovered[i]) {
				iterativeDFS(graph, i, discovered);
			}
		}
	}
}
 
*/