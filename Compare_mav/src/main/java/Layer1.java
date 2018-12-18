import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Chris Cavazos on 12/17/2018.
 */
public class Layer1 {
    public int[] binaryAnalysis(ArrayList<Integer> list){
        int[] arr = new int[255];
        Arrays.fill(arr,0);
        for(int i : list){
            arr[i]++;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
