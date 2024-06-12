package Structures;

import java.util.PriorityQueue;

public class Kth {

 // crear función que obtenga el K-ésimo número mas grande de un arreglo
 public static Node sol(int[] arr, int k) {
  int kth = k;
  PriorityQueue<Node> heap = new PriorityQueue<>((a, b) -> {
   return b.value - a.value;
  });
  PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

  Node val;
  // realizar sol
  for (int it : arr) {
   heap.add(new Node(it));
  }

  while (k-- > 1)
   heap.poll();

  val = heap.peek();
  System.out.printf("%d-ésimo mas pequeño es: %d\n", kth, val.value);

  return val;
 }

 public static void main(String[] args) {
  int[] input = { 1, 2, 99, 123, 692, 1024, 99, 3, 4, 9, 10, 11, 15, 49 };
  sol(input, 2);
 }
}
