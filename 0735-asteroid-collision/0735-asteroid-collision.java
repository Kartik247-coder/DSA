class Solution {
    public int[] asteroidCollision(int[] arr) {
        int n=arr.length;

        Stack<Integer> st=new Stack<>();
        st.push(arr[0]);

        for(int i=1;i<n;i++){
            boolean alive=true;
            while(alive && !st.isEmpty() && st.peek()>0 && arr[i]<0){
                if(st.peek()==-arr[i]){
                    st.pop();
                    alive=false;
                }
                else if(st.peek()>-arr[i]){
                  alive=false;
                }
                else{
                    st.pop();
                }
            }
            if(alive) st.push(arr[i]);
        }
        int[] ans=new int[st.size()];

        for(int i=st.size()-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;

    }
}