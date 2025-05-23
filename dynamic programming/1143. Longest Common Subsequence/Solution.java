class Solution {
    public int longestCommonSubsequenceTD(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()][text2.length()];

        return longestCommonSubsequence(
                text1.toCharArray(),
                text2.toCharArray(),
                text1.length() - 1,
                text2.length() - 1, dp);
    }

    public int longestCommonSubsequenceBU(String q, String p) {
        int n = q.length();
        int m = p.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (q.charAt(i - 1) == p.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n][m];
    }

    private int longestCommonSubsequence(char[] text1, char[] text2, int i, int j, Integer[][] dp) {
        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        int cost;
        if (text1[i] == text2[j]) {
            cost = 1 + longestCommonSubsequence(text1, text2, i - 1, j - 1, dp);
        } else {
            cost = Math.max(
                    longestCommonSubsequence(text1, text2, i - 1, j, dp),
                    longestCommonSubsequence(text1, text2, i, j - 1, dp));
        }
        dp[i][j] = cost;
        return cost;
    }
}