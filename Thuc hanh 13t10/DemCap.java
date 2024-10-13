import java.util.Scanner;
import java.util.Stack;

public class DemCap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // Số phần tử của dãy A
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();  // Nhập các phần tử của dãy A
        }

        long count = 0;
        Stack<Integer> stack = new Stack<>();

        // Duyệt qua từng phần tử trong mảng
        for (int i = 0; i < N; i++) {
            // Nếu stack không rỗng và phần tử trên đỉnh stack lớn hơn A[i], ta cần pop ra
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }

            // Số lượng cặp hợp lệ với A[i] là (i - vị trí của phần tử cuối cùng trong stack)
            count += stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Thêm chỉ số hiện tại vào stack
            stack.push(i);
        }

        System.out.println(count);  // In ra kết quả
    }
}
