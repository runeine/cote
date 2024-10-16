package com.example.demo.cote;

import java.util.HashMap;

class Poketmon {
    public int solution(int[] nums) {
        int answer = 0;
        int max = nums.length/2;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
                        int mon = nums[i];
            map.put(mon, map.getOrDefault(mon, 0)+1);
            if(map.size() == max){
                return max;
            }

        }
        answer = map.size();
        return answer;
    }
}

