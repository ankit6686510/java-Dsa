public class Valid_Anagram {
    //using  freq array kiya hai
   public static void main(String[] args) {
     String s =  "anagram";
     String t = "nagaram";

     System.out.println(isAnagram( s  ,  t));
   }
   public static boolean isAnagram(String s ,String t){
    //check dono ki length
    if(s.length() != t.length()){
        return false;
    }
    //frequency array create karunnga of size 26(a-z lowercase only)
    int[] freq =  new int[26];

    //count karunga frq of each character in string s 
    for(int i  = 0 ; i < s.length() ; i++){
        char ch =  s.charAt(i);//current character from s
        freq[ch -'a']++; //increase its count

    }
    // decrease freq for each char in string t
    for(int i = 0 ; i< t.length() ; i++){
        char ch =  t.charAt(i);//current chatracter from t
        freq[ch - 'a']--;// count decrease karo
    }
    //check final freq
    //agar kisi charcter ka count isnot eqal to 0 -->> not anagram
    for(int i = 0 ; i < 26 ; i++){
        if(freq[i] != 0){
            return false;
        }
    }
    //agr saare count matched ho jaate hai return true
    return true;
   }
    
}
