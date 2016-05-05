public class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();;
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                if (hm.get(nums[i]) == 1) {
                    hm.put(nums[i], 2);
                }
            }else {
                hm.put(nums[i], 1);
            }
        }
        int sum = 0;
        int index = 0;
        for (int k:hm.keySet()) {
            sum += hm.get(k);
            while(index < sum) {
                nums[index] = k;
                index++;
            }
        }
        Arrays.sort(nums,0,sum);
        return sum;
    }
}