import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<int[]> queue = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            queue.add(new int[] {i + 1, Integer.parseInt(st.nextToken())}); // {풍선 번호, 값}
        }

        StringBuilder sb = new StringBuilder();

        int[] current = queue.poll();
        sb.append(current[0]).append(" ");  // 첫 번째 풍선 번호 추가
        int in = current[1];

        while (!queue.isEmpty()) {
            if (in > 0) { 
                // 오른쪽으로 이동 (in - 1번만 이동)
                in = (in - 1) % queue.size(); // 불필요한 전체 회전 제거
                for (int i = 0; i < in; i++) {
                    queue.add(queue.poll());
                }
            } else {
                // 왼쪽으로 이동 (절대값 만큼 이동)
                in = (-in) % queue.size(); // 불필요한 전체 회전 제거
                for (int i = 0; i < in; i++) {
                    queue.addFirst(queue.pollLast());
                }
            }
            current = queue.poll();
            sb.append(current[0]).append(" ");
            in = current[1];
        }

        System.out.println(sb.toString());
    }
}
