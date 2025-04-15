class Solution {
    public String longestPalindrome(String string) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < string.length(); i++) {
            int oddLength = expandFromCenter(string, i, i);
            int evenLength = expandFromCenter(string, i, i + 1);
            int maxLength = Math.max(oddLength, evenLength);
            if (maxLength > end - start + 1) {
                start = i - ((maxLength - 1) / 2);
                end = i + (maxLength / 2);
            }
        }
        return string.substring(start, end + 1); // last index not included
    }

    private int expandFromCenter(String s, int left, int right) {
        while ((left >= 0) && (right < s.length()) && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
        }
        return right - left - 1; // has passed in last loop
    }
}
