public class LL {
    private Node node;
    private Node tail;
    private int size;

    public LL(){
        this.size =  0;
    }

    public void insertFirst(int val){
        Node node =  new node(val);
        node.next =  head;
        head =  node;

        if(tail == head){
            tail =  head;

        }
        size += 1;
    }
    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next =  node;
        tail =  node;
        size++;

    }
    public void insert(int val , int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        Node temp =  head; // index = 0
        for(int i = 1 ; i< index ;i++){
            temp =  temp.next;
        }
        Node node = new Node(val , temp.next);
        temp.next = node;

        size++;
    }
    //insert using recursion
    public void insertusingrecur(int val , int index){
        head = insertusingrecur(val, index ,head);
    }
    private Node insertusingrecur(int val , int index , Node node){
        if(index == 0 ){
            Node temp =  new Node(val,node);
            size++;
            return temp;
        }
        node.next =  insertusingrecur(val, index-1 , node.next);
        return node;
        
    }
}
