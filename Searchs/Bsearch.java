package Searchs;

public class Bsearch {
  static int BinarySearchRec(int[] arr, int target, int low, int high) {
    if (high < low)
      return -1;
    int mid = low + (high - low) / 2;
    if (arr[mid] == target)
      return mid;

    if (target < arr[mid]) {
      return BinarySearchRec(arr, target, low, mid - 1);
    } else
      return BinarySearchRec(arr, target, mid + 1, high);
  }

  static int BinarySearchIT(int[] arr, int target) {
    int low = 0;
    int high = arr.length;
    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] == target) {
        return mid;
      }
      if (target < arr[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 3, 6, 8, 10, 13, 15, 18, 20, 22, 25, 28, 30 };
    int target = 18;
    int index = BinarySearchRec(arr, target, 0, arr.length - 1);
    System.out.println("Index rec:" + index);
    index = BinarySearchIT(arr, target);
    System.out.println("Index it: " + index);

  }
}
