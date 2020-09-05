package implementations;

import java.util.Arrays;

public class MergeSort {
    public static void sort(int[] array){
        MergeSort.mergeSortHelper(array,0,array.length-1);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        if(left < right){
          int middle = left + (right - left) / 2;
          MergeSort.mergeSortHelper(array, left, middle);
          MergeSort.mergeSortHelper(array, middle + 1, right);
          MergeSort.merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int leftArrayLength = middle - left + 1;
        int rightArrayLength = right - middle;
        int[] leftArray = new int[leftArrayLength + 1];
        int[] rightArray = new int[rightArrayLength + 1];

        if (leftArrayLength >= 0) System.arraycopy(array, left, leftArray, 0, leftArrayLength);

        for(int index=0;index<rightArrayLength;index++){
            rightArray[index] = array[middle + index + 1];
        }
        leftArray[leftArrayLength] = Integer.MAX_VALUE;
        rightArray[rightArrayLength] = Integer.MAX_VALUE;
        int leftIndex = 0, rightIndex = 0;

        for(int index=left;index<=right;index++){
            if(leftArray[leftIndex] < rightArray[rightIndex]){
                array[index] = leftArray[leftIndex];
                leftIndex++;
            }
            else{
                array[index] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}
