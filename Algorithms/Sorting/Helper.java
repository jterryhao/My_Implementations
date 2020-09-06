import java.util.Arrays;
import java.util.Random;

public class Helper {
    static int[] randomArray(){
        Random random = new Random();
        int length = random.nextInt(100);
        int[] array = new int[length];

        for(int index=0;index<length;index++){
            array[index] = random.nextInt(100);
        }
        return array;
    }

    static void isSorted(int[] array, String methodName){
        boolean sorted = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]){
             sorted = false;
             break;
            }
        }

        if(sorted){
            System.out.printf("Array is sorted by %s.%n", methodName);
        }
        else{
            System.out.println(Arrays.toString(array));
        }
    }
}
