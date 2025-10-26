public class TestMakeItZigzag {
    public static void main(String[] args) {
        // Test case from the problem
        int[] test1 = {1, 4, 2, 5, 3};
        int[] test2 = {3, 3, 2, 1};
        int[] test3 = {6, 6, 6, 6};
        int[] test4 = {1, 2, 3, 4, 5, 6, 7};
        int[] test5 = {3, 2, 1};
        int[] test6 = {1, 2};
        
        System.out.println("Test 1: " + MakeItZigzagSolution.solve(test1, test1.length)); // Expected: 0
        System.out.println("Test 2: " + MakeItZigzagSolution.solve(test2, test2.length)); // Expected: 1
        System.out.println("Test 3: " + MakeItZigzagSolution.solve(test3, test3.length)); // Expected: 3
        System.out.println("Test 4: " + MakeItZigzagSolution.solve(test4, test4.length)); // Expected: 6
        System.out.println("Test 5: " + MakeItZigzagSolution.solve(test5, test5.length)); // Expected: 1
        System.out.println("Test 6: " + MakeItZigzagSolution.solve(test6, test6.length)); // Expected: 0
        
        // Test large case
        int[] test7 = {65, 85, 19, 53, 21, 79, 92, 29, 96};
        System.out.println("Test 7: " + MakeItZigzagSolution.solve(test7, test7.length)); // Expected: 13
    }
}
