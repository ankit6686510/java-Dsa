import java.util.HashMap;

public class validAnagran_Hashmap {
    //using hashmap
    public static void main(String[] args) {

		String s = "anagram";
		String t = "nagaram";

		System.out.println(isAnagram(s, t)); // true
	}
    public static boolean isAnagram(String s , String t){
        //check length
        if(s.length() != t.length()){
            return false;
        }

        // Step 2: Pehle string s ke liye character frequency count karo
        HashMap<Character , Integer> map =  new HashMap<>();
        for(int i = 0; i < s.length() ; i++){
            char ch =  s.charAt(i);

            // agar already present hai, to uska count badhao
            if(map.containsKey(ch)){
                map.put(ch ,map.get(ch) + 1);
            }else{
                // nahi hai to pehli baar 1 se start karo
                map.put(ch , 1);
            }
        }
        // Step 3: Ab string t ke characters check karo
        for(int i = 0; i < t.length() ; i++){
            char ch  =  t.charAt(i);

            //aggr char map m hai and count > 0
            if(map.containsKey(ch) && map.get(ch) > 0){
                map.put(ch ,map.get(ch) -1);//count kam karo
            }else{
                // agar character missing hai ya count 0 ho gaya, not anagram
                return false;
            }

        }
        // Step 4: Sab counts match hue honge to return true


        return true;
    }
    StringBuilder sb = new StringBuilder();
    
}
