//import java.io.*;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        // 차후 보석 값에 대한 계산 결과값 출력을 위한 변수 선언
//        int result = 0;
//
//        // 우선순위 큐를 사용하느거보다 이게 나을것 같다
//        List<Cristal> cristalList = new ArrayList<>();
//        List<Integer> backpackList = new ArrayList<>();
//
//        String[] splitInput = br.readLine().split(" ");
//        int cristalCount = Integer.parseInt(splitInput[0]);
//        int backpackCount = Integer.parseInt(splitInput[1]);
//
//        // 보석 생성
//        for (int i = 0; i < cristalCount; i++) {
//            String[] cristalInput = br.readLine().split(" ");
//            Cristal cristal = new Cristal(Integer.parseInt(cristalInput[0]), Integer.parseInt(cristalInput[1]));
//            cristalList.add(cristal);
//        }
//
//        // 가방 생성
//        for (int i = 0; i < backpackCount; i++) {
//            backpackList.add(Integer.parseInt(br.readLine()));
//        }
//
//        // 오름차순으로 정렬
//        cristalList.sort(Comparator.comparingInt(o -> o.weight));
//
//        // 가방 개수만큼 반복
//        for (int i = 0; i < backpackCount; i++) {
//            int max = Integer.MIN_VALUE;
//            int maxIndex = -1;
//            int stand = backpackList.get(i);
//            for (int j = 0; j < cristalCount; j++) {
//                int cristalWeight = cristalList.get(j).getWeight();
//                int cristalPrice = cristalList.get(j).getPrice();
//                boolean cristalFlag = cristalList.get(j).getFlag();
//                if (stand >= cristalWeight) {
//                    if (max < cristalPrice) {
//                        if (!cristalFlag) {
//                            max = cristalPrice;
//                            maxIndex = j;
//                        }
//                    }
//                } else {
//                    break;
//                }
//            }
//            result += max;
//            cristalList.get(maxIndex).setFlag(true);
//        }
//
//        bw.write(result + "\n");
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    static class Cristal {
//        int weight;
//        int price;
//        boolean flag;
//
//        public Cristal(int weight, int price) {
//            this.weight = weight;
//            this.price = price;
//            this.flag = false;
//        }
//
//        public int getWeight() {
//            return weight;
//        }
//
//        public int getPrice() {
//            return price;
//        }
//
//        public boolean getFlag() {
//            return flag;
//        }
//
//        public void setFlag(boolean flag) {
//            this.flag = flag;
//        }
//    }
//}


//import java.io.*;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int[] srcArray;
//    static int[] tgtArray;
//    static boolean[] selectArray;
//
//    // 순열에 대한 문제
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int input1 = Integer.parseInt(st.nextToken());
//        int input2 = Integer.parseInt(st.nextToken());
//
//        srcArray = new int[input1];
//        tgtArray = new int[input2];
//        selectArray = new boolean[input1];
//
//        for (int i = 0; i < input1; i++) srcArray[i] = i + 1;
//
//        perm(0);
//    }
//
//    static void perm(int tgtIdx) {
//        if (tgtIdx == tgtArray.length) {
//            permPrint(tgtArray);
//            return;
//        }
//        for (int i = 0; i < srcArray.length; i++) {
//            if (selectArray[i]) continue;
//            tgtArray[tgtIdx] = srcArray[i];
//            selectArray[i] = true;
//            perm(tgtIdx + 1);
//            selectArray[i] = false;
//        }
//    }
//
//    static void permPrint(int[] tgtArray) {
//        StringBuilder sb = new StringBuilder();
//        for (int tgt : tgtArray) {
//            sb.append(tgt).append(" ");
//        }
//        System.out.println(sb);
//    }
//}

//import java.io.*;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
//
//        int forCount = Integer.parseInt(br.readLine());
//        for (int i = 0; i < forCount; i++) {
//            st = new StringTokenizer(br.readLine());
//            int first = Integer.parseInt(st.nextToken());
//            int second = Integer.parseInt(st.nextToken());
//
//            long combResult = comb(first, second);
//            sb.append(combResult).append("\n");
//        }
//
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    // 결국엔 강 서쪽에 다리가 무조건 존재해야 하기에,
//    // 동쪽으로부터의 서쪽만큼의 조합을 구하는 문제로 귀결
//    // 조합의 공식은 nCr
//    static long comb(int first, int second) {
//        // 최악의 경우 30개 중에 29개를 뽑아야 하는 경우의 수도 존재하기에
//        // BigInteger 를 사용할 수 도 있지만, 보다 빠르게 해결하기 위한 최적화된 해의 방법을 사용한다.
//
//        long result = 1;
//        // 분자 계산, 분모 계산
//        // 만약 30 개중에 5개를 뽑아야 하는 조합의 수를 계싼해야 한다면,
//        // 다음과 같은 식이 성립된다.
//
//        // 30!
//        // 25! * 5!
//        // 그렇다면 분자에서는 30부터 26까지의 곱셈만 진행되고, 분모는 1부터 5까지의 곱셈만 진행되면 된다.
//        // 아래 코드는 위 과정을 함축시킨 코드이다.
//        for (int i = 0; i < first; i++) {
//            result *= second - i; //분자
//            result /= i + 1; // 분모
//        }
//        return result;
//    }
//}


//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//        List<Food> foodList = new ArrayList<>();
//        int forCount = Integer.parseInt(br.readLine());
//        for (int i = 0; i < forCount; i++) {
//            st = new StringTokenizer(br.readLine());
//            Food food = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//            foodList.add(food);
//        }
//
//        // 이것도 조합을 구하는게 아닌가?
//        // 입력값으로 들어오는 forCount 값에서 1 부터 forCount 값의 조합만큼의 계싼 결과중 가장 작은 값을 출력한다.
//        // 완전탐색이기 때문에 시간상의 최적화는 되지 않으나, 결과값은 구할 수 있을거 같다.
//    }
//
//    static class Food {
//        int sour;
//        int bitter;
//
//        public Food(int sour, int bitter) {
//            this.sour = sour;
//            this.bitter = bitter;
//        }
//
//        public int getSour() {
//            return sour;
//        }
//
//        public int getBitter() {
//            return bitter;
//        }
//
//        @Override
//        public String toString() {
//            return "Food{" +
//                    "sour=" + sour +
//                    ", bitter=" + bitter +
//                    '}';
//        }
//    }
//}
//


//import java.util.Stack;
//
//public class Main {
//    public static void main(String[] args) {
//        boolean solution1 = solution("()()");
//        System.out.println("solution1 = " + solution1);
//
//        boolean solution2 = solution("(())()");
//        System.out.println("solution2 = " + solution2);
//
//        boolean solution3 = solution(")()(");
//        System.out.println("solution3 = " + solution3);
//
//        boolean solution4 = solution("(()(");
//        System.out.println("solution4 = " + solution4);
//    }
//
//    public static boolean solution(String s) {
//        // 입력값을 char 배열로 생성한다.
//        char[] charArray = s.toCharArray();
//        // Charcter 타입의 stack 변수를 생성한다.
//        Stack<Character> stack = new Stack<>();
//
//        // 반복문을 통해 입력값의 배열을 순회한다.
//        for (char ch : charArray) {
//            // 만약 '(' 여는 문자가 나온경우, stack 에 넣는다.
//            if (ch == '(') stack.push(ch);
//
//                // 만약 ')' 닫는 문자가 나온경우, stack 의 pop 을 실행한다.
//                // 이전의 문자가 '(' 여는 문자인지 확인이 필요하지 않는 이유는, 이미 stack 에 push 되는 문자는 여는 문자 '(' 만 push 된다.
//            else {
//                // 혹시 pop을 하기전에, 이미 빈 스택인 경우, ')'가 들어온 경우는 절대 올바른 괄호가 될 수 없다.
//                // 예시로 빈 stack 인데, ')' 문자가 들어온 뒤, 다음 어떤 문자가 들어와도 첫번째 닫는 괄호 ')'는 올바른 괄호가 될 수 없다.
//                // 그렇기에, 스택의 사이즈가 빈 값이면 return false 처리한다.
//                if (stack.isEmpty()) return false;
//
//                    // 위 if 조건문을 만족하지 않는다면, 정상적으로 stack에서 '(' 문자를 제거한다.
//                else stack.pop();
//            }
//        }
//
//        // 반복문이 다 실행되고 난 뒤, 최종적으로 stack 변수가 빈값이어야 정상적인 괄호이다. 아닌 경우는 false를 return 한다.
//        return stack.isEmpty();
//    }
//}


//import java.util.Stack;
//
//public class Main {
//    public static void main(String[] args) {
//        int[][] input1 = {
//                {0, 0, 0, 0, 0},
//                {0, 0, 1, 0, 3},
//                {0, 2, 5, 0, 1},
//                {4, 2, 4, 4, 2},
//                {3, 5, 1, 3, 1}
//        };
//        int[] moves1 = {1, 5, 3, 5, 1, 2, 1, 4};
//        int solution1 = solution(input1, moves1);
//        System.out.println("solution1 = " + solution1);
//    }
//
//    public static int solution(int[][] board, int[] moves) {
//        // 리턴하기 위한 변수 선언
//        int answer = 0;
//
//        // stack 을 이용하여 동일한 인형을 뽑는경우, pop을 하기 위한 변수 선언
//        Stack<Integer> stack = new Stack<>();
//        // 크레인이 2차원 배열에서의 몇번쨰 열로 이동할지 반복문 순회
//        for (int i = 0; i < moves.length; i++) {
//            // 크레인이 2차원 0번째 인덱스부터 뽑는 값이 0인지 아닌지 확인하기 위한
//            // 2차원 배열길이만큼 반복문을 순회하면서 0값이 아닌 값 찾기
//            for (int j = 0; j < board.length; j++) {
//                // 크레인이 움직여서 찾은 열의 값 꺼내기
//                int data = board[j][moves[i] - 1];
//                // 만약 이 값이 0이 아니라면, 크레인이 꺼낸 인형의 값이라 볼 수 있음
//                // 다만 값이 0인 경우는 계속해서 해당 반복문을 실행
//                if (data != 0) {
//                    // 0이 아닌 값을 찾은 경우는 이제 동일한 인형이 stack 에 담긴건지 확인을 해야함
//                    // 또한 해당 인덱스에 위치하는 값은 꺼내서 stack으로 일단 이동하거나, pop 되기에 0으로 할당해야함
//                    board[j][moves[i] - 1] = 0;
//                    // 만약 stack이 빈값이라면, 그냥 push 진행
//                    if (stack.isEmpty()) {
//                        stack.push(data);
//                    } else {
//                        // 빈값이 아니라면 이전의 stack에 담긴값이랑 비교함
//                        // stack에 담겨있는 값이 인형인데, 해당 인형값과 현재 data값이 일치한다면 pop 처리해야함
//                        Integer peek = stack.peek();
//                        if (peek.equals(data)) {
//                            // +2 하는 이유는, 인형이 2개가 일치해서 사라지는 것이기에 +2 처리
//                            answer += 2;
//                            stack.pop();
//                        } else {
//                            // 값이 같지 않다면, stack 에 push
//                            stack.push(data);
//                        }
//                    }
//                    // data 가 0이 아니라는건 더이상 크레인이 아래로 내려갈 필요가 없음, 0이 아닌시점에서 크레인은 이미 인형을 뽑았다고 판단
//                    // 해당 반복문을 종료함
//                    break;
//                }
//            }
//        }
//        // 결과값 리턴
//        return answer;
//    }
//}


//import java.io.*;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
//        int count = Integer.parseInt(br.readLine());
//        int[] array = new int[count];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < count; i++) array[i] = Integer.parseInt(st.nextToken());
//
//        Stack<int[]> stack = new Stack<>();
//        for (int i = 0; i < count; i++) {
//            if (stack.isEmpty()) {
//                stack.push(new int[]{array[i], i + 1});
//            } else {
//                int topHeight = stack.peek()[0];
//                if (topHeight <= array[i]) {
//                    stack.pop();
//                    sb.append("0").append(" ");
//                } else {
//                    int[] pop = stack.pop();
//                    stack.push(new int[]{array[i], i + 1});
//                    sb.append(pop);
//                }
//            }
//        }
//    }
//}


//import java.util.ArrayDeque;
//import java.util.Queue;
//
//public class Main {
//    public static void main(String[] args) {
//        // ["i", "drink", "water"]	["want", "to"]	["i", "want", "to", "drink", "water"]
//        String[] cards1 = {"i", "drink", "water"};
//        String[] cards2 = {"want", "to"};
//        String[] goal1 = {"i", "want", "to", "drink", "water"};
//        String solution1 = solution(cards1, cards2, goal1);
//        System.out.println("solution1 = " + solution1);
//
//        // ["i", "water", "drink"]	["want", "to"]	["i", "want", "to", "drink", "water"]
//        String[] cards3 = {"i", "water", "drink"};
//        String[] cards4 = {"want", "to"};
//        String[] goal2 = {"i", "want", "to", "drink", "water"};
//        String solution2 = solution(cards3, cards4, goal2);
//        System.out.println("solution2 = " + solution2);
//    }
//
//    public static String solution(String[] cards1, String[] cards2, String[] goal) {
//        // return 변수 선언
//        String answer = "Yes";
//
//        // 입력값으로 받은 card1, card2, goal 값을 전부 queue에 할당하기 위한 변수 선언
//        Queue<String> cardQueue1 = new ArrayDeque<>();
//        Queue<String> cardQueue2 = new ArrayDeque<>();
//        Queue<String> goalQueue = new ArrayDeque<>();
//
//        // 각각 변수 이름에 맞게 반복문으로 값 할당
//        for (String card : cards1) cardQueue1.offer(card);
//        for (String card : cards2) cardQueue2.offer(card);
//        for (String go : goal) goalQueue.offer(go);
//
//        // 완성하고자 하는 문자열 큐를 반복문을 통해 순회함
//        // 결국 이 큐가 비어야 정상적으로 card1, card2로 문장을 완성할 수 있음
//        while (!goalQueue.isEmpty()) {
//            // 기준이 되는, 목표하고자 하는 값을 하나 peek해서 꺼냄
//            // poll 을 하지 않는 이유는, 아직 이 단어가 일치하는 card1, card2에 존재하는지 모르기 떄문
//            String stand = goalQueue.peek();
//            // 위의 이유와 마찬가지로 card1, card2에서 하나씩 꺼내봄
//            String peek1 = cardQueue1.peek();
//            String peek2 = cardQueue2.peek();
//            // 혹시 빈 큐에서 값을 꺼내볼수 있는 것이기에 만약 null이 반환된다면 빈 문자열 할당
//            if (peek1 == null) peek1 = "";
//            if (peek2 == null) peek2 = "";
//            // 만약 card1에서 꺼낸 값이 기준값과 같다면, 목표하는 단어와 같기에 poll 처리
//            if (peek1.equals(stand)) cardQueue1.poll();
//            // 만약 card2에서 꺼낸 값이 기준값과 같다면, 목표하는 단어와 같기에 poll 처리
//            else if (peek2.equals(stand)) cardQueue2.poll();
//            // 위 두가지 조건을 만족하지 않는다는 것은, 올바른 문장을 완성할 수 없음을 뜻함.
//            // No 처리 및 반복문 탈출
//            else {
//                answer = "No";
//                break;
//            }
//            // 목표 단어 poll 처리
//            goalQueue.poll();
//        }
//        // 결과값 반환
//        return answer;
//    }
//}

//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        // ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
//        String[] input1 = {
//                "Enter uid1234 Muzi",
//                "Enter uid4567 Prodo",
//                "Leave uid1234",
//                "Enter uid1234 Prodo",
//                "Change uid4567 Ryan"
//        };
//        String[] solution1 = solution(input1);
//        // ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
//        System.out.println("Arrays.toString(solution1) = " + Arrays.toString(solution1));
//    }
//
//    public static String[] solution(String[] record) {
//        String[] answer = {};
//        // map 변수 선언 (결과적으로, 닉네임이 어떻게 변경되었는지 최종적인 값을 담기 위함에 있음)
//        Map<String, String> map = new HashMap<>();
//        // 입력받은 문자열 자르기 위한 StringTokenizer 객체 생성
//        StringTokenizer st;
//        // 입력값을 반복문으로 순회
//        for (String rec : record) {
//            // 입력값 자르기
//            st = new StringTokenizer(rec);
//            String input1 = st.nextToken(); // Enter, Leave, Change
//            String input2 = st.nextToken(); // 아이디
//            String input3; // 닉네임
//            // 만약 Enter 라면, map 에 아이디와 닉네임을 넣음
//            if (input1.equals("Enter")) {
//                input3 = st.nextToken();
//                map.put(input2, input3);
//            } else if (input1.equals("Leave")) {
//                // 만약 Leave 라면, map 에 아이디를 넣을때, 기존에 변수에 존재하는 닉네임 값을 찾아서 넣음
//                map.put(input2, map.get(input2));
//            } else {
//                // Change 라면, 아이디 값에 맞는 덮어쓰기를 진행
//                input3 = st.nextToken();
//                map.put(input2, input3);
//            }
//        }
//
//        // 위 과정에서 최종적인 map 변수에 아이디와 키값이 존재함
//        // 해당 반복문을 통해, 결과값을 반환해야함
//        // 누가 들어왔고 나갔고의 문자열 생성을 위한 반복문
//        List<String> list = new ArrayList<>();
//        for (String rec : record) {
//            st = new StringTokenizer(rec);
//            String input1 = st.nextToken(); // Enter, Leave, Cahnge
//            String input2 = st.nextToken(); // 아이디
//            String nickname = map.get(input2);
//            String result;
//            // Enter, Leave 일떄만 문자열을 생성하면 됨, Change 는 할 필요가 없음
//            if (input1.equals("Enter")) {
//                result = nickname + "님이 들어왔습니다.";
//                list.add(result);
//            } else if (input1.equals("Leave")) {
//                result = nickname + "님이 나갔습니다.";
//                list.add(result);
//            }
//        }
//
//        // 배열로 만들어야 하는데 List Collection 을 위에서 사용했기에 배열로 변환
//        answer = new String[list.size()];
//        list.toArray(answer);
//
//        // 결과값 리턴
//        return answer;
//    }
//}


//import java.io.*;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        // 입력값을 선언함
//        int totalWeight = Integer.parseInt(br.readLine());
//        final int FIVE_VALUE = 5; // 나눌 값을 상수로 정의
//        final int THREE_VALUE = 3; // 나눌 값을 상수로 정의
//        int result = 0; // 출력할 결과값 선언
//
//        // [핵심 아이디이]
//        // 5kg 으로 나누어서 배달하는게 가장 적은 개수로 배달하는 경우이다.
//        // 하지만, 5kg로 나누어 배달하는 경우만 존재하는 것이 아니기에, 5kg로 나누어 지지 않는 경우
//        // 3kg로 하나 배달한다는 가정하에 총 무게 (totalWeight) 에서 -3 처리 후에, 다시 5kg로 나누어 지는지 확인
//        while (totalWeight > 0) {
//            int fiveRemain = totalWeight % FIVE_VALUE; // 나머지 값
//            int fiveMod = totalWeight / FIVE_VALUE; // 몫 값
//            // 만약 5kg로 나누어 떨어진다면
//            if (fiveRemain == 0) {
//                // 몫 만큼 결과값 + 후 반복문 종료
//                result += fiveMod;
//                break;
//            }
//            // 위 조건을 만족하지 않는다는 것은, 5kg로 나누어 떨어지지 않는다는 것
//            // 3kg 하나를 배달해야 함을 알 수 있음.
//            totalWeight -= THREE_VALUE;
//            result++;
//        }
//        // 만약에 총 무게가 0보다 작다는건, 5,3kg로 배달할수 없음을 알 수 있음
//        if (totalWeight < 0)result = -1; // -1로 반환
//
//        // 결과값 출력
//        bw.write(result + "");
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}

// 4790
// 1000 4 = 4000, 790
// 500 1 = 500, 290
// 100 2 = 200. 90
// 50 1 = 50, 40
// 10 4 = 40, 0


//import java.io.*;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int forCount = Integer.parseInt(br.readLine());
//        int[][] array = new int[forCount][2];
//        for (int i = 0; i < forCount; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            array[i][0] = Integer.parseInt(st.nextToken());
//            array[i][1] = Integer.parseInt(st.nextToken());
//        }
//
//        // 회의 정렬: 끝나는 시간 기준, 끝나는 시간이 같으면 시작 시간 기준
//        Arrays.sort(array, (a, b) -> {
//            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
//            return Integer.compare(a[1], b[1]);
//        });
//
//        System.out.println(Arrays.deepToString(array));
//
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}


//import java.io.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int input = Integer.parseInt(br.readLine());
//        int result = factorial(input);
//
//        bw.write(result + "");
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    public static int factorial(int n) {
//        if (n == 1) {
//            return n;
//        }
//        return n * factorial(n - 1);
//    }
//}

//import java.io.*;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//        int forCount = Integer.parseInt(br.readLine());
//        int[] array = new int[forCount + 1]; // 0번은 더미 데이터
//        for (int i = 0; i < forCount - 1; i++) {
//            st = new StringTokenizer(br.readLine());
//            int value1 = Integer.parseInt(st.nextToken()); // 부모 노드 값
//            int value2 = Integer.parseInt(st.nextToken()); // 노드 값
//            array[value2] = value1;
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(i + 1 + " : " + array[i + 1]);
//        }
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}

//import java.io.*;
//import java.util.ArrayDeque;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int first;
//    static int second;
//    static Queue<int[]> queue = new ArrayDeque<>();
//    static int[][] array;
//    static int[][] days;
//
//    // 상 하 좌 우
//    static int[] dx = {0, 0, -1, 1};
//    static int[] dy = {-1, 1, 0, 0};
//
//    public static void main(String[] args) throws IOException {
//        // 입츨력 스트림 변수 선언
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        // 입력받는 문자열 자르기 위한 StringTokenizer 객체 생성
//        StringTokenizer st;
//
//        // 입력값 자르기
//        st = new StringTokenizer(br.readLine());
//        first = Integer.parseInt(st.nextToken()); // 행
//        second = Integer.parseInt(st.nextToken()); // 열
//        array = new int[second][first]; // 토마토 상자 배열
//        days = new int[second][first]; // 토마토 상자에서 익은 토마토가 언제 익는지 체크하기 위한 변수 선언
//
//        // 입력값 받은것을 토마토 상자에 값을 넣음
//        for (int i = 0; i < second; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < first; j++) {
//                int value = Integer.parseInt(st.nextToken());
//                array[i][j] = value;
//                // 만약에 익은 토마토 값이라면
//                if (value == 1) {
//                    // bfs 에서 탐색하기 위한 익은 토마토의 위치 좌표값을 넣음
//                    queue.add(new int[]{i, j});
//                    // 익은 토마토는 0일로 설정
//                    // 차후에 bfs 로 상하좌우 전염시키면서 몇일쨰 날짜에 익게되었는지 마킹
//                    days[i][j] = 0;
//                } else if (value == 0) {
//                    // 익지않은 토마토니까 일단 -1로 할당함
//                    // 나중에 어차피 bfs 에서 몇일에 익은 토마토인지 날짜값을 할당함
//                    days[i][j] = -1;
//                }
//            }
//        }
//
//        // bfs 메서드 호출
//        int result = bfs();
//
//        // 결과값 출력
//        bw.write(result + "");
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    static int bfs() {
//        // bfs 의 기본 뼈대, 반복문을 순회하면서 큐에 담긴 익은 토마토의 좌표값을 꺼내서 상하 좌우값을 전염시킴
//        while (!queue.isEmpty()) {
//            // 큐에서 값을 꺼내기
//            int[] poll = queue.poll();
//            int x = poll[0];
//            int y = poll[1];
//            // 반복문을 통해 상하좌우 값 계산
//            for (int i = 0; i < 4; i++) {
//                int nx = x + dx[i];
//                int ny = y + dy[i];
//                // 만약 2차원 배열에서 벗어나는 값이 아니거나, 익지않은 토마토인 경우는 따로 체크하지 않음
//                if (nx >= 0 && nx < second && ny >= 0 && ny < first && days[nx][ny] == -1) {
//                    queue.add(new int[]{nx, ny});
//                    days[nx][ny] = days[x][y] + 1;
//                }
//            }
//        }
//
//        // 만약에 days 가 -1이 존재한다면, 익을수 없는 토마토가 존재한다고 판단.
//        for (int i = 0; i < second; i++) {
//            for (int j = 0; j < first; j++) {
//                if (days[i][j] == -1) {
//                    return -1;
//                }
//            }
//        }
//
//        // 이제 days 배열에서 가장 큰 값을 찾음
//        int MAX_VALUE = Integer.MIN_VALUE;
//        for (int i = 0; i < second; i++) {
//            for (int j = 0; j < first; j++) {
//                int value = days[i][j];
//                if (MAX_VALUE < value) {
//                    MAX_VALUE = value;
//                }
//            }
//        }
//
//        return MAX_VALUE;
//    }
//}

//import java.io.*;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int V, E, SUM;
//    static Edge[] edges;
//    static int[] parent;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        V = Integer.parseInt(st.nextToken()); // 정점의 개수
//        E = Integer.parseInt(st.nextToken()); // 간선의 개수
//
//        parent = new int[V + 1]; // 정점 배열 초기화 (문제에서 정점은 0번이 아니라 1번부터 시작임)
//        edges = new Edge[E]; // 간선 배열 초기화
//
//        // 입력값으로 받은 값 Edge 객체 생성처리
//        for (int i = 0; i < E; i++) {
//            st = new StringTokenizer(br.readLine());
//            int v1 = Integer.parseInt(st.nextToken());
//            int v2 = Integer.parseInt(st.nextToken());
//            int co = Integer.parseInt(st.nextToken());
//            // Edge 객체를 생성해서 배열에 담음
//            edges[i] = new Edge(v1, v2, co);
//        }
//        // 각 정점의 부모를 자기 자신으로 초기설정
//        makeSet();
//        // 가중치 값을 기준으로 오름차순 정렬
//        Arrays.sort(edges, (o1, o2) -> o1.c - o2.c);
//        // count 변수 선언 이유 : 선택한 간선의 수가 정점의 수 - 1값과 같을때 까지만 반복문이 실행되어야 함
//        int count = 0;
//        for (int i = 0; i < edges.length; i++) {
//            Edge edge = edges[i];
//            // union 메서드 호출하여 같은 집합인지 확인, 서로소인지를 확인하는 듯 함
//            // 명확하지는 않음.
//            if (union(edge.v1, edge.v2)) {
//                // 가중치 값을 합산 진행
//                SUM += edge.c;
//                count++;
//                // 만약 선택한 간선의 개수가 정점의 개수 - 1과 같으면 탈출
//                if (count == V - 1) {
//                    break;
//                }
//            }
//        }
//
//        // 결과값 출력
//        bw.write(SUM + "");
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    // 자기자신을 부모 노드로 설정하는 메서드
//    static void makeSet() {
//        for (int i = 1; i <= V; i++) {
//            parent[i] = i;
//        }
//    }
//
//    // 특정값의 부모를 찾는 메서드
//    static int findSet(int x) {
//        if (parent[x] == x) return x;
//        return parent[x] = findSet(parent[x]);
//    }
//
//    // 특정 값 두가지의 부모가 같은지 다른지 확인하는 메서드
//    // 만약 다르다면, 큰값이 작은값의 부모값을 할당받음, 그 반대의 경우 반대 처리 진행
//    static boolean union(int x, int y) {
//        int findX = findSet(x);
//        int findY = findSet(y);
//        if (findX == findY) return false;
//        if (findX < findY) parent[findY] = findX;
//        else parent[findX] = findY;
//        return true;
//    }
//
//    // 내뷰 클래스 선언
//    static class Edge {
//        int v1, v2, c;
//
//        public Edge(int v1, int v2, int c) {
//            this.v1 = v1;
//            this.v2 = v2;
//            this.c = c;
//        }
//
//        @Override
//        public String toString() {
//            return "Edge{" +
//                    "v1=" + v1 +
//                    ", v2=" + v2 +
//                    ", c=" + c +
//                    '}';
//        }
//    }
//}


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int R, C; // 가로 세로
    static boolean[] alphaVisit = new boolean[26]; // 알파벳 배열 선언 (방문 여부 확인)
    static int result; // 말이 지나온 칸 수
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] alphaBoard; // 입력값을 담을 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로 세로 변수 초기화
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 전역변수 초기화
        alphaBoard = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                alphaBoard[i][j] = charArray[j];
            }
        }

        // 메서드 호출
        // 문제에서 말의 시작점이 1행 1열에 놓여있는데, 좌측 상단의 칸도 포함된다고 했음
        dfs(0, 0, 1);
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    // 이 문제는 dfs 를 사용해야함
    // 이유 : 백트래킹을 사용해야함에도 이유가 있지만, 말이 상하좌우로 움직이면서 지금까지 나온 알파벳과는 다른 알파벳을 선택할 수 있어야 하기 때문
    static void dfs(int y, int x, int count) {
        // 백트래킹을 이용한 문제풀이 방식이기에 이전에 시도한 방식이
        // 더 많은 칸을 이동했을수도 있음
        // 그렇게에 최대값을 호출시에 무조건 담아놔야 함
        result = Math.max(result, count);

        // 현재 들어온 지점은 방문 처리 시킴
        alphaVisit[alphaBoard[y][x] - 'A'] = true;

        // 상 하 좌 우 값 탐색을 위한 반복문
        for (int i = 0; i < 4; i++) {
            // 현재 지점에서 갈 수 있는 좌표값 계싼
            int ny = y + dy[i];
            int nx = x + dx[i];

            // 상하좌우 격자에서 인덱스가 벗어나지 않으면서, 이동하고자 하는 좌표의 알파벳이 방문한적 없는 알파벳인 경우
            if (ny >= 0 && ny < R && nx >= 0 && nx < C
                    && !alphaVisit[alphaBoard[ny][nx] - 'A']) {
                // dfs 재호출
                dfs(ny, nx, count + 1);
            }
        }
        // 위 반복문을 통해 dfs 재귀호출이 이루어지지 않는다라는 것은 백 트래킹이 이루어 져야 한다는 것을 뜻함
        // 현재 좌표 방문을 false 처리
        alphaVisit[alphaBoard[y][x] - 'A'] = false;
    }
}