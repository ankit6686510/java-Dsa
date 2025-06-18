package Lecture_42_stack_queue;

public class queue {
    protected int[] arr;
    protected int front = 0;
    protected int size = 0; //private se  made protected ya getter method bnaa do iska

    //getter method of size

//     public int getSize() {
//     return size;
// }


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
        if(isFull()){
            throw new Exception("Queue is Full");
        }
        int idx = (front + size) % arr.length;
        arr[idx]  =  item;
        size++;
    }

    public int Dequeue() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        int rv = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return rv;
    }

    public void Display(){
        for(int i = 0; i < size; i++){
            int idx = (front + i) % arr.length;
            System.out.print(arr[idx] + " ");
        }
        System.out.println();
    }
}
