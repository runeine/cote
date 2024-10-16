package com.example.demo.cote.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DualPriorityQueue {

    public int[] solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Integer> pqAsc = new PriorityQueue<>();
        PriorityQueue<Integer> pqDesc = new PriorityQueue<>(Comparator.reverseOrder());
        for(String operation : operations){
            String[] split = operation.split(" ");
            String command = split[0];
            int number = Integer.parseInt(split[1]);
            if(command.equals("I")){
                // insert
                pqAsc.add(number);
                pqDesc.add(number);
            }else if(command.equals("D") && number == 1 && !pqDesc.isEmpty()){
                // delete max
                int max = pqDesc.poll();
                pqAsc.remove(max);

            }else if(command.equals("D") && number == -1 && !pqAsc.isEmpty()) {
                // delete min
                int min = pqAsc.poll();
                pqDesc.remove(min);
            }
        }
        System.out.println(pqDesc.peek());
        System.out.println(pqAsc.peek());
        int min = pqAsc.isEmpty() ? 0 : pqAsc.poll(),
            max = pqDesc.isEmpty() ? 0 : pqDesc.poll();

        return new int[]{max, min} ;
    }

    public static void main(String[] args){
        DualPriorityQueue dualPriorityQueue = new DualPriorityQueue();
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(dualPriorityQueue.solution(operations));
    }
}
