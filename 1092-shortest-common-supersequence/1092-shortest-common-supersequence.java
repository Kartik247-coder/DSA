class Solution {
    public static String lcs(String a,String b){
       int m=a.length();
       int n=b.length();

       int[][]dp=new int[m+1][n+1];

       for(int i=1;i<=m;i++){
         for(int j=1;j<=n;j++){
               if(a.charAt(i-1)==b.charAt(j-1)){
                  dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                  dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
       }

       StringBuilder str=new StringBuilder("");
       int i=m,j=n;
       while(i>0 && j>0){
          if(a.charAt(i-1)==b.charAt(j-1)){
            str.append(a.charAt(i-1));
            i--;
            j--;
          }
          else if(dp[i-1][j]>dp[i][j-1]) i--;
          else j--;
       }
       return str.reverse().toString();
    }
    
    public String shortestCommonSupersequence(String a, String b) {
        int m=a.length();
        int n=b.length();

        String lcs=lcs(a,b);
        int l=lcs.length();

        int i=0,j=0,k=0;
        StringBuilder ans=new StringBuilder("");

        while(i<m && j<n && k<l){
            while(i<m && a.charAt(i)!=lcs.charAt(k)){
                  ans.append(a.charAt(i));
                  i++;
            }
            while(j<n && b.charAt(j)!=lcs.charAt(k)){
                ans.append(b.charAt(j));
                j++;
            }
            ans.append(lcs.charAt(k));
            k++;i++;j++;
        }
         
        while(j<n){
            ans.append(b.charAt(j));
            j++;
        }
        while(i<m){
            ans.append(a.charAt(i));
            i++;
        }
        return ans.toString();
    }
}