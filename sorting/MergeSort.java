import java.util.Arrays;
import java.util.Scanner;

// Scanning part is optional

public class MergeSort {

    // merge function
    public static void merge(int[] a, int left, int mid, int right) {

        // size of left and right subarrays
        int len1 = mid - left + 1;
        int len2 = right - mid;

        int[] leftArray = new int[len1];
        int[] rightArray = new int[len2];

        for (int i = 0; i < len1; i++) {
            leftArray[i] = a[left + i];
        }
        for (int i = 0; i < len2; i++) {
            rightArray[i] = a[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;

        // merge temp arrays
        while (i < len1 && j < len2) {
            if (leftArray[i] <= rightArray[j]) {
                a[k] = leftArray[i];
                i++;
            } else {
                a[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // copy remaining elements
        while (i < len1) {
            a[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < len2) {
            a[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // merge sort function
    public static void mergesort(int arr[], int left, int right) {

        // check for empty or null array
        if (left < right) {

            // find the middle point
            int mid = left + ((right - left) / 2);

            // sort first and second halves
            mergesort(arr, left, mid);
            mergesort(arr, mid + 1, right);

            // merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {

        // declaring the scanner object
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter space separated numbers: ");

        // Taking input from client
        String[] input = sc.nextLine().split(" ");

        int[] numbers = new int[input.length];
        
        // converting string array to integer array
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        // sorting the array
        mergesort(numbers, 0, numbers.length - 1);

        // printing the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(numbers));

        // closing the scanner
        sc.close();
    }
}