class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;

        int max = nums[0];
        int prevMax = nums[0];
        for (int i = 1; i < length; i++) {
            prevMax = Math.max(prevMax + nums[i], nums[i]);
            if (prevMax > max) {
                max = prevMax;
            }
        }
        return max;
    }
}