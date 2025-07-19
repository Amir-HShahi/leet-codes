class TreeAncestor {
    final int[][] up;
    final int logN;

    public TreeAncestor(int n, int[] parent) {
        logN = (int) (Math.log(n) / Math.log(2)) + 1;
        up = new int[n][logN];

        for (int i = 0; i < n; i++)
            up[i][0] = parent[i];

        for (int j = 1; j < logN; j++)
            for (int i = 0; i < n; i++)
                if (up[i][j - 1] != -1)
                    up[i][j] = up[up[i][j - 1]][j - 1];
                else
                    up[i][j] = -1;
    }

    public int getKthAncestor(int node, int k) {
        for (int i = 0; i < logN; i++) {
            if (node == -1)
                return -1;

            if ((k & (1 << i)) != 0)
                node = up[node][i];

        }
        return node;
    }
}