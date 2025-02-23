//time complexity: O(m*n) worst case we have to flood fill the entire matrix and visiting every grid will take m * n time
//space complexity: O(m*n) although we are polling 1 at a time, when we visit all 4 directions, we will add almost all grids before we start polling and processing each

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0){
            return null;
        }

        int originalColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        image[sr][sc] = color;
        queue.offer(new int[]{sr, sc});

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int newsr = curr[0] + dir[0];
                int newsc = curr[1] + dir[1];
                if (newsr >= 0 && newsc >= 0 && newsr < image.length && newsc < image[0].length 
                && image[newsr][newsc] == originalColor && image[newsr][newsc] != color) {
                    image[newsr][newsc] = color;
                    queue.offer(new int[]{newsr, newsc});
                }
                
            }
        }
        return image;
    }
}
