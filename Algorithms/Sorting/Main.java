import implementations.*;

import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        int[] array = Helper.randomArray();
        System.out.println(Arrays.toString(array));
        InsertionSort.sort(array);
        System.out.println(Arrays.toString(array));

        array = Helper.randomArray();
        System.out.println(Arrays.toString(array));
        MergeSort.sort(array);
        System.out.println(Arrays.toString(array));

        array = Helper.randomArray();
        System.out.println(Arrays.toString(array));
        BubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}