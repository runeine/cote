package com.example.demo.cote.heap;

import java.util.PriorityQueue;

public class Scovil {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i <scoville.length;i++){
            pq.add(scoville[i]);
        }

        int firstMin = pq.peek();

        while(firstMin < K){

            if(pq.size()>=2){
                pq.add(pq.poll() + (pq.poll()*2));
                firstMin = pq.peek();
                answer++;
            }else{
                return -1;
            }



        }

        return answer;
    }

    public static void main(String[] args){
        Scovil scovil = new Scovil();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(scovil.solution(scoville, K));
    }


}
