package Lecture_42_stack_queue;

import java.util.Stack;

public class Stack_Reverse {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        System.out.println(st);
		Reverse(st);
		System.out.println(st);

    }
    public static void Reverse(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int ii =  st.pop();
        Reverse(st); // recursive call 
        Insert_Buttom(st , ii); // 2nd recursive call
    }
    public static void Insert_Buttom(Stack<Integer> st , int item){
        if(st.isEmpty()){
            st.push(item);
            return;
        }
        int ii =  st.pop();
        Insert_Buttom(st, item);
        st.push(ii);
    }
}
//tc = o(n^2) 2 recursive call lag rhi hai