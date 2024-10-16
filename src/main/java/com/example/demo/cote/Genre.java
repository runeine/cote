package com.example.demo.cote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Genre {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
    // Create a map to store the total plays for each genre
    Map<String, Integer> genrePlayCount = new HashMap<>();
    // Create a map to store the songs for each genre
    Map<String, PriorityQueue<int[]>> genreSongs = new HashMap<>();

    // Populate the maps
    for (int i = 0; i < genres.length; i++) {
        String genre = genres[i];
        int play = plays[i];
        
        genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);
        
        genreSongs.putIfAbsent(genre, new PriorityQueue<>((a, b) -> {
            if (b[1] != a[1]) {
                return b[1] - a[1]; // Sort by play count in descending order
            } else {
                return a[0] - b[0]; // Sort by song index in ascending order
            }
        }));
        
        genreSongs.get(genre).offer(new int[]{i, play});
    }

    // Create a priority queue to sort genres by total plays in descending order
    PriorityQueue<String> genreQueue = new PriorityQueue<>((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));
    genreQueue.addAll(genrePlayCount.keySet());

    // Collect the best album songs
    List<Integer> bestAlbum = new ArrayList<>();
    while (!genreQueue.isEmpty()) {
        String genre = genreQueue.poll();
        PriorityQueue<int[]> songs = genreSongs.get(genre);
        
        int count = 0;
        while (!songs.isEmpty() && count < 2) {
            bestAlbum.add(songs.poll()[0]);
            count++;
        }
    }

    // Convert the list to an array
    answer = bestAlbum.stream().mapToInt(i -> i).toArray();
      
        return answer;
        

    }
}
