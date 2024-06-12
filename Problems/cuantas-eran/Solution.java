import java.util.*;
public class Solution{
        static Map<String, Integer> map = new HashMap<>();
        public static String addToMap(String aux){
                if (map.containsKey(aux)){
                        map.put( aux , map.get(aux) + 1);
                        return null;
                }
                else {
                        map.put(aux , 1);
                        return aux;
                }
        }
        public static int ValorDe(String aux){
                return map.get(aux);
        }
        public static void main(String[] args){
                Scanner scan = new Scanner(System.in);
                int N = scan.nextInt();
                int K = scan.nextInt();
                ArrayList<String> arr = new ArrayList<>();
                for (int i = 0; i < N ; i++){
                        String aux = scan.next();
                        if (addToMap(aux) != null){
                                arr.add(aux);
                        }
                }
                PriorityQueue<String> heap = new PriorityQueue<>((String a, String b) ->{
                        if (ValorDe(a) == ValorDe(b)) return a.compareTo(b); return ValorDe(b) - ValorDe(a); });
                for (int i = 0 ; i < N && i < arr.size(); i++)
                        heap.add(arr.get(i));
                for (int i = 0 ; i < K ; i++)
                        System.out.print(heap.poll() + " ");
        }
}
