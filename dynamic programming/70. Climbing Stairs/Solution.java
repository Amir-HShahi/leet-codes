class Solution {
    public int climbStairs(int n) {
        int[] memoize = new int[n + 1];
        memoize[0] = 1; // there is one way, not no way
        memoize[1] = 1;
        return climbStairs(n, memoize);
    }

    private int climbStairs(int n, int[] memoize) {
        if (n == 1 || n == 0)
            return memoize[n];

        if (memoize[n] > 0)
            return memoize[n];

        int steps = climbStairs(n - 1, memoize) + climbStairs(n - 2, memoize);
        memoize[n] = steps;
        return steps;
    }
}