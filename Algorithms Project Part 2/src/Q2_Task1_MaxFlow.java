
import java.util.ArrayList;
import java.util.Scanner;

//* Java Implementation of Edmonds-Karp Algorithm *
/**
 * @author Amal
 * @author Rawan
 * @author Mehave
 */
public class Q2_Task1_MaxFlow {

    /**
     * @param args the command line arguments
     */
    static int Nodes, Edges, Source, Sink;
    static weightGraph[] graph;

    public static void EdmondsKarp() {
        
        
        System.out.println("\n\t Maximum Flow");
        System.out.println("---------------------------");
        System.out.println("> Augiminting paths:\n");
      
        boolean visited[] = new boolean[Nodes];
        
        // There is no flow initially
        int maxFlow = 0;
        
        
        while (true) {
	       
            // Parent array used for storing path
            // (parent[i] stores edge used to get to node i)
            Edge[] parent = new Edge[Nodes];

            // Create a visited array and mark all vertices as not visited 
            for (int i = 0; i < visited.length; ++i) {
                visited[i] = false;
            }

            // Create a queue, enqueue source vertex and mark source vertex as visited 
            ArrayList<weightGraph> queue = new ArrayList<>();
            queue.add(graph[Source]);
            visited[Source] = true;

            // Breadth first search(BFS)finding shortest augmenting path
            while (!queue.isEmpty()) {
                weightGraph curr = queue.remove(0);

		     // Checks that edge has not yet been visited, and it doesn't
                // point to the source, and it is possible to send flow through it. 
                for (Edge e : curr.edges) {
                    if (parent[e.v] == null && e.v != Source && e.capacity > e.flow && visited[e.v] == false) {
                        parent[e.v] = e;
                        queue.add(graph[e.v]);
                        visited[e.v] = true;
                    }
                }
            }

	       // If sink was NOT reached, no augmenting path was found.
            // Algorithm terminates and prints out max flow.
            if (parent[Sink] == null) {
                break;
            }

            // If sink WAS reached, we will push more flow through the path
            int pushFlow = Integer.MAX_VALUE;
            
            // Store Agumentation Flow
            String path = "";
	       
            // Finds maximum flow that can be pushed through given path
            // by finding the minimum residual flow of every edge in the path
            for (Edge e = parent[Sink]; e != null; e = parent[e.u]) {
                String direction = "←";
                pushFlow = Math.min(pushFlow, e.capacity - e.flow);
                if (e.capacity != 0) {
                    direction = "→";
                }
                path = direction + (e.v + 1) + path;
            }
            
            // Print the augmentation path
            path = (0 + 1) + path;
            System.out.printf("%-17s %s%d \n", path, ", flow: ", pushFlow);

            // Adds to flow values and subtracts from reverse flow values in path
            for (Edge e = parent[Sink]; e != null; e = parent[e.u]) {
                e.flow += pushFlow;
                e.reverse.flow -= pushFlow;
            }
            // Add path flow to overall flow 
            maxFlow += pushFlow;
            // Print the Updated Maximum Flow
            System.out.println("Updated flow: " + maxFlow + "\n");
        }
        // print the Maximum Flow
        System.out.println("> The maximum flow:  " + maxFlow);
        
        // print min-cut edges
        System.out.println("\t Minimum cut");
        System.out.println("---------------------------\n\n> Edges included in the min-cut");

        // Print all edges that are from a reachable vertex to 
        // non-reachable vertex in the original graph
        int total_Cut = 0;
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                for (Edge e : graph[i].edges) {
                    if (visited[i] && !visited[j] && e.getEdge(i, j) != 0) {
                        System.out.println("\nEdge: " + (i + 1) + " → " + (j + 1) + " , capacity = " + e.getEdge(i, j));
                        total_Cut += e.getEdge(i, j);
                    }
                }
            }
        }
        //print total_cut 
        System.out.println("\n> The total min-cut capacity is " + total_Cut + "\n");

    }

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("    ********** CPCS324 Project - Question 2 - Task 1 **********");
    
    System.out.println("\n\tWeighted Graph ");
    System.out.println("---------------------------");
    System.out.print("> Enter total number of Vertices: ");       
        Nodes = scan.nextInt();
    System.out.print("> Enter total number of Edges: ");        
        Edges = scan.nextInt();

//Initialize starting vertex and ending vertex
        Source = 0;
        Sink = Nodes - 1;

//Initialize the Weighted Graph
    graph = new weightGraph[Nodes];

// Initialize each node
        for (int i = 0; i < Nodes; i++) {
            graph[i] = new weightGraph();
        }
System.out.println("> Enter the each edge in this order:");
System.out.println("\t u, v, weight");
        // Initialize each edge
        for (int i = 0; i < Edges; i++) {
        System.out.print("Edge "+ (i+1) + ": " );
            int u = scan.nextInt() - 1;
            int v = scan.nextInt() - 1;
            int c = scan.nextInt();

	       // Note edge "b" is not actually in the input graph
            // It is a construct that allows us to solve the problem
            Edge a = new Edge(u, v, 0, c);
            Edge b = new Edge(v, u, 0, 0);

	       // Set pointer from each edge "a" to
            // its reverse edge "b" and vice versa
            a.setReverse(b);
            b.setReverse(a);

            graph[u].edges.add(a);
            graph[v].edges.add(b);
        }
      
        EdmondsKarp();
    }

// No explicit constructor is necessary :P
    static class weightGraph {

// List of edges also includes reverse edges that
// are not in original given graph (for push-back flow)
        ArrayList<Edge> edges = new ArrayList<>();
    }

    static class Edge {

        int u, v, flow, capacity;
        Edge reverse;

        public Edge(int u, int v, int flow, int capacity) {
            this.u = u;
            this.v = v;
            this.flow = flow;
            this.capacity = capacity;
        }

        public int getEdge(int u, int v) {

            if (u == this.u && v == this.v) {
                return this.capacity;
            }

            return 0;
        }

        public void setReverse(Edge e) {
            reverse = e;
        }

    }
}
