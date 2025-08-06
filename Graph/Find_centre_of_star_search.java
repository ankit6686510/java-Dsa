public class Find_centre_of_star_search {
    public int findCenter(int[][] edges) {
        // Get the first two edges
        int a = edges[0][0];
        int b = edges[0][1];
        int c = edges[1][0];
        int d = edges[1][1];

        // The common node between the first two edges is the center
        if (a == c || a == d) return a;
        return b;
    }
}
