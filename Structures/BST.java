import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class BST {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  static class BinarySearchTree {
    Node head;

    BinarySearchTree(Node head) {
      this.head = head;
    }

    void insert(int data) {
      Node newNode = new Node(data);
      if (head == null) {
        head = newNode;
      }
      /*
       * Creamos un iterador y un prev (it = head , prev = null)
       * Dentro de mi while asigno a prev el valor de it y luego
       * avanzo a izq o derecha dependiendo de si es mayor o menor.
       * Cuando it = null, creo un nuevo nodo en base a prev
       * 
       */
      Node it = head;
      Node prev = null;
      while (it != null) {
        prev = it;
        if (data <= it.data)
          it = it.left;
        else
          it = it.right;

      }
      if (data < prev.data)
        prev.left = newNode;
      else
        prev.right = newNode;

    }

    void insertRec(int data) {
      this.head = insertRec(head, new Node(data));
    }

    Node insertRec(Node it, Node newNode) {
      if (it == null) {
        return newNode;
      }

      if (newNode.data < it.data) {
        it.left = insertRec(it.left, newNode);
      } else if (newNode.data >= it.data) {
        it.right = insertRec(it.right, newNode);
      }
      return it;
    }

    LinkedList<LinkedList<Integer>> printByLevel() {
      Queue<Node> cola = new LinkedList<>();
      LinkedList<LinkedList<Integer>> arbol = new LinkedList<>();

      cola.add(head);
      while (!cola.isEmpty()) {
        int size = cola.size();
        LinkedList<Integer> level = new LinkedList<>();
        while (size != 0) {
          Node aux = cola.poll();
          level.add(aux.data);
          if (aux.left != null)
            cola.add(aux.left);
          if (aux.right != null)
            cola.add(aux.right);
          size--;
        }
        arbol.add(level);
      }
      return arbol;
    }

    int getHeight() {
      return getHeight(0, this.head);
    }

    int getHeight(int level, Node iterator) {
      if (iterator == null)
        return level;

      int leftSize = getHeight(level + 1, iterator.left);
      int rightSize = getHeight(level + 1, iterator.right);
      if (leftSize > rightSize)
        return leftSize;
      return rightSize;
    }

  }

  public static void main(String[] args) {
    BinarySearchTree arbol = new BinarySearchTree(new Node(20));
    arbol.insert(10);
    arbol.insert(15);
    arbol.insert(30);
    arbol.insert(25);
    arbol.insert(40);
    arbol.insert(3);
    arbol.insert(5);
    arbol.insert(8);
    arbol.insert(13);
    arbol.insert(1);
    arbol.insert(2);
    arbol.insert(0);
    arbol.insert(4);
    arbol.insert(12);
    arbol.insert(14);

    System.out.println(arbol.printByLevel());
    System.out.println(arbol.getHeight());

  }
}
