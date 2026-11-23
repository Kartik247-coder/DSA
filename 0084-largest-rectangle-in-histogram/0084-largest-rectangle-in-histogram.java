class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        int[] pse=prevsmaller(arr);
        int[] nse=nextsmaller(arr);
        
        int max=0;

        for(int i=0;i<n;i++){
            if(nse[i]==-1) nse[i]=n;
            int width=nse[i]-pse[i]-1;
            int area=width*arr[i];
            max=Math.max(max,area);
        }
        return max;

    }

    public static int[] prevsmaller(int[]arr){
        int n=arr.length;

        int[] ans=new int[n];

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            ans[i]=(st.size()==0)?-1:st.peek();

            st.push(i);
        }
        return ans;
    }
    public static int[] nextsmaller(int[]arr){
        int n=arr.length;

        int[] ans=new int[n];

        Stack<Integer> st=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            ans[i]=(st.size()==0)?-1:st.peek();

            st.push(i);
        }
        return ans;
    }
}