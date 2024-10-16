package com.example.demo.cote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GenreHashMap {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, HashMap<Integer,Integer>> genrePlayCount = new HashMap<>();
        HashMap<String, Integer> genreTotalPlay = new HashMap<>();

        for(int i = 0; i <genres.length ; i++){
            String genre = genres[i];

            if(genrePlayCount.containsKey(genre)){
                genrePlayCount.get(genre).put(i,plays[i]);    
            } else {
                HashMap<Integer,Integer> song = new HashMap<>();
                song.put(i,plays[i]);

                genrePlayCount.put(genre,song);
            }
        
            if(genreTotalPlay.containsKey(genre)){
                genreTotalPlay.put(genre,genreTotalPlay.get(genre)+plays[i]);
            } else {
                genreTotalPlay.put(genre,plays[i]);
            }
    }
    List<Integer> bestAlbum = new ArrayList<>();
    genreTotalPlay.entrySet().stream().sorted((e1 ,e2) -> e2.getValue() - e1.getValue())
    .forEach(e -> {
        genrePlayCount.get(e.getKey()).entrySet().stream().sorted((e1,e2) -> e2.getValue() - e1.getValue())
        .limit(2).forEach(action -> {
            bestAlbum.add(action.getKey());            
        });
    });
    
    
         answer =   bestAlbum.stream().mapToInt(i -> i).toArray();
        return answer;
        

    }
}
