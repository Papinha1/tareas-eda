import java.util.*;
public class Solution{


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Map<String , Integer> map = new HashMap<>();
        for (int i = 0 ; i < n ; i++){
           String in = scan.next(); 
           if (map.containsKey(in)){
               map.replace(in, map.get(in) + 1);
           }
           else{
               map.put(in, 0);
           }
        }
        for (Map.Entry<String,Integer> it : map.entrySet()){
                System.out.println(it.getKey());
        }
        for (Map.Entry<String,Integer> it : map.entrySet()){
            if (it.getValue() != 0){
                System.out.println(it.getKey()+ "=" + it.getValue());
            }
        }
        
        scan.close();
    }

}