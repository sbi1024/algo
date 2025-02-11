package basic.subset;

public class BasicSubset {
    static int[] src = {1, 2, 3, 4, 5};
    static boolean[] select = new boolean[src.length];

    public static void main(String[] args) {
        subset(0);
    }

    static void subset(int srcIdx) {
        if (srcIdx == src.length) {
            printSubSet();
            return;
        }
        select[srcIdx] = true;
        subset(srcIdx + 1);

        select[srcIdx] = false;
        subset(srcIdx + 1);
    }

    static void printSubSet() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < select.length; i++) {
            if (select[i]) {
                sb.append(src[i]).append(" ");
            }
        }
        System.out.println(sb);
    }
}
