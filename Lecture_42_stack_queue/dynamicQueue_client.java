package Lecture_42_stack_queue;

public class dynamicQueue_client {
    public static void main(String[] args) throws Exception {
       Dynamic_Queue q = new Dynamic_Queue();

        for (int i = 1; i <= 10; i++) {
            q.Enqueue(i);
        }

        q.Display();

        q.Dequeue();
        q.Dequeue();
        q.Enqueue(11);
        q.Display();
    }
}
