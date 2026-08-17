class Solution {
    public static int sol(String a,String b,int i,int j,int[][]dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)){
            return dp[i][j]=1+sol(a,b,i-1,j-1,dp);
        }
        else{
            return dp[i][j]=Math.max(sol(a,b,i-1,j,dp),sol(a,b,i,j-1,dp));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();

        int[][] dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return sol(text1,text2,m-1,n-1,dp);
    }
}