package Lecture_57_Heap;

import java.util.PriorityQueue;

public class Minimum_Sum_Pair {
    // https://code-gym.codingblocks.com/problems/2698
    public static void main(String[] args) {
        int[] arr = { 2, 2, 3, 3, 4 };
        int sum  = 0 ;
        PriorityQueue<Integer> pq =  new PriorityQueue<>();
        for(int i  = 0 ;  i < arr.length ;  i++){
            pq.add(arr[i]);
        }
        while(pq.size() > 1){
            int a =  pq.poll();
            int b =  pq.poll();
            sum += a + b;
            pq.add(a+b);
        }
        System.out.println(sum);
    }

   
}


//brute force
//  public static void main(String[] args) {
//         int[] arr = { 2, 2, 3, 3, 4 };
//         int sum = 0;

//         for (int i = 0; i < arr.length; i++) {
//             for (int j = i + 1; j < arr.length; j++) {
//                 sum = sum + Math.min(arr[i], arr[j]);
//             }
//         }
//         System.out.println(sum);
//     }