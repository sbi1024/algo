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


//import java.io.*;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int R, C; // 가로 세로
//    static boolean[] alphaVisit = new boolean[26]; // 알파벳 배열 선언 (방문 여부 확인)
//    static int result; // 말이 지나온 칸 수
//    static int[] dx = {-1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//    static char[][] alphaBoard; // 입력값을 담을 배열
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        // 가로 세로 변수 초기화
//        R = Integer.parseInt(st.nextToken());
//        C = Integer.parseInt(st.nextToken());
//
//        // 전역변수 초기화
//        alphaBoard = new char[R][C];
//        for (int i = 0; i < R; i++) {
//            char[] charArray = br.readLine().toCharArray();
//            for (int j = 0; j < charArray.length; j++) {
//                alphaBoard[i][j] = charArray[j];
//            }
//        }
//
//        // 메서드 호출
//        // 문제에서 말의 시작점이 1행 1열에 놓여있는데, 좌측 상단의 칸도 포함된다고 했음
//        dfs(0, 0, 1);
//        bw.write(result + "");
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    // 이 문제는 dfs 를 사용해야함
//    // 이유 : 백트래킹을 사용해야함에도 이유가 있지만, 말이 상하좌우로 움직이면서 지금까지 나온 알파벳과는 다른 알파벳을 선택할 수 있어야 하기 때문
//    static void dfs(int y, int x, int count) {
//        // 백트래킹을 이용한 문제풀이 방식이기에 이전에 시도한 방식이
//        // 더 많은 칸을 이동했을수도 있음
//        // 그렇게에 최대값을 호출시에 무조건 담아놔야 함
//        result = Math.max(result, count);
//
//        // 현재 들어온 지점은 방문 처리 시킴
//        alphaVisit[alphaBoard[y][x] - 'A'] = true;
//
//        // 상 하 좌 우 값 탐색을 위한 반복문
//        for (int i = 0; i < 4; i++) {
//            // 현재 지점에서 갈 수 있는 좌표값 계싼
//            int ny = y + dy[i];
//            int nx = x + dx[i];
//
//            // 상하좌우 격자에서 인덱스가 벗어나지 않으면서, 이동하고자 하는 좌표의 알파벳이 방문한적 없는 알파벳인 경우
//            if (ny >= 0 && ny < R && nx >= 0 && nx < C
//                    && !alphaVisit[alphaBoard[ny][nx] - 'A']) {
//                // dfs 재호출
//                dfs(ny, nx, count + 1);
//            }
//        }
//        // 위 반복문을 통해 dfs 재귀호출이 이루어지지 않는다라는 것은 백 트래킹이 이루어 져야 한다는 것을 뜻함
//        // 현재 좌표 방문을 false 처리
//        alphaVisit[alphaBoard[y][x] - 'A'] = false;
//    }
//}

//import java.io.*;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int row, col; // 격자판의 행과 열의 수
//    static Shark[][] sharkMap; // 상어가 존재하는 위치를 기록하는 변수
//    static int sharkTotalSize; // 결과값으로 도출할 낚시왕이 잡은 상어의 총 크기
//    static int moveX = -1; // 낚시꾼이 위치한 현재 x 위치
//    static int moveY = 0; // 낚시꾼이 위치한 현재 y 위치
//
//    public static void main(String[] args) throws IOException {
//        // 입력값을 받을 stream 선언
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        row = Integer.parseInt(st.nextToken()); // 격자판의 행의 개수
//        col = Integer.parseInt(st.nextToken()); // 격자판의 열의 개수
//        int sharkCount = Integer.parseInt(st.nextToken()); // 격자판에 존재하는 상어의 개수
//
//        if (sharkCount != 0) {
//            sharkMap = new Shark[row][col]; // 상어가 어디에 존재하는지 뱅려 선언
//            for (int i = 0; i < sharkCount; i++) {
//                // 입력값 파싱
//                st = new StringTokenizer(br.readLine());
//                int indexX = Integer.parseInt(st.nextToken()); // x 좌표
//                int indexY = Integer.parseInt(st.nextToken()); // y 좌표
//                int speed = Integer.parseInt(st.nextToken()); // 속력
//                int direction = Integer.parseInt(st.nextToken()); // 방향
//                int size = Integer.parseInt(st.nextToken()); // 크기
//                // 값 할당
//                sharkMap[indexX - 1][indexY - 1] = new Shark(speed, direction, size);
//            }
//            // 문제에서 주어진 조건 메서드 실행
//            simulation();
//        }
//
//        // 결과값 출력
//        bw.write(sharkTotalSize + "");
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    static void simulation() {
//        // 조건문 변경이 필요할 수도 있음.
//        while (moveX != col - 1) {
//            // 1. 낚시왕이 오른쪽으로 한칸 이동한다.
//            moveX++;
//            // 2-1. 낚시왕이 있는 현재 위치에서의 상어 중에서 가장 땅과 가까운 상어를 잡는다.
//            for (int i = 0; i < row; i++) {
//                // 땅과 가장 가까운 상어
//                Shark shark = sharkMap[i][moveX];
//                // 만약 존재하지 않는다면 다음 값을 찾는다
//                if (shark == null) continue;
//                // 2-2. 존재한다면, 해당 위치의 상어를 격자판에서 지운다.
//                sharkMap[i][moveX] = null;
//                // 그 후 상어는 낚시왕이 잡은것이니, 해당 값을 sharkTotalSize 에 더한다.
//                sharkTotalSize += shark.getSize();
//                // break (찾으면 더이상 진행하지 않음)
//                break;
//            }
//            // 3. 상어가 이동한다.
//            moveShark();
//        }
//    }
//
//    // 상어가 이동할떄의 시물레이션 메서드
//    static void moveShark() {
//        // 1. 상어는 주어진 속도로 이동한다.
//        // 2. 상어가 이동하려고 하는 칸이 격자판의 경계를 넘는 경우 방향을 반대로 바꾼 후 이동한다.
//        // 3. 상어가 이동을 마친 후에, 한칸에 상어가 두마리 이상인 경우, 크기가 가장 큰 상어가 나머지 상어를 모두 잡아먹는다.
//        // 방향은 1 : 위, 2 : 아래, 3 : 오른쪽, 4 : 왼쪽
//
//        // 임시 배열 생성
//        // 키보인트, 새로운 배열을 생성해서 담아야함
//        // 그 이유는, 문제에서 주어진 조건이 상어기 이동을 마치고 나서, 한칸에 상어가 두마리 이상인 경우 큰 상어가 작은 상어를 잡아먹는 조건
//        // 결국 기존 배열의 상어 위치는 유지하고, 처리진행
//        Shark[][] newSharkMap = new Shark[row][col];
//
//        // 반복문을 돌면서, 상어를 이동시킴 (차후 상어가 위치한 좌표값만 큐에 담아두고 메서드 수정을 하는게 좋아보이기는 함)
//        for (int y = 0; y < row; y++) {
//            for (int x = 0; x < col; x++) {
//                Shark shark = sharkMap[y][x];
//                // null 이라는 것은 상어가 미존재
//                if (shark == null) continue;
//                // null 이 아닌 경우, 상어가 존재, 해당 상어 격자를 벗어났는지 확인 및, 방향성 체크
//
//                int direction = shark.getDirection(); // 상어의 방향성
//                int speed = shark.getSpeed(); // 상어의 속력
//                int plusY = y;
//                int plusX = x;
//
//                // *** 별도 처리 부분 ***
//                for (int i = 0; i < speed; i++) {
//                    if (direction == 1) {
//                        // 위
//                        if (plusY == 0) {
//                            direction = 2; // 아래로 변경
//                        } else {
//                            plusY--;
//                            continue;
//                        }
//                        plusY++;
//                    }
//                    else if (direction == 2) {
//                        // 아래
//                        if (plusY == row - 1) {
//                            direction = 1; // 위로 변경
//                        } else {
//                            plusY++;
//                            continue;
//                        }
//                        plusY--;
//                    }
//                    else if (direction == 3) {
//                        // 오른쪽
//                        if (plusX == col - 1) {
//                            direction = 4; // 왼쪽으로 변경
//                        } else {
//                            plusX++;
//                            continue;
//                        }
//                        plusX--;
//                    }
//                    else {
//                        // 왼쪽
//                        if (plusX == 0) {
//                            direction = 3; // 오른쪽으로 변경
//                        } else {
//                            plusX--;
//                            continue;
//                        }
//                        plusX++;
//                    }
//                }
//                // *** 공통 처리 부분 ***
//                shark.setDirection(direction);
//                // 해당 위치에 이미 다른 상어가 있으면 크기 비교
//                if (newSharkMap[plusY][plusX] == null) {
//                    newSharkMap[plusY][plusX] = shark; // 그냥 넣음
//                } else {
//                    // 이미 있으면 크기 비교
//                    if (newSharkMap[plusY][plusX].getSize() < shark.getSize()) {
//                        newSharkMap[plusY][plusX] = shark;
//                    }
//                }
//            }
//        }
//        // 이동 처리된 상어의 배열을 기존 전역변수에 담음
//        sharkMap = newSharkMap;
//    }
//
//
//    // 상어 객체가 가지고 있는 정보를 담을 class 선언
//    static class Shark {
//        int speed; // 속력
//        int direction; // 방향
//        int size; // 크기
//
//        // 생성자를 통한 객체 생성
//        public Shark(int speed, int direction, int size) {
//            this.speed = speed;
//            this.direction = direction;
//            this.size = size;
//        }
//
//        // 출력값을 확인하기 위한 오버라이딩
//        @Override
//        public String toString() {
//            return "Shark{" +
//                    "speed=" + speed +
//                    ", direction=" + direction +
//                    ", size=" + size +
//                    '}';
//        }
//
//        // 메서드로 값 반환
//
//        public int getSpeed() {
//            return speed;
//        }
//
//        // 메서드로 값 반환
//        public int getDirection() {
//            return direction;
//        }
//
//        // 방향은 격자를 벗어난다면 바꿔져야 함
//        public void setDirection(int direction) {
//            this.direction = direction;
//        }
//
//        // 메서드로 값 반환
//        public int getSize() {
//            return size;
//        }
//    }
//}


//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    // 입력값
//    static int N, M;
//    static int r, c, d;
//    // -1: 청소됨. 0: 청소안됨. 1: 벽
//    static int[][] room;
//    // 북동남서 0 1 2 3
//    static int[] dy = {-1, 0, 1, 0};
//    static int[] dx = {0, 1, 0, -1};
//    // 청소한 칸 수
//    static int cnt = 0;
//
//    public static void main(String[] args) throws Exception {
//        // 입력값 처리
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        room = new int[N][M];
//
//        st = new StringTokenizer(br.readLine());
//        r = Integer.parseInt(st.nextToken());
//        c = Integer.parseInt(st.nextToken());
//        d = Integer.parseInt(st.nextToken());
//
//        // 입력값 할당
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < M; j++) {
//                room[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        while (true) {
//            // 1. 청소되지 않은 경우: 청소
//            if (room[r][c] == 0) {
//                room[r][c] = -1;
//                cnt++;
//            }
//
//            boolean Empty = false;
//            // 사방에 청소된 곳 있는지 여부 탐색 (사방탐색)
//            for (int d = 0; d < 4; d++) {
//                int ny = r + dy[d];
//                int nx = c + dx[d];
//                // 청소된 곳이거나 벽이면 skip
//                if (ny < 0 || ny >= N || nx < 0 || nx >= M || room[ny][nx] != 0) continue;
//                // 아니라면, 반복문 탈출
//                Empty = true;
//                break;
//            }
//            // 2. 사방이 모두 청소되었을 경우
//            if (!Empty) {
//                // 후진 계산
//                int ny = r + dy[(d + 2) % 4];
//                int nx = c + dx[(d + 2) % 4];
//
//                // 후진할 수 없는 경우 : 종료조건 (벽이거나, 격자를 벗어나거나)
//                if (ny < 0 || ny >= N || nx < 0 || nx >= M || room[ny][nx] == 1) break;
//
//                // 후진할 수 있으면 후진
//                r = ny;
//                c = nx;
//            }
//            // 3. 사방에 청소되지 않은 빈칸 있는 경우
//            else {
//                // 반시계 계산
//                d = (d + 3) % 4;
//                int ny = r + dy[d];
//                int nx = c + dx[d];
//
//                // 전진할 수 없거나, 청소되지 않은 빈칸 없을 경우
//                if (ny < 0 || ny >= N || nx < 0 || nx >= M || room[ny][nx] != 0) continue;
//
//                // 전진
//                r = ny;
//                c = nx;
//            }
//        }
//        // 결과값 출력
//        System.out.println(cnt);
//    }
//}

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int K, W, H;
//    static int[][] map;
//    static boolean[][][] visit;
//
//    // 상 하 좌 우
//    static int[] dy = {-1, 1, 0, 0};
//    static int[] dx = {0, 0, -1, 1};
//    // 말의 움직임 8방
//    static int[] hdy = {-2, -2, -1, -1, 2, 2, 1, 1};
//    static int[] hdx = {-1, 1, -2, 2, -1, 1, -2, 2};
//
//    // bfs queue
//    static Queue<Node> queue = new ArrayDeque<>();
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        K = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        W = Integer.parseInt(st.nextToken());
//        H = Integer.parseInt(st.nextToken());
//
//        map = new int[H][W];
//        visit = new boolean[H][W][K + 1];
//
//        for (int i = 0; i < H; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < K; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        // bfs
//        bfs();
//    }
//
//    static void bfs() {
//        // 시작점 좌표, K 이동 큐에 담는다. visit 도 함께
//        visit[0][0][K] = true;
//        queue.offer(new Node(0, 0, K, 0));
//
//        while (!queue.isEmpty()) {
//            Node node = queue.poll();
//
//            // 목표 도달
//            if (node.y == H - 1 && node.x == W - 1) {
//                System.out.println(node.d);
//                return;
//            }
//
//            // 탐색 1 - 상하좌우
//            for (int i = 0; i < 4; i++) {
//                int ny = node.y + dy[i];
//                int nx = node.y + dx[i];
//                if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][node.k]) continue;
//                visit[ny][nx][node.k] = true;
//                queue.offer(new Node(ny, nx, node.k, node.d + 1));
//            }
//
//            // 탐색 2 - 말처럼 이동
//            if (node.k == 0) continue;
//            for (int i = 0; i < 8; i++) {
//                int ny = node.y + hdy[i];
//                int nx = node.y + hdx[i];
//                if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][node.k - 1]) continue;
//                visit[ny][nx][node.k - 1] = true;
//                queue.offer(new Node(ny, nx, node.k - 1, node.d + 1));
//            }
//        }
//
//        System.out.println(-1);
//    }
//
//    static class Node {
//        int y, x, k, d;
//
//        public Node(int y, int x, int k, int d) {
//            this.y = y;
//            this.x = x;
//            this.k = k;
//            this.d = d;
//        }
//    }
//}

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    static int N, M, max;
//    // 처음 데이터 유지, 복사해서 벽 바이러스 작업 수행
//    // 벽을 세우는 좌표는 0에서 3개르 조합
//    static int[][] map, copyMap;
//    static List<Node> zero = new ArrayList<>(); // 0 인 좌표
//    static List<Node> virus = new ArrayList<>(); // 2 인 좌표 (바이러스)
//    static int zeroSize;
//    static Node[] wall = new Node[3]; // zero 에서 선택한 조합
//    static int[] dy = {-1, 1, 0, 0};
//    static int[] dx = {0, 0, -1, 1};
//    static Queue<Node> queue = new ArrayDeque<>();
//
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        map = new int[N][M];
//        copyMap = new int[N][M];
//
//        max = Integer.MIN_VALUE;
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < M; j++) {
//                int n = Integer.parseInt(st.nextToken());
//                map[i][j] = n;
//                if (n == 0) zero.add(new Node(i, j)); // 0
//                else if (n == 2) virus.add(new Node(i, j)); // 바이러스
//            }
//        }
//
//        zeroSize = zero.size();
//        comb(0, 0);
//        System.out.println(max);
//    }
//
//    static void comb(int srcIdx, int tgtIdx) {
//        if (tgtIdx == 3) {
//            // 조합완성
//            check();
//            return;
//        }
//        if (srcIdx == zeroSize) return;
//
//        wall[tgtIdx] = zero.get(srcIdx);
//
//        comb(srcIdx + 1, tgtIdx + 1);
//        comb(srcIdx + 1, tgtIdx);
//    }
//
//    static void check() {
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                copyMap[i][j] = map[i][j];
//            }
//        }
//
//        for (int i = 0; i < 3; i++) {
//            int y = wall[i].y;
//            int x = wall[i].x;
//            copyMap[y][x] = 1;
//        }
//
//        queue.addAll(virus);
//
//        while (!queue.isEmpty()) {
//            Node n = queue.poll();
//            for (int d = 0; d < 4; d++) {
//                int ny = n.y + dy[d];
//                int nx = n.y + dx[d];
//                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
//                if (copyMap[ny][nx] == 0) {
//                    copyMap[ny][nx] = 2;
//                    queue.offer(new Node(ny, nx));
//                }
//            }
//        }
//
//        int sum = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (copyMap[i][j] == 0) sum++;
//            }
//        }
//
//        max = Math.max(Main.max, sum);
//    }
//
//    static class Node {
//        int y, x;
//
//        public Node(int y, int x) {
//            this.y = y;
//            this.x = x;
//        }
//    }
//}

//import java.io.*;
//import java.util.*;
//
//public class Main {
//    static int N, M; // 격자의 행과 열
//    static int[][] map; // 격자판 2차원 배열
//    static List<Node> zeroList = new ArrayList<>(); // 조합을 구해야하는데, 벽을 세울수 있는 위치 Node 를 리스트 변수로 관리
//    static List<Node> virusList = new ArrayList<>();
//    static boolean[] zeroVisit;
//    static Node[] selectZero = new Node[3];
//    static int[] dy = {-1, 1, 0, 0}; // 상 하 좌 우
//    static int[] dx = {0, 0, -1, 1}; // 상 하 좌 우
//    static int result = Integer.MIN_VALUE; // 안전지대 값
//
//
//    public static void main(String[] args) throws IOException {
//        // 입출력 스트림 생성
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken()); // 행의 값 할당
//        M = Integer.parseInt(st.nextToken()); // 열의 값 할당
//
//        map = new int[N][M]; // 격자판 초기화
//        // map 데이터 할당
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < M; j++) {
//                int value = Integer.parseInt(st.nextToken());
//                map[i][j] = value;
//                // 만약 빈 공간이라면, 이부분에 벽을 세울수 있으니 list 에 담는다.
//                if (value == 0) zeroList.add(new Node(i, j));
//                else if (value == 2) virusList.add(new Node(i, j));
//            }
//        }
//
//        // 방문 배열 초기화
//        zeroVisit = new boolean[zeroList.size()];
//
//        // 조합을 찾는다
//        comb(0, 0);
//
//        // 결과값 출력
//        bw.write(result + "");
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    // 사실상 dfs 다만,기저조건에서 bfs 호출
//    static void comb(int depth, int startIndex) {
//        if (depth == 3) {
//            // 여기서 bfs 호출하고 호출된 메서드에서 result 비교
//            bfs();
//            return;
//        }
//        // 방문 여부에 따라 호출
//        for (int i = startIndex; i < zeroList.size(); i++) {
//            if (!zeroVisit[i]) {
//                selectZero[depth] = zeroList.get(i);
//                zeroVisit[i] = true;
//                comb(depth + 1, i + 1);
//                zeroVisit[i] = false;
//            }
//        }
//    }
//
//    // 바이러스가 전염될때 어떻게 map 이 변화될지 확인
//    static void bfs() {
//        // 새로운 배열 생성 (처음에 얕은복사로 했다가, 깊은복사로 코드 변경했음)
//        // 주소값만 새롭게 옮기면 안됨, 원본 map이 변경됨
//        int[][] copyMap = new int[N][M];
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                copyMap[i][j] = map[i][j];
//            }
//        }
//        // 새로운 copyMap 에 조합에서 선택된 벽을 생성해봄
//        for (Node node : selectZero) {
//            copyMap[node.y][node.x] = 1;
//        }
//        // bfs 에 사용할 큐 생성
//        Queue<Node> queue = new ArrayDeque<>(virusList);
//        while (!queue.isEmpty()) {
//            Node poll = queue.poll();
//            // 사방 탐색 필요
//            for (int i = 0; i < 4; i++) {
//                int ny = poll.y + dy[i];
//                int nx = poll.x + dx[i];
//                // 격자판을 벗어나면 전파 못함
//                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
//                // 벽이라면 전염 못함, 근데 바이러스를 만나면 어떻게 처리해야 하지?
//                if (copyMap[ny][nx] == 1 || copyMap[ny][nx] == 2) continue;
//                // 2로 변경처리 후, 전염된 위치라면 queue 에 담는다.
//                copyMap[ny][nx] = 2;
//                queue.offer(new Node(ny, nx));
//            }
//        }
//        // 안전지대 확인
//        checkSafeZone(copyMap);
//    }
//
//    static void checkSafeZone(int[][] copyMap) {
//        int sum = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (copyMap[i][j] == 0) {
//                    sum++;
//                }
//            }
//        }
//
//        result = Math.max(result, sum);
//    }
//
//    // Node 객체 선언
//    static class Node {
//        int y, x;
//
//        // 생성자 호출
//        public Node(int y, int x) {
//            this.y = y;
//            this.x = x;
//        }
//
//        @Override
//        public String toString() {
//            return "Node{" +
//                    "y=" + y +
//                    ", x=" + x +
//                    '}';
//        }
//    }
//}


//import java.io.*;
//import java.util.ArrayDeque;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main {
//    // 말처럼 움직일 수 있는 횟수, 행, 열 값
//    static int K, W, H;
//    static int[][] map;
//    static boolean[][][] visitMap;
//    static int[] dy = {-1, 1, 0, 0}; // 상 하 좌 우
//    static int[] dx = {0, 0, -1, 1}; // 상 하 좌 우
//    static int[] hdy = {-2, -2, -1, -1, 2, 2, 1, 1}; // 말의 움직임
//    static int[] hdx = {-1, 1, -2, 2, -1, 1, -2, 2}; // 말의 움직임
//
//    public static void main(String[] args) throws IOException {
//        // 입출력 스트림 생성
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//
//        // 변수 초기화
//        K = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        W = Integer.parseInt(st.nextToken());
//        H = Integer.parseInt(st.nextToken());
//        map = new int[H][W];
//        visitMap = new boolean[H][W][K + 1];
//
//        // map 데이터 할당
//        for (int i = 0; i < H; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < W; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        // bfs 호출
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
//        Queue<Node> queue = new ArrayDeque<>();
//        visitMap[0][0][K] = true;
//        queue.offer(new Node(0, 0, K, 0));
//
//        while (!queue.isEmpty()) {
//            Node poll = queue.poll();
//            int y = poll.y;
//            int x = poll.x;
//            int distance = poll.distance;
//
//            // 기저 조건
//            if (y == H - 1 && x == W - 1) {
//                return distance;
//            }
//
//            // 상하좌우 이동
//            for (int i = 0; i < 4; i++) {
//                int ny = y + dy[i];
//                int nx = x + dx[i];
//
//                if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visitMap[ny][nx][poll.k])
//                    continue;
//
//                visitMap[ny][nx][poll.k] = true;
//                queue.offer(new Node(ny, nx, poll.k, poll.distance + 1));
//            }
//
//            // 말의 움직임
//            if (poll.k > 0) { // K가 남아있을 때만 사용 가능
//                for (int i = 0; i < 8; i++) {
//                    int ny = poll.y + hdy[i];
//                    int nx = poll.x + hdx[i];
//
//                    if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visitMap[ny][nx][poll.k - 1])
//                        continue;
//
//                    visitMap[ny][nx][poll.k - 1] = true;
//                    queue.offer(new Node(ny, nx, poll.k - 1, poll.distance + 1));
//                }
//            }
//        }
//
//        return -1;
//    }
//
//    static class Node {
//        int y;
//        int x;
//        int k;
//        int distance;
//
//
//        public Node(int y, int x, int k, int distance) {
//            this.y = y;
//            this.x = x;
//            this.k = k;
//            this.distance = distance;
//        }
//    }
//}

/*
import java.io.*;
import java.util.*;

public class Main {
    static int N; // 구역구 개수
    static int[] zoneArray;
    static int[] personArray; // 인구수 배열
    static boolean[][] linkArray; // 각 구역의 연결 상태 관리 배열
    static List<Integer> selectList = new ArrayList<>(); // 선택된 구역
    static List<Integer> notSelectList = new ArrayList<>(); // 선택된 구역

    static boolean[] visitArray; // 방문한 구역
    static int tempCount;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 입출력 스트림 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 변수 값 할당
        N = Integer.parseInt(st.nextToken());
        zoneArray = new int[N];
        personArray = new int[N];
        visitArray = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < personArray.length; i++) {
            zoneArray[i] = i + 1;
            personArray[i] = Integer.parseInt(st.nextToken());
        }

        // 각 구역에 연결된 구역 체크
        linkArray = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int index = Integer.parseInt(st.nextToken());
                linkArray[i][index - 1] = true;
            }
        }

        // 1개의 조합부터 N - 1 까찌의 조합을 짜봄
        // N - 1은 전부 다 선택하는 조합이기에 해볼 필요가 없음 어차피 두구역으로 안나누어짐
        for (int i = 0; i < N - 1; i++) {
            tempCount = i + 1;
            comb(0);
        }

        if (result == Integer.MAX_VALUE) {
            result = -1;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void comb(int startIndex) {
        if (tempCount == selectList.size()) {
            notSelectList.clear(); // 이전 결과 초기화
            for (int i = 1; i <= N; i++) { // 전체 구역에서 selectList에 없는 값 찾기
                if (!selectList.contains(i)) {
                    notSelectList.add(i);
                }
            }
            boolean check1 = check(selectList);
            boolean check2 = check(notSelectList);

            // 둘다 나누어진 두가지 구역이라면
            if (check1 && check2) {
                int result1 = 0;
                int result2 = 0;
                for (int i = 0; i < selectList.size(); i++) {
                    result1 += personArray[selectList.get(i) - 1];
                }

                for (int i = 0; i < notSelectList.size(); i++) {
                    result2 += personArray[notSelectList.get(i) - 1];
                }
                int abs = Math.abs(result1 - result2);
                result = Math.min(result, abs);
                return;
            }
            return;
        }

        for (int i = startIndex; i < N; i++) {
            if (!visitArray[i]) {
                selectList.add(i + 1);
                visitArray[i] = true;
                comb(i + 1);
                visitArray[i] = false;
                selectList.remove(selectList.size() - 1);
            }
        }
    }

    // check 조건 명확화
    // 기존의 메서드는 불확실함
    // 변경 포인트 : 인자값으로 전달받는 list 에서의 연결 여부 확인
    public static boolean check(List<Integer> list) {
        if (list.isEmpty()) {
            return false;
        }

        boolean[] tempVisit = new boolean[N];
        Queue<Integer> queue = new ArrayDeque<>();
        int startValue = list.get(0);
        queue.offer(startValue);
        tempVisit[startValue - 1] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            count++;

            for (int i = 0; i < list.size(); i++) {
                Integer value = list.get(i);
                if (!tempVisit[value - 1] && linkArray[poll - 1][value - 1]) {
                    queue.offer(value);
                    tempVisit[value - 1] = true;
                }
            }
        }

        return count == list.size();
    }
}*/


//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//// 완탐 - dfs
//public class Main {
//    static int N, cnt;
//    static int[][] map;
//    // delta
//    // 현재 방향에 따라 다음 이동 방향이 제한 <= 현재 방향에 따른 y, x 의 변화량
//    // 현재 -> 다음
//    static int[][][] delta = {
//            {{1, 1}, {0, 1}, {1, 0}}, // 대각선 0 => 대각선, 가로, 세로
//            {{1, 1}, {0, 1}, {0, 0}}, // 가로 1  => 대각선, 가로, 세로 (dummy)
//            {{1, 1}, {0, 0}, {1, 0}}  // 세로 2  => 대각선, 가로(dummy), 세로
//    };
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//
//        map = new int[N + 1][N + 1]; // 0 dummy
//
//        for (int i = 1; i <= N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 1; j <= N; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        // 풀이 dfs
//        dfs(1, 2, 1); // 1,2 좌표에서 가로 로 시작
//
//        System.out.println(cnt);
//    }
//
//    static void dfs(int y, int x, int d) { // d: 현재 y,x 좌표에 놓여진 방향
//
//        // 현재 좌표가 N, N 확인
//        if (y == N && x == N) {
//            cnt++;
//            return;
//        }
//
//        // delta 를 이용한 탐색 이어나간다. for 문이 기저조건 역할
//        for (int i = 0; i < 3; i++) { // i 는 대각선, 가로, 세로
//
//            int ny = y + delta[d][i][0];
//            int nx = x + delta[d][i][1];
//
//            // dummy ( 가면 안되는 방향 ) 처리
//            if (y == ny && x == nx) continue;
//
//            // 범위
//            if (ny > N || nx > N || map[ny][nx] == 1) continue; // 참고로 visit 필요 X
//
//            // 대각선 이동의 측면
//            if (i == 0 && (map[ny][nx - 1] == 1 || map[ny - 1][nx] == 1)) continue;
//
//            dfs(ny, nx, i);
//        }
//    }
//}


//public class Main {
//    public static void main(String[] args) {
//        int[] schedules1 = {700, 700, 1100};
//        int[][] timeLogs1 = {
//                {710, 2359, 1050, 700, 650, 631, 659},
//                {800, 801, 805, 800, 759, 810, 809},
//                {1105, 1001, 1002, 600, 1059, 1001, 1100}
//        };
//        int startDay1 = 5;
//        int solution1 = solution(schedules1, timeLogs1, startDay1);
//        System.out.println("solution1 = " + solution1);
//
//        int[] schedules2 = {730, 855, 700, 720};
//        int[][] timeLogs2 = {
//                {710, 700, 650, 735, 700, 931, 912},
//                {908, 901, 805, 815, 800, 831, 835},
//                {705, 701, 702, 705, 710, 710, 711},
//                {707, 731, 859, 913, 934, 931, 905}
//        };
//        int startDay2 = 1;
//        int solution2 = solution(schedules2, timeLogs2, startDay2);
//        System.out.println("solution2 = " + solution2);
//    }
//
//    public static int solution(int[] schedules, int[][] timelogs, int startday) {
//        int answer = 0;
//
//        for (int i = 0; i < timelogs.length; i++) {
//            int standTime = calcStandTime(schedules[i]);
//            boolean flag = true;
//            int currentDay = startday;
//            for (int j = 0; j < timelogs[i].length; j++) {
//                // 주말 인 경우는 무조건 통과
//                if (currentDay % 7 == 6 || currentDay % 7 == 0) {
//                    currentDay++;
//                    continue;
//                }
//                // 시간이 넘어간 경우
//                if (timelogs[i][j] > standTime) {
//                    flag = false;
//                    break;
//                }
//                currentDay++;
//            }
//            if (flag) answer++;
//        }
//
//
//        return answer;
//    }
//
//    public static int calcStandTime(int tempTime) {
//        int time = tempTime / 100;
//        int minute = (tempTime % 100) + 10;
//
//        // 60 분을 넘어가는 경우
//        if (minute >= 60) {
//            minute -= 60;
//            time += 1;
//        }
//        // 24시를 넘어가는 경우
//        if (time >= 24) {
//            time -= 24;
//        }
//
//        return time * 100 + minute;
//    }
//}

//import java.io.*;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int N, M, D; // 격자판 행, 열, 궁수의 공격 거리 제한 변수
//    static int[][] map; // 격자판 2차원 배열 생성, 궁수는 N + 1 행에 위치
//
//    // 조합 관련된 변수 선언
//    static int[] archer; // 궁수
//    static boolean[] visit; // 방문 여부 확인
//    static int[] selectArcher = new int[3]; // 선택된 궁수의 위치
//
//    static int[] dy = {-1, -1, -1};
//    static int[] dx = {-1, 0, 1};
//
//    // 결과값
//    static int result = Integer.MIN_VALUE;
//
//
//    public static void main(String[] args) throws IOException {
//        // 입출력 스트림 생성
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        // 변수 할당
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken()); // 행 할당
//        M = Integer.parseInt(st.nextToken()); // 열 할당
//        D = Integer.parseInt(st.nextToken()); // 궁수의 거리 제한 할당
//        map = new int[N + 1][M]; // 궁수의 위치는  N + 1에 위치 (0 : 아무것도 없음, 1 : 적군의 위치, 2: 성, 궁수 위치)
//
//        // map 변수 할당 (마지막 행은, 성과 궁수가 위치)
//        for (int i = 0; i < map.length - 1; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < map[i].length; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        // 조합 실행
//        archer = new int[M];
//        for (int i = 0; i < archer.length; i++) archer[i] = i;
//        visit = new boolean[M];
//        comb(0, 0);
//
//        // 출력
//
//        bw.write(result + "");
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    // 조합의 경우를 구함, 궁수가 위차하는 경우의 수에서 시뮬레이션을 실행해야 함
//    public static void comb(int depth, int startIndex) {
//        // 기저조건
//        // 5개 중에 3개를 전부 다 뽑았을 경우
//        if (depth == 3) {
//            // 여기서 해당 조합을 결과값을 가지고 궁수를 배치하여 시뮬레이션 실행
//            simulation();
//            return;
//        }
//
//        // dfs 실행
//        for (int i = startIndex; i < archer.length; i++) {
//            if (!visit[i]) {
//                selectArcher[depth] = archer[i];
//                visit[i] = true;
//                comb(depth + 1, i + 1);
//                visit[i] = false;
//            }
//        }
//    }
//
//    public static void simulation() {
//        // 1. 가장 먼저 조합으로 뽑은 궁수의 위치를 map 에 할당한다.
//        // 궁수의 위치는 2로 표현
//        for (int i = 0; i < 3; i++) map[N][selectArcher[i]] = 2;
//
//        int[][] copyMap = makeCopyMap(map);
//
//        int removeEnemy = 0;
//
//        // 2. 반복문을 탈출하는 조건은 적군이 map 에 존재하는지 판단
//        while (checkEnemy(copyMap)) {
//            // 3. 궁수의 위치가 표현이 되었고, 적을 공격해서 제거해야함.
//            // 이때 궁수는 자신의 위치에서 가장 가까운 위치의 적을 제거 (거리가 D 이하인 적)
//            for (int archerCol : selectArcher) {
//                PriorityQueue<Target> targets = new PriorityQueue<>((t1, t2) -> {
//                    if (t1.distance != t2.distance) {
//                        return t1.distance - t2.distance;
//                    }
//                    return t1.x - t2.x;
//                });
//
//                for (int r = 0; r < N; r++) {
//                    for (int c = 0; c < M; c++) {
//                        if (copyMap[r][c] == 1) { // 적이 있으면
//                            int dist = Math.abs(N - r) + Math.abs(archerCol - c);
//                            if (dist <= D) { // 공격 범위 내라면
//                                targets.offer(new Target(r, c, dist));
//                            }
//                        }
//                    }
//                }
//
//                // 우선순위 큐에서 가장 우선순위가 높은(조건에 맞는) 적 선택
//                if (!targets.isEmpty()) {
//                    Target target = targets.poll();
//                    copyMap[target.y][target.x] = 0;
//                    removeEnemy++;
//                }
//            }
//
//            // 3. 궁수가 적군을 제거하고, 적군은 한칸 내려옴
//            // 마지막 행 부터 체크해야함
//            for (int i = N - 1; i >= 0; i--) {
//                for (int j = 0; j < M; j++) {
//                    if (copyMap[i][j] == 1) {
//                        // 현재 위치를 빈 공간 (0) 으로 만들고, 다음 위치로 이동
//                        copyMap[i][j] = 0;
//                        // 성에 도달하였으니, 따로 작업할 이유 없음
//                        if (i + 1 < N) {
//                            // 적군 위치 할당
//                            copyMap[i + 1][j] = 1;
//                        }
//                    }
//                }
//            }
//        }
//
//        // 결과값 갱신
//        result = Math.max(result, removeEnemy);
//
//        // 마지막 행 궁수 위치 초기화
//        for (int i = 0; i < M; i++) {
//            map[N][i] = 0;
//        }
//    }
//
//    // 복사 배열 생성
//    static int[][] makeCopyMap(int[][] map) {
//        int[][] copyMap = new int[N + 1][M];
//
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                copyMap[i][j] = map[i][j];
//            }
//        }
//
//        return copyMap;
//    }
//
//    // 적군이 존재하는지 확인 메서드
//    public static boolean checkEnemy(int[][] map) {
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                if (map[i][j] == 1) {
//                    // 한명이라도 존재한다면, true  반환
//                    return true;
//                }
//            }
//        }
//        // 없다면 false 반환
//        return false;
//    }
//
//    // 객체 생성
//    static class Target {
//        int y;
//        int x;
//        int distance;
//
//        public Target(int y, int x, int distance) {
//            this.y = y;
//            this.x = x;
//            this.distance = distance;
//        }
//    }
//}


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N; // 입력값으로 주어지는 인원의 수
    static int[] people; // 인원 (N)
    static int[] selectPeople; // 선택된 인원 (N / 2)
    static List<Integer> notSelectPeople = new ArrayList<>(); // 비 선택된 인원 (N / 2)
    static boolean[] visitPeople; // 방문한 인원 (N)
    static int[][] peoplePowerMap; // 각 인원이 시너지가 존재하는 능력치를 담는 map

    static int result = Integer.MAX_VALUE; // 결과값 변수 선언

    public static void main(String[] args) throws IOException {
        // 입출력 스트림 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 변수 값 할당
        N = Integer.parseInt(br.readLine());
        people = new int[N];
        selectPeople = new int[N / 2];
        visitPeople = new boolean[N];
        peoplePowerMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            people[i] = i;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                peoplePowerMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 주어진 인원의 조합 계산 (N개 중에 N / 2를 뽑음)
        peopleComb(0, 0);


        // 결과값 출력 및 자원 반환
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    // 뽑을수 있는 사람의 조합을 구함
    static void peopleComb(int depth, int startIndex) {
        // 기저 조건 설정 > 뽑아야 하는 인원 수에 도달할 경우 종료
        if (depth == selectPeople.length) {
            // 여기서 반대로 뽑히지 않은 인원과의 차이값을 계산
            initNotSelectPeople();
            // 최소값 갱신
            updateMinValue();
            // 기저 조건 완료 = 메서드 종료 처리
            return;
        }

        // 조합 반복문 dfs
        for (int i = startIndex; i < N; i++) {
            if (!visitPeople[i]) {
                selectPeople[depth] = people[i];
                visitPeople[i] = true;
                peopleComb(depth + 1, i + 1);
                visitPeople[i] = false;
            }
        }
    }

    static void initNotSelectPeople() {
        // 혹시 이전에 사용된 데이터가 있을수 있기에 clear 처리
        notSelectPeople.clear();
        // selectPeople 이 아닌 배열을 만듬
        for (int i = 0; i < visitPeople.length; i++) {
            if (!visitPeople[i]) notSelectPeople.add(i);
        }
    }

    static void updateMinValue() {
        // selectPeople, notSelectPeople 로 두가지 팀은 나누어 졌음
        // 다만 해당 변수에 대해서 2가지를 뽑는 다는 조합의 경우의 수를 구해서 합산한 값을 각각 구해야 함
        int abs = Math.abs(calcSelectPeople() - calcNotSelectPeople());
        // 도출된 값 갱신
        if (abs < result) result = abs;
    }

    // 선택된 인원의 능력치 합 계산
    static int calcSelectPeople() {
        int sum = 0;
        int length = selectPeople.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int first = selectPeople[i];
                int second = selectPeople[j];
                sum += peoplePowerMap[first][second] + peoplePowerMap[second][first];
            }
        }
        return sum;
    }

    // 비 선택된 인원의 능력치 합 계산
    static int calcNotSelectPeople() {
        int sum = 0;
        int size = notSelectPeople.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int first = notSelectPeople.get(i);
                int second = notSelectPeople.get(j);
                sum += peoplePowerMap[first][second] + peoplePowerMap[second][first];
            }
        }
        return sum;
    }
}