class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        int freshCount = 0;
        int min = -1;

        Queue<Pair> q = new LinkedList<>();


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2 ) q.offer(new Pair(i,j));
                else if(grid[i][j] == 1) freshCount++;
            }
        }

       

        if(freshCount == 0) return 0; 
        if(q.size() == 0) return -1;

        while(!q.isEmpty()){
            min++;
            int size = q.size();
            for(int i =0;i<size;i++){
                Pair node = q.poll();
                int row = node.row;
                int col = node.col;

                for(int dir = 0 ; dir<4;dir++){
                    int newRow = row+delRow[dir];
                    int newCol = col+delCol[dir];

                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m ){
                        if(grid[newRow][newCol]==1){
                            q.offer(new Pair(newRow,newCol));
                            grid[newRow][newCol] =2;
                            freshCount --;
                        }
                    }
                }
            }
        }
        return freshCount != 0 ? -1 : min;
    }

    class Pair{
        int row ;
        int col ;
        Pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }
}