package basic.bfsdfs;

import java.util.ArrayDeque;

public class DFS_BFS_Graph_Test1 {
    static boolean[][] matrix;
    static boolean[] visit;

    public static void main(String[] args) {
        matrix = new boolean[5][5];
        // 간선
        // 1 -> 2,4
        // 2 -> 3,4
        // 3 -> 2
        // 4 -> 3

        matrix[1][2] = true;
        matrix[1][4] = true;
        matrix[2][3] = true;
        matrix[2][4] = true;
        matrix[3][2] = true;
        matrix[4][3] = true;

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
        for (int i = 1; i <= 4; i++) {
            if (!matrix[v][i] || visit[i]) continue; // 갈수없거나, 이미 방문한 경우
            dfs(i);
        }
    }

    static void bfs(int sv) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(sv);
        visit[sv] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " -> ");

            for (int i = 1; i <= 4; i++) {
                if (!matrix[v][i] || visit[i]) continue; // 갈수없거나, 이미 방문한 경우
                queue.offer(i);
                visit[i] = true;
            }
        }
    }
}
