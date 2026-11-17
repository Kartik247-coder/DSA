class Solution {
    public static int find(String a,String b,int i,int j,int[][]dp){
        if(i<0 && j<0) return 0;
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)) return dp[i][j]=find(a,b,i-1,j-1,dp);
        else{
            int ins=find(a,b,i-1,j,dp);
            int rep=find(a,b,i-1,j-1,dp);
            int del=find(a,b,i,j-1,dp);
            return dp[i][j]=1+Math.min(ins,Math.min(rep,del));
        }
    }
    public int minDistance(String a, String b) {
        int m=a.length();
        int n=b.length();
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return find(a,b,m-1,n-1,dp);

    }
}