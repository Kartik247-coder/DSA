class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int n=arr.length;
        int hi=n-1,lo=0;
        int lb=n;
        List<Integer> list=new ArrayList<>();

        if(x<arr[0]){
            for(int i=0;i<k;i++){
                list.add(arr[i]);
            }
            return list;
        }
        if(x>arr[n-1]){
            for(int i=n-1;i>=n-k;i--){
                list.add(arr[i]);
            }
            Collections.sort(list);
            return list;
        }

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(arr[mid]>=x){
             lb=mid;
             hi=mid-1;
            }
            else lo=mid+1;
        }

        int i=lb-1,j=lb;
        int m=0;

        while(i>=0 && j<n && k>0){
            int di=Math.abs(arr[i]-x);
            int dj=Math.abs(arr[j]-x);

            if(di<=dj){
             list.add(arr[i]);
             i--;
            }
            else{
                list.add(arr[j]);
                j++;
            }
            k--;
        }
        while(j==n && k>0 ){
            list.add(arr[i]);
            i--;
            k--;
        }
        while(i<0 && k>0){
            list.add(arr[j]);
            j++;
            k--;
        }
        Collections.sort(list);
        return list;

    }
}