package Lecture_42_stack_queue;

public class stack_client {
    public static void main(String[] args) throws Exception { //lekin idhr exception aayega nhi
        stack st = new stack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        // st.push(60);
        System.out.println(st.isfull());
        // st.push(60);

        st.Display();
        System.out.println(st.pop());
        st.Display();
        
    }
}
