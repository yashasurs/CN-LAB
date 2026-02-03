import java.util.*;

public class BellmanFord {

    static final int INF = 999999;
    static int N;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of Vertices: ");
        N = sc.nextInt();

        graph = new int[N][N];
        System.out.println("Enter the Weight Matrix of Graph (use " + INF + " for no edge):");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter the Source Vertex: ");
        int source = sc.nextInt();

        bellmanFord(source - 1);
    }

    static void bellmanFord(int src) {
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        // Step 1: Relax edges V-1 times
        for (int i = 0; i < N - 1; i++) {
            for (int u = 0; u < N; u++) {
                for (int v = 0; v < N; v++) {
                    if (graph[u][v] != INF &&
                        dist[u] != INF &&
                        dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        // Step 2: Check for negative weight cycle
        for (int u = 0; u < N; u++) {
            for (int v = 0; v < N; v++) {
                if (graph[u][v] != INF &&
                    dist[u] != INF &&
                    dist[u] + graph[u][v] < dist[v]) {
                    System.out.println("Negative weight cycle detected.");
                    return;
                }
            }
        }

        // Step 3: Print result
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < N; i++) {
            if (dist[i] == INF)
                System.out.println((i + 1) + "\tINF");
            else
                System.out.println((i + 1) + "\t" + dist[i]);
        }
    }
}
