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
}
