package LeetCode.Q155MinStack;

import java.util.Deque;
import java.util.EmptyStackException;
import java.util.LinkedList;

public class MinStack {
    Deque<Integer> stackMin;
    Deque<Integer> stack;
    public MinStack() {
        stackMin = new LinkedList<>();
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if(stackMin.isEmpty() || x<=stackMin.peek()) stackMin.push(x);
    }

    public void pop() {
        if (stack.isEmpty()) throw new EmptyStackException();
        if (stackMin.peek().equals(stack.pop())) stackMin.pop();
    }

    public int top() {
        if (stack.isEmpty()) throw new EmptyStackException();
        return stack.peek();
    }

    public int getMin() {
        if(stackMin.isEmpty()) throw new EmptyStackException();
        return stackMin.peek();
    }
}

