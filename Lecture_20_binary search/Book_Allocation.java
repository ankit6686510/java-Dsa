/**
  This class solves the Book Allocation problem using binary search
  Problem: Given an array of book pages and number of students,
  allocate books to students such that maximum pages assigned to a student is minimized.
 */
public class Book_Allocation {
    public static void main(String[] args) {
        int[] pages = {10, 20, 30, 40};
        int numStudents = 2;
        
        System.out.println("Minimum number of maximum pages: " + 
                          findMinimumPages(pages, numStudents));
    }
    
  
    public static int findMinimumPages(int[] pages, int numStudents) {
        // Binary search range
        int low = 0;
        int high = 0;
        
        // Calculate sum of all pages as upper bound for binary search
        for (int i = 0; i < pages.length; i++) {
            high += pages[i];
        }
        
        int result = 0;
        
        // Apply binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isPossibleAllocation(pages, numStudents, mid)) {
                result = mid;
                high = mid - 1; // Try to find an even smaller value
            } else {
                low = mid + 1; // Need to increase allowed pages
            }
        }
        
        return result;
    }
    

    public static boolean isPossibleAllocation(int[] pages, int numStudents, int maxPages) {
        int currentPages = 0;
        int studentsRequired = 1;
        
        for (int i = 0; i < pages.length; i++) {
            if (currentPages + pages[i] <= maxPages) {
                currentPages += pages[i];
            } else {
                studentsRequired++;
                currentPages = pages[i];
            }
            
            if (studentsRequired > numStudents) {
                return false;
            }
        }
        
        return true;
    }
}
