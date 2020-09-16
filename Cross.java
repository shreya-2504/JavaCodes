package ProblemStatement;

import java.util.HashMap;
import java.util.Map;

public class Cross {

	public static void main(String[] args) {

		int arr[]= {0,1,3,5,6,8,12,17};
		int arr1[] = {0,1,2,3,4,8,9,11};
		Solution s = new Solution();
	
		System.out.println("Frog Path : "+s.canCross(arr1));
	}
}
class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[stones.length][stones.length];
        //System.out.println(dp.length);
        for(int i=0; i<stones.length; i++){
            map.put(stones[i], i);//key as a stone and value as a stone index
        }
        return helper(map, 0, stones[stones.length-1], 0, dp);
    }
    
    private boolean helper(Map<Integer, Integer> map, int pos, int lastElement, int jump, int[][] dp){
        if(!map.containsKey(pos)) return false;//chck if stone is present or not 
        if(pos == lastElement) return true; // if successfully crosses the path it will return true.
        
       // int curr = dp[map.get(pos)][jump];
        System.out.println("map:"+map.get(pos));
        
       // System.out.println(curr);
        //if(curr == 1) return true;
        //if(curr == -1) return false;
        
        //check for k+1 jump
        if(helper(map, pos+(jump+1), lastElement, jump+1, dp)) {
           // dp[map.get(pos)][jump] = 1;
            return true;
        }
        //check for k jump
        if(jump > 0 && helper(map, pos+jump, lastElement, jump, dp)){
            //dp[map.get(pos)][jump] = 1;
            return true;
        }
        //check for k-1 jump
        if(jump > 1 && helper(map, pos+(jump-1), lastElement, jump-1, dp)){
            //dp[map.get(pos)][jump] = 1;//dp= dropping point
            return true;
        }
        
        //dp[map.get(pos)][jump] = -1;
        return false;
    }
}
//position is decided from jump--> 