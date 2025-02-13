package basic.bfsdfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 자료 구조 중 인접 리스트
public class DFS_BFS_Graph_Test2 {
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visit;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        // 간선
        // 1 -> 2,4
        adjList.get(1).add(2);
        adjList.get(1).add(4);
        // 2 -> 3,4
        adjList.get(2).add(3);
        adjList.get(2).add(4);
        // 3 -> 2
        adjList.get(3).add(2);
        // 4 -> 3
        adjList.get(4).add(3);

        // visit
        visit = new boolean[5]; // 0 dummy

//        dfs(1);
        bfs(1);
    }

    static void dfs(int v) {
        // 해당 정점에서 할 일 진행
        visit[v] = true;
        System.out.print(v + " -> ");

        // dfs() 를 이어갈 수 있는 다음 정점 방문
        List<Integer> list = adjList.get(v);
        for (Integer i : list) {
            if (visit[i]) continue;
            dfs(i);
        }
    }


    static void bfs(int sv) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(sv);
        visit[sv] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " -> ");

            List<Integer> list = adjList.get(v);
            for (Integer i : list) {
                if (visit[i]) continue;
                queue.offer(i);
                visit[i] = true;
            }
        }
    }
}
