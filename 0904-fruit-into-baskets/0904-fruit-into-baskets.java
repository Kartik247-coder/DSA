class Solution {
    public int totalFruit(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();

        int i=0,j=0;
        int max=Integer.MIN_VALUE;

        while(i<n && j<n){
            int ele=arr[j];
            if(map.containsKey(ele)){
                map.put(ele,map.get(ele)+1);
            }
            else map.put(ele,1);

            while(i<n && map.size()>2){
                int freq=map.get(arr[i]);
                if(freq==1) map.remove(arr[i]);
                else map.put(arr[i],freq-1);
                i++;
            }
            int leng=j-i+1;

            max=Math.max(max,leng);
            j++;
        }
        return max;
    }
}