package implementations;

public class InsertionSort {
    public static void sort(int[] array){
        for(int index=1;index<array.length;index++){
            int currentElement = array[index];
            int correctIndex = index - 1;

            // insert currentElement into array[0...index-1]
            while(correctIndex >= 0 && array[correctIndex] > currentElement){
                array[correctIndex + 1] = array[correctIndex];
                correctIndex--;
            }
            array[correctIndex + 1] = currentElement;
        }
    }
}
