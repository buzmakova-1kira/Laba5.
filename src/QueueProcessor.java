import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class QueueProcessor {
    public static void printReverse(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}