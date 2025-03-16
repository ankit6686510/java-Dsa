package Lecture_20;

public class Book_Allocation {
    public static void main(String[] args) {
        int[] page =  {10,20,30,40};
        int nos = 2;//no.of students
        System.out.println(minPage(page, nos));


    }
    public static int minPage(int[]page,int nos){
        int lo =0;
        int hi = 0;
        for(int i = 0 ; i< page.length ;i++){
            hi += page[i];

        }
        int ans= 0;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(isitpossible(page,nos,mid)==true){
                ans = mid;
                hi = mid-1;

            }else{
                lo = mid+1;
            }
        }
        return ans;
    }
   public static boolean isitpossible(int[]page, int nos,int mid){
    int readpage = 0;
    int students =1;
    for(int i = 0;i < page.length;i++){
        if(readpage + page[i] <=mid){
            readpage += page[i];
        }else{
            students++;
            readpage = page[i];
        }if(students>nos){
            return false;
        }
    }
    return true;


   }
    
}
