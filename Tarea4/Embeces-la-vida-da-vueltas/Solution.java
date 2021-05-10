import java.uti.*;
public class Solution{
	public static int ans(int[] arr){
		int sol = 0;
		int j;
		for (int i = 0 ; i < arr.length ; i++){
			int min = arr[i];	
			j = i;
			for (int k = i ; k < arr.length ; k++){
				if (arr[k] < min){
					min = arr[k];
					j = k;
				}
			}
			sol += j - i + 1;
			swap(arr,i,j);
		}
		return sol; 
	}
	public static void swap(int[] arr, int i, int j){ // da vuelta los valores entre i y j
		int aux;
		for (int it = 0 ; it + i < j - it ; it++){
			aux = arr[j-it];
			arr[j - it] = arr[it + i];
			arr[it + i] = aux;	
		}
	}



	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0 ; i < n ; i++){
			arr[i] = scan.nextInt();
		}
		System.out.println(ans(arr));
	}
}
