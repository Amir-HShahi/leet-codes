class Solution {
    public int minDistanceBU(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];

        // init before main loops
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= length2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[length1][length2];
    }

    public int minDistanceTD(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 == 0) {
            return length2;
        }

        if (length2 == 0) {
            return length1;
        }

        int[][] dp = new int[length1 + 1][length2 + 1];
        return minDistance(word1, word2, length1, length2, dp);
    }

    public int minDistance(String word1, String word2, int i, int j, int[][] dp) {
        if (i == 0) {
            return dp[i][j] = j;
        }
        if (j == 0) {
            return dp[i][j] = i;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return dp[i][j] = minDistance(word1, word2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.min(
                    minDistance(word1, word2, i - 1, j - 1, dp),
                    Math.min(
                            minDistance(word1, word2, i, j - 1, dp),
                            minDistance(word1, word2, i - 1, j, dp)))
                    + 1;
        }
    }
}