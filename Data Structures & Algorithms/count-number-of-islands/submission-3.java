class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first =  first;
        this.second = second;

    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m  = grid[0].length;
        int[][] vis  = new int[n][m];
        int count = 0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(vis[row][col]==0 && grid[row][col]=='1'){
                    count++;
                    bfs(row,col,vis,grid);
                }
            }
        }
        return count;
    }
   
   public void bfs(int row,int col, int[][] vis, char[][] grid){
    vis[row][col]=1;
    Queue<Pair> q = new LinkedList<Pair>();
    q.add(new Pair(row,col));
    int n = grid.length;
    int m = grid[0].length;
    int[] drow = {-1,0,1,0};
    int[] dcol ={0,1,0,-1};
    while(!q.isEmpty()){
        int roww = q.peek().first;
        int coll =  q.peek().second;
        q.remove();
        for(int i=0;i<4;i++){
            int nrow= roww+drow[i];
            int ncol= coll+dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol < m && vis[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
                vis[nrow][ncol]= 1;
                q.add(new Pair(nrow,ncol));
            }
        }
    }
   }
}
