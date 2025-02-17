package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// bfs + 백트랙킹
// 0 인 모든 좌표를 zero 라는 ArrayList 에 담는다
// zero 의 0 번째 좌표부터 시작 ~ zero 전체 0인 모든 좌표를 다 채우면 정답
// 0 인 y, x 좌표에 1 ~ 9 의 숫자로 채우기 전에 visit 이용 가로, 세로, 3곱하기3
// 다음 0인 좌표에 위 작업을 반복
// zero 의 모든 좌표에 수를 다 놓으면 종료
public class BJ_스도쿠_2239 {
    static int[][] map = new int[9][9];
    static List<Node> zero = new ArrayList<>();
    static int size; // zero 의 size
    static boolean complete; // false
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 값을 입력하여 2차원 배열에 할당
        for (int i = 0; i < 9; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < line.length; j++) {
                int n = line[j] - '0';
                map[i][j] = n;
                if (n == 0) zero.add(new Node(i, j));
            }
        }

        size = zero.size();
        dfs(0); // zero 의 맨 앞 Node 객체
    }

    static void dfs(int idx) { // zero ArrayList 의 인덱스
        // 기저 조건
        if (complete) return;

        // 기저 조건
        if (idx == size) { // 모든 빈칸을 다 채움
            complete = true; // 작업 완료 flag 설정
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            return;
        }

        // 현재 idx 번째 0인 항목의 y,x 를 구한다.
        Node node = zero.get(idx);
        int y = node.y;
        int x = node.x;

        // map 의 y,x 자리에 1 ~ 9 까지의 숫자를 채워 본다. (가로 ,세로, 3 곱하고 3안에 사용되지 않은 수)
        boolean[] visit = new boolean[10]; // 0는 dummy

        // 가로에 사용 된 수 check
        for (int i = 0; i < 9; i++) {
            if (map[y][i] != 0) visit[map[y][i]] = true;
        }
        // 세로에 사용 된 수 check
        for (int i = 0; i < 9; i++) {
            if (map[i][x] != 0) visit[map[i][x]] = true;
        }
        // 3 곱하기 3에 사용 된 수 check
        int ny = (y / 3) * 3;
        int nx = (x / 3) * 3;
        int ny3 = ny + 3;
        int nx3 = nx + 3;

        for (int i = ny; i < ny3; i++) {
            for (int j = nx; j < nx3; j++) {
                if (map[i][j] != 0) visit[map[i][j]] = true;
            }
        }

        // visit 에 사용되지 않은 수에 대해 다음 재귀 호출 (다음 0인 자리를 진행
        for (int i = 1; i <= 9; i++) {
            if (!visit[i]) {
                map[y][x] = i; // 빈 y,x 자리에 가능한 1부터 9까지 숫자중 한개를 사용해보고, 다음 재귀 호출 이어간다.
                dfs(idx + 1);
                map[y][x] = 0;
            }
        }
    }

    // 0 인 좌표를 표현, zero 담을 객체
    static class Node {
        int y, x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
