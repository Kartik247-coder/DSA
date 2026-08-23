class Solution {
    public int removeElement(int[] arr, int val) {
        int n=arr.length;
        int i=0,j=0;
        int count=0;

        while(i<n && j<n){
            if(arr[j]!=val){
                arr[i]=arr[j];
                i++;
                count++;
            }
            j++;
        }
        return count;

    }
}