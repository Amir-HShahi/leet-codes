import java.util.Stack;

class Solution {
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> firstStack = new Stack<Character>();
        Stack<Character> secondStack = new Stack<Character>();
        for (Character character : s.toCharArray()) {
            if (!firstStack.isEmpty() && character.equals('#')) {
                firstStack.pop();
            } else if (!character.equals('#')) {
                firstStack.push(character);
            }
        }
        for (Character character : t.toCharArray()) {
            if (!secondStack.isEmpty() && character.equals('#')) {
                secondStack.pop();
            } else if (!character.equals('#')) {
                secondStack.push(character);
            }
        }
        if (firstStack.size() != secondStack.size()) {
            return false;
        }
        while (!firstStack.isEmpty() && !secondStack.isEmpty()) {
            if (firstStack.pop() != secondStack.pop()) {
                return false;
            }
        }
        return firstStack.isEmpty() && secondStack.isEmpty();
    }
}