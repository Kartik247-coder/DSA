class Solution {
    public int maxSatisfied(int[] arr, int[] grumpy, int k) {
        int n=arr.length;
        int a=0,b=0;
        int unsatisfied=0;
        int max=Integer.MIN_VALUE;
        int i=0,j=k-1;

        for(int x=0;x<=j;x++){
            if(grumpy[x]==1)unsatisfied+=arr[x];
        }

        while(j<n){
            if(max<unsatisfied){
                max=unsatisfied;
                a=i;
                b=j;
            }
            i++;
            j++;
            if(grumpy[i-1]==1) unsatisfied-=arr[i-1];
            if(j<n && grumpy[j]==1) unsatisfied+=arr[j];
        }

        for(int x=a;x<=b;x++){
            if(grumpy[x]==1) grumpy[x]=0;
        }

        int sum=0;

        for(int x=0;x<n;x++){
            if(grumpy[x]==0) sum+=arr[x];
        }
        return sum;


    }
}