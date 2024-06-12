import java.util.*;
import java.util.LinkedList;

public class Graph {
  static class Conn {
    int value;
    int weight;

    Conn(int value, int weight) {
      this.value = value;
      this.weight = weight;
    }
  }

  static LinkedList<Integer> BFS(Boolean[][] graph, int firstNode) {
    Boolean[] visited = new Boolean[graph.length];
    for (int i = 0; i < visited.length; i++) {
      visited[i] = false; // inicializo en false
    }
    Queue<Integer> cola = new LinkedList<>();
    // esta lista va guardando las iteraciones que se hacen en el grafo
    // en un orden de barrido o BFS
    LinkedList<Integer> lista = new LinkedList<>();

    lista.add(firstNode);
    cola.add(firstNode);
    visited[firstNode] = true;

    while (!cola.isEmpty()) {
      int current = cola.poll();

      for (int i = 0; i < graph.length; i++) {
        if (graph[current][i] == true && !visited[i]) {
          visited[i] = true;
          cola.add(i);
          lista.add(i);
        }
      }
    }
    return lista;
  }

  static LinkedList<Integer> DFS(Boolean[][] graph, int firstNode) {
    Boolean[] visited = new Boolean[graph.length];
    for (int i = 0; i < visited.length; i++) {
      visited[i] = false; // inicializo en false
    }
    Stack<Integer> stack = new Stack<>();
    // esta lista va guardando las iteraciones que se hacen en el grafo
    // en un orden de barrido o BFS
    LinkedList<Integer> lista = new LinkedList<>();

    lista.add(firstNode);
    stack.add(firstNode);
    visited[firstNode] = true;

    while (!stack.isEmpty()) {
      int current = stack.pop();

      for (int i = 0; i < graph.length; i++) {
        if (graph[current][i] == true && !visited[i]) {
          visited[i] = true;
          stack.add(i);
          lista.add(i);
        }
      }
    }
    return lista;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    Boolean[][] grafo = new Boolean[n][n];

    int v = scan.nextInt(); // cantidad de vértices de mi grafo
    for (int i = 0; i < grafo.length; i++) {
      for (int j = 0; j < grafo.length; j++) {
        grafo[i][j] = false;
      }
    }
    for (int i = 0; i < v; i++) {
      int origen = scan.nextInt();
      int destino = scan.nextInt();
      grafo[origen][destino] = true;
      // conexión doble, la agrego para ambos sentidos
      grafo[destino][origen] = true;
    }
    for (int i = 0; i < grafo.length; i++) {
      for (int j = 0; j < grafo.length; j++) {
        int val = grafo[i][j] ? 1 : 0; // si es true = 1, si es false = 0
        System.out.print(val + " ");
      }
      System.out.println();
    }
    System.out.println(BFS(grafo, 0));
    System.out.println(DFS(grafo, 0));
  }
}
// Representación de lista de adyacencia
// LinkedList<LinkedList<Conn>> lista = new LinkedList<>();
// for (int i = 0; i < n; i++) {
// lista.add(new LinkedList<>());
// }
// for (int i = 0; i < v; i++) {
// int origen = scan.nextInt();
// int destino = scan.nextInt();
// int peso = scan.nextInt();
// lista.get(origen).add(new Conn(destino, peso));
// }
// for (int i = 0; i < lista.size(); i++) {
// LinkedList<Conn> subList = lista.get(i);
// System.out.println("Conexiones para el nodo: " + i);
// for (int j = 0; j < subList.size(); j++) {
// Conn temp = subList.get(j);
// System.out.printf("value: %d, peso: %d - ", temp.value, temp.weight);
// }
// System.out.println();
// }