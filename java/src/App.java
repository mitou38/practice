import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
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
        return null;
    }
    public static void main(String[] args) throws Exception {
        int[] number_array = new int[] {2, 4, 8, 16, 32};
        HashMap<Integer, Object> expected = new HashMap<Integer, Object>();
        expected.put(12, new int[]{1, 2});
        expected.put(34, new int[]{0, 4});
        expected.put(18, new int[]{0, 3});
        expected.put(42, null);

        for (HashMap.Entry<Integer, Object> item : expected.entrySet()) {
            assert App.twoSum(number_array, item.getKey()) == item.getValue();
        }

        System.out.println("Everything its OK");
    }   
}