package com.example.demo.cote.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stock{
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        // 최초 시간을 0으로 초기화
        // prices를 순차적으로 돌면서 가격을 비교
        // 다음 순서 가격과 비교하여 떨어지지 않았다면, 현재 순서의 가격이 유지된 시간 증가
        // 떨어졌다면, 현재 순서의 가격이 유지된 시간을 저장
        // 마지막 순서는 무조건 0이므로, 마지막 순서의 가격이 유지된 시간은 0

        for( int i=0; i< prices.length;i++){

            for(int y=i+1; y<prices.length; y++){
                if(prices[i] <= prices[y]){
                    answer[i]++;
                }else{
                    answer[i]++;
                    break;
                }
            }
        }


        return answer;
    }

    public int[] solution2(int[] prices){
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - 1 - index;
        }

        return answer;
    }

    public int[] solution3(int[] prices){
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {



        }

        return answer;
    }
    public static void main(String[] args){
        Stock stock = new Stock();
        int[] prices = {1, 2, 3, 2, 2,3};
        int[] result = stock.solution2(prices);
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}
