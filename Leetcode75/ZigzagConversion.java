public class ZigzagConversion{
   //leetcode 6
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuilder sb =  new StringBuilder();//bcz it took o(n) tc
        //if we perform opern on string it will take 0(n^2)

        for(int i = 0; i < numRows ; i++){
            int idx =  i;
            int deltaSouth = 2 * (numRows -1 -i);
            int deltaNorth =  2*i;
            boolean goingSouth = true;

            while(idx < s.length()){
                sb.append(s.charAt(idx));
//agr to aap 0th index pr ho tb deltasouth mai add karo
                if(i == 0){
                    idx += deltaSouth;
                }else if(i == numRows -1){
                    idx += deltaNorth;
                }else{
                    if(goingSouth){
                        idx += deltaSouth;
                    }else{
                        idx += deltaNorth;
                    }
                    goingSouth =!goingSouth;
                }
            }
        }
        return sb.toString();


    }

}