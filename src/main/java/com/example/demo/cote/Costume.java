package com.example.demo.cote;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Costume {
    public static int solution(String[][] clothes) {
        int answer;
        Map<String, Integer> type = new HashMap<>();
        for(int i =0; i<clothes.length; i++){
            type.put(clothes[i][1], (Integer) type.getOrDefault(clothes[i][1], 0) + 1);
            
            
        }
        AtomicInteger typeCount = new AtomicInteger(1);

        type.forEach((key, value) -> {
            typeCount.set(typeCount.get() * (value + 1));
        });

      

        
        answer = typeCount.get() - 1;

        return answer;
    
    }

    public static void main(String[] args) {
        
        System.out.println(
        solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}})
        );
        
    }
}
