package basic.input;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        // 1,2,3,4,5
//        {
//            Scanner sc = new Scanner(System.in);
//            int[] input = new int[5];
//            for (int i = 0; i < 5; i++) {
//                input[i] = sc.nextInt();
//            }
//
//            System.out.println(input);
//        }

//        {
//            Scanner sc = new Scanner(System.in);
//            char[] input = new char[5];
//            for (int i = 0; i < 5; i++) {
//                input[i] = sc.next().charAt(0);
//            }
//
//            System.out.println(input);
//        }
//        {
//            Scanner sc = new Scanner(System.in);
//            char[] input = sc.nextLine().toCharArray();
//            System.out.println(Arrays.toString(input));
//        }

//        {
//            Scanner sc = new Scanner(System.in);
//            int N = sc.nextInt();
//            int[] input = new int[N];
//            System.out.println(Arrays.toString(input));
//        }

        // next(), nextInt() 는 개행문자를 포함하지 않는다.
        {
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            int N = sc.nextInt();
            sc.nextLine(); // 이걸 통해 개행문자 처리를 해야한다.
            char[] input = sc.nextLine().toCharArray();

            System.out.println(N);
            System.out.println(Arrays.toString(input));
        }
    }
}
