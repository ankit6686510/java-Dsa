import java.util.Scanner;

public class SearchIn2dMatrix2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        scn.close();
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][]arr= new int[n][m];
        for(int i = 0;i < arr.length;i++){
            for(int j  = 0;j < arr[0].length;j++){
                arr[i][j] =  scn.nextInt();
            }
        }
        int x =  scn.nextInt();
        System.out.println(search(arr,x));
    }
    public static boolean search(int[][]arr,int x){
        int r = 0;
        int c=  arr[0].length-1;//5-1 =4
        while(r<arr.length && c>=0){//0<5 && 4>=0 true
            if(arr[r][c]==x){
                return true;
            }else if(arr[r][c] > x){
                c--;
            }else{
                r++;
            }

    }
    return false;
}
}