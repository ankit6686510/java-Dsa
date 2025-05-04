package Lecture_42_stack_queue;


public class Reverse_queue {
    public static void main(String[] args) throws Exception{
        queue q = new queue();
		q.Enqueue(10);
		q.Enqueue(20);
		q.Enqueue(30);
		q.Enqueue(40);
		q.Enqueue(50);
		q.Display();
		Reverse(q);
		q.Display();
        
    }
    public static void Reverse(queue q ) throws Exception{
        if(q.isEmpty()){
            return;
        }
        int ii =  q.Dequeue();
        Reverse(q);
        q.Enqueue(ii);
    }
}
