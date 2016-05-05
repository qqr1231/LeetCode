public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)   return 0;
        int area = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j]) {
                j--;
            }else{
                i++;
            }
        }
        return area;
    }
}