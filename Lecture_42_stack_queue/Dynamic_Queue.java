package Lecture_42_stack_queue;

public class Dynamic_Queue extends queue{
     @Override
    public void Enqueue(int item) throws Exception {
        if (isFull()) {
            int[] newarray = new int[2 * arr.length];

            for (int i = 0; i < size; i++) {
                int idx = (front + i) % arr.length;
                newarray[i] = arr[idx];
            }

            arr = newarray;
            front = 0;
        }

        super.Enqueue(item); // safe to call after resizing
    }
    
}
