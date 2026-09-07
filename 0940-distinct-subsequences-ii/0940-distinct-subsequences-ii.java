class Solution {
    public int distinctSubseqII(String s) {
        final long MOD = 1_000_000_007;

        long[] dp = new long[26];
        long total = 0;

        for (char ch : s.toCharArray()) {
            int c = ch - 'a';

            long newCount = (total + 1) % MOD;

            total = (total + newCount - dp[c] + MOD) % MOD;

            dp[c] = newCount;
        }

        return (int) total;
    }
}