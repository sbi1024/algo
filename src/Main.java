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



/**
 * 테스트 1 〉	통과 (2.16ms, 70.5MB)
 * 테스트 2 〉	통과 (2.48ms, 91.7MB)
 * 테스트 3 〉	통과 (2.50ms, 90.2MB)
 * 테스트 4 〉	통과 (2.35ms, 78.5MB)
 * 테스트 5 〉	통과 (8.79ms, 87.7MB)
 * 테스트 6 〉	통과 (5.89ms, 92.7MB)
 * 테스트 7 〉	통과 (7.54ms, 87.8MB)
 * 테스트 8 〉	통과 (7.86ms, 99.3MB)
 * 테스트 9 〉	통과 (5.98ms, 77.8MB)
 * 테스트 10 〉	통과 (6.39ms, 88.4MB)
 * 테스트 11 〉	통과 (4.77ms, 75.2MB)
 * 테스트 12 〉	통과 (5.57ms, 88.2MB)
 * 테스트 13 〉	통과 (5.46ms, 84.4MB)
 * 테스트 14 〉	통과 (6.52ms, 83.7MB)
 * 테스트 15 〉	통과 (2.77ms, 78.2MB)
 * 테스트 16 〉	통과 (2.97ms, 73.6MB)
 * 테스트 17 〉	통과 (3.09ms, 77.3MB)
 * 테스트 18 〉	통과 (3.46ms, 86.3MB)
 * 테스트 19 〉	통과 (6.31ms, 92.6MB)
 * 테스트 20 〉	통과 (8.78ms, 74.1MB)
 * 테스트 21 〉	통과 (10.98ms, 77.4MB)
 * 테스트 22 〉	통과 (7.81ms, 84.3MB)
 * 테스트 23 〉	통과 (8.30ms, 73.6MB)
 * 테스트 24 〉	통과 (6.82ms, 74MB)
 * 테스트 25 〉	통과 (127.77ms, 145MB)
 * 테스트 26 〉	통과 (98.71ms, 159MB)
 * 테스트 27 〉	통과 (118.94ms, 149MB)
 * 테스트 28 〉	통과 (106.72ms, 174MB)
 * 테스트 29 〉	통과 (114.59ms, 149MB)
 * 테스트 30 〉	통과 (108.81ms, 173MB)
 * 테스트 31 〉	통과 (100.62ms, 143MB)
 * 테스트 32 〉	통과 (121.10ms, 144MB)
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int forCount = Integer.parseInt(st.nextToken());
        int goalCount = Integer.parseInt(st.nextToken());
        int MAX_VALUE = Integer.MIN_VALUE;
        int[] array = new int[forCount];

        for (int i = 0; i < forCount; i++) {
            array[i] = Integer.parseInt(br.readLine());
            MAX_VALUE = Math.max(array[i], MAX_VALUE);
        }

        long left = 1;
        long right = MAX_VALUE;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < forCount; i++) {
                count += (array[i] / mid);
            }

            if (count >= goalCount) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}