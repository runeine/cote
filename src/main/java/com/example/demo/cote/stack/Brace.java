package com.example.demo.cote.stack;

import java.util.Stack;

public class Brace {
    boolean solution(String s) {
        boolean answer = true;

        // 열린만큼 닫혀야 한다
        // 처음은 열려야 한다.
        // 마지막은 닫혀야 한다.
        // 열린만큼 닫힌다.
        // 열린게 없는데 닫히면 안된다.
        // 닫힌게 없는데 열리면 안된다.
        // 열린게 있으면 닫혀야 한다.
        
        int openCount = 0;
        int closeCount = 0;
        
        System.out.println("Hello Java");
        for(int i=0; i < s.length(); i++){
            
            if(s.charAt(i) == '('){
                openCount++;
                

            }else if(s.charAt(i) == ')'){
                closeCount++;                
            }
            if(openCount < closeCount){
                return false;
            }

        }

        if(openCount != closeCount){
            return false;
        }

        return answer;
    }   

    boolean solitionStack(String s){
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for(int i=0; i< s.length();i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            } else if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    return false;
                } else {
                    stack.pop();
                }
            }

        }
        if(!stack.isEmpty()){
            return false;
        }
        return answer;



    }
    public static void main(String[] args) {
        Brace brace = new Brace();
        System.out.println(brace.solution("()()"));
        System.out.println(brace.solitionStack("()()"));
    }
        

}
