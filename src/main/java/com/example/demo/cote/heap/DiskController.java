package com.example.demo.cote.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController {
    public int solution(int[][] jobs) {
        int answer = 0;

        // jobs �� ���� �ð� ������ ����
        // job �� ���������� ����
        // ���� ���� ������ �ð��ȿ� ���� �ð��� ���ԵǴ� �۾��� ��� �켱���� ť�� �߰�
        // �켱 ���� ť�� ����ð��� ª�� ������ ����
        // �켱 ���� ť�� ��� �����ϸ� �۾� �ð��� ���
        // �۾� ���� �ð� ���� job�� ã�Ƽ� �ݺ� ����
        // �� �۾� �ð��� ��� ���Ͽ� ����� ����
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
