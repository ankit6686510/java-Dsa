import java.util.*;
public class set {
    public static void main(String[] args) {
        HashMap<String , Integer>map =  new HashMap<>();

        map.put("ankit" , 100);
        map.put("kumar" , 99);
        map.put("jha" , 98);
        map.put("gulshan" , 100);
        map.put("jha" , 99);

        //one way to implement set
        // Set<String> set =  new HashSet<>();

        // set.add("apple");
        // set.add("banana");
        // set.add("ilitchi");
        // set.add("apple");//duplicate ignored
        // System.out.println(set);
        
        //other way to implement set
        Set<String> key1 = map.keySet();
   
        // System.out.println(key1);
        // for(String k:key1){//map pr loop laga rhe hai 
        //     System.out.println(k + " " + map.get(k));

        // }
        // Set<String>key =  map.keySet();
        // System.out.println(key);

        // for (String k : map.keySet()) {
		// 	System.out.println(k + " " + map.get(k));
		// }

        ArrayList<String> key = new ArrayList<>(map.keySet());
		System.out.println(key);
		// 3rd way
		for (String k : map.keySet()) {
			System.out.println(k + " " + map.get(k));
		}
    }
    
}
