class Solution {
    //
    public int brokenCalc(int start, int target) {
        if(start==target) return 0;
        int count=0;
        while(target>start){
            if(target%2==0){
                target=target/2;
            }
            else{
                target=target+1;
            }
            count++;
        }
        return count+(start-target);
        
    }
}