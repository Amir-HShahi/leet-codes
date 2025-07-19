class TreeAncestor {
    final int[][] up;
    final int maxPow;

    public TreeAncestor(int n, int[] parent) {
        maxPow = (int) (Math.log(n) / Math.log(2)) + 1;
        up = new int[maxPow][n];
        up[0] = parent;
        for (int j = 1; j < maxPow; j++) {
            for (int i = 0; i < n; i++) {
                int pre = up[j - 1][i];
                up[j][i] = pre == -1 ? -1 : up[j - 1][pre];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int pow = this.maxPow;
        while (k > 0 && node > -1) {
            if (k >= 1 << pow) {
                node = up[pow][node];
                k -= 1 << pow;
            } else
                pow -= 1;
        }
        return node;
    }
}