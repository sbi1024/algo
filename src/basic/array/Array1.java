package basic.array;

import java.util.HashMap;
import java.util.Map;

public class Array1 {
    public static void main(String[] args) {
        {
            // #1. 주어진 배열의 원소들 중 제시된 규칙과 다른 항목이 몇 건??
            // 맨 앞부터 3개씩 묶어서 곱셈 결과가 맞으면 통과 틀리면 wrongCnt 증가
            // 3,2,6 : 3 x 2 = 6 통과
            // 3,4,4 : 3 x 4 = 12 != 4 wrongCnt

			int[] intArray = {3,2,6, 3,4,4, 1,4,2, 2,3,6, 1,3,5, 1,5,1, 1,1,1, 2,4,2, 2,2,4};
			int wrongCnt = 0;
			// 구현
			int intLength = intArray.length - 2;
			for (int i = 0; i < intLength; i = i + 3) {
				if( intArray[i] * intArray[i+1] != intArray[i+2 ] ) wrongCnt++;
			}

			System.out.println(wrongCnt);
        }

        {
            // 양 끝에서 출발해서 안쪽으로 이동하면서 각 대칭 항목이 다른 건 몇건?
            // 맨 앞부터 3개씩 묶어서 곱셈 결과가 맞으면 통과 틀리면 wrongCnt 증가
            char[] charArray = "XYZEBFFGQOVVPWGFFCEAYX".toCharArray();
            int wrongCnt = 0;
            for (int i = 0; i < charArray.length / 2 - 1; i++) {
                if (charArray[i] != charArray[charArray.length - 1 - i]) {
                    wrongCnt++;
                }
            }
            System.out.println(wrongCnt);
        }

        {
            // 모든 알파벳 소문자가 몇 번 반복되었는지 출력
            String str1 = "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi";
            HashMap<Character, Integer> map = new HashMap<>();
            char[] charArray1 = str1.toCharArray();
            for (char ch : charArray1) {
                if (map.containsKey(ch)) map.put(ch, map.get(ch) + 1);
                else map.put(ch, 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                System.out.println("소문자 알파벳 : [" + entry.getKey() + "] 반복 횟수 : [" + entry.getValue() + "]");
            }

            String str2 = "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi";
            int[] alphaArray = new int[26];
            char[] charArray2 = str2.toCharArray();
            for (char ch : charArray2) {
                alphaArray[ch - 'a']++;
            }

            for (int i = 0; i < alphaArray.length; i++) {
                if (alphaArray[i] != 0) {
                    System.out.println(((char) (i + 'a')) + " : " + alphaArray[i]);
                }
            }
        }



    }
}
