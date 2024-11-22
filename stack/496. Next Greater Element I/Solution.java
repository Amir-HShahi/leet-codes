import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> nextGreater = new HashMap<Integer, Integer>();
        
        for (Integer integer : nums2) {
            while (!stack.empty() && stack.peek() < integer) {
                nextGreater.put(stack.pop(), integer);
            }
            stack.push(integer);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = nextGreater.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}