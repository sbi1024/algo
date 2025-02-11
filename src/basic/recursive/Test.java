package basic.recursive;

public class Test {
    public static void main(String[] args) {
        // m1();
        // m1_param(0);
        // m2();
        // m3();
        m4(5);
    }

    static int m1_i = 0;

    static void m1() {
        // 로컬변수는 재귀호출마다 스택에 서로 만들어지고 초기화 된다.
        int i = 0;
        System.out.println("m1() " + i);

        // static 변수
        System.out.println("m1_i() " + m1_i++);
        m1();
    }

    static void m1_param(int i) {
        // 파라미터 변수
        System.out.println("m1_param() " + i++);
        m1_param(i);
    }

    // 기저조건
    static int m2_cnt = 5;

    static void m2() {
        System.out.println("앞 m2() " + m2_cnt);
        if (m2_cnt > 0) {
            m2_cnt--;
            m2();
        }
        System.out.println("뒤 m2()" + m2_cnt);
    }

    // 기저조건
    static int m3_cnt = 5;

    static void m3() {
        if (m3_cnt == 0) return;

        System.out.println("앞 m3() " + m3_cnt);

        m3_cnt--;
        m3();
        m3_cnt++;

        System.out.println("뒤 m3() " + m3_cnt);
    }


    // 기저조건


    static void m4(int m4_cnt) {
        if (m4_cnt == 0) return;
        System.out.println("앞 m4() " + m4_cnt);
//        m4(m4_cnt - 1);
        m4(m4_cnt - 1);
        System.out.println("뒤 m4() " + m4_cnt);
    }
}
