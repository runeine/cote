package com.example.demo.cote;

import java.util.HashMap;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author runei
 */
class Participant {


    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<participant.length;i++){
            String p = participant[i];
            map.put(p, map.getOrDefault(p, 0)+1);
        }

        for(int i=0;i<completion.length;i++){
            String c = completion[i];
            
            if(map.get(c) == 1){
                map.remove(c);
                continue;
            }
            map.put(c, map.get(c)-1);
        }
        
        for(String key : map.keySet()){
            if(map.get(key) > 0){
                answer = key;
            }
        }
   
        return answer; 
    }

    public static void main(String[] args) {
        Participant p = new Participant();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(p.solution(participant, completion));
        System.err.println("Hello, World!");
    }
}

