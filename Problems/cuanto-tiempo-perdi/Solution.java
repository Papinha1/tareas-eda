import java.util.Scanner;

public class Solution {//divdie and conquer
    static int maxSubArray(int[] nums) {
        return Subarray(nums, 0 ,nums.length -1 );
    }
    static int Subarray(int[] A,int left, int right){
        if(left == right){return A[left];}
        int mid = left + (right - left) / 2;
        int leftSum = Subarray(A,left,mid);// 
        int rightSum = Subarray(A,mid+1,right);//
        int crossSum = crossSubarray(A,left,right);// 
        if(leftSum >= rightSum && leftSum >= crossSum){// leftSum max
            return leftSum;
        }
        if(rightSum >= leftSum && rightSum >= crossSum){// rightSum max
            return rightSum;
        }
        return crossSum; //crossSum max
    }
    static int crossSubarray(int[] A,int left,int right){
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int mid = left + (right - left) / 2;
        for(int i = mid; i >= left ; i--){
            sum = sum + A[i];
            if(leftSum < sum){
                leftSum = sum;
            }
        }
        sum = 0;
        for(int j = mid + 1; j <= right; j++){
            sum = sum + A[j];
            if(rightSum < sum){
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0 ; i < n ; i++){
			arr[i] = scan.nextInt();
		}
		scan.close();
		System.out.println(maxSubArray(arr));
	}
}