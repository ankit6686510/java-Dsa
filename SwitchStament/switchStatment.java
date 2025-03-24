package SwitchStament;

public class switchStatment {
    public static void main(String[] args) {
        int dayOfWeek = 5; // 1: Monday, 2: Tuesday, ..., 7: Sunday

        // switch statement to find the name of the day
        switch (dayOfWeek) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            default:
                System.out.println("Invalid day");
        }
    }
}
