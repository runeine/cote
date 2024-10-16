package com.example.demo.cote.stack;

import java.util.LinkedList;
import java.util.Queue;

public class Truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        // 대기 트럭들을 모두 대기 큐에 넣어준다
        Queue<Integer> wait = new LinkedList<>();
        for(int i=0;i<truck_weights.length;i++){
            wait.add(truck_weights[i]);
        }

        answer =+1;
        // 트럭들이 순서대로 지나가며 wieght를 넘지 않넘는 만큼 완료 진행 중 큐에 넣어준다.
        Queue<Integer> progress = new LinkedList<>();
        
        int time = 0;
        int currentWeight =0;
        
        while(!wait.isEmpty()){

            time++;           
            // 다음 트럭이 진행 큐에 들어갈 수 있는 지 확인하고 진행 큐에 넣어준다.
            if(currentWeight + wait.peek() <=weight && !wait.isEmpty()){
                int  truck = wait.poll();
                currentWeight += truck;
                progress.add(truck);            
                
            }         

            // 진행 큐에 담긴 것 + 다음 wait.peek() 이 weight를 넘으면 진행 큐에 있는 것을 전부 빼준다.
            if(!wait.isEmpty() && currentWeight + wait.peek()> weight){
                while(!progress.isEmpty()){
                    currentWeight -= progress.peek();
                    progress.poll();
                }
                time+=bridge_length;
            }
            
        }
        
        
        // 진행 큐에 들어가는 순간 진행 큐에 있는 모든 트런은 완료 큐로 이동 시키고 시간을 증가 시킨다.


        return answer;
    }

    public static void main(String[] args) {
        
        Truck truck = new Truck();
        System.out.println(truck.solution(2, 10, new int[]{7,4,5,6}));
    }

}
