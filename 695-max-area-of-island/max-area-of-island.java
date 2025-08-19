class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int max = 0;
        for(int i =0 ; i<n;i++) {
            for(int j =0 ; j < m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                   max = Math.max(max, bfs(i, j, vis, grid));
                }
            }
        }
        return max;
    }

    public int bfs(int ro, int co, int[][] vis , int[][] grid){
            int[] delRow = {-1,0,1,0};
            int[] delCol = {0,1,0,-1}; 
            int n = grid.length;
            int m = grid[0].length;
            int count = 1;
            vis[ro][co] = 1;
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(ro,co));

            while(!q.isEmpty()){
                int row = q.peek().first;
                int col = q.peek().second;
                q.remove();

                for(int i =0 ;i<4;i++){
                    int nrow = row+delRow[i];
                    int ncol = col+delCol[i];
                    if(nrow >= 0 && nrow < n && ncol>=0 && ncol<m
                    && grid[nrow][ncol] == 1 && vis[nrow][ncol] != 1 ){
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow,ncol));
                        count++;
                    }
                }
            }
            return count;
        }

    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}