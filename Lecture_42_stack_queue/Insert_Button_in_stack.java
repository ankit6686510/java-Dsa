package Lecture_42_stack_queue;

import java.util.Stack;

public class Insert_Button_in_stack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		System.out.println(st);
		Insert_Button(st, -9);
		System.out.println(st);

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
 //tc = o(N)