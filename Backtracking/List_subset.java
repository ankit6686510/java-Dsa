import java.util.*;

public class List_subset {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3 };
        List<List<Integer>> big = new ArrayList<>();
        // List<Integer> temp = new ArrayList<>();

        // subset(arr, 0, temp, big);
        subset(arr, 0, new ArrayList<Integer>(), big);
        System.out.println(big);
    }

    public static void subset(int[] arr, int vidx, List<Integer> temp, List<List<Integer>> big) {
        if (vidx == arr.length) {
            big.add(new ArrayList<>(temp));
            return;
        }
        // include
        temp.add(arr[vidx]);
        subset(arr, vidx + 1, temp, big);

        // exclude
        temp.remove(temp.size() - 1);
        subset(arr, vidx + 1, temp, big);
    }
}
