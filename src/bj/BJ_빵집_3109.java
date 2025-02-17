package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_빵집_3109 {
    // 백트리킹 - 이전의 놓은 파이프 라인이 다음에 놓을 파이프라인의 영향을 미친다.
    // 그리디 - 최대한 많은 파이프라인.... <= 왼쪽에서 오른쪽으로 가면서 이어지는 탐색중, 우선순위가 존재한다.
    // 우선 순위대로 방문했을 때 성공하면, 다음 우선순위의 탐색을 이어가면 안된다. 바로 죵료해야
    // 항상 현재 좌표에서 유리한 방향 1가지만 성공하면 탐색 종료
    // visit - 특정 좌표를 탐색의 과정에서 방문하게 되면 무조건 'x' 로 표시

    static int R, C, ans;
    static char[][] map;

    // delta 순서 (우상, 우, 우하)
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 각 행병로 밑으로 내려가면서 탐색 진행
        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) ans++;
        }

        System.out.println(ans);
    }

    static boolean dfs(int y, int x) {
        int nx = x + 1;
        if (nx == C - 1) return true;

        // 우선순위를 가진 delta 다음 방문 진행
        // 다음 재귀호출의 결과가 true 이면 성공이고 이때 다음 delta 방문 하면 X
        for (int d = 0; d < 3; d++) {
            int ny = y + dy[d];
            if (ny < 0 || ny >= R || map[ny][nx] == 'x') continue;
            map[ny][nx] = 'x';
            if (dfs(ny, nx)) return true;
        }

        // 현재 좌표에서 성공 X
        return false;
    }
}
