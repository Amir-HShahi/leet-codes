import java.util.HashMap;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> closeToOpen = new HashMap<Character, Character>();
        closeToOpen.put('}', '{');
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');

        for (char character : s.toCharArray()) {
            if (closeToOpen.containsKey(character)) {
                if (!stack.isEmpty() && stack.peek().equals(closeToOpen.get(character))) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(character);
            }
        }
        return stack.isEmpty();
    }
}