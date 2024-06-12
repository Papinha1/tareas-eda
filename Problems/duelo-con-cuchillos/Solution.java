import java.util.*;
public class Solution{
        public static int ans(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
        for (int a : A)
            pq.offer(a);
        while (pq.size() > 1)
            pq.offer(pq.poll() - pq.poll());
        return pq.poll();
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n ;i++){
            arr[i] = scan.nextInt();
        }
        System.out.println(ans(arr));
        scan.close();
        
    }
}