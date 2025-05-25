package Heap_Hashmap_problems;
import java.util.*;
public class Highest_Freq_character {
    public static void main(String[] args) {
       Scanner scn =  new Scanner(System.in);
       String str = scn.nextLine();
        scn.close();
       HashMap<Character , Integer>hm =  new HashMap<>();
       for(int i = 0 ; i < str.length() ; i++){
        char ch =  str.charAt(i);

        if(hm.containsKey(ch)){
            int of =  hm.get(ch);//old freq
            int nf =  of + 1;//new freq
            hm.put(ch, nf);
        }else{
            hm.put(ch , 1);
        }
       }
       char mfc =  str.charAt(0);//maximum freq counter
       for(Character key : hm.keySet()){
            if(hm.get(key) > hm.get(mfc)){
                mfc =  key;
            }

       }
       System.out.println(mfc);
    }
}