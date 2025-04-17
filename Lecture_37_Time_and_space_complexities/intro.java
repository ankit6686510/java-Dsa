package Lecture_37_Time_and_space_complexities;

public class intro {
    public static void main(String[] args) {
        long start = System.currentTimeMillis(); // corrected here
        for(int i = 0; i < 1000000; i++) {
            // do nothing
        }
        long end = System.currentTimeMillis(); // corrected here
        System.out.println(end - start);
    }
}
