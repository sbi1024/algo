package basic.recursive;

public class Test2 {
    public static void main(String[] args) {
//        factorial(5);
        int result = factorial2(5);
        System.out.println(result);
    }

    static int result = 1;

    static void factorial(int n) {
        if (n == 1) {
            System.out.println(result);
            return;
        }
        result = result * n;
        factorial(n - 1);
    }

    static int factorial2(int n) {
        if (n == 1) {
            return result;
        }
        return n * factorial2(n - 1);
    }

    // #3. 결과값을 재귀호출의 parameter 값으로
    static void factorial3(int n, int result) {
        // 기저조건
        if (n == 1) {
            // result 에 이전 계산값이 존재
            System.out.println(result);
            return;
        }

        factorial3(n - 1, result * n); // 넘어온 이전 계산 값에 자신을 곱한다.
    }

}
