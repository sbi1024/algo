package basic.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// MST
// 간선 중심 풀이
// 간선의 자료구조 (v1, v2, c)의 베열 또는 리스트
// 위 자료구조가 입력 테케에 친절하게 주어지면 그대로 간선 리스트를 만들면 된다.
// 만약, 간선 리스트가 아닌 테케가 주어지면 그걸 이용해서 간선 리스트를 만들어야 한다.
// 간선 리스트를 최소비용 순으로 정렬 (간선이 많은 문제는 불리)
// 정렬 후, 최소비용 간선을 계쏙 선택해서 간선이 연결하는 정점을 선택
// cycle 이 발생하는 전선 skip <= union find 알고리즘 사용
// 선택한 간선의 수가 정점의 수 - 1이 될때까지 진행
public class Kruskal {
    static int V, E, sum; // sum : MST 비용 (모든 정점을 방문하는 최소 비용)
    static Edge[] edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 수

        parent = new int[V];
        // 간선의 수가 주어졌으므로 배열 사용
        // 간선의 수는 주어지지 않고, 간선 정보만 주어진다. <== List 사용
        edges = new Edge[E];

        // 간선 리스트 입력 처리
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int co = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(v1, v2, co);
        }

        // 자기 자신을 부무로 설정
        makeSet();

        Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);

        // System.out.println(Arrays.toString(edges));

        // 크루스칼
        int cnt = 0; // 선택된 간선의 수의 합
        int edgesLen = edges.length;
        for (int i = 0; i < edgesLen; i++) {
            Edge edge = edges[i];
            // cycle 을 체크하고 없으면 선택
            if (union(edge.v1, edge.v2)) {
                System.out.println(edge.v1 + " -> " + edge.v2 + " : " + edge.c);
                sum += edge.c;
                cnt++;
                // a모든 간선을 선택한 것이다.
                if (cnt == V - 1) {
                    break;
                }
            }
        }
        System.out.println(sum);
    }


    static void makeSet() {
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
    }


    static int findSet(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findSet(parent[x]);
    }

    // 기존 union
//    static void union(int x, int y) {
//        int px = findSet(x);
//        int py = findSet(y);
//        if (px < py) parent[py] = px;
//        else parent[px] = py;
//    }

    // 크루스칼은 findSet(v1) findSet(v2)을 이용해서 cycle 을 체크하고 cycle 이 안생기면 union
    // findSet(v1), findSet(v2) 중복 실행이 되므로 쿠르스칼에 맞게 변
    static boolean union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if (px == py) return false;
        if (px < py) parent[py] = px;
        else parent[px] = py;

        return true;
    }

    // 간선 클래스 <= int[] 대체 가
    static class Edge {
        @Override
        public String toString() {
            return "Edge{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", c=" + c +
                    '}';
        }

        int v1, v2, c;

        public Edge(int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }
    }
}

/**
 * 정점수 간선수
 * v1 v2 가중치
 * 5 10
 * 0 1 5
 * 0 2 10
 * 0 3 8
 * 0 4 7
 * 1 2 5
 * 1 3 3
 * 1 4 6
 * 2 3 1
 * 2 4 3
 * 3 4 1
 */

