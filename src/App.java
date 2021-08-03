import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {


    /**
     * Format print indexes result
     * @param array pair of indexes found
     */
    public static void printArray(int[] array){
        System.out.print("[");
        for(int item : array){
            System.out.print(item);
            if(array[array.length-1] != item)
            System.out.print(", ");
        }
        System.out.print("] => ");
    }

    /**
     * Format print indexes result
     * @param array pair of indexes found
     * @param target result
     */
    public static void printArray(int[] array, int target){
        App.printArray(array);
        System.out.println(target);
    }

    /**
     * Find 2 indexes in the array that the addition gives the target number
     * @param number_array Array of numbers
     * @param target result
     */
    public static int[]  twoSum(int[] number_array, int target ){

        for(int i =0; i < number_array.length; i++)
        {
            int complement = target - number_array[i];
            List<Integer> listNumbers = Arrays.stream(number_array)
                .boxed()
                .collect(Collectors.toList());
            if(complement > 0 && listNumbers.contains(complement))
            {
                return new int[] {i, listNumbers.indexOf(complement)};
            }
            
        }
        return null;
    }
    public static void main(String[] args) throws Exception {
        int[] number_array = new int[] {2, 4, 8, 16, 32};
        int[] res = App.twoSum(number_array, 12);
        assert res[0] + res[1] == 12;
        
        res = App.twoSum(number_array, 34);   
        assert res[0] + res[1] == 34;

        res = App.twoSum(number_array, 18);   
        assert res[0] + res[1] == 18;
        
        assert App.twoSum(number_array, 42) == null;

        System.out.println("Everything its OK");
    }   
}