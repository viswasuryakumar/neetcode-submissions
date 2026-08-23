class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            int rootA = find(parent, a);
            int rootB = find(parent, b);

            if (rootA == rootB) {
                // a and b are already connected -> this edge creates the cycle
                return edge;
            }
            // union
            parent[rootA] = rootB;
        }

        return new int[]{}; // won't be reached given problem constraints
    }

    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]]; // path compression (halving)
            x = parent[x];
        }
        return x;
    }
}