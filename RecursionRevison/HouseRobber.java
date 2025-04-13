package RecursionRevison;

public class HouseRobber {
    public static void main(String[] args) {
        int[] houses = {2, 7, 9, 3, 1};
        System.out.println(rob(houses, 0));
    }

    public static int rob(int[] houses, int currentHouse) {
        if (currentHouse >= houses.length) {
            return 0;
        }

        // rob this house and skip next
        int rob = houses[currentHouse] + rob(houses, currentHouse + 2);

        // skip this house and rob next
        int skip = rob(houses, currentHouse + 1);

        return Math.max(rob, skip);
    }
}
