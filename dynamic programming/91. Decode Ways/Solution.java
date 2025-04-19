class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty())
            return 1;

        if (s.startsWith("0"))
            return 0;

        if (Integer.parseInt(s.substring(0, 1)) >= 3
                || (s.length() >= 2 && Integer.parseInt(s.substring(0, 2)) >= 27)) {
            return numDecodings(s.substring(1, s.length()));
        }

        int count  = 0;
        count += numDecodings(s.substring(1, s.length()));
        if (s.length() >= 2) {
            count += numDecodings(s.substring(2, s.length()));;
        }
        return count;
    }

    // private int numDecodings(String codedStr, int[] r)
}