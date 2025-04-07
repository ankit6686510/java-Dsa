package lecture31recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3;
        toh(n , "A" , "B" , "C");
    }
    public static void toh(int n , String src , String help , String des){
        if(n == 0){
            return;
        }
        toh(n-1 ,src , des ,help);
        System.out.println("Move Disc " + n + " from " + src + " to " + des  );
        toh(n-1 , help , src , des);
    }
}
