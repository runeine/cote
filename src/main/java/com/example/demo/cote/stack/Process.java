package com.example.demo.cote.stack;

import java.util.*;

public class Process {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<priorities.length;i++){
            priority.add(priorities[i]);
        }

        while(!priority.isEmpty()){

            for(int y=0;y< priorities.length;y++){
                
                if(priorities[y] == priority.peek()){
                    answer++;
                    priority.poll();
                
                    if(location == y){
                        return answer;
                    }
                }            
                
                



            }
        }
        
        

        return answer;
    }   
    

   
    public static void main(String[] args) {
        Process p = new Process();
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(p.solution(priorities, location));
    }

}
