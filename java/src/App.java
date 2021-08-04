import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class App {

    /**
     * Find 2 indexes in the array that the addition gives the target number
     * @param number_array Array of numbers
     * @param target result expected
     * @return Array of indexes of null
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
        return new int[]{};
    }
    public static void main(String[] args) throws Exception {
        int[] number_array = new int[] {2, 4, 8, 16, 32};

        Map<Integer, Object> expected = Map.of(
            12, new int[]{1, 2},
            34, new int[]{0, 4},
            18, new int[]{0, 3},
            42, new int[]{}
        );

        for (Map.Entry<Integer, Object> item : expected.entrySet()) {
            assert App.twoSum(number_array, item.getKey()) == item.getValue();
        }

        System.out.println("Everything its OK");
    }   
}