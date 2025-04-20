public class subset{
    public static void main(String[] args) {

        int[] arr = {1,2,3};
        subset(arr, 0, "");
        
    }
    public static void subset(int[] arr , int vidx , String ans ){

        if(vidx == arr.length){
            System.out.println(ans);
            return;
        }
        subset(arr , vidx +1, ans); // exlude ki call
        subset(arr , vidx +1 ,ans + arr[vidx]); //include ki call
       


    }

}