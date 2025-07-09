import java.util.*;

public class Map {

    public static void main(String[] args) {
        // Map<String,Integer> map =  new HashMap<>();//parent class jaise hum list  = new arraylist krte the
        HashMap<String, Integer> map = new HashMap<>();
        map.put("ankit", 100);
        map.put("kumar", 99);
        map.put("jha", 98);
        map.put("gulshan", 100);
        map.put("jha", 99);
        // map.put(null, 89);//null value bhi le lega null as kay and 89 as value
        // System.out.println(map); //it will print in any order 
        // System.out.println(map.get("ankit"));
        // System.out.println(map.containsKey("kumar"));//true
        // System.out.println(map.remove("jha"));
        // System.out.println(map.remove("gulshan"));

        // System.out.println(map);
        TreeMap<String, Integer> map1 = new TreeMap<>();
        map1.put("Mohini", 78);
        map1.put("Hunir", 98);
        map1.put("Raja", 88);
        map1.put("Nandini", 55);
        map1.put("Amisha", 48);
        map1.put("Kunal", 78);
        map1.put("Ankit", 69);
        map1.put("Ankita", 53);
        map1.put("Ankit", 99);
        // map1.put(null, 90); //null nhi print kar rha error dega
        // System.out.println(map1);

        LinkedHashMap<String, Integer> map2 = new LinkedHashMap<>();
        map2.put("Ankit", 100);
        map2.put("Mohini", 78);
        map2.put("Hunir", 98);
        map2.put("Raja", 88);
        map2.put("Nandini", 55);
        map2.put("Amisha", 48);
        map2.put("Kunal", 78);
        map2.put("Ankita", 69);//update kae dega ankit ki value ko 100 se 99

        map2.put("Ankit", 99);

        map2.put(null, 90);//null print kar dega

        System.out.println(map2);

    }

}
