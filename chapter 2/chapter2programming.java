import java.sql.SQLOutput;

public class chapter2programming {
    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; ++i){
            int key = arr[i];
            // Insert arr[i] into the sorted sequence arr[1.. i - 1]
            int j = i - 1;
            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void reversedInsertionSort(int[] arr){
        for(int i = 1; i < arr.length; ++i){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] < key){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static boolean[] booleanReturn(boolean[] arr1, boolean[] arr2){

        if(arr1.length != arr2.length){
            try{
                throw new Exception("Arrays aren't the same size.");
            } catch(Exception bs) {
                bs.printStackTrace();
            }
        }

        boolean[] sum = new boolean[arr1.length + 1];
        boolean carry = false;

        for(int i = arr1.length - 1; i >= 0; i--) {
            //if there isn't a carry
            if (!carry) {
                if (arr1[i] && arr2[i]){
                    sum[i+1] = false;
                    carry = true;
                } else if (arr1[i] != arr2[i]){
                    sum[i+1] = true;
                } else if (!arr1[i] && !arr2[i]){
                    sum[i+1] = false;
                }
            }
            //if there is a carry bit
            else {
                if(arr1[i] && arr2[i]) {
                    sum[i+1] = true;
                } else if(arr1[i] != arr2[i]){
                    sum[i+1] = false;
                } else if (!arr1[i] && !arr2[i]) {
                    sum[i + 1] = false;
                    carry = false;
                }
            }
        }
        if (carry) {
            sum[0] = true;
        } else if(!carry) {
            sum[0] = false;
        }
        return sum;
    }

    public static void mergeSort(int[] arr, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = 0; i < n1; ++i){
            L[i] = arr[p + i];
        }
        for(int j = 0; j < n2; ++j){
            R[j] = arr[q + 1 + j];
        }
        int i = 0;
        int j = 0;
        int z = p;

        while(i < n1 && j < n2){
            if (L[i] <= R[j]){
                arr[z] = L[i];
                i++;
            } else {
                arr[z] = R[j];
                j++;
            }
            z++;
        }
        while (i < n1) {
            arr[z] = L[i];
            i++;
            z++;
        }
        while (j < n2) {
            arr[z] = R[j];
            j++;
            z++;
        }
    }

    public static void sort(int[] arr, int l, int r){
        if(l < r){
            int middle = (l + r)/2;
            sort(arr, l, middle);
            sort(arr, middle + 1, r);
            mergeSort(arr, l, middle, r);
        }
    }


    public static int binarySearch(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int middle = l + (r - 1) / 2;

            if (arr[middle] == x) {
                return middle;
            }
            if (arr[middle] > x) {
                return binarySearch(arr, l, middle - 1, x);
            }
            return binarySearch(arr, middle + 1, r, x);
        }
        return -1;
    }

    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length-i-1; j++){
                if(arr[j] > arr[j + 1]){
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }



    public static void main(String[] args) {
        System.out.println("Insertion Sort: ");
        int[] insertionArr = {5, 2, 4, 6, 1, 3};
        for(int i = 0; i < insertionArr.length; i++){
            System.out.print(insertionArr[i] + " ");
        }
        System.out.println();
        insertionSort(insertionArr);
        for(int i = 0; i < insertionArr.length; i++){
            System.out.print(insertionArr[i] + " ");
        }

        System.out.println("\n\nReverse Insertion Sort: ");
        int[] revInsertionArr = {13, 6, 18, 32, 2, 8};
        for(int i = 0; i < revInsertionArr.length; i++){
            System.out.print(revInsertionArr[i] + " ");
        }
        System.out.println();
        reversedInsertionSort(revInsertionArr);
        for(int i = 0; i < revInsertionArr.length; i++){
            System.out.print(revInsertionArr[i] + " ");
        }

        System.out.println("\n\nboolean addition: ");
        boolean[] arr1 = {true, true, false, false};
        boolean[] arr2 = {false, true, false, true};
        for(int i = 0; i < arr1.length; i++){
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < arr2.length; i++){
            System.out.print(arr2[i] + " ");
        }
        booleanReturn(arr1, arr2);
        System.out.println();
        for(int i = 0; i < arr1.length; i++){
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < arr2.length; i++){
            System.out.print(arr2[i] + " ");
        }


        System.out.println("\n\nMerge Sort: ");
        int[] mergeArr = {3, 6, 23, 1, 54, 16};
        for(int i = 0; i < mergeArr.length; i++){
            System.out.print(mergeArr[i] + " ");
        }
        System.out.println();
        sort(mergeArr, 0, mergeArr.length - 1);
        for(int i = 0; i < mergeArr.length; i++){
            System.out.print(mergeArr[i] + " ");
        }

        System.out.println("\n\nBinary Seacrh: ");
        int[] binArr = {1, 6, 23, 21, 16};
        for(int i = 0; i < binArr.length; i++){
            System.out.print(binArr[i] + " ");
        }
        System.out.println();
        int res = binarySearch(binArr, 0, binArr.length - 1, 6);
        if(res == -1){
            System.out.println("Couldn't find number.");
        } else{
           System.out.println("found number: " + binArr[res]);
        }

        System.out.println("\nBubble Sort: ");
        int[] bubSort = {11, 51, 108, 312, 63, 79};
        for(int i = 0; i < bubSort.length; i++){
            System.out.print(bubSort[i] + " ");
        }
        System.out.println();
        bubbleSort(bubSort);
        for(int i = 0; i < bubSort.length; i++){
            System.out.print(bubSort[i] + " ");
        }
    }
}
