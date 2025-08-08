public class Flood_Fill {
     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];

        // No need to fill if the new color is the same as the current one
        if (originalColor == newColor) return image;

        fill(image, sr, sc, originalColor, newColor);
        return image;
    }

    // DFS function
    private void fill(int[][] image, int r, int c, int originalColor, int newColor) {
        // Base conditions: out of bounds or color mismatch
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) return;
        if (image[r][c] != originalColor) return;

        // Fill the pixel
        image[r][c] = newColor;

        // Explore 4 directions
        fill(image, r + 1, c, originalColor, newColor); // Down
        fill(image, r - 1, c, originalColor, newColor); // Up
        fill(image, r, c + 1, originalColor, newColor); // Right
        fill(image, r, c - 1, originalColor, newColor); // Left
    }
}
