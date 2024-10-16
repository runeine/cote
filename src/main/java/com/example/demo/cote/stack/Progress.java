package com.example.demo.cote.stack;

import java.util.*;

public class Progress {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int totalSuceess = 0;

        int day = 1;
        int i = 0;
        List<Integer> result = new LinkedList<>();

        // 첫번째 프로그래스가 100이 되면 다음 작업을 시작한다.
        // 다음 작업이 100이 되면 다음 작업을 시작한다.

        // 프로그래스는 현재 프로그래스 + (작업속도 * day) 이다.
        
        while (totalSuceess < progresses.length) {

            if(progresses[i] + (speeds[i] * day) >=100){
                
                totalSuceess++;
                i++;
                map.put(day, map.getOrDefault(day, 0)+1);
                
            } else {
                day++;
            }
            
            
        }
        map.forEach((k,v) -> {
            System.out.println(k + " : " + v);
        });

        map.entrySet().stream().sorted((e1,e2) -> e1.getKey() - e2.getKey()).forEach(e -> {
            result.add(e.getValue());
        });

        map.forEach((k,v) -> {
            System.out.println(k + " : " + v);
        });

        answer = result.stream().mapToInt(j -> j).toArray();

        return answer;
        
        }

        public int[] solutionForQueue(int[] progresses, int[] speeds) {
            int[] answer = {};
    
            Queue<Integer> queue = new LinkedList<Integer>();

            for(int i=0;i < progresses.length;i++){
                queue.add((int) Math.ceil((100.0  - progresses[i]) / speeds[i]));
            }

            List<Integer> list = new LinkedList<Integer>();

            while(!queue.isEmpty()){

                int count = 1;
                int days = queue.poll();
                while(!queue.isEmpty() && days >= queue.peek()){
                    count++;
                    queue.poll();
                }
                list.add(count);

            }


            answer = list.stream().mapToInt(i -> i).toArray();
            return answer;
            
            }





    public static void main(String[] args) {
        Progress progress = new Progress();
        progress.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
    }
}
