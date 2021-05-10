import java.util.*;
public class kdiff{
    static void recursive(int n, int k, int ans){
       if (n == 0){
           System.out.print(ans + " ");
            return;
       }
        int temp = ans%10;
        ans*=10;
        ans+= temp;
        if (temp - k >= 0){
            recursive(n-1, k, ans-k);
        }
        if (temp + k <= 9 && k != 0){
            recursive(n-1, k, ans+k);
        }

    }
    public static void main(String[] args){
       Scanner scan = new Scanner(System.in);
       int n = scan.nextInt();
       int k = scan.nextInt();
       for (int i = 1 ; i < 10 ; i ++){
            if (10 - i > k || i >= k ){
                recursive(n-1, k, i);
            }
       }
       scan.close();
    }
}