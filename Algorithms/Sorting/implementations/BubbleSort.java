package implementations;

public class BubbleSort {
    public static void sort(int[] array){
        for(int leftIndex=0;leftIndex<array.length - 1;leftIndex++){
            for(int rightIndex= array.length - 1;rightIndex > leftIndex;rightIndex--){
                if(array[rightIndex] < array[rightIndex - 1]){
                    int temp = array[rightIndex];
                    array[rightIndex] = array[rightIndex - 1];
                    array[rightIndex - 1] = temp;
                }
            }
        }
    }
}
