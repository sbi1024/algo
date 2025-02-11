package basic.delta;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class DeltaTest1 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int forCount1 = Integer.parseInt(st.nextToken());
        int forCount2 = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= forCount1; i++) deque.addLast(i);

        while (!deque.isEmpty()) {
            for (int i = 0; i < forCount2 - 1; i++) {
                Integer value = deque.removeFirst();
                deque.addLast(value);
            }
            sb.append(deque.removeFirst()).append(", ");
        }


        bw.write("<" + sb.substring(0, sb.toString().length() - 2) + ">");
        bw.flush();
        bw.close();
    }
}



