package Lecture_57_Heap;

import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> list = new ArrayList<>();

    public void add(int item){
        list.add(item);
        upheapify(list.size() -1);

    }
    public void upheapify(int ci){
        int pi =  (ci -1)/2;
        if(list.get(pi) > list.get(ci)){
            swap(pi , ci);
            // ci = pi;
            upheapify(pi);
        }
    }
    public void swap(int i , int j){
        int ith =  list.get(i);
        int jth =  list.get(j);
        list.set(i, jth);
        list.set(j, ith);
    }
    public int remove(){
        swap(0 , list.size() - 1);
        int rv =  list.remove(list.size() -1);
        downheapify(0);
        return rv;
    }
    public void downheapify(int pi){
        int lci =  2 * pi +1;
        int rci =  2 * pi + 2;
        int mini =  pi;
        if(lci < list.size() && list.get(lci) < list.get(mini)){
            mini =  lci;

        }
        if(rci < list.size() && list.get(rci) < list.get(mini)){
            mini =  rci;
        }
        if(mini != pi){
            swap(mini, pi);
            downheapify(mini);
        }
    }
    public int size(){
        return list.size();
    }
    public int min(){
        return list.get(0);

    }
    public void Display(){
        System.out.println(list);
    }
    
}
