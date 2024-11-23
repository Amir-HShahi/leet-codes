import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            switch (token) {
                case "*": {
                    Integer result = stack.pop() * stack.pop();
                    stack.push(result);
                    break;
                }
                case "/": {
                    Integer secondElement = stack.pop();
                    Integer result = stack.pop() / secondElement;
                    stack.push(result);
                    break;
                }
                case "-": {
                    Integer secondElement = stack.pop();
                    Integer result = stack.pop() - secondElement;
                    stack.push(result);
                    break;
                }
                case "+": {
                    Integer result = stack.pop() + stack.pop();
                    stack.push(result);
                    break;
                }
                default: {
                    stack.push(Integer.parseInt(token));
                    break;
                }
                    
            }
        }
        return stack.pop();
    }
}