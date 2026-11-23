class Solution {
 
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;

        int[] arr=new int[n2];

        Stack<Integer> st=new Stack<>();

        arr[n2-1]=-1;
        st.push(nums2[n2-1]);

       for(int i=n2-2;i>=0;i--){
        while(!st.isEmpty() && st.peek()<=nums2[i]){
            st.pop();
        }
        if(!st.isEmpty()) arr[i]=st.peek();
        else arr[i]=-1;
        st.push(nums2[i]);
       }
       int[] ans=new int[n1];

       for(int i=0;i<n1;i++){
        int idx=0;
        while(nums2[idx]!=nums1[i]) idx++;
        ans[i]=arr[idx];
       }
       return ans;

    }
}