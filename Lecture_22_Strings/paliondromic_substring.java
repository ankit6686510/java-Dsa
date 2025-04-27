public class paliondromic_substring {
    //leetcode 647
//     Input: s = "abc"
// Output: 3
// Explanation: Three palindromic strings: "a", "b", "c".

public static void main(String[] args){
    String s = "aaa";
    System.out.println(countSubstrings(s));
}
public static int countSubstrings(String s ){
    
    int count = 0;

    //count palindrome starting from o to last index
    for(int i = 0 ; i < s.length() ;i++){
       //count palindrome with odd length
        count += countpalindrome(s , i ,i);

        //count palindrome with even length
        count += countpalindrome(s , i , i+1);
    }
    return count;
}
public static int countpalindrome(String s  , int left ,int right){
    //palindrome count karna hai lekin normal approach se nhi but optimal ussse bhi

    int count = 0;

    while(left >= 0 && right < s.length()  && s.charAt(left) == s.charAt(right)){ 
        count ++ ;
        left--;
        right++;

    }
    return count;

}
}
