package com.example.demo.cote.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController {
    public int solution(int[][] jobs) {
        int answer = 0;

        // jobs 를 시작 시간 순으로 정렬
        // job 를 순차적으로 수행
        // 현재 잡이 끝나는 시간안에 시작 시간이 포함되는 작업을 모두 우선순위 큐에 추가
        // 우선 순위 큐는 수행시간이 짧은 순으로 정렬
        // 우선 순위 큐를 모두 수행하며 작업 시간을 기록
        // 작업 종료 시간 이후 job을 찾아서 반복 수행
        // 총 작업 시간을 모두 더하여 평균을 구함
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int count = 0;
        int time = 0;
        int idx = 0;

        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }

            if (pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] job = pq.poll();
                time += job[1];
                answer += time - job[0];
                count++;
            }
        }

        return answer / count;

    }
    public static void main(String[] args){
        DiskController diskController = new DiskController();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(diskController.solution(jobs));
    }
}
