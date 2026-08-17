class Solution {
    public int countSquares(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        int count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]!=1) continue;

                if(i==0 || j==0){
                    if(arr[i][j]==1) count++;
                    continue;
                }

                int val=arr[i][j]+Math.min(arr[i][j-1],Math.min(arr[i-1][j-1],arr[i-1][j]));
                count+=val;
                arr[i][j]=val;

                
            }
        }
        return count;
    }
}