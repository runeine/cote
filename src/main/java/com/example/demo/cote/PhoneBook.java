package com.example.demo.cote;

import java.util.Arrays;

public class PhoneBook {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i=0;i<phone_book.length;i++){
            if(phone_book[i].startsWith(phone_book[i+1])){
                answer = false;
                break;
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        
        solution(new String[]{"119", "97674223", "1195524421"});
        
    }
}
