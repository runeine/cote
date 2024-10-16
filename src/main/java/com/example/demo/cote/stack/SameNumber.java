package com.example.demo.cote.stack;

import java.util.*;


public class SameNumber {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            if(i==0){
                stack.push(arr[i]);
            }else{
                if(stack.lastElement() != arr[i]){
                    stack.push(arr[i]);
                }
            }

           
        }
        answer = stack.stream().mapToInt(i -> i).toArray();
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        SameNumber sameNumber = new SameNumber();
        sameNumber.solution(new int[]{1,1,3,3,0,1,1});
    }

}
