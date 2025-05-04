package Lecture_42_stack_queue;

public class stack {
    protected int[] arr;
    protected int top = -1;

    public stack(){
        arr = new int[5];
    }
    public stack (int n){
        arr = new int[n];
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isfull(){
        return top ==  arr.length -1;

    }
    public void push(int item) throws Exception{
        if(isfull()){
            throw new Exception("stack full hogya hau");

        }
        top++;
        arr[top] = item;
    }
    public int pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("Bklol Stack Empty hai ");
		}
		int rv = arr[top];
		top--;
		return rv;
	}



    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("stack empty hai");
        }
        int rv = arr[top]; //rv --> retrun value
        return rv;
    }
    public int size(){
        return top +1;
    }
    public void Display(){
        for(int i = 0 ; i <= top ; i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
    
}
