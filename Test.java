import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public boolean isNStraightHand(int[] nums, int need) {
        Arrays.sort(nums);
        HashMap<Integer,Integer>hs=new HashMap<>();
        for(int e:nums) hs.put(e,hs.getOrDefault(e,0)+1);
        int search_space[]=hs.keySet().stream().mapToInt(Integer::intValue).toArray();
        for(int i=0;i<nums.length;i++){
            if(hs.get(nums[i])<=0) continue;
            int sz=1;
            int low=i,high=search_space.length-1;
            while(sz<need){
                int mid=(low+high)>>1;
                if(search_space[mid]>nums[i]){
                    mid=i;
                    high=mid-1;
                }else low=mid+1;
                if(mid==-1) return false;
                if(search_space[mid]!=nums[i]+1) return false;
                if(hs.get(search_space[mid])<=0) return false;
                hs.put(search_space[mid],hs.get(search_space[mid])-1);
                sz++;
            }
        }
        return true;
    }
}
