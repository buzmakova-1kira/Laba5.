package processor;

import java.util.Queue;
import java.util.Stack;

public class QueueProcessor {
    public static <T> void printReverse(Queue<T> queue) {
        if (queue.isEmpty()) {
            return;
        }
        Stack<T> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}