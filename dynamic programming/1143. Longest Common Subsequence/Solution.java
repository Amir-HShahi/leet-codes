class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence(text1.toCharArray(), text2.toCharArray(), text1.length() - 1,
                text2.length() - 1);
    }

    private int longestCommonSubsequence(char[] text1, char[] text2, int i, int j) {
        if (i == -1 || j == -1)
            return 0;

        if (text1[i] == text2[j])
            return 1 + longestCommonSubsequence(text1, text2, --i, --j);

        return Math.max(
                longestCommonSubsequence(text1, text2, i - 1, j),
                longestCommonSubsequence(text1, text2, i, j - 1));
    }
}