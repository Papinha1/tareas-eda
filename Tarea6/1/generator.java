import java.util.*;
public class generator{
   public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        Random rand = new Random();
        System.out.println(n + " " + max);
        for (int i = 0 ; i < n ; i++){
            System.out.print(rand.nextInt(max) + " ");
        }

   }
}