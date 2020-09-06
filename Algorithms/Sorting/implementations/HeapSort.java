package implementations;

import java.util.PriorityQueue;

public class HeapSort {
    public static void sort(int[] array){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int j : array) {
            priorityQueue.add(j);
        }
        for(int i=0;i<array.length;i++){
            array[i] = priorityQueue.remove();
        }
    }
}
