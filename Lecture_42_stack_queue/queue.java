package Lecture_42_stack_queue;

public class queue {
    protected int[] arr;
    protected int front = 0;
    private int size = 0;

    public queue(){
        arr = new int[5];
    }
    public queue(int n){
        arr =  new int[n];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == arr.length;
    }

    public void Enqueue(int item) throws Exception{
        //enqueue add karta hai element
        if(isFull()){
            throw new Exception("baklol queue empty hai");

        }
        int idx =  (front + size) % arr.length;
        // % karne se queueu hamra circular bn gya hai
        arr[idx]  =  item;
        size++;
    }
    
    public int Dequeue() throws Exception{
        if(isEmpty()){
            throw new Exception("baklol queue empty hai kya");
        }
        int rv =  arr[front];
        return rv;
    }
    public void Display(){
        for(int i  = 0 ; i < size ;i++){
            int idx =  (front +i ) % arr.length;
            System.out.print(arr[idx] +" ");
        }
        System.out.println();
    }

    
    
}
