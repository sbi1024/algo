package basic.stackqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPQ {
    public static void main(String[] args) {
//        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
//        pqueue.offer(3);
//        pqueue.offer(2);
//        pqueue.offer(7);
//        pqueue.offer(5);
//        pqueue.offer(9);
//
//        while (!pqueue.isEmpty()) {
//            System.out.println(pqueue.poll());
//        }
//
//        for (Integer num : pqueue) {
//            System.out.println(num);
//
//        }

        // 사용자 정의 클래스
//        {
//            // 아래와 같이 정렬조건을 주지 않을 경우는 Edge 클래스가 Comparable 인터페이스를 구현해야 한다.
//            PriorityQueue<Edge> pqueue = new PriorityQueue<>();
//            pqueue.offer(new Edge(2, 5, 4));
//            pqueue.offer(new Edge(1, 6, 3));
//            pqueue.offer(new Edge(7, 5, 8));
//            pqueue.offer(new Edge(3, 9, 1));
//
//            while (!pqueue.isEmpty()) {
//                System.out.println(pqueue.poll());
//            }
//        }

        {
            // 아래와 같이 정렬조건을 주지 않을 경우는 Edge 클래스가 Comparable 인터페이스를 구현해야 한다.
            PriorityQueue<Edge> pqueue = new PriorityQueue<>((o1, o2) -> o1.c - o2.c);
            pqueue.offer(new Edge(2, 5, 4));
            pqueue.offer(new Edge(1, 6, 3));
            pqueue.offer(new Edge(7, 5, 8));
            pqueue.offer(new Edge(3, 9, 1));

            while (!pqueue.isEmpty()) {
                System.out.println(pqueue.poll());
            }
        }
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
