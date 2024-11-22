import java.util.Stack;

class MyQueue {
    Stack<Integer> firstStack = new Stack<Integer>();
    Stack<Integer> secondStack = new Stack<Integer>();
    
    public void push(int x) {
        firstStack.push(x);
    }
    
    public int pop() {
        while (!firstStack.empty()) {
            secondStack.push(firstStack.pop());
        }
        int pop = secondStack.pop();
        while (!secondStack.empty()) {
            firstStack.push(secondStack.pop());
        }
        return pop;
    }
    
    public int peek() {
        while (!firstStack.empty()) {
            secondStack.push(firstStack.pop());
        }
        int peek = secondStack.peek();
        while (!secondStack.empty()) {
            firstStack.push(secondStack.pop());
        }
        return peek;
    }
    
    public boolean empty() {
        return firstStack.empty() && secondStack.empty();
    }
}