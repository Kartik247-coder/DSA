class Solution {
    //kartik
    public String breakPalindrome(String pal) {
        int n = pal.length();

        if (n == 1) return "";

        char[] s = pal.toCharArray();

        for (int i = 0; i < n / 2; i++) {
            if (s[i] != 'a') {
                s[i] = 'a';
                return new String(s);
            }
        }

        s[n - 1] = 'b';
        return new String(s);
    }
}