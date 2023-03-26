package leetcode.top35.DFSandBFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumbersOfIslands {
    class Pair{
        int first;
        int second;
        Pair(int fst,int scnd){
            this.first=fst;
            this.second=scnd;
        }
    }

    class Solution {
        public int numIslands(char[][] grid) {
            int n=grid.length;
            int m=grid[0].length;
            int visited[][]=new int[n][m];

            int count=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(visited[i][j]==0 && grid[i][j]=='1'){
                        count++;
                        BFS(i,j,grid,visited);
                    }
                }
            }
            return count;
        }

        public void BFS(int row,int col,char[][] grid,int visited[][]){
            visited[row][col]=1;
            Queue<Pair> q=new LinkedList<Pair>();
            q.add(new Pair(row,col));
            int n=grid.length;
            int m=grid[0].length;

            int delRow[]={-1,1,0,0};
            int delCol[]={0,0,1,-1};
            while(!q.isEmpty()){
                int nrow=q.peek().first;
                int ncol=q.peek().second;
                q.poll();

                for(int i=0;i<4;i++){
                    int deltaRow=nrow+delRow[i];
                    int deltaCol=ncol+delCol[i];

                    if(deltaRow>=0 && deltaRow<n && deltaCol>=0 && deltaCol<m && visited[deltaRow][deltaCol]==0 && grid[deltaRow][deltaCol]=='1'){
                        visited[deltaRow][deltaCol]=1;
                        q.add(new Pair(deltaRow,deltaCol));
                    }
                }
            }

        }
    }

    //DFS
    private int n;
    private int m;

    public int numIslands2(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }

    //Simple DFS
    class Solution2 {
        public void dfs(int i, int j, char[][] grid){
            if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!='1'){
                return;
            }
            grid[i][j]='2';
            dfs(i+1, j, grid);
            dfs(i-1, j, grid);
            dfs(i, j-1, grid);
            dfs(i, j+1, grid);
        }
        public int numIslands3(char[][] grid) {
            int ans = 0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]=='1'){
                        dfs(i, j, grid);
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
}
