package implementations;

import javafx.util.Pair;

import java.util.Stack;

public class  QuickSort {

    public static void sort(int[] array){
        Stack<Pair<Integer, Integer>> indicesStack = new Stack<>();
        indicesStack.add(new Pair<>(0, array.length - 1));

        while(!indicesStack.empty()){
            Pair<Integer, Integer> indices = indicesStack.pop();
            int leftIndex = indices.getKey();
            int rightIndex = indices.getValue();

            while(rightIndex - leftIndex + 1 > 10){
                int pivot = rightIndex;
                int pivotIndex = QuickSort.partition(array, leftIndex, rightIndex, pivot);

                if(pivotIndex - leftIndex > rightIndex - pivotIndex){
                    indicesStack.push(new Pair<>(leftIndex, pivotIndex - 1));
                    leftIndex = pivotIndex + 1;
                }
                else{
                    indicesStack.push(new Pair<>(pivotIndex + 1, rightIndex));
                    rightIndex = pivotIndex - 1;
                }
            }
        }
        InsertionSort.sort(array);
    }

    private static int partition(int[] array, int leftIndex, int rightIndex, int pivot) {
        int pivotElement = array[pivot];
        int pivotIndex = leftIndex - 1;

        for(int index=leftIndex;index<rightIndex;index++){
            if(array[index] <= pivotElement){
                pivotIndex++;
                int temp = array[pivotIndex];
                array[pivotIndex] = array[index];
                array[index] = temp;
            }
        }
        int temp = array[pivotIndex + 1];
        array[pivotIndex + 1] = array[pivot];
        array[pivot] = temp;
        return pivotIndex + 1;
    }
}
