package Lecture_46_LinkedList;

public class Intro {
    public class Node{
        int val;
        Node next;
    }
    private Node head;//1st node of linked list
    private int size;//size of linked list
    private Node tail;//last node of linked list
    
    //add first element to linked list

    //tc = o(1)
    public void addfirst(int item){
        Node nn =  new Node();
        nn.val =  item;
        if(size==0){
            head = nn;
            tail =  nn;
            size++;
        }else{
            nn.next =  head;
            head =  nn;
            size++;
        }
    }
    //tc = o(1)
    public void addlast(int item){
        if(size==0){
            addfirst(item);
        }else{
            Node nn =  new Node();
            nn.val =  item;
            tail.next =  nn;
            tail = nn;
            size++;
        }
    }

    //o(N)
    public void addatindex(int item , int k) throws Exception{
        if(k == 0){
            addfirst(item);
        }else if(k == size){
            addlast(item);
        }else{
            Node k_1th =  getnode(k-1);
            Node nn =  new Node();
            nn.val =  item;
            nn.next = k_1th.next;
            k_1th.next =  nn;
            size++;
        }

    }
    private Node getnode(int k) throws Exception{
        if(k < 0 || k >= size){
            throw new Exception("k out of range");
        }
        Node temp = head;
        for(int i = 0; i < k ;  i++){
            temp =  temp.next;
        }
        return temp;

    }
    //tc o(1)
    public int getfirst() throws Exception{
        if(head == null){
            throw new Exception("list is empty");
        }
        return head.val;
    }
    //tc o(1)
    public int getlast() throws Exception{
        if(head == null){
            throw new Exception("list is empty");
        }
        return  tail.val;
    }
    //tc o(n)
    public int getatindex(int k) throws Exception{
        return getnode(k).val;

    }
    //o(1)
   public int removefirst() throws Exception {
    if (size == 0) {
        throw new Exception("List is empty");
    }

    Node temp = head;
    if (size == 1) {
        head = null;
        tail = null;
    } else {
        head = head.next;
        temp.next = null;
    }
    size--;
    return temp.val;
}

    public int removelast() throws Exception{
        if(size == 1){
            return removefirst();
        }else{
            Node prev =  getnode(size - 2);
            Node temp =  tail;
            tail = prev;
            size--;
            return temp.val;
        }
    }
    public int removeatindex(int k) throws Exception{
        if(k == 0){
            return removefirst();
        }else if( k == size - 1){
            return removelast();
        }else{
            Node prev = getnode(k-1);
            Node curr =  prev.next;
            prev.next =  curr.next;
            curr.next =  null;
            size--;
            return curr.val;
        }

    }
    public void Display(){
        Node temp =  head;
        while(temp != null){
            System.out.print(temp.val  +  " -> ");
            temp =  temp.next;
        }
        System.out.println(".");
    }
    public int getSize() {
    return size;
}


}
