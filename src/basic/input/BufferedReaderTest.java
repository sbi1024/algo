package basic.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str = br.readLine(); // 1 2 3 4 5
//
//            int[] input = new int[5];
//            StringTokenizer st = new StringTokenizer(str);
//
//            for (int i = 0; i < 5; i++) {
//                input[i] = Integer.parseInt(st.nextToken());
//            }
//
//            System.out.println(Arrays.toString(input));
//        }

//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str = br.readLine(); // 1 2 3 4 5
//
//            char[] input = new char[5];
//            StringTokenizer st = new StringTokenizer(str);
//
//            for (int i = 0; i < 5; i++) {
//                input[i] = st.nextToken().charAt(0);
//            }
//            System.out.println(Arrays.toString(input));
//        }


//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str = br.readLine(); // 1 2 3 4 5
//
//            char[] input = str.toCharArray();
//
//            System.out.println(Arrays.toString(input));
//        }

//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int N = Integer.parseInt(br.readLine());
//            int[] input = new int[N];
//
//            String str = br.readLine();
//            StringTokenizer st = new StringTokenizer(str);
//            for (int i = 0; i < N; i++) {
//                input[i] = Integer.parseInt(st.nextToken());
//            }
//
//            System.out.println(N);
//            System.out.println(Arrays.toString(input));
//        }

        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[][] input = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);
                for (int j = 0; j < N; j++) {
                    input[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(N);
            System.out.println(Arrays.deepToString(input));
        }
    }
}
