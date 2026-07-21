class Solution {
    public int countComponents(int n, int[][] edges) {
          //build the graph
          List<List<Integer>> adj = new ArrayList<>();
          for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
          }
          for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
          }

          //track visited nodes and count
          boolean[] visited = new boolean[n];
          int count = 0;

          //visit each node
          for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adj, visited);
            }
        }

        return count;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }

    }
}
