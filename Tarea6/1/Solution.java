import java.util.*;
public class Solution{
    static class Node{
        private int data;
        private Node left;
        private Node right;
        Node(){
            this.left = null;
            this.right = null;
        }
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
        public void setLeft(Node left){this.left = left;}
        public void setRight(Node right){this.right= right;}
        public void setData(int data){this.data = data;}

        public Node getLeft(){return left;}
        public Node getRight(){return right;}
        public int getData(){return data;}
    }
    static class Tree{
        private Node head;
        Tree(){this.head = null;}
        Tree(Node head){this.head = head;}

        public void setHead(Node head){this.head = head;}
        public Node getHead(){return head;}
        public void insert(int ndata){
            head = insert(new Node(ndata),head);
        }
        private Node insert(Node nnode, Node curr){
            if (curr == null)return nnode;
            if (nnode.getData() < curr.getData()){
                curr.setLeft( insert(nnode, curr.getLeft() ) );
            }
            else curr.setRight( insert(nnode, curr.getRight() ) );
            return curr;
        }
    }
    static void sol(Tree tree){
        Queue<Node> cola = new LinkedList<>();
        cola.add(tree.getHead());
        while(!cola.isEmpty()){
            int min = Integer.MAX_VALUE;
            int lvl = cola.size();
            for (int i = 0 ; i < lvl ; i++){
                Node curr = cola.poll();
                if (curr == null)break;
                if (curr.getData() < min){
                    min = curr.getData();
                }
                if (curr.getLeft() != null)cola.add(curr.getLeft());
                if (curr.getRight() != null)cola.add(curr.getRight());
            }
            System.out.print(min + " ");
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Tree arbol = new Tree();
        for (int i = 0 ; i < n ; i++){
            int aux = scan.nextInt();
            arbol.insert(aux);
        }
        Queue<Node> test = new LinkedList<>();
        test.add(arbol.getHead());
        
        sol(arbol);
        scan.close();
    }
}